package com.larscheng.www.tcporudp.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {


        // 1 创建socket链接
        Socket socket = new Socket(InetAddress.getByName("127 .0.0.1"), 9009);
        // 2 创建输出流
        OutputStream outputStream = socket.getOutputStream();
        // 3 读文件
        String path = "/home/lars/Self/larscheng-learning-demo/Others/src/main/java/com/larscheng/www/tcp/upload/test.txt";
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        // 4 写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }

        socket.shutdownOutput();

        //关闭资源
        fileInputStream.close();
        outputStream.close();
        socket.close();
    }
}
