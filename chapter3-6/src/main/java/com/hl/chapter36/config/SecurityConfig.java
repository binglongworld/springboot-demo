package com.hl.chapter36.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * security配置类
 * 重写两个方法，认证和授权
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 认证
     * 创建用户和用户的角色
     * 密码编码方式：BCryptPasswordEncoder
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 因为没写数据库，所以此处从内存读取用户、密码
        auth.inMemoryAuthentication()
                // 密码加密方式
                .passwordEncoder(new BCryptPasswordEncoder())
                // 用户名和密码
                .withUser("demo").password(new BCryptPasswordEncoder().encode("demo"))
                // 用户拥有的角色
                .roles("vip1", "vip2", "vip3")
                .and()
                // 第一个普通用户
                .withUser("vip1").password(new BCryptPasswordEncoder().encode("vip1"))
                .roles("vip1")
                .and()
                // 第二个普通用户
                .withUser("vip2").password(new BCryptPasswordEncoder().encode("vip2"))
                .roles("vip2")
                .and()
                // 第三个普通用户
                .withUser("vip3").password(new BCryptPasswordEncoder().encode("vip3"))
                .roles("vip3");
    }

    /**
     * 授权
     * 确定用户在当前系统中是否能够执行某个操作，即用户拥有的功能权限
     * 链式编程
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 请求授权的规则
        // 首页所有人可以访问，功能页只有对应权限的人才能访问
        // http.authorizeRequests() 开始请求权限配置
        // antMatchers("/").permitAll()请求匹配"/"，所有用户都可以访问
        http.authorizeRequests()
                // 首页所有人都能访问
                .antMatchers("/").permitAll()
                // level1目录下的只有vip1才能访问
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // 没有权限默认会到登录页面
        // formLogin() 开始配置登录操作
        // loginPage("/toLogin") 设置登录页面的访问地址
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");

        // 防止跨站请求
        // 安全器令牌
        // 关闭CSRF功能
        http.csrf().disable();

        // 注销，跳转到首页
//        http.logout().deleteCookies("remember").invalidateHttpSession(true);
        http.logout().logoutSuccessUrl("/toLogin");

        // 开启记住我功能 cookie
        http.rememberMe().rememberMeParameter("remember");

    }
}
