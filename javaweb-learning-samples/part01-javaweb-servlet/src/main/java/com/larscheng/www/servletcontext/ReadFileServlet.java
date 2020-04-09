package com.larscheng.www.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: larscheng
 * @date: 2020/4/8 下午4:04
 * @description: Servlet测试
 */
public class ReadFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Properties properties = new Properties();
        InputStream resourceAsStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/test.properties");
//        FileInputStream fileInputStream = new FileInputStream("/WEB-INF/classes/test.properties");
        properties.load(resourceAsStream);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(properties.getProperty("info"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
