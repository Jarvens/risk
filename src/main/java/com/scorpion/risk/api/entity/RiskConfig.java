package com.scorpion.risk.api.entity;

import java.util.List;

/**
 * Created on 2017/9/17.
 */
public class RiskConfig {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<IpList> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<IpList> blackList) {
        this.blackList = blackList;
    }

    public List<IpList> getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(List<IpList> whiteList) {
        this.whiteList = whiteList;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getMaxClient() {
        return maxClient;
    }

    public void setMaxClient(int maxClient) {
        this.maxClient = maxClient;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getOff() {
        return off;
    }

    public void setOff(String off) {
        this.off = off;
    }

    @Override
    public String toString() {
        return "RiskConfig{" +
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
                '}';
    }
}
