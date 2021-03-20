package com.ibms.demo.mapper;

import com.ibms.demo.pojo.Role;

import java.util.Collection;
import java.util.List;

/**
 * Created by gyh on 2021/2/4
 */
public interface RoleMapper {
    List<Role> findRoleByUserId(Integer userId);

    Integer insert(Integer userId, Integer roleId, Integer unitId);

    List<Role> findAll();

    Integer findIdByName(String name);

    Integer removeRoleToUser(Integer userId, Integer roleId, Integer unitId);

    Integer deleteById(Integer id);
}
