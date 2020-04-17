package com.example.demo.utils;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


/**
 * 发送邮件工具类
 */
@Component
public class MailService {
    private static final Log logger = LogFactory.getLog(MailService.class);
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送简单邮件
     *
     * @param from
     * @param to
     * @param cc
     * @param subject
     * @param content
     */
    public void sendSimpleEmail(String from, String to, String cc, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);//发送邮件的主体
        message.setTo(to);//收件人
        message.setCc(cc);//抄送人
        message.setSubject(subject);//邮件主题
        message.setText(content);//邮件内容
        javaMailSender.send(message);
    }

    /**
     * 发送附带文件的邮件工具类
     *
     * @param from
     * @param to
     * @param subject
     * @param content
     * @param file
     */
    public void sendAttachFileMail(String from, String to, String subject, String content, File file) {
        try {
            MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content);
            mimeMessageHelper.addAttachment(file.getName(), file);
            javaMailSender.send(mimeMailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
