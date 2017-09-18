package com.scorpion.risk.api.service.impl;

import com.scorpion.risk.api.entity.Donation;
import com.scorpion.risk.api.mapper.DonationMapper;
import com.scorpion.risk.api.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
