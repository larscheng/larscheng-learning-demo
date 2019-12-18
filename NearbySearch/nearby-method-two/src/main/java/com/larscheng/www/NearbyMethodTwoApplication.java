package com.larscheng.www;

import com.larscheng.www.domain.User;
import com.larscheng.www.service.RedisNearByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class NearbyMethodTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NearbyMethodTwoApplication.class, args);
    }


    @Autowired
    private RedisNearByService redisNearByService;


    /***
     * 添加用户
     * @return
     */
    @PostMapping("/addUser")
    public boolean add(@RequestBody User user) {
        return redisNearByService.save(user.setCreateTime(LocalDateTime.now()));
    }


    /**
     * 获取附近x米的人
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
        return redisNearByService.nearBySearch(distance,userLng,userLat);
    }

}
