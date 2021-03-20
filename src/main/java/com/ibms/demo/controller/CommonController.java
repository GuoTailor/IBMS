package com.ibms.demo.controller;

import com.ibms.demo.pojo.ResponseInfo;
import com.ibms.demo.pojo.User;
import com.ibms.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gyh on 2021/2/4
 */
@RestController
@RequestMapping("/common")
public class CommonController {
    final UserService userService;

    public CommonController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseInfo<String> test() {
        return ResponseInfo.ok();
    }

    /**
     * @api {post} /common/register 注册用户
     * @apiDescription 注册用户
     * @apiName register
     * @apiVersion 0.0.1
     * @apiUse User
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup Common
     * @apiPermission none
     */
    @PostMapping("/register")
    public ResponseInfo<User> register(User user) {
        return ResponseInfo.ok(userService.register(user));
    }
}
