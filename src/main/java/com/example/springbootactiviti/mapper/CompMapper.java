package com.example.springbootactiviti.mapper;

import com.example.springbootactiviti.entity.Comp;

public interface CompMapper {
    int deleteByPrimaryKey(Integer compId);

    int insert(Comp record);

    int insertSelective(Comp record);

    Comp selectByPrimaryKey(Integer compId);

    int updateByPrimaryKeySelective(Comp record);

    int updateByPrimaryKey(Comp record);
}