package com.larscheng.www;

import com.sun.mail.util.MailSSLSocketFactory;
import lombok.SneakyThrows;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author: larscheng
 * @date: 2020/4/14 上午11:25
 * @description: 发送邮件
 */
public class SendMailUtil {

    private static final  String sender = "larscheng@foxmail.com";
    private static final  String auth = "huztbudomtupeaaj";

    public static void sendMsg(String username,String password,String email) throws Exception {

        Properties properties = new Properties();
        properties.setProperty("mail.host","smtp.qq.com");
        properties.setProperty("mail.transport.protocol","smtp");
        properties.setProperty("mail.smtp.auth","true");


        //QQ存在一个特性设置SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        // 创建session
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, auth);
            }
        });

        session.setDebug(true);


        // 通过session过去transport
        Transport transport = session.getTransport();
        // 使用邮箱配置链接上邮件服务器
        transport.connect("smtp.qq.com",sender,auth);
        // 创建邮件
        MimeMessage mimeMessage = new MimeMessage(session);
        // 设置发件人
        mimeMessage.setFrom(new InternetAddress(sender));
        // 设置收件人 ，此处设置的自己
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        // 设置邮件主题
        mimeMessage.setSubject("注册成功");
        //设置邮件内容
        mimeMessage.setContent(username+"你好： 恭喜你注册成功，你的密码是 ： "+password,"text/html;charset=utf-8");

        // 发送邮件
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        // 关闭连接
        transport.close();
    }
}
