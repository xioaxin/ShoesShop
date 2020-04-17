package com.example.demo.utils;


import com.example.demo.pojo.ActiveMQMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;


/**
 * @Description: JMS组件（用于消息队列通信)
 * @author: ZPX
 * @createDate: 2020/4/18 1:35
 * @version: 1.0
 */
@Component
public class JmsComponent {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    //发送
    public void send(ActiveMQMessage msg) {
        jmsMessagingTemplate.convertAndSend(queue, msg);
    }

    //接收
    @JmsListener(destination = "amq")
    public void receive(ActiveMQMessage msg) {
        System.out.println("revive" + msg);
    }
}




