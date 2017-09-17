package com.scorpion.risk.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created on 2017/9/17.
 */
public class IpList {

    //主键
    private Long id;

    //ip
    private String ip;

    //类型 1 白名单  0 黑名单
    private String type;

    //创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //修改时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "IpList{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", type='" + type + '\'' +
                ", createTime=" + createTime +
                ", updatetime=" + updatetime +
                '}';
    }
}
