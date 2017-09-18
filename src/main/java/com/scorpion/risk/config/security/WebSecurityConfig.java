package com.scorpion.risk.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created on 2017/9/18.
 */
//
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 设置  HTTP  验证规则
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭csrf验证
        http.csrf().disable()
                //对请求进行认证
                .authorizeRequests()
                //所有 /的请求 都通过
                .antMatchers("/").permitAll()
                //所有 /auth  的请求都放行
                .antMatchers(HttpMethod.GET, "/login").permitAll()
                //权限检查
                .antMatchers("/api/config/add").hasAnyAuthority("AUTH_WRITE")
                //角色检查
                .antMatchers("/world").hasRole("ADMIN")
                //所有请求需要身份认证
                .anyRequest().authenticated().and()
                //添加一个过滤器  所有auth请求都交给 JWTAuthFilter来处理
                .addFilterBefore(new JWTLoginFilter("/login",authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class);
        super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new CustomAuthenticationProvider());
    }
}
