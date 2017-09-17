package com.scorpion.risk.api.service.impl;

import com.scorpion.risk.api.entity.RiskConfig;
import com.scorpion.risk.api.mapper.RiskConfigMapper;
import com.scorpion.risk.api.service.RiskConfigService;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2017/9/17.
 */
@Service
public class RiskConfigServiceImpl implements RiskConfigService {

    @Autowired
    private RiskConfigMapper riskConfigMapper;


    /**
     * 创建配置信息
     *
     * @param riskConfig
     * @return
     */
    @Override
    public BaseResult add(RiskConfig riskConfig) {
        return null;
    }

    /**
     * 根据id删除配置信息
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult deleteByPrimaryKey(Long id) {
        return null;
    }

    /**
     * 分页查询配置信息
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findByPage(Integer pageNo, Integer pageSize) {
        return null;
    }
}
