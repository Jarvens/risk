package com.scorpion.risk.api.controller;

import com.github.pagehelper.Page;
import com.scorpion.risk.annotation.RequestLimit;
import com.scorpion.risk.api.entity.Limit;
import com.scorpion.risk.api.service.IndexService;
import com.scorpion.risk.api.service.LimitService;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.result.PageResult;
import com.scorpion.risk.util.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2017/9/16.
 */
@RestController
@RequestMapping("api")
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private IndexService indexService;

    @Autowired
    private LimitService limitService;

    @RequestLimit(count = 10, time = 60000, config = true)
    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    @AccessSecret
    public BaseResult limit(HttpServletRequest request) {
        String ip = IPUtil.getIPAddress(request);
        String url = request.getRequestURL().toString();
        String key = "request_limit_".concat(url).concat(ip);

        LOGGER.info(ip + "|" + url + "|" + key);
//        indexService.setRedis();
        return BaseResult.success("SUCCESS");
    }

    @RequestLimit(count = 10, time = 60000, config = true)
    @RequestMapping(value = "/findByPage",method = RequestMethod.GET)
    public PageResult findByPage(Integer pageNum,Integer pageSize){
        Page<Limit> limitPage = limitService.findByPage(pageNum,pageSize);
        PageResult<Limit> pageResult = new PageResult<>(limitPage);
        return pageResult;
    }

}
