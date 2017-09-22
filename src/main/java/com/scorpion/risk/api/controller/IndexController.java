package com.scorpion.risk.api.controller;

import com.github.pagehelper.Page;
import com.scorpion.risk.annotation.RequestLimit;
import com.scorpion.risk.api.entity.Limit;
import com.scorpion.risk.api.entity.RiskConfig;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

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
    @RequestMapping(value = "/findByPage", method = RequestMethod.GET)
    public PageResult findByPage(Integer pageNum, Integer pageSize) {
        Page<Limit> limitPage = limitService.findByPage(pageNum, pageSize);
        PageResult<Limit> pageResult = new PageResult<>(limitPage);
        return pageResult;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public BaseResult post(RiskConfig riskConfig) {
        System.out.println(riskConfig);
        return BaseResult.success("SUCCESS");
    }


    /**
     * 测试文件上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public BaseResult importData(@RequestParam MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();

        return BaseResult.success("SUCCESS");
    }



}
