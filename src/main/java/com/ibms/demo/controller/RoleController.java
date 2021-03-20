package com.ibms.demo.controller;

import com.ibms.demo.pojo.ResponseInfo;
import com.ibms.demo.pojo.Role;
import com.ibms.demo.service.RoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by gyh on 2021/2/4
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * @api {get} /role/all 获取所有角色列表
     * @apiDescription 获取所有角色列表
     * @apiName getAllRoles
     * @apiVersion 0.0.1
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": [{"id": 1,"name": "ROLE_SUPER_ADMIN","nameZh": null,"authority":
     * "ROLE_SUPER_ADMIN"},{"id": 2,"name": "ROLE_ADMIN","nameZh": null,"authority": "ROLE_ADMIN"},{"id": 3,"name":
     * "ROLE_USER","nameZh": null,"authority": "ROLE_USER"}]}
     * @apiGroup Role
     * @apiPermission admin
     */
    @GetMapping("/all")
    public ResponseInfo<Set<Role>> getAllRoles() {
        return ResponseInfo.ok(roleService.getRoles());
    }

    /**
     * @api {put} /role 为用户添加角色到部门
     * @apiDescription 为用户添加角色到部门
     * @apiName addRoleToUser
     * @apiVersion 0.0.1
     * @apiParam {Integer} userId 用户id
     * @apiParam {Integer} unitId 部门id
     * @apiParam {String} roleName 角色名（ROLE_SUPER_ADMIN：超级管理员，ROLE_ADMIN：管理员，ROLE_USER：用户；等）
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup Role
     * @apiPermission superAdmin
     */
    @PutMapping()
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseInfo<Integer> addRoleToUser(@RequestParam int userId, @RequestParam String roleName, @RequestParam int unitId) {
        return ResponseInfo.ok(roleService.addRoleToUser(userId, roleName, unitId));
    }

    /**
     * @api {delete} /role 为部门用户移除角色
     * @apiDescription 为部门用户移除角色
     * @apiName removeRoleToUser
     * @apiVersion 0.0.1
     * @apiParam {Integer} userId 用户id
     * @apiParam {Integer} unitId 部门id
     * @apiParam {String} roleName 角色名（ROLE_SUPER_ADMIN：超级管理员，ROLE_ADMIN：管理员，ROLE_USER：用户）
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup Role
     * @apiPermission superAdmin
     */
    @DeleteMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseInfo<Integer> removeRoleToUser(@RequestParam int userId, @RequestParam String roleName, @RequestParam int unitId) {
        return ResponseInfo.ok(roleService.removeRoleToUser(userId, roleName, unitId));
    }
}
