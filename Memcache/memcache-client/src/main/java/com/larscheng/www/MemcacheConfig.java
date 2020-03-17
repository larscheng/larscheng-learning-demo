package com.larscheng.www;

import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * 描述:
 *
 * @author zhengql
 * @date 2019/10/18 17:46
 */
@Configuration
public class MemcacheConfig  implements CommandLineRunner {

    @Autowired
    private  MemcacheSource memcacheSource;

    private MemcachedClient client = null;


    public MemcachedClient getClient() {
        return client;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            client = new MemcachedClient(new InetSocketAddress(memcacheSource.getIp(),memcacheSource.getPort()));
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
}
