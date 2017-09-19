package com.scorpion.risk.api.mapper;

import com.scorpion.risk.api.entity.Donation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2017/9/18.
 */
@Mapper
public interface DonationMapper {

    int add(Donation donation);

    /**
     * 录入献血证编号
     *
     * @param donationId
     * @return
     */
    int addDonationId(String donationId);

    List<String> findAll();

}
