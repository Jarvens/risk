package com.scorpion.risk.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.scorpion.risk.interceptor.AuthorizationInterceptor;
import com.scorpion.risk.interceptor.RequestLimitInterceptor;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Configuration
 * Created on 2017/9/16.
 */
@Configuration
public class ApiConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {
        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastConf = new FastJsonConfig();
        fastConf.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConverter.setFastJsonConfig(fastConf);
        list.add(fastJsonConverter);
        super.configureMessageConverters(list);
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

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }
}
