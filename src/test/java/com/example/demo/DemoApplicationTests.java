package com.example.demo;

import com.example.demo.pojo.Customer;
import org.apache.catalina.User;
import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.security.provider.MD5;
import sun.security.rsa.RSASignature;

import java.sql.SQLException;
import java.util.concurrent.locks.Lock;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws ClassNotFoundException, SQLException {

    }

}
