package com.lucifer.service;

import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Component
public class EmailService {

    public void sendMail(String addr,String title, String msg) throws Exception {

        Properties props = new Properties();

        props.setProperty("mail.transport.protocol", "smtp");

        props.setProperty("mail.smtp.host", "smtp.126.com");

        props.setProperty("mail.smtp.auth", "true");

        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        props.setProperty("mail.smtp.port", "465");

        props.setProperty("mail.smtp.socketFactory.port", "465");

        // 根据配置创建会话对象, 用于和邮件服务器交互

        Session session = Session.getDefaultInstance(props);

        session.setDebug(true);   // 设置为debug模式, 可以查看详细的发送 log

        // 创建一封邮件

        Message message = createMimeMessage(session, "freeservice@126.com", addr,title,msg);

        // 根据 Session 获取邮件传输对象

        Transport transport = session.getTransport();

        // 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则会报错

        transport.connect("freeservice@126.com", "REYVECRYOZEZIFKL");

        // 发送邮件

        transport.sendMessage(message, message.getAllRecipients());

        // 关闭连接

        transport.close();
    }

    private static Message createMimeMessage(Session session, String sendMail, String receiveMail,String title,String msg) throws Exception {

        Message message = new MimeMessage(session);

        message.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
        message.setFrom(new InternetAddress(sendMail));

        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail));

        // 设置邮件标题

        message.setSubject(title);

        // 设置邮件正文

        message.setText(msg);

        message.setSentDate(new Date());

        //保存设置

        message.saveChanges();


        return message;

    }
}
