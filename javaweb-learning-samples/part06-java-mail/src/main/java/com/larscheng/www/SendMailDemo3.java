package com.larscheng.www;

import com.sun.mail.util.MailSSLSocketFactory;
import lombok.SneakyThrows;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author: larscheng
 * @date: 2020/4/14 上午11:25
 * @description: 发送复杂邮件（文本+图片+附件）
 */
public class SendMailDemo3 {

    private static final  String sender = "larscheng@foxmail.com";
    private static final  String auth = "huztbudomtupeaaj";
    /**
     * qq邮箱有授权码
     *
     * @param args
     */
    @SneakyThrows
    public static void main(String[] args) throws GeneralSecurityException {


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
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(sender));
        // 设置邮件主题
        mimeMessage.setSubject("测试复杂带附件邮件");

        /*准备邮件数据*/
        email(mimeMessage);


        // 发送邮件
        transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());
        // 关闭连接
        transport.close();
    }

    private static void email(MimeMessage mimeMessage) throws MessagingException {
        //内嵌资源--图片
        MimeBodyPart image = new MimeBodyPart();
        String path1 = "/home/lars/Self/larscheng-learning-demo/javaweb-learning-samples/part06-java-mail/src/main/resources/0.gif";
        DataHandler dataHandler = new DataHandler(new FileDataSource(path1));
        image.setDataHandler(dataHandler);
        image.setContentID("test.gif");

        //附件数据--文本文件
        String path2 = "/home/lars/Self/larscheng-learning-demo/javaweb-learning-samples/part06-java-mail/src/main/resources/test.txt";
        MimeBodyPart file = new MimeBodyPart();
        DataHandler dataFile = new DataHandler(new FileDataSource(path2));
        file.setDataHandler(dataFile);
        file.setFileName("test.txt");

        //文本数据中引用内嵌资源
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("收到一封图片+附件的邮件: <br> <img src='cid:test.gif'>","text/html;charset=UTF-8");

        //组装邮件内容
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(text);
        multipart.addBodyPart(image);
        multipart.setSubType("related");
        //正文内容整合
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(multipart);

        //正文+附件整合
        MimeMultipart all = new MimeMultipart();
        all.addBodyPart(bodyPart);
        all.addBodyPart(file);
        all.setSubType("mixed");

        //设置邮件内容,并保存修改
        mimeMessage.setContent(all);
        mimeMessage.saveChanges();
    }
}
