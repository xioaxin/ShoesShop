package com.example.demo.controllers;


import com.example.demo.pojo.Chat;
import com.example.demo.pojo.SocketMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @Description:
 * @author: ZPX
 * @createDate: 2020/4/17 22:47
 * @version: 1.0
 */
@Controller
public class GreetingController {
    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public SocketMessage greeting(SocketMessage socketMessage) {
        return socketMessage;
    }

    @MessageMapping("/chat")
    @ResponseBody
    public void chat(Principal principal, Chat chat) {
//        model.addAttribute("username", principal.getName());
        String from = principal.getName(); //获取当前登录的用户名
        System.out.println(principal.getName());
        chat.setFrom(from);
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(), "/queue/chat", chat);
    }
}




