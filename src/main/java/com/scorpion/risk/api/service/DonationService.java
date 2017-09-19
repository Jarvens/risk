package com.scorpion.risk.api.service;

import com.scorpion.risk.api.entity.Donation;
import com.scorpion.risk.result.BaseResult;

import java.util.List;

/**
 * Created on 2017/9/18.
 */
public interface DonationService {

    void add(Donation donation);

    BaseResult addDonationId(List<String> donationId);

    List<String> findAll();


}
