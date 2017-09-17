package com.scorpion.risk.api.mapper;

import com.github.pagehelper.Page;
import com.scorpion.risk.api.entity.RiskConfig;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created on 2017/9/17.
 */
@Mapper
public interface RiskConfigMapper {

    /**
     * 创建配置
     * @param riskConfig
     * @return
     */
    int add(RiskConfig riskConfig);

    /**
     * 根据id删除配置
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 分页查询配置信息
     * @return
     */
    Page<RiskConfig> findByPage();
}
