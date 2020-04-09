package com.larscheng.www.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.CharsetEncoder;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: larscheng
 * @date: 2020/4/9 下午2:25
 * @description: session测试
 */
public class Session1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取session
        HttpSession session = req.getSession();
        session.setAttribute("username","larscheng");
        String sessionId = session.getId();
        if (session.isNew()){
            resp.getWriter().write("新的session创建成功，sessionid： "+sessionId);
        }else {
            resp.getWriter().write("session已经在服务器创建，sessionid： "+sessionId);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
