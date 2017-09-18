package com.scorpion.risk.api.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
        int result = riskConfigMapper.add(riskConfig);
        if (result <= 0) {
            return BaseResult.error("add_fail", "创建配置信息失败");
        }
        return BaseResult.success("创建配置信息成功");
    }

    /**
     * 根据id删除配置信息
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult deleteByPrimaryKey(Long id) {
        int result = riskConfigMapper.deleteByPrimaryKey(id);
        if (result <= 0)
            return BaseResult.error("delete_fail", "删除失败");
        return BaseResult.success("删除配置信息成功");
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
        PageHelper.startPage(pageNo, pageSize);
        Page<RiskConfig> riskConfigs = riskConfigMapper.findByPage();
        PageResult<RiskConfig> result = new PageResult<>(riskConfigs);
        return result;
    }
}
