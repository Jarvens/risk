package com.scorpion.risk.api.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scorpion.risk.api.entity.Limit;
import com.scorpion.risk.api.mapper.LimitMapper;
import com.scorpion.risk.api.service.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 2017/9/17.
 */
@Service
@Transactional(readOnly = true)
public class LimitServiceImpl implements LimitService {

    @Autowired
    private LimitMapper limitMapper;


    @Override
    public List<Limit> findAll() {
        return null;
    }

    @Override
    public Page<Limit> findByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return limitMapper.findByPage();
    }
}
