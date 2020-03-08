package com.example.demo.utils;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


/**
 * 发送邮件工具类
 */
@Component
public class MailService {
    private static final Log logger = LogFactory.getLog(MailService.class);
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleEmail(String from, String to, String cc, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);//发送邮件的主体
        message.setTo(to);//收件人
        message.setCc(cc);//抄送人
        message.setSubject(subject);//邮件主题
        message.setText(content);//邮件内容
        javaMailSender.send(message);
    }
}
