package com.scorpion.risk.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created on 2017/9/18.
 */
public class Donation {

    //主键
    private Long id;

    //献血编号
    private Long donationId;

    //献血日期
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date donationDate;

    //采集类型 0全血 1成分
    private String collectionType;

    //献血量
    private Integer donationVolumes;

    //献血地点
    private String donationAddress;

    //献血机构
    private String donationOrg;

    //创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    //修改时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    //城市编码
    private Integer city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDonationId() {
        return donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public Integer getDonationVolumes() {
        return donationVolumes;
    }

    public void setDonationVolumes(Integer donationVolumes) {
        this.donationVolumes = donationVolumes;
    }

    public String getDonationAddress() {
        return donationAddress;
    }

    public void setDonationAddress(String donationAddress) {
        this.donationAddress = donationAddress;
    }

    public String getDonationOrg() {
        return donationOrg;
    }

    public void setDonationOrg(String donationOrg) {
        this.donationOrg = donationOrg;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", donationId=" + donationId +
                ", donationDate=" + donationDate +
                ", collectionType='" + collectionType + '\'' +
                ", donationVolumes=" + donationVolumes +
                ", donationAddress='" + donationAddress + '\'' +
                ", donationOrg='" + donationOrg + '\'' +
                ", createtime=" + createtime +
                ", updateTime=" + updateTime +
                ", city=" + city +
                '}';
    }
}
