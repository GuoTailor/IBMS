package com.ibms.demo.controller;

import com.ibms.demo.pojo.PageView;
import com.ibms.demo.pojo.ResponseInfo;
import com.ibms.demo.pojo.User;
import com.ibms.demo.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gyh on 2021/2/4
 */
@RestController
@RequestMapping("/user")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @api {get} /user/info 获取用户信息
     * @apiDescription 获取用户信息
     * @apiName userInfo
     * @apiVersion 0.0.1
     * @apiParam {string} [id] 用户id
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {"id": 1,"username": "admin","name": "超级管理员","telephone": "110","createTime":
     * "2021-02-04 23:52:55","authorities": [{"id": 1,"name": "ROLE_SUPER_ADMIN","nameZh": "超级管理员","authority": "ROLE_SUPER_ADMIN"}]}}
     * @apiGroup User
     * @apiPermission admin
     */
    @GetMapping("/info")
    public ResponseInfo<User> userInfo(@RequestParam(required = false) Integer id) {
        return ResponseInfo.ok(userService.findUserById(id));
    }

    /**
     * @api {get} /user/all 获取所有用户信息
     * @apiDescription 获取所有用户信息
     * @apiName getAllUser
     * @apiVersion 0.0.1
     * @apiParam {Integer} page 第几页(从一开始)
     * @apiParam {Integer} size 每页大小
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {"pageNum": 1,"pageSize": 2,"total": 3,"list": [{"id": 1,"username": "admin",
     * "name": "超级管理员","telephone": "110","createTime": "2021-02-04 23:52:55","authorities": [{"id": 1,"name":
     * "ROLE_SUPER_ADMIN","nameZh": "超级管理员","unitId": 2,"authority": "ROLE_SUPER_ADMIN"}]},{"id": 3,"username":
     * "test","name": "test","telephone": "111","createTime": "2021-02-04 23:09:20","authorities": [{"id": 3,"name":
     * "ROLE_USER","nameZh": "用户","unitId": 2,"authority": "ROLE_USER"}]}],"pages": 2}}
     * @apiUse PageView
     * @apiGroup User
     * @apiPermission supperAdmin
     */
    @GetMapping("/all")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseInfo<PageView<User>> getAllUser(@RequestParam int page, @RequestParam int size) {
        return ResponseInfo.ok(userService.getAllUser(page, size));
    }

    /**
     * @api {delete} /user 删除用户
     * @apiDescription 删除用户
     * @apiName delete
     * @apiVersion 0.0.1
     * @apiParam {Integer} id 用户id
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup User
     * @apiPermission supperAdmin
     */
    @DeleteMapping()
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseInfo<Integer> delete(@RequestParam() Integer id) {
        return ResponseInfo.ok(userService.deleteUserById(id));
    }

    /**
     * @api {put} /user 更新用户
     * @apiDescription 更新用户，支持跟新密码
     * @apiName update
     * @apiVersion 0.0.1
     * @apiUse User
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup User
     * @apiPermission admin
     */
    @PutMapping
    public ResponseInfo<Integer> update(@RequestBody User user) {
        return ResponseInfo.ok(userService.update(user));
    }
}
