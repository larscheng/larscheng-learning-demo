package com.larscheng.www;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author zhengql
 * @date 2019/10/18 17:04
 */
@Component
@ConfigurationProperties(prefix = "memcache")
public class MemcacheSource {

    private String ip;

    private int port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
