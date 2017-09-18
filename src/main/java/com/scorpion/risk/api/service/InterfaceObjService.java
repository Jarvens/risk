package com.scorpion.risk.api.service;

import com.scorpion.risk.api.entity.InterfaceObj;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.result.PageResult;

/**
 * Created on 2017/9/18.
 */
public interface InterfaceObjService {

    /**
     * 创建接口列表
     * @param interfaceObj
     * @return
     */
    BaseResult add(InterfaceObj interfaceObj);

    /**
     * 根据主键删除接口信息
     * @param id
     * @return
     */
    BaseResult deleteByPrimaryKey(Long id);

    /**
     * 修改接口信息
     * @param interfaceObj
     * @return
     */
    BaseResult update(InterfaceObj interfaceObj);

    /**
     * 分页查询接口列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult findByPage(Integer pageNo,Integer pageSize);

    /**
     * 查询所有接口列表
     * @return
     */
    BaseResult findAll();
}
