package com.scorpion.risk.api.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scorpion.risk.api.entity.InterfaceObj;
import com.scorpion.risk.api.entity.RiskConfig;
import com.scorpion.risk.api.entity.RiskConfigSnapshot;
import com.scorpion.risk.api.mapper.InterfaceObjMapper;
import com.scorpion.risk.api.mapper.RiskConfigMapper;
import com.scorpion.risk.api.mapper.RiskConfigSnapShotMapper;
import com.scorpion.risk.api.service.InterfaceObjService;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.result.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2017/9/18.
 */
@Service
public class InterfaceObjServiceImpl implements InterfaceObjService {

    @Autowired
    private InterfaceObjMapper interfaceObjMapper;

    @Autowired
    private RiskConfigMapper riskConfigMapper;

    @Autowired
    private RiskConfigSnapShotMapper riskConfigSnapShotMapper;

    /**
     * 创建接口
     *
     * @param interfaceObj
     * @return
     */
    @Override
    public BaseResult add(InterfaceObj interfaceObj) {
        int result = interfaceObjMapper.add(interfaceObj);
        if (result <= 0)
            return BaseResult.error("add_fail", "操作失败");
        return BaseResult.success("操作成功");
    }


    /**
     * 根据主键删除接口信息
     *
     * @param id
     * @return
     */
    @Override
    public BaseResult deleteByPrimaryKey(Long id) {
        int result = interfaceObjMapper.deleteByPrimaryKey(id);
        if (result <= 0)
            return BaseResult.error("delete_fail", "操作失败");
        return BaseResult.success("操作成功");
    }


    /**
     * 修改接口信息
     *
     * @param interfaceObj
     * @return
     */
    @Override
    public BaseResult update(InterfaceObj interfaceObj) {
        int result = interfaceObjMapper.update(interfaceObj);
        if (result <= 0)
            return BaseResult.error("update_fail", "操作失败");
        return BaseResult.success("操作成功");
    }

    /**
     * 分页查询接口列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findByPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page<InterfaceObj> page = interfaceObjMapper.findByPage();
        PageResult result = new PageResult(page);
        return result;
    }


    /**
     * 查询所有接口列表
     *
     * @return
     */
    @Override
    public BaseResult findAll() {
        List<InterfaceObj> list = interfaceObjMapper.findAll();
        return BaseResult.success(list);
    }

    /**
     * 设置接口规则
     *
     * @param interfaceId
     * @param ruleId
     * @return
     */
    @Override
    public BaseResult ruleSetting(Long interfaceId, Long ruleId) {
        RiskConfig riskConfig = riskConfigMapper.findByPrimaryKey(ruleId);
        if (null == riskConfig)
            return BaseResult.error("config_not_found", "规则不存在");
        RiskConfigSnapshot riskConfigSnapshot = new RiskConfigSnapshot();
        BeanUtils.copyProperties(riskConfig, riskConfigSnapshot);
        riskConfigSnapshot.setInterfaceId(interfaceId);
        int result = riskConfigSnapShotMapper.add(riskConfigSnapshot);
        if (result > 0)
            return BaseResult.success("操作成功");
        return BaseResult.error("setting_fail", "操作失败");
    }


}
