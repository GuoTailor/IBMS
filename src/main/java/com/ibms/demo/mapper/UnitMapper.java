package com.ibms.demo.mapper;

import com.ibms.demo.pojo.Unit;

import java.util.List;

/**
 * @Entity com.ibms.demo.pojo.Unit
 */
public interface UnitMapper {

    List<Unit> findAll();

    List<Unit> findByUserId(Integer userId);

    int deleteByPrimaryKey(Integer id);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
}