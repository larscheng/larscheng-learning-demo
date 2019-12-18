package com.larscheng.www.controller;


import com.alibaba.fastjson.JSON;
import com.larscheng.www.dao.UserMapper;
import com.larscheng.www.domain.User;
import com.larscheng.www.serviceImpl.UserServiceImpl;
import com.mysql.cj.xdevapi.JsonArray;
import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.io.GeohashUtils;
import com.spatial4j.core.shape.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author larscheng
 * @since 2019-12-06
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserMapper userMapper;

    private SpatialContext spatialContext = SpatialContext.GEO;


    /***
     * 查询用户列表
     * @return
     */
    @GetMapping("/findAll")
    public String list() {
        return JSON.toJSONString(userService.list());
    }


    /***
     * 添加用户
     * @return
     */
    @PostMapping("/addUser")
    public boolean add(@RequestBody User user) {
        return userService.save(user.setCreateTime(LocalDateTime.now()));
    }


    /**
     * 获取附近x米的人
     *
     * 自行计算外接正方形坐标及距离判断！！！！！！！！！！！！！！
     *
     * @param distance 距离范围 单位km
     * @param userLng  当前经度
     * @param userLat  当前纬度
     * @return json
     */
    @GetMapping("/nearby")
    public String nearBySearch(@RequestParam("distance") double distance,
                               @RequestParam("userLng") double userLng,
                               @RequestParam("userLat") double userLat) {
        double[] point = getGpsRange(userLng, userLat, distance);

        //1.获取位置在正方形内的所有用户
        List<User> users = userMapper.selectUser(point[0], point[1], point[2], point[3]);
        //2.剔除半径超过指定距离的多余用户
        users = users.stream().filter(a -> getDistance(a.getLongitude(), a.getLatitude(), userLng, userLat) <= distance)
                .collect(Collectors.toList());
        return JSON.toJSONString(users);
    }


    /**
     * 获取附近x米的人
     * 使用第三方库计算外接正方形和距离！！！！！！！！
     * @param distance 距离范围 单位km
     * @param userLng  当前经度
     * @param userLat  当前纬度
     * @return json
     */
    @GetMapping("/nearby1")
    public String nearBySearch1(@RequestParam("distance") double distance,
                               @RequestParam("userLng") double userLng,
                               @RequestParam("userLat") double userLat) {
        Rectangle rectangle = getRectangle(distance, userLng, userLat);
        //1.获取位置在正方形内的所有用户
        List<User> users = userMapper.selectUser(rectangle.getMinX(), rectangle.getMaxX(), rectangle.getMinY(), rectangle.getMaxY());
        //2.剔除半径超过指定距离的多余用户
        users = users.stream().filter(a -> getDistance1(a.getLongitude(), a.getLatitude(), userLng, userLat) <= distance)
                .collect(Collectors.toList());
        return JSON.toJSONString(users);
    }











    /*********************************************  手动实现的工具方法 ***************************************************************/


    //地球半径常量，km
    private static final double EARTH_RADIUS = 6378.137;

    /**
     * 查询出某个范围内的最大经纬度和最小经纬度
     *
     * @param longitude 当前位置经度
     * @param latitude  当前位置纬度
     * @param rangeDis  距离范围，单位km
     * @return
     */
    public static double[] getGpsRange(double longitude, double latitude, double rangeDis) {
        double dlng = 2 * Math.asin(Math.sin(rangeDis / (2 * EARTH_RADIUS)) / Math.cos(latitude * Math.PI / 180));
        //角度转为弧度
        dlng = dlng * 180 / Math.PI;
        double dlat = rangeDis / EARTH_RADIUS;
        dlat = dlat * 180 / Math.PI;
        double minlng = longitude - dlng;
        double maxlng = longitude + dlng;
        double minlat = latitude - dlat;
        double maxlat = latitude + dlat;
        return new double[]{minlng, maxlng, minlat, maxlat};
    }


    /**
     * 根据地球上任意两点的经纬度计算两点间的距离,返回距离单位：km
     *
     * @param longitude1 坐标1 经度
     * @param latitude1  坐标1 纬度
     * @param longitude2 坐标2 经度
     * @param latitude2  坐标2 纬度
     * @return 返回km
     */
    public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        double radLat1 = rad(latitude1);
        double radLat2 = rad(latitude2);
        double a = radLat1 - radLat2;
        double b = rad(longitude1) - rad(longitude2);
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        distance = distance * EARTH_RADIUS;
        distance = Math.round(distance * 10000) / 10000.0;
        return distance;
    }

    /**
     * 角度转弧度
     *
     * @param d
     * @return
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }



    /*********************************************  第三方工具方法 ***************************************************************/

    /***
     * 球面中，两点间的距离（第三方库方法）
     * @param longitude 经度1
     * @param latitude  纬度1
     * @param userLng   经度2
     * @param userLat   纬度2
     * @return 返回距离，单位km
     */
    private double getDistance1(Double longitude, Double latitude, double userLng, double userLat) {
        return spatialContext.calcDistance(spatialContext.makePoint(userLng, userLat),
                spatialContext.makePoint(longitude, latitude)) * DistanceUtils.DEG_TO_KM;
    }

    /**
     * 利用开源库计算外接正方形坐标
     * @param distance
     * @param userLng
     * @param userLat
     * @return
     */
    private Rectangle getRectangle(double distance, double userLng, double userLat) {
        return spatialContext.getDistCalc().calcBoxByDistFromPt(
                spatialContext.makePoint(userLng, userLat), distance * DistanceUtils.KM_TO_DEG, spatialContext, null);
    }
}

