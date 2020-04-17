package com.example.demo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.apache.activemq.command.ActiveMQQueue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;

import javax.jms.Queue;

@SpringBootApplication
@MapperScan("com.example.demo.mappers") //扫描mybatis的Mapper层
@EnableAdminServer
@EnableWebSecurity
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //提供一个消息队列
    @Bean
    Queue queue() {
        return new ActiveMQQueue("amq");
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
