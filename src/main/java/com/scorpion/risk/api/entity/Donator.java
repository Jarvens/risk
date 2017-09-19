package com.scorpion.risk.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created on 2017/9/18.
 */
public class Donator {

    //主键
    private Long id;

    //献血者唯一标识id
    private int donorId;

    //姓名
    private String name;

    //性别 0 未知 1 男 2 女 9 未说明的性别
    private String sex;

    //年龄
    private Integer age;

    //abo血型  0不明  1A 2B 3O 4AB 9其它
    private String abo;

    //证件号码
    private String certificateId;

    //证件类型 0身份证 1军官证  2士兵证 3驾驶证  4学生证 5工作证 6护照
    private String certificateType;

    //手机
    private String mobileTelePhone;

    //联系电话
    private String telePhone;

    //献血总量
    private Double donationTotalVolumes;

    //最后献血时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastDonationDate;

    //创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //修改时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    //RH血型
    private String rh;

    //城市编码
    private Integer city;

    //联系地址
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAbo() {
        return abo;
    }

    public void setAbo(String abo) {
        this.abo = abo;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getMobileTelePhone() {
        return mobileTelePhone;
    }

    public void setMobileTelePhone(String mobileTelePhone) {
        this.mobileTelePhone = mobileTelePhone;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public Date getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(Date lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
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

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getDonationTotalVolumes() {
        return donationTotalVolumes;
    }

    public void setDonationTotalVolumes(Double donationTotalVolumes) {
        this.donationTotalVolumes = donationTotalVolumes;
    }

    @Override
    public String toString() {
        return "Donator{" +
                "id=" + id +
                ", donorId=" + donorId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", abo='" + abo + '\'' +
                ", certificateId='" + certificateId + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", mobileTelePhone='" + mobileTelePhone + '\'' +
                ", telePhone='" + telePhone + '\'' +
                ", donationTotalVolumes=" + donationTotalVolumes +
                ", lastDonationDate=" + lastDonationDate +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", rh='" + rh + '\'' +
                ", city=" + city +
                ", address='" + address + '\'' +
                '}';
    }
}
