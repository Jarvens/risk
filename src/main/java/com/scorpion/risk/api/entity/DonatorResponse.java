package com.scorpion.risk.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

/**
 * Created on 2017/9/19.
 */
public class DonatorResponse {

    //献血者编号
    private int DonorId;

    //献血者姓名
    private String Name;

    //献血者性别
    //0   未知的性别
    //1   男
    //2   女
    //9   未说明的性别
    //
    private String Sex;

    //年龄
    private int Age;

    //血型
    //0     不明
    //1     A
    //2     B
    //3     O
    //4     AB
    //5     其它
    private String ABO;

    //证件类型
    //0      身份证
    //1      军官证
    //2      士兵证
    //3      驾驶证
    //4      学生证
    //5      工作证
    //6      护照
    private String CertificateType;

    //证件号码
    private String CertificateID;

    //手机号
    private String MobileTelePhone;

    //联系电话
    private String TelePhone;

    //总献血量
    private Double DonationTotalVolumes;

    //最后献血日期
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date LastDonationDate;

    //献血记录集合
    private List<DonatorResponse> DonationList;

    public int getDonorId() {
        return DonorId;
    }

    public void setDonorId(int donorId) {
        DonorId = donorId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getABO() {
        return ABO;
    }

    public void setABO(String ABO) {
        this.ABO = ABO;
    }

    public String getCertificateType() {
        return CertificateType;
    }

    public void setCertificateType(String certificateType) {
        CertificateType = certificateType;
    }

    public String getCertificateID() {
        return CertificateID;
    }

    public void setCertificateID(String certificateID) {
        CertificateID = certificateID;
    }

    public String getMobileTelePhone() {
        return MobileTelePhone;
    }

    public void setMobileTelePhone(String mobileTelePhone) {
        MobileTelePhone = mobileTelePhone;
    }

    public String getTelePhone() {
        return TelePhone;
    }

    public void setTelePhone(String telePhone) {
        TelePhone = telePhone;
    }

    public Double getDonationTotalVolumes() {
        return DonationTotalVolumes;
    }

    public void setDonationTotalVolumes(Double donationTotalVolumes) {
        DonationTotalVolumes = donationTotalVolumes;
    }

    public Date getLastDonationDate() {
        return LastDonationDate;
    }

    public void setLastDonationDate(Date lastDonationDate) {
        LastDonationDate = lastDonationDate;
    }

    public List<DonatorResponse> getDonationList() {
        return DonationList;
    }

    public void setDonationList(List<DonatorResponse> donationList) {
        DonationList = donationList;
    }

    @Override
    public String toString() {
        return "DonatorResponse{" +
                "DonorId=" + DonorId +
                ", Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Age=" + Age +
                ", ABO='" + ABO + '\'' +
                ", CertificateType='" + CertificateType + '\'' +
                ", CertificateID='" + CertificateID + '\'' +
                ", MobileTelePhone='" + MobileTelePhone + '\'' +
                ", TelePhone='" + TelePhone + '\'' +
                ", DonationTotalVolumes=" + DonationTotalVolumes +
                ", LastDonationDate=" + LastDonationDate +
                ", DonationList=" + DonationList +
                '}';
    }
}
