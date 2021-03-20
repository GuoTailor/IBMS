package com.ibms.demo.mapper;

import com.ibms.demo.pojo.Model;

import java.util.List;

/**
 * @Entity com.ibms.demo.pojo.Model
 */
public interface ModelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Model record);

    int insertSelective(Model record);

    List<Model> findAll();

    Model selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);
}