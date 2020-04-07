package com.larscheng.www.tcporudp.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws IOException {
        //1 开放端口
        DatagramSocket datagramSocket = new DatagramSocket(9001);
        //2 接受数据包
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getData().length));

    }
}
