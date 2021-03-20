package com.ibms.demo.controller;

import com.ibms.demo.pojo.Model;
import com.ibms.demo.pojo.PageView;
import com.ibms.demo.pojo.ResponseInfo;
import com.ibms.demo.service.ModelService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gyh on 2021/3/2
 */
@RestController
@RequestMapping("/model")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    /**
     * @api {get} /model 获取模型列表
     * @apiDescription 获取模型列表
     * @apiName getModeList
     * @apiVersion 0.0.1
     * @apiParam {Integer} page 第几页(从一开始)
     * @apiParam {Integer} size 每页大小
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup Model
     * @apiPermission admin
     */
    @GetMapping
    public ResponseInfo<PageView<Model>> getModeList(@RequestParam int page, @RequestParam int size) {
        return ResponseInfo.ok(modelService.getModeList(page, size));
    }

    /**
     * @api {post} /model 创建模型
     * @apiDescription 创建模型
     * @apiName createMode
     * @apiVersion 0.0.1
     * @apiUse Model
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup Model
     * @apiPermission admin
     */
    @PostMapping
    public ResponseInfo<Integer> createMode(@RequestBody Model model) {
        return ResponseInfo.ok(modelService.createMode(model));
    }

    /**
     * @api {put} /model 更新模型
     * @apiDescription 更新模型
     * @apiName updateModel
     * @apiVersion 0.0.1
     * @apiUse Model
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup Model
     * @apiPermission admin
     */
    @PutMapping
    public ResponseInfo<Integer> updateModel(@RequestBody Model model) {
        return ResponseInfo.ok(modelService.updateModel(model));
    }

    /**
     * @api {delete} /model 删除模型
     * @apiDescription 删除模型
     * @apiName deleteModel
     * @apiVersion 0.0.1
     * @apiParam {Integer} id 模型id
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": {}}
     * @apiGroup Model
     * @apiPermission admin
     */
    @DeleteMapping
    public ResponseInfo<Integer> deleteModel(@RequestParam Integer id) {
        return ResponseInfo.ok(modelService.deleteModel(id));
    }
}
