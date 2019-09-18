package com.larscheng.www;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther: lars
 * @date: 2019/7/10 16:01
 * @description:
 */
@FeignClient(name = "nacos-provide",fallback = RemoteHystrix.class)
public interface RemoteClient {

    @GetMapping("/helloNacos")
    String helloNacos();
}
