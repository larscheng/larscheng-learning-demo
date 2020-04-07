package com.larscheng.www.tcporudp.udp;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        //1 建立socket
        DatagramSocket datagramSocket = new DatagramSocket();
        //2 创建数据包
        String msg = "hello udp";
        DatagramPacket datagramPacket = new DatagramPacket(
                msg.getBytes(),0,msg.getBytes().length,InetAddress.getByName("127.0.0.1"),9001
        );
        //3 发送
        datagramSocket.send(datagramPacket);

        //4 关闭资源
        datagramSocket.close();
    }
}
