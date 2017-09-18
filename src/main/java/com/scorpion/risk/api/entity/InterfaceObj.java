package com.scorpion.risk.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created on 2017/9/18.
 */
public class InterfaceObj {

    //主键
    private Long id;

    //接口名称
    private String name;

    //接口类型   1.GET  0.POST
    private String type;

    //接口地址
    private String url;

    //规则编号
    private String ruleCode;

    //是否存在参数  1存在  0不存在
    private String params;

    //参数类型  1字符串  2数字 3对象  4json字符串
    private String paramsType;

    //创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //修改时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getParamsType() {
        return paramsType;
    }

    public void setParamsType(String paramsType) {
        this.paramsType = paramsType;
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
        return "InterfaceObj{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", ruleCode='" + ruleCode + '\'' +
                ", params='" + params + '\'' +
                ", paramsType='" + paramsType + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
