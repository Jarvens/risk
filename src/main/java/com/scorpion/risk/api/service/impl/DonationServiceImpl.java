package com.scorpion.risk.api.service.impl;

import com.scorpion.risk.api.entity.Donation;
import com.scorpion.risk.api.mapper.DonationMapper;
import com.scorpion.risk.api.service.DonationService;
import com.scorpion.risk.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2017/9/18.
 */
@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    private DonationMapper donationMapper;

    /**
     * 创建献血记录
     *
     * @param donation
     */
    @Override
    public void add(Donation donation) {

        int result = donationMapper.add(donation);

    }

    /**
     * 录入献血证编号
     *
     * @param donationId
     */
    @Override
    public BaseResult addDonationId(List<String> donationId) {
        for (String str : donationId) {
            donationMapper.addDonationId(str);
        }
        return BaseResult.success("数据导入成功");

    }

    @Override
    public List<String> findAll() {
        return null;
    }


}
