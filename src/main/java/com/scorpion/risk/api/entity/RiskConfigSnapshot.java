package com.scorpion.risk.api.entity;

import java.util.List;

/**
 * Created on 2017/9/18.
 */
public class RiskConfigSnapshot extends RiskConfig {

    //主键
    private Long id;

    //名称
    private String name;

    //黑名单
    private List<IpList> blackList;

    //白名单
    private List<IpList> whiteList;

    //访问频率
    private int frequency;

    //最大客户端连接数
    private int maxClient;

    //授权码
    private String authorization;

    //有效期 单位:分钟
    private int expire;

    //配置模式  1手动  0自动
    private String auto;

    //开关   1关  0开   默认 关闭
    private String off;

    //接口id
    private Long interfaceId;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<IpList> getBlackList() {
        return blackList;
    }

    @Override
    public void setBlackList(List<IpList> blackList) {
        this.blackList = blackList;
    }

    @Override
    public List<IpList> getWhiteList() {
        return whiteList;
    }

    @Override
    public void setWhiteList(List<IpList> whiteList) {
        this.whiteList = whiteList;
    }

    @Override
    public int getFrequency() {
        return frequency;
    }

    @Override
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int getMaxClient() {
        return maxClient;
    }

    @Override
    public void setMaxClient(int maxClient) {
        this.maxClient = maxClient;
    }

    @Override
    public String getAuthorization() {
        return authorization;
    }

    @Override
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    @Override
    public int getExpire() {
        return expire;
    }

    @Override
    public void setExpire(int expire) {
        this.expire = expire;
    }

    @Override
    public String getAuto() {
        return auto;
    }

    @Override
    public void setAuto(String auto) {
        this.auto = auto;
    }

    @Override
    public String getOff() {
        return off;
    }

    @Override
    public void setOff(String off) {
        this.off = off;
    }

    public Long getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Long interfaceId) {
        this.interfaceId = interfaceId;
    }

    @Override
    public String toString() {
        return "RiskConfigSnapshot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blackList=" + blackList +
                ", whiteList=" + whiteList +
                ", frequency=" + frequency +
                ", maxClient=" + maxClient +
                ", authorization='" + authorization + '\'' +
                ", expire=" + expire +
                ", auto='" + auto + '\'' +
                ", off='" + off + '\'' +
                ", interfaceId=" + interfaceId +
                '}';
    }
}
