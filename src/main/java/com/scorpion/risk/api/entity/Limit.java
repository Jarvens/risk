package com.scorpion.risk.api.entity;

import java.util.Date;

/**
 * Created on 2017/9/17.
 */
public class Limit {

    //主键
    private Long id;

    //IP地址
    private String ip;

    //访问次数
    private int count;

    //时间段
    private String timeQuantum;


    //创建时间
    private Date createTime;

    //修改时间
    private Date updateTime;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTimeQuantum() {
        return timeQuantum;
    }

    public void setTimeQuantum(String timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Limit{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", count=" + count +
                ", timeQuantum='" + timeQuantum + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
