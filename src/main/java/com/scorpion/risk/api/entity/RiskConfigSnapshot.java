package com.scorpion.risk.api.entity;

/**
 * Created on 2017/9/18.
 */
public class RiskConfigSnapshot extends RiskConfig {

    //接口id
    private Long interfaceId;


    public Long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Long interfaceId) {
        this.interfaceId = interfaceId;
    }

    @Override
    public String toString() {
        return "RiskConfigSnapshot{" +
                "interfaceId=" + interfaceId +
                '}';
    }
}
