package com.scorpion.risk.api.service.impl;

import com.scorpion.risk.api.entity.Donator;
import com.scorpion.risk.api.mapper.DonatorMapper;
import com.scorpion.risk.api.service.DonatorService;
import com.scorpion.risk.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2017/9/18.
 */
@Service
public class DonatorServiceImpl implements DonatorService {


    @Autowired
    private DonatorMapper donatorMapper;

    /**
     * 创建献血者
     *
     * @param donator
     * @return
     */
    @Override
    public BaseResult add(Donator donator) {
        return null;
    }

    /**
     * 查询所有献血者
     *
     * @return
     */
    @Override
    public List<Donator> findAll() {
        return donatorMapper.findAll();
    }


}
