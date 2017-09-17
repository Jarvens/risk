package com.scorpion.risk.api.mapper;

import com.github.pagehelper.Page;
import com.scorpion.risk.api.entity.Limit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2017/9/17.
 */
@Mapper
public interface LimitMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Limit limit);

    Limit selectByPrimaryKey(Long id);

    Page<Limit> findByPage();

    List<Limit> findAll();
}
