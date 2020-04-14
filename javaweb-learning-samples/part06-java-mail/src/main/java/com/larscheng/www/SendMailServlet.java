package com.larscheng.www;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: larscheng
 * @date: 2020/4/14 下午2:19
 * @description: 注册发邮件模拟
 */
public class SendMailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        if (username != null && password != null && email != null) {
            //发送邮件
            SendMail sendMail = new SendMail(username, password, email);
            new Thread(sendMail).start();
            req.setAttribute("msg","注册成功邮件已发送");
            req.getRequestDispatcher("info.jsp").forward(req,resp);
        }else {
            req.setAttribute("msg","注册失败！！！！！");
            req.getRequestDispatcher("info.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /***
     * 确保你的tomcat的lib目录下存在mail.jar，否则会报错
     */
    class SendMail implements Runnable {

        private String username;
        private String password;
        private String email;

        public SendMail(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

        @SneakyThrows
        public void run() {
            SendMailUtil.sendMsg(username, password, email);
        }
    }
}
