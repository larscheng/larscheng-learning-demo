package com.larscheng.www.tcporudp.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            serverSocket = new ServerSocket(9090);
            while (true){
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();

                byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer))!= -1){
                    byteArrayOutputStream.write(buffer,0,len);
                }
                System.out.println(byteArrayOutputStream.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                byteArrayOutputStream.close();
                inputStream.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
