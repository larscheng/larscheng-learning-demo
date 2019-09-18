package com.larscheng.www.javaclient;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

/**
 * 描述:
 * java客户端
 *
 * @author zhengql
 * @date 2019/9/18 19:47
 */
public class RabbitMqJavaClient {
    public static void main(String[] args) {
        JavaClientFirst();
        JavaClientSecond();
    }

    private static void JavaClientSecond() {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = null;
        try {
            factory.setUri("amqp://dev:123456@localhost:5672/dev");
        } catch (URISyntaxException | NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
        try {
            connection = factory.newConnection();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    System.out.println(connection.getServerProperties());
                    connection.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    private static void JavaClientFirst() {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");
        Connection connection = null;
        try {
            connection = factory.newConnection();
            System.out.println(connection.getServerProperties());
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
