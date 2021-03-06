package com.scorpion.risk.api.mapper;

import com.github.pagehelper.Page;
import com.scorpion.risk.api.entity.RiskConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created on 2017/9/17.
 */
@Mapper
public interface RiskConfigMapper {

    /**
     * 创建配置
     *
     * @param riskConfig
     * @return
     */
    int add(RiskConfig riskConfig);

    /**
     * 根据id删除配置
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 分页查询配置信息
     *
     * @return
     */
    Page<RiskConfig> findByPage();

    /**
     * 配置详情
     *
     * @param id
     * @return
     */
    RiskConfig info(Long id);

    /**
     * 查询所有规则
     *
     * @return
     */
    List<RiskConfig> findAll();

    /**
     * 根据id查询规则
     *
     * @param id
     * @return
     */
    RiskConfig findByPrimaryKey(@Param("id") Long id);

}
