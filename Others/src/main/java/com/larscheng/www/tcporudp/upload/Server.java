package com.larscheng.www.tcporudp.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        //1 创建socket服务
        ServerSocket serverSocket = new ServerSocket(9009);
        while (true){
            //2 监听客户端
            Socket accept = serverSocket.accept();
            //3 获取输入流
            InputStream inputStream = accept.getInputStream();
            //4 输出文件
            FileOutputStream fileOutputStream = new FileOutputStream(new File("/home/lars/Self/larscheng-learning-demo/Others/src/main/java/com/larscheng/www/tcp/upload/test-copy.txt"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer))!=-1){
                fileOutputStream.write(buffer,0,len);
            }
        }

    }
}
