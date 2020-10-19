package mail;

import org.junit.Test;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailTest {

    @Test
    public void send() throws Exception {
        // 参数配置

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

        Message message = createMimeMessage(session, "freeservice@126.com", "2228651648@qq.com");

        // 根据 Session 获取邮件传输对象

        Transport transport = session.getTransport();

        // 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则会报错

        transport.connect("freeservice@126.com", "REYVECRYOZEZIFKL");

        // 发送邮件

        transport.sendMessage(message, message.getAllRecipients());

        // 关闭连接

        transport.close();
    }

    /**

     * 创建一封简单邮件

     */

    private static Message createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(sendMail));

        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail));

        // 设置邮件标题

        message.setSubject("发送邮件测试");

        // 设置邮件正文

        message.setText("这是测试内容，请忽略此内容详情");

        message.setSentDate(new Date());

        //保存设置

        message.saveChanges();

        return message;

    }
}
