package com.lv.basui.utils;

import com.lv.basui.dto.MailDto;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 发送邮件的工具类
 */
@Component
public class MailUtils {
    private final Logger logger = LoggerFactory.getLogger(MailUtils.class);

    //发件邮箱
    private static String myEmailAccount="zxxzking@qq.com";
    //邮箱密码
    // qq邮箱使用随机码
    private static String myEmailPassword="mfcklwqqgpywbeeh";

    //smtp地址
    private static String myEmailSMTPHost="smtp.qq.com";

    // 1. 创建参数配置, 用于连接邮件服务器的参数配置
    private static Properties props = new Properties();

    private static Session session = null;




    // 初始化参数
     static {
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        //qq邮箱必须使用ssl 端口为465
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        session = Session.getDefaultInstance(props);
        session.setDebug(true);
    }


    public static void doSendMsg(MailDto dto)throws Exception{
         if(StringUtils.isBlank(dto.getTargetMail())){
             throw new RuntimeException("收件人邮箱不能为空");
         }
        MimeMessage message = createMimeMessage(session, myEmailAccount, dto);
        Transport transport = session.getTransport();
        transport.connect(myEmailAccount, myEmailPassword);
        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        try {
            transport.sendMessage(message, message.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
        }finally {
            // 7. 关闭连接
            transport.close();
        }

    }


    public static MimeMessage createMimeMessage(Session session, String sendMail,MailDto dto) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, dto.getFromPerson(), "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(dto.getTargetMail(), dto.getToPerson(), "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject(dto.getSubject(), "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(dto.getContent(), "text/html;charset=UTF-8");

        // 6. 设置发件时间 (立即发送)
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }
}
