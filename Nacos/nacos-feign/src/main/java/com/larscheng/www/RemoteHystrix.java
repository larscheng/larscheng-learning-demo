package com.larscheng.www;

import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/10 16:02
 */
@Component
public class RemoteHystrix implements RemoteClient {

    @Override
    public String helloNacos() {
        return "请求超时了";
    }
}
