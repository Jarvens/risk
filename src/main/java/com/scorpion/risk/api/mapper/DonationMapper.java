package com.scorpion.risk.api.mapper;

import com.scorpion.risk.api.entity.Donation;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created on 2017/9/18.
 */
@Mapper
public interface DonationMapper {

    int add(Donation donation);
}
