package com.scorpion.risk.api.controller;

import com.scorpion.risk.api.entity.InterfaceObj;
import com.scorpion.risk.api.service.InterfaceObjService;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2017/9/18.
 */
@RestController
@RequestMapping("api")
public class InterfaceObjController {


    @Autowired
    private InterfaceObjService interfaceObjService;

    /**
     * 创建接口列表
     *
     * @param interfaceObj
     * @return
     */
    @RequestMapping(value = "/interface/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody InterfaceObj interfaceObj) {
        return interfaceObjService.add(interfaceObj);
    }


    /**
     * 根据主键删除接口信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/interface/deleteByPrimaryKey", method = RequestMethod.POST)
    public BaseResult deleteByPrimaryKey(Long id) {
        return interfaceObjService.deleteByPrimaryKey(id);
    }

    /**
     * 修改接口
     *
     * @param interfaceObj
     * @return
     */
    @RequestMapping(value = "/interface/update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody InterfaceObj interfaceObj) {
        return interfaceObjService.update(interfaceObj);
    }


    /**
     * 分页查询接口列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/interface/findByPage", method = RequestMethod.GET)
    public PageResult findByPage(Integer pageNo, Integer pageSize) {
        return interfaceObjService.findByPage(pageNo, pageSize);
    }

    /**
     * 设置接口规则
     *
     * @param interfaceId
     * @param ruleId
     * @return
     */
    @RequestMapping(value = "/interface/ruleSetting", method = RequestMethod.POST)
    public BaseResult ruleSetting(Long interfaceId, Long ruleId) {
        return interfaceObjService.ruleSetting(interfaceId,ruleId);
    }


}
