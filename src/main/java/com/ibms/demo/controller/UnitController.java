package com.ibms.demo.controller;

import com.ibms.demo.pojo.PageView;
import com.ibms.demo.pojo.ResponseInfo;
import com.ibms.demo.pojo.Unit;
import com.ibms.demo.service.UnitService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gyh on 2021/2/6
 */
@RestController
@RequestMapping("/unit")
public class UnitController {
    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    /**
     * @api {get} /unit 获取单位信息
     * @apiDescription 获取单位信息
     * @apiName findUnitById
     * @apiVersion 0.0.1
     * @apiParam {string} id 单位id
     * @apiParamExample {url} 请求示例:
     * /unit?id=2
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {"id": 2,"name": "test","site": "重庆电子校6305","userId": 3,"createTime":
     * "2021-02-06T09:59:50.000+00:00","user": {"id": 3,"username": "test","name": "test","telephone": "111","createTime":
     * "2021-02-04 23:09:20","authorities": [{"id": 3,"name": "ROLE_USER","nameZh": "用户","authority": "ROLE_USER"}]}}}
     * @apiGroup Unit
     * @apiPermission supperAdmin
     */
    @GetMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseInfo<Unit> findUnitById(@RequestParam Integer id) {
        return ResponseInfo.ok(unitService.findById(id));
    }

    /**
     * @api {get} /unit/all 获取所有单位信息
     * @apiDescription 获取所有单位信息
     * @apiName getAllUnit
     * @apiVersion 0.0.1
     * @apiParam {Integer} page 第几页 (从一开始)
     * @apiParam {Integer} size 每页大小
     * @apiParamExample {url} 请求示例:
     * /unit/all?page=1&size=1
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {"pageNum": 1,"pageSize": 1,"total": 2,"list": [{"id": 1,"name": "test","site":
     * "重庆电子校6305","userId": null,"createTime": null,"user": null}],"pages": 2}}
     * @apiUse PageView
     * @apiGroup Unit
     * @apiPermission supperAdmin
     */
    @GetMapping("/all")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseInfo<PageView<Unit>> getAllUnit(@RequestParam int page, @RequestParam int size) {
        return ResponseInfo.ok(unitService.getAllUnit(page, size));
    }

    /**
     * @api {post} /unit 创建单位
     * @apiDescription 创建单位
     * @apiName createUnit
     * @apiVersion 0.0.1
     * @apiUse Unit
     * @apiParamExample {json} 请求示例:
     * {"site": "重庆电子校6305","name": "test","userId": 3}
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {"id": 2,"name": "test","site": "重庆电子校6305","userId": 3,"createTime": null}}
     * @apiGroup Unit
     * @apiPermission supperAdmin
     */
    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseInfo<Unit> createUnit(@RequestBody Unit unit) {
        return ResponseInfo.ok(unitService.createUnit(unit));
    }

    /**
     * @api {put} /unit 更新单位
     * @apiDescription 更新单位
     * @apiName updateUnit
     * @apiVersion 0.0.1
     * @apiUse Unit
     * @apiParamExample {json} 请求示例:
     * {"id": 2,"site": "重庆电子校6305","name": "电子校"}
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup Unit
     * @apiPermission supperAdmin
     */
    @PutMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseInfo<Integer> updateUnit(@RequestBody Unit unit) {
        return ResponseInfo.ok(unitService.updateUnit(unit));
    }

    /**
     * @api {delete} /unit 删除单位
     * @apiDescription 删除单位
     * @apiName removeUnit
     * @apiVersion 0.0.1
     * @apiParam {Integer} id 单位id
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup User
     * @apiPermission supperAdmin
     */
    @DeleteMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseInfo<Integer> removeUnit(@RequestParam Integer id) {
        return ResponseInfo.ok(unitService.removeUnit(id));
    }
}
