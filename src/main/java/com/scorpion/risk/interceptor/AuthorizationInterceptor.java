package com.scorpion.risk.interceptor;

import com.alibaba.fastjson.JSON;
import com.scorpion.risk.annotation.AccessSecret;
import com.scorpion.risk.result.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2017/9/17.
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Methods", "POST,GET,PUT,DELETE,OPTIONS");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            AccessSecret accessSecret = handlerMethod.getMethodAnnotation(AccessSecret.class);

            if (null != accessSecret) {
                response.getWriter().write(JSON.toJSONString(BaseResult.authorizationError()));
                return false;
            } else {
                return true;
            }
        }

        return super.preHandle(request, response, handler);
    }
}
