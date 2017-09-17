package com.scorpion.risk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RiskApplication.class)
public class DemoApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
	@Test
	public void test() {
	    stringRedisTemplate.opsForValue().set("kdsah","asf");
	}

}
