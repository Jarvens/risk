package com.scorpion.risk.api.controller;

import com.scorpion.risk.api.entity.InterfaceObj;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.result.PageResult;
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

    /**
     * 创建接口列表
     *
     * @param interfaceObj
     * @return
     */
    @RequestMapping(value = "/interface/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody InterfaceObj interfaceObj) {
        return null;
    }


    /**
     * 根据主键删除接口信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/interface/deleteByPrimaryKey", method = RequestMethod.POST)
    public BaseResult deleteByPrimaryKey(Long id) {
        return null;
    }

    /**
     * 修改接口
     *
     * @param interfaceObj
     * @return
     */
    @RequestMapping(value = "/interface/update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody InterfaceObj interfaceObj) {
        return null;
    }


    /**
     * 分页查询接口列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/intrface/findByPage", method = RequestMethod.GET)
    public PageResult findByPage(Integer pageNo, Integer pageSize) {
        return null;
    }


}
