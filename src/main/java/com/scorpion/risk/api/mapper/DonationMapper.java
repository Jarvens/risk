package com.scorpion.risk.api.mapper;

import com.scorpion.risk.api.entity.Donation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据献血人主键查询献血记录
     *
     * @param donatorId
     * @return
     */
    List<Donation> findByDonatorId(@Param("donatorId") Long donatorId);

}
