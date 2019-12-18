package com.larscheng.www.service;

import com.alibaba.fastjson.JSON;
import com.larscheng.www.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * redis附近的人解决方案
 *
 * @author larscheng
 * @date 2019/12/9 19:17
 */
@Service
public class RedisNearByService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private final static String KEY = "user_info";


    public boolean save(User user) {
        Long flag = redisTemplate.opsForGeo().add(KEY, new RedisGeoCommands.GeoLocation<>(
                user.getName(),
                new Point(user.getLongitude(), user.getLatitude()))
        );
        return flag != null && flag > 0;
    }

    /**
     * 根据当前位置获取附近指定范围内的用户
     * @param distance 指定范围 单位km ，可根据{@link org.springframework.data.geo.Metrics} 进行设置
     * @param userLng 用户经度
     * @param userLat 用户纬度
     * @return
     */
    public String nearBySearch(double distance, double userLng, double userLat) {
        List<User> users = new ArrayList<>();
        GeoResults<RedisGeoCommands.GeoLocation<Object>> reslut = redisTemplate.opsForGeo()
                .radius(KEY, new Circle(new Point(userLng, userLat), new Distance(distance, Metrics.KILOMETERS)),
                        RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs()
                                .includeDistance()
                                .includeCoordinates().sortAscending());
        List<GeoResult<RedisGeoCommands.GeoLocation<Object>>> content = reslut.getContent();
        content.forEach(a-> users.add(
                new User().setDistance(a.getDistance().getValue())
                .setLatitude(a.getContent().getPoint().getX())
                .setLongitude(a.getContent().getPoint().getY())));
        return JSON.toJSONString(users);
    }
}
