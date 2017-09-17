package com.scorpion.risk.api.service;

import com.scorpion.risk.api.entity.RiskConfig;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.result.PageResult;

/**
 * Created on 2017/9/17.
 */
public interface RiskConfigService {

    /**
     * 创建配置
     *
     * @param riskConfig
     * @return
     */
    BaseResult add(RiskConfig riskConfig);

    /**
     * 根据主键删除配置
     *
     * @param id
     * @return
     */
    BaseResult deleteByPrimaryKey(Long id);

    /**
     * 分页查询配置信息
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult findByPage(Integer pageNo, Integer pageSize);
}
