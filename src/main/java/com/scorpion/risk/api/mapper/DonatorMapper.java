package com.scorpion.risk.api.mapper;

import com.scorpion.risk.api.entity.Donator;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2017/9/18.
 */
@Mapper
public interface DonatorMapper {

    int add(Donator donator);

    List<Donator> findAll();

}
