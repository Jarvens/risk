package com.scorpion.risk.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 接口频率  注解
 * Created on 2017/9/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented

public @interface RequestLimit {

    //访问次数  默认为最大值
    int count() default Integer.MAX_VALUE;

    //频次时间段   默认为1分钟  单位为 毫秒
    long time() default 60000;

    //控制模式   true 启用配置  false  默认配置
    boolean config() default false;
}
