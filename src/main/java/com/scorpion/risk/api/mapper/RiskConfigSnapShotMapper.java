package com.scorpion.risk.api.mapper;

import com.scorpion.risk.api.entity.InterfaceObj;
import com.scorpion.risk.api.entity.RiskConfigSnapshot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created on 2017/9/18.
 */
@Mapper
public interface RiskConfigSnapShotMapper {

    /**
     * 创建规则快照
     * @param riskConfigSnapshot
     * @return
     */
    int add(RiskConfigSnapshot riskConfigSnapshot);

    /**
     * 根据请求类型  以及请求地址查询接口规则配置
     *
     * @param method
     * @param url
     * @return
     */
    RiskConfigSnapshot findByMethodTypeAndUrl(@Param("method") String method, @Param("url") String url);


}
