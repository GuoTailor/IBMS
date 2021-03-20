package com.ibms.demo.controller;

import com.aliyun.iot20180120.models.QueryDeviceResponseBody;
import com.aliyun.iot20180120.models.QueryProductListResponseBody;
import com.ibms.demo.pojo.ResponseInfo;
import com.ibms.demo.service.DeviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gyh on 2021/3/2
 */
@RestController
@RequestMapping("/device")
public class DevicesController {
    final DeviceService deviceService;

    public DevicesController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    /**
     * @api {post} /device/product 获取产品列表
     * @apiDescription 获取产品列表
     * @apiName getProductList
     * @apiVersion 0.0.1
     * @apiParam {Integer} page 第几页(从一开始)
     * @apiParam {Integer} size 每页大小
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": [{"gmtCreate":1610541754000,"dataFormat":1,"description":null,"deviceCount":1,
     * "nodeType":0,"productKey":"a18J9whiM6i","productName":"测试","authType":"secret"},{"gmtCreate":1604222323000,
     * "dataFormat":1,"description":null,"deviceCount":0,"nodeType":0,"productKey":"a1vK9deNhNV","productName":"test",
     * "authType":"secret"},{"gmtCreate":1602989671000,"dataFormat":1,"description":null,"deviceCount":4,"nodeType":0,
     * "productKey":"a11fef3ti51","productName":"照明","authType":"secret"}]}
     * @apiSuccess (返回) {Integer} gmtCreate 时间戳（毫秒
     * @apiSuccess (返回) {Integer} dataFormat 0：透传模式。使用自定义的串口数据格式。该模式下，设备可以上报原始数据（如二进制数据流）。
     * 阿里云物联网平台会运行您配置在云端的数据解析脚本，将原始数据转换成Alink JSON标准数据格式。
     * 1：Alink JSON。阿里云物联网平台定义的设备与云端的数据交换协议，采用 JSON 格式。
     * @apiSuccess (返回) {String} description 产品描述。
     * @apiSuccess (返回) {Integer} deviceCount 产品下的设备数量。
     * @apiSuccess (返回) {Integer} nodeType 0：设备。设备不能挂载子设备，可以直连IoT Hub，也可以作为网关的子设备连接IoT Hub。
     * 1：网关。网关可以挂载子设备，具有子设备管理模块，维持子设备的拓扑关系，并且可以将拓扑关系同步到云端。
     * @apiSuccess (返回) {String} productKey 产品的ProductKey。创建产品时，物联网平台为该产品颁发的全局唯一标识。
     * @apiSuccess (返回) {String} productName 产品名称。
     * @apiSuccess (返回) {String} authType 产品下的设备接入物联网平台的认证方式。secret：设备密钥。id2：ID²。x509：X.509证书。
     * @apiGroup Device
     * @apiPermission admin
     * @return
     */
    @GetMapping("/product")
    public ResponseInfo<QueryProductListResponseBody> getProductList(int page, int size) throws Exception {
        return ResponseInfo.ok(deviceService.getProductList(page, size));
    }

    /**
     * @api {post} /device/list 获取设备列表
     * @apiDescription 获取设备列表
     * @apiName queryDevice
     * @apiVersion 0.0.1
     * @apiParam {Integer} page 第几页(从一开始)
     * @apiParam {Integer} size 每页大小
     * @apiParam {String} productKey 产品的ProductKey。创建产品时，物联网平台为该产品颁发的全局唯一标识。
     * @apiSuccessExample {json} 成功返回:
     * {"code": 0,"msg": "成功","data": [{"deviceId":"eQfK5UGgFBF1ZMilMmDo","deviceSecret":"79e3e6ce93dbea9e128cbcb52f30eca9"
     * ,"productKey":"a11fef3ti51","deviceStatus":"OFFLINE","deviceName":"AirConditioner","deviceType":null,"gmtCreate":
     * "Mon,11-Jan-2021 08:58:25 GMT","gmtModified":"Mon, 11-Jan-2021 08:58:25 GMT","utcCreate":"2021-01-11T08:58:25.000Z",
     * "utcModified":"2021-01-11T08:58:25.000Z","iotId":"eQfK5UGgFBF1ZMilMmDo000000","nickname":"空调"},{"deviceId":
     * "iYhldBKJp8VMIZxLxY30","deviceSecret":"db4c5bf28aea0427f457a9b7fd6e0355","productKey":"a11fef3ti51","deviceStatus"
     * :"OFFLINE","deviceName":"DeviveTest","deviceType":null,"gmtCreate":"Wed, 30-Dec-2020 11:13:35 GMT","gmtModified":
     * "Wed,30-Dec-2020 11:13:35 GMT","utcCreate":"2020-12-30T11:13:35.000Z","utcModified":"2020-12-30T11:13:35.000Z","iotId":
     * "iYhldBKJp8VMIZxLxY30000000","nickname":null}]}
     * @apiSuccess (返回) {String} deviceId 设备ID（旧版参数）
     * @apiSuccess (返回) {String} deviceSecret 设备密钥。
     * @apiSuccess (返回) {String} productKey 设备所隶属的产品ProductKey。
     * @apiSuccess (返回) {String} deviceStatus ONLINE：设备在线。OFFLINE：设备离线。UNACTIVE：设备未激活。DISABLE：设备已禁用。
     * @apiSuccess (返回) {String} deviceName 设备名称。
     * @apiSuccess (返回) {String} deviceType 设备所属产品的品类。
     * @apiSuccess (返回) {String} gmtCreate 设备创建时间，GMT格式。
     * @apiSuccess (返回) {String} gmtModified 设备信息最后一次更新时的时间，GMT格式。
     * @apiSuccess (返回) {String} utcCreate 设备创建时间，UTC格式。
     * @apiSuccess (返回) {String} utcModified 设备信息最后一次更新时的时间，UTC格式。
     * @apiSuccess (返回) {String} iotId 设备ID。物联网平台为该设备颁发的ID，设备的唯一标识符。
     * @apiSuccess (返回) {String} nickname 设备的备注名称。
     * @apiGroup Device
     * @apiPermission admin
     * @return
     */
    @GetMapping("/list")
    public ResponseInfo<QueryDeviceResponseBody> queryDevice(int page, int size, String productKey) throws Exception {
        return ResponseInfo.ok(deviceService.queryDevice(page, size, productKey));
    }

}
