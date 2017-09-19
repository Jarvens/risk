package com.scorpion.risk.api.mapper;

import com.scorpion.risk.api.entity.Donator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created on 2017/9/18.
 */
@Mapper
public interface DonatorMapper {

    int add(Donator donator);

    List<Donator> findAll();

    /**
     * 参数查询献血者信息
     *
     * @param certificateId 证件号码
     * @param name          姓名
     * @param mobile        手机号
     * @return
     */
    Donator findByCondition(@Param("certificateId") String certificateId,
                            @Param("name") String name,
                            @Param("mobile") String mobile);

}
