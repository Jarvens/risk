package com.scorpion.risk.api.service;

import com.scorpion.risk.api.entity.Donator;
import com.scorpion.risk.result.BaseResult;
import com.scorpion.risk.result.PageResult;

import java.util.List;

/**
 * Created on 2017/9/18.
 */
public interface DonatorService {

    /**
     * 创建献血者
     * @param donator
     * @return
     */
    BaseResult add(Donator donator);


    /**
     * 查询所有献血者
     * @return
     */
    List<Donator> findAll();


}
