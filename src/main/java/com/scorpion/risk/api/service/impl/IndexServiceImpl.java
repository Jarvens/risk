package com.scorpion.risk.api.service.impl;

import com.scorpion.risk.api.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created on 2017/9/17.
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public int setRedis() {
        redisTemplate.opsForSet().add("测试KEY","测试KEY");
        return 0;
    }
}
