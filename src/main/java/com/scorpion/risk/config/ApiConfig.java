package com.scorpion.risk.config;

import com.scorpion.risk.interceptor.AuthorizationInterceptor;
import com.scorpion.risk.interceptor.RequestLimitInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Configuration
 * Created on 2017/9/16.
 */
@Configuration
public class ApiConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }


    /**
     * 初始化Bean
     *
     * @return
     */
    @Bean
    public HandlerInterceptor getMyInterceptor() {
        return new RequestLimitInterceptor();
    }

    @Bean
    public HandlerInterceptor getAuthorizationInterceptor() {
        return new AuthorizationInterceptor();
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(getAuthorizationInterceptor());
        registry.addInterceptor(getMyInterceptor());
        super.addInterceptors(registry);
    }
}
