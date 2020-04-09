package com.larscheng.www.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author: larscheng
 * @date: 2020/4/9 上午10:05
 * @description: 文件下载示例
 */
public class HttpServletResponseDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取文件路径
        String path = "/home/lars/Self/larscheng-learning-demo/javaweb-learning-samples/part01-javaweb-servlet/src/main/resources/test.properties";
        System.out.println(path);
        //2、获取文件名
        String fileName = path.substring(path.lastIndexOf("/")+1);
        //3、获取读取该文件的输入流
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        //4、获取写出该文件的输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //5、创建缓冲区
        byte[] buffer = new byte[1024];
        //6、将文件输入流写入到缓冲区，将缓冲区中内容写入到输出流
        int len = 0;
        while ((len=fileInputStream.read(buffer))>0){
            outputStream.write(buffer,0,len);
        }
        //7、设置响应头参数使浏览器自动下载
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
        //8、关闭资源
        outputStream.close();
        fileInputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
