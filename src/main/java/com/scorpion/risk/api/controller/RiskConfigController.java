package com.scorpion.risk.api.controller;

import com.scorpion.risk.annotation.RequestLimit;
import com.scorpion.risk.api.entity.RiskConfig;
import com.scorpion.risk.api.service.RiskConfigService;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.result.PageResult;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 配置
 * Created on 2017/9/17.
 */
@RestController
@RequestMapping("api")
public class RiskConfigController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RiskConfigController.class);

    @Autowired
    private RiskConfigService riskConfigService;


    /**
     * 创建配置
     *
     * @param riskConfig
     * @return
     */
    @ApiOperation(value = "规则",notes = "创建规则")
    @RequestLimit(count = 10, time = 60000, config = true)
    @RequestMapping(value = "/config/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody RiskConfig riskConfig) {
        LOGGER.info("请求进来");
        return riskConfigService.add(riskConfig);
    }


    /**
     * 根据id删除配置信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/config/deleteByPrimaryKey", method = RequestMethod.POST)
    public BaseResult deleteByPrimaryKey(Long id) {
        return riskConfigService.deleteByPrimaryKey(id);
    }


    /**
     * 分页查询配置列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestLimit(count = 10, time = 60000, config = false)
    @RequestMapping(value = "/config/findByPage", method = RequestMethod.GET)
    public PageResult findByPage(Integer pageNo, Integer pageSize) {
        return riskConfigService.findByPage(pageNo, pageSize);
    }

    /**
     * 查看规则详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/config/info", method = RequestMethod.GET)
    public BaseResult info(Long id) {
        return riskConfigService.info(id);
    }

    /**
     * 查询所有规则
     *
     * @return
     */
    @RequestMapping(value = "/config/findAll", method = RequestMethod.GET)
    public BaseResult findAll() {
        return riskConfigService.findAll();
    }

}
