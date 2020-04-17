package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description: WebSecurity的配置
 * @author: ZPX
 * @createDate: 2020/4/18 0:21
 * @version: 1.0
 */
@Configuration
public class MyWebSecurityConfig1 extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("李沙沙")
                .password("$2a$10$ZDBer5ECIkRIQzFi0ywupOPuHw8yyk0sGt48O4xHEAl0HuhoNIe9m")
                .roles("admin")
                .and()
                .withUser("郑沛鑫")
                .password("$2a$10$ZDBer5ECIkRIQzFi0ywupOPuHw8yyk0sGt48O4xHEAl0HuhoNIe9m")
                .roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 如果有允许匿名的url，填在下面
                .antMatchers("/druid/submitLogin**", "/actuator**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();
        // 关闭CSRF跨域
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/druid/**", "/actuator/**" ,"/druid/submitLogin**");
    }
}




