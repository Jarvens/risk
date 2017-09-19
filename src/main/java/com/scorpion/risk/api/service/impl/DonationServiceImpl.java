package com.scorpion.risk.api.service.impl;

import com.scorpion.risk.api.entity.ApiResponse;
import com.scorpion.risk.api.entity.Donation;
import com.scorpion.risk.api.entity.Donator;
import com.scorpion.risk.api.mapper.DonationMapper;
import com.scorpion.risk.api.mapper.DonatorMapper;
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

    @Autowired
    private DonatorMapper donatorMapper;

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
        return donationMapper.findAll();
    }

    /**
     * 条件查询  献血人信息  &献血记录
     *
     * @param certificateId
     * @param name
     * @param mobile
     * @return
     */
    @Override
    public BaseResult findByCondition(String certificateId, String name, String mobile) {

        Donator donator = donatorMapper.findByCondition(certificateId, name, mobile);
        if (null == donator)
            return BaseResult.notFound();
        List<Donation> donationList = donationMapper.findByDonatorId(donator.getId());
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setDonator(donator);
        apiResponse.setDonationList(donationList);
        return BaseResult.success(apiResponse);
    }


}
