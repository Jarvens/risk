package com.scorpion.risk.api.mapper;

import com.scorpion.risk.api.entity.RiskConfigSnapshot;
import org.apache.ibatis.annotations.Mapper;

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


}
