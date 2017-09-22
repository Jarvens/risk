package com.scorpion.risk.interceptor;

import com.alibaba.fastjson.JSON;
import com.scorpion.risk.annotation.RequestLimit;
import com.scorpion.risk.api.entity.InterfaceObj;
import com.scorpion.risk.api.entity.RiskConfigSnapshot;
import com.scorpion.risk.api.mapper.InterfaceObjMapper;
import com.scorpion.risk.api.mapper.RiskConfigSnapShotMapper;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.util.IPUtil;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * api接口频率 拦截器
 * Created on 2017/9/17.
 */
public class RequestLimitInterceptor extends HandlerInterceptorAdapter {


    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLimitInterceptor.class);

    @Autowired
    private RiskConfigSnapShotMapper riskConfigSnapShotMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Methods", "POST,GET,PUT,DELETE,OPTIONS");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RequestLimit requestLimit = handlerMethod.getMethodAnnotation(RequestLimit.class);
            if (requestLimit != null) {
                int limitCount = requestLimit.count();
                long time = requestLimit.time();
                boolean config = requestLimit.config();
                String ip = IPUtil.getIPAddress(request);
                String url = request.getRequestURL().toString();
                String key = "request_limit_".concat(url).concat(ip);
                String redisCount = stringRedisTemplate.opsForValue().get(key);
                //当前访问时间
                long currentTimeMillis = System.currentTimeMillis();
                //上次访问时间
                String previousStr = stringRedisTemplate.opsForValue()
                        .get(key + "times") == null ? "0" : stringRedisTemplate.opsForValue().get(key + "times");
                long previousTimeMillis = Long.valueOf(previousStr);
                String requestUrl = request.getRequestURI().toLowerCase().toString();
                String requestMethod = request.getMethod().toLowerCase().toString();
                RiskConfigSnapshot obj = riskConfigSnapShotMapper.findByMethodTypeAndUrl(requestMethod, requestUrl);
                if (null != obj) {
                    //接口状态
                    //1关 0开
                    if (obj.getOff().toLowerCase().equals("0")) {
                        limitCount = obj.getFrequency();
                        boolean result = validExpire(currentTimeMillis, previousTimeMillis, redisCount, limitCount);
                        if (result == false) {
                            response.getWriter().write(JSON.toJSONString(BaseResult.limitError()));
                            return false;
                        }
                    }
                }

                boolean result = validExpire(currentTimeMillis, previousTimeMillis, redisCount, limitCount);
                if (result == false) {
                    response.getWriter().write(JSON.toJSONString(BaseResult.limitError()));
                    return false;
                }
                //redis设置自增访问频率
                stringRedisTemplate.opsForValue().increment(key, 1);
                //设置1分钟过期
                stringRedisTemplate.expire(key, 60, TimeUnit.SECONDS);
                //记录上次访问时间Long值
                stringRedisTemplate.opsForValue().set(key + "times", String.valueOf(currentTimeMillis));
                stringRedisTemplate.expire(key + "times", 60, TimeUnit.SECONDS);
                LOGGER.info("限流次数【" + limitCount + "】");
                LOGGER.info("限流IP【" + ip + "】");
                LOGGER.info("限流地址【" + url + "】");
                LOGGER.info("限流时间频率【" + time + "】");
                LOGGER.info("配置模式【" + (config ? "配置模式" : "默认配置") + "】");
                LOGGER.info("限流key【" + key + "】");
                LOGGER.info("当前访问次数【" + redisCount + "】");
            }
        }
        return super.preHandle(request, response, handler);
    }

    /**
     * 校验过期时间
     *
     * @param currentTimes  当前时间Long值
     * @param previousTimes 上一次请求时间Long值
     * @param redisCount    redis存储当前请求计数器
     * @param limitCount    限制请求计数器
     * @return
     */
    private boolean validExpire(Long currentTimes, Long previousTimes, String redisCount, int limitCount) {
        if ((currentTimes - previousTimes) < 60000) {
            if (Integer.valueOf(redisCount) > limitCount) {
                return false;
            }
            return true;
        }
        return true;
    }


}
