package com.larscheng.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author larscheng
 */
@SpringBootApplication
@MapperScan("com.larscheng.www.dao")
public class SpringbootMybatisplusDuridMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisplusDuridMysqlApplication.class, args);
    }

}
