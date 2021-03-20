package com.ibms.demo.mapper;

import com.ibms.demo.pojo.Building;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity com.ibms.demo.pojo.Building
 */
public interface BuildingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Building record);

    int insertSelective(Building record);

    Building selectByPrimaryKey(Integer id);

    Integer findTypeById(Integer id);

    List<Building> findAllByParentId(Integer parentId);

    List<Building> findAllByUnitId(Integer unitId);

    int updateByPrimaryKeySelective(Building record);

    int updateByPrimaryKey(Building record);
}
