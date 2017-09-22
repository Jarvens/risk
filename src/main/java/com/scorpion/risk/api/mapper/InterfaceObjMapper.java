package com.scorpion.risk.api.mapper;

import com.github.pagehelper.Page;
import com.scorpion.risk.api.entity.InterfaceObj;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

/**
 * Created on 2017/9/18.
 */
@Mapper
public interface InterfaceObjMapper {

    /**
     * 创建接口列表
     *
     * @param interfaceObj
     * @return
     */
    int add(InterfaceObj interfaceObj);

    /**
     * 根据主键删除接口信息
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 修改接口信息
     *
     * @param interfaceObj
     * @return
     */
    int update(InterfaceObj interfaceObj);

    /**
     * 分页查询
     *
     * @return
     */
    Page<InterfaceObj> findByPage();

    /**
     * 查询所有
     *
     * @return
     */
    List<InterfaceObj> findAll();

    /**
     * 接口规则设置
     *
     * @param interfaceId
     * @param ruleId
     * @return
     */
    int ruleSetting(@Param("interfaceId") Long interfaceId, @Param("ruleId") Long ruleId);

    /**
     * 根据id查询接口
     *
     * @param id
     * @return
     */
    InterfaceObj findByPrimaryKey(Long id);



}
