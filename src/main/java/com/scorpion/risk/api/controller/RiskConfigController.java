package com.scorpion.risk.api.controller;

import com.scorpion.risk.api.entity.RiskConfig;
import com.scorpion.risk.api.service.RiskConfigService;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.result.PageResult;
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
@RequestMapping("config")
public class RiskConfigController {


    @Autowired
    private RiskConfigService riskConfigService;

    /**
     * 创建配置
     * @param riskConfig
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseResult add(@RequestBody RiskConfig riskConfig){

        return riskConfigService.add(riskConfig);
    }


    /**
     * 根据id删除配置信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteByPrimaryKey",method = RequestMethod.POST)
    public BaseResult deleteByPrimaryKey(Long id){
        return riskConfigService.deleteByPrimaryKey(id);
    }


    /**
     * 分页查询配置列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/findByPage",method = RequestMethod.GET)
    public PageResult findByPage(Integer pageNo,Integer pageSize){
        return riskConfigService.findByPage(pageNo,pageSize);
    }

}
