package com.larscheng.www.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: larscheng
 * @date: 2020/4/8 下午4:04
 * @description: Servlet测试
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /***
         * setAttribute 共享数据
         */
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("info","HelloServlet被调用了");
        resp.getWriter().print("hello servlet!!!!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
