package com.larscheng.www.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: larscheng
 * @date: 2020/4/9 下午2:25
 * @description: cookie测试
 */
public class CookieServlet extends HttpServlet {
    /**
     * cookie保存上一次访问的时间
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();

        Cookie[] cookies = req.getCookies();

        if (cookies != null) {

            List<Cookie> lastLoginTimes = Stream.of(cookies)
                    .filter(a -> a.getName().equals("lastLoginTime"))
                    .collect(Collectors.toList());
            if (lastLoginTimes.size() > 0) {
                LocalDateTime localDateTime = Instant.ofEpochMilli(Long.parseLong(lastLoginTimes.get(0).getValue()))
                        .atZone(ZoneId.of("Asia/Shanghai")).toLocalDateTime();
                writer.write("lastLoginTime: " + localDateTime);
            } else {
                writer.write("First login");
            }
        }else {
            writer.write("First login");
        }

        Cookie lastLoginTime = new Cookie("lastLoginTime", String.valueOf(System.currentTimeMillis()));
        //存活期 分钟
        lastLoginTime.setMaxAge(60);
        resp.addCookie(lastLoginTime);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
