package com.larscheng.www.controller;


import ch.hsr.geohash.GeoHash;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.larscheng.www.domain.UserGeohash;
import com.larscheng.www.service.UserGeohashService;
import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.io.GeohashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author larscheng
 * @since 2019-12-10
 */
@RestController
@RequestMapping("/userGeohash")
public class UserGeohashController {

    @Autowired
    private UserGeohashService userGeohashService;

    private SpatialContext spatialContext = SpatialContext.GEO;
    /***
     * 查询用户列表
     * @return
     */
    @GetMapping("/findAll")
    public String list() {
        return JSON.toJSONString(userGeohashService.list());
    }

    /***
     * 添加用户
     * @return
     */
    @PostMapping("/addUser")
    public boolean add(@RequestBody UserGeohash user) {

        //默认精度12位
        String geoHashCode = GeohashUtils.encodeLatLon(user.getLatitude(),user.getLongitude());

        return userGeohashService.save(user.setGeoCode(geoHashCode).setCreateTime(LocalDateTime.now()));
    }


    /**
     * 获取附近x米的人
     *
     * @param distance 距离范围 单位km
     * @param len      geoHash的精度
     * @param userLng  当前经度
     * @param userLat  当前纬度
     * @return json
     */
    @GetMapping("/nearby1")
    public String nearBySearch1(@RequestParam("distance") double distance,
                               @RequestParam("len") int len,
                               @RequestParam("userLng") double userLng,
                               @RequestParam("userLat") double userLat) {


        //1.根据要求的范围，确定geoHash码的精度，获取到当前用户坐标的geoHash码
        String geoHashCode = GeohashUtils.encodeLatLon(userLat, userLng, len);
        QueryWrapper<UserGeohash> queryWrapper = new QueryWrapper<UserGeohash>()
                .likeRight("geo_code",geoHashCode);
        //2.匹配指定精度的geoHash码
        List<UserGeohash> users = userGeohashService.list(queryWrapper);
        //3.过滤超出距离的
        users = users.stream()
                .filter(a ->getDistance(a.getLongitude(),a.getLatitude(),userLng,userLat)<= distance)
                .collect(Collectors.toList());
        return JSON.toJSONString(users);
    }

    /**
     * 获取附近x米的人
     *
     * @param distance 距离范围 单位km
     * @param len      geoHash的精度
     * @param userLng  当前经度
     * @param userLat  当前纬度
     * @return json
     */
    @GetMapping("/nearby")
    public String nearBySearch(@RequestParam("distance") double distance,
                               @RequestParam("len") int len,
                               @RequestParam("userLng") double userLng,
                               @RequestParam("userLat") double userLat) {


        //根据要求的范围，确定geoHash码的精度，获取到当前用户坐标的geoHash码
        GeoHash geoHash = GeoHash.withCharacterPrecision(userLat, userLng, len);
        //获取到用户周边8个方位的geoHash码
        GeoHash[] adjacent = geoHash.getAdjacent();

        QueryWrapper<UserGeohash> queryWrapper = new QueryWrapper<UserGeohash>().likeRight("geo_code",geoHash.toBase32());
        Stream.of(adjacent).forEach(a -> queryWrapper.or().likeRight("geo_code",a.toBase32()));

        //匹配指定精度的geoHash码
        List<UserGeohash> users = userGeohashService.list(queryWrapper);
        //过滤超出距离的
        users = users.stream()
                .filter(a ->getDistance(a.getLongitude(),a.getLatitude(),userLng,userLat)<= distance)
                .collect(Collectors.toList());
        return JSON.toJSONString(users);
    }


    /***
     * 球面中，两点间的距离
     * @param longitude 经度1
     * @param latitude  纬度1
     * @param userLng   经度2
     * @param userLat   纬度2
     * @return 返回距离，单位km
     */
    private double getDistance(Double longitude, Double latitude, double userLng, double userLat) {
        return spatialContext.calcDistance(spatialContext.makePoint(userLng, userLat),
                spatialContext.makePoint(longitude, latitude)) * DistanceUtils.DEG_TO_KM;
    }

}

