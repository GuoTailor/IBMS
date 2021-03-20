package com.ibms.demo.service;

import com.ibms.demo.mapper.RoleMapper;
import com.ibms.demo.pojo.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gyh on 2021/2/7
 */
@Service
public class RoleService {
    @Resource
    RoleMapper roleMapper;
    private final Set<Role> roles = new HashSet<>();

    /**
     * 获取所有角色
     *
     * @return 角色集合
     */
    public Set<Role> getRoles() {
        if (roles.isEmpty()) {
            synchronized(RoleService.class) {
                if (roles.isEmpty()) {
                    roles.addAll(roleMapper.findAll());
                }
            }
        }
        return roles;
    }

    public Integer getRoleIdByName(String roleName) {
        return getRoles().stream()
                .filter(r -> r.getName().equals(roleName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("不存在该角色名:" + roleName))
                .getId();
    }

    /**
     * 给用户添加角色
     *
     * @param userId   用户id
     * @param roleName 角色id
     * @return 受影响行数
     */
    public Integer addRoleToUser(int userId, String roleName, Integer unitId) {
        Integer roleId = getRoleIdByName(roleName);
        return roleMapper.insert(userId, roleId, unitId);
    }

    /**
     * 给用户移除角色
     *
     * @param userId   用户id
     * @param roleName 角色id
     * @return 受影响行数
     */
    public Integer removeRoleToUser(int userId, String roleName, Integer unitId) {
        Integer roleId = getRoleIdByName(roleName);
        return roleMapper.removeRoleToUser(userId, roleId, unitId);
    }
}
