package com.ibms.demo.controller;

import com.ibms.demo.pojo.Building;
import com.ibms.demo.pojo.PageView;
import com.ibms.demo.pojo.ResponseInfo;
import com.ibms.demo.service.BuildingService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gyh on 2021/2/4
 */
@RestController
@RequestMapping("/building")
public class BuildingController {
    final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    /**
     * @api {get} /building/list 获取楼宇列表
     * @apiDescription 获取楼宇列表
     * @apiName getBuildingList
     * @apiVersion 0.0.1
     * @apiParam {Integer} page 第几页(从一开始)
     * @apiParam {Integer} size 每页大小
     * @apiParam {Integer} [parentId] 上级id，如果不传就返回当前部门管理的楼宇
     * @apiParamExample {url} 请求示例:
     * /building/list?page=1&size=2&parentId=3
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {"pageNum": 1,"pageSize": 2,"total": 3,"list": [{"id": 4,"parentId": 3,"unitId":
     * 2,"name": "15-201","type": 3,"comment": null,"createTime": "2021-02-07 14:03:59"},{"id": 5,"parentId": 3,"unitId":
     * 2,"name": "15-202","type": 3,"comment": null,"createTime": "2021-02-07 14:04:13"}],"pages": 2}}
     * @apiSuccess (返回) {Integer} parentId 上级id
     * @apiSuccess (返回) {Integer} unitId 部门id
     * @apiSuccess (返回) {String} name 名称
     * @apiSuccess (返回) {Integer} type 类型{1:楼宇,2:楼层,3:房间}
     * @apiSuccess (返回) {String} comment 备注
     * @apiSuccess (返回) {Date} createTime 创建时间
     * @apiGroup Building
     * @apiPermission admin
     */
    @GetMapping("/list")
    public ResponseInfo<PageView<Building>> getBuildingList(@RequestParam int page, @RequestParam int size,
                                                            @RequestParam(required = false) Integer parentId) {
        return ResponseInfo.ok(buildingService.getBuildingList(page, size, parentId));
    }

    /**
     * @api {post} /building 创建楼宇
     * @apiDescription 创建楼宇
     * @apiName createBuilding
     * @apiVersion 0.0.1
     * @apiUse Building
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup Building
     * @apiPermission admin
     */
    @PostMapping
    public ResponseInfo<Building> createBuilding(@RequestBody Building building) {
        return ResponseInfo.ok(buildingService.createBuilding(building));
    }

    /**
     * @api {put} /building 修改楼宇的信息
     * @apiDescription 修改楼宇的信息。不能修改楼宇的父类id，不能修改楼宇的类型，不能修改楼宇的部门id
     * @apiName updateBuilding
     * @apiVersion 0.0.1
     * @apiParam {Integer} id id
     * @apiParam {String} [name] 名称
     * @apiParam {String} [comment] 备注
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup Building
     * @apiPermission admin
     */
    @PutMapping
    public ResponseInfo<Integer> updateBuilding(@RequestBody Building building) {
        return ResponseInfo.ok(buildingService.updateBuilding(building));
    }

    /**
     * @api {delete} /building 删除楼宇
     * @apiDescription 删除楼宇
     * @apiName removeBuilding
     * @apiVersion 0.0.1
     * @apiParam {Integer} id id
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup Building
     * @apiPermission admin
     */
    @DeleteMapping
    public ResponseInfo<Integer> removeBuilding(@RequestParam Integer id) {
        return ResponseInfo.ok(buildingService.removeBuilding(id));
    }
}
