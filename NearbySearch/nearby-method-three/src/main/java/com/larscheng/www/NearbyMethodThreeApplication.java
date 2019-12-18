package com.larscheng.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.larscheng.www.dao")
public class NearbyMethodThreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NearbyMethodThreeApplication.class, args);
    }

}
