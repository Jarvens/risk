package com.scorpion.risk.api.service;

import com.scorpion.risk.api.entity.Donation;
import com.scorpion.risk.result.BaseResult;

import java.util.List;

/**
 * Created on 2017/9/18.
 */
public interface DonationService {

    /**
     * 创建献血数据
     *
     * @param donation
     */
    void add(Donation donation);

    /**
     * 读取文件内献血证编号 入库
     *
     * @param donationId
     * @return
     */
    BaseResult addDonationId(List<String> donationId);

    /**
     * 查询所有献血证编号
     *
     * @return
     */
    List<String> findAll();

    /**
     * 条件查询 献血人信息
     *
     * @param certificateId
     * @param name
     * @param mobile
     * @return
     */
    BaseResult findByCondition(String certificateId, String name, String mobile);


}
