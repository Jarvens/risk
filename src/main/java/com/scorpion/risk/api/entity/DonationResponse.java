package com.scorpion.risk.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created on 2017/9/19.
 */
public class DonationResponse {

    //献血编号  唯一识别码
    private String DonationID;

    //献血日期
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date DonationDate;

    //采集类型
    //0     全血
    //1     成分血
    private String CollectionType;

    //献血量
    private Double DonationVolumes;

    public String getDonationID() {
        return DonationID;
    }

    public void setDonationID(String donationID) {
        DonationID = donationID;
    }

    public Date getDonationDate() {
        return DonationDate;
    }

    public void setDonationDate(Date donationDate) {
        DonationDate = donationDate;
    }

    public String getCollectionType() {
        return CollectionType;
    }

    public void setCollectionType(String collectionType) {
        CollectionType = collectionType;
    }

    public Double getDonationVolumes() {
        return DonationVolumes;
    }

    public void setDonationVolumes(Double donationVolumes) {
        DonationVolumes = donationVolumes;
    }

    @Override
    public String toString() {
        return "DonationResponse{" +
                "DonationID='" + DonationID + '\'' +
                ", DonationDate=" + DonationDate +
                ", CollectionType='" + CollectionType + '\'' +
                ", DonationVolumes=" + DonationVolumes +
                '}';
    }
}
