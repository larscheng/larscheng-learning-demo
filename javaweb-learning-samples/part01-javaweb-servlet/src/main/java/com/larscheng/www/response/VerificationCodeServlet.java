package com.larscheng.www.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author: larscheng
 * @date: 2020/4/8 下午4:04
 * @description: 验证码
 */
public class VerificationCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //内存中创建画板
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //获取2d画笔
        Graphics2D pen = (Graphics2D) image.getGraphics();
        //设置图片背景色和大小尺寸
        pen.setColor(Color.RED);
        pen.fillRect(0,0,80,20);
        //生成随机数
        String randomNum = getRandomNum(8);
        //写数据
        pen.setColor(Color.BLACK);
        pen.setFont(new Font(null,Font.BOLD,15));
        pen.drawString(randomNum,0,20);

        //设置浏览器页面5秒刷新
        resp.setHeader("refresh","5");
        //设置浏览器页面以图片形式接收并打开
        resp.setContentType("image/jpeg");
        //设置缓存禁用
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //图片写入输出流
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    /**
     * 获取指定长度的随机数
     * @param len 长度
     * @return 随机数
     */
    private static String getRandomNum(int len) {
        Random random = new Random();
        double num = (1+random.nextDouble()) * Math.pow(10,len);
        return String.valueOf(num).substring(2,len+2);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
