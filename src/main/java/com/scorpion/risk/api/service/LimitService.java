package com.scorpion.risk.api.service;

import com.github.pagehelper.Page;
import com.scorpion.risk.api.entity.Limit;
import com.scorpion.risk.result.PageResult;

import java.util.List;

/**
 * Created on 2017/9/17.
 */
public interface LimitService {

    List<Limit> findAll();

    Page<Limit> findByPage(int pageNum, int pageSize);
}
