//package com.example.demo;
//
//import com.example.demo.Check.KaptchaFilter;
//import com.example.demo.demo1.CustomUserDetailsService;
//import com.example.demo.services.CustomerAndRolesService;
//import com.example.demo.utils.MD5Util;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import sun.security.rsa.RSASignature;
//
///**
// * Description
// * SpringSecurity 类的配置（登陆的拦截、和
// * @Author ZPX
// * @Date Created in 2019-11-22 23:25
// * @Version 1.0
// */
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private CustomerAndRolesService customerAndRolesService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customerAndRolesService).passwordEncoder(new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return charSequence.toString();
//            }
//
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return s.equals(RSASignature.MD5withRSA(charSequence.toString()));
//            }
//        });
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                // 如果有允许匿名的url，填在下面
//                .antMatchers("/register**", "/find_password1/**", "/findpassword_ajax", "/defaultKaptcha**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                // 设置登陆页
//                .formLogin().loginPage("/login")
//                // 设置登陆成功页
//                // 自定义登陆用户名和密码参数，默认为username和password
//               .usernameParameter("username")
//                .passwordParameter("password")
//                .failureUrl("/login?error=true")
//                .defaultSuccessUrl("/index").permitAll()
//                .and()
//                .logout().permitAll();
//        http.addFilterBefore(new KaptchaFilter("/login", "/login?error"), UsernamePasswordAuthenticationFilter.class);
//        // 关闭CSRF跨域
//        http.csrf().disable();
//    }
//
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // 设置拦截忽略文件夹，可以对静态资源放行
//        web.ignoring().antMatchers("/css/**", "/js/**", "/druid/**", "/defaultKaptcha/**");
//    }
//}
//
