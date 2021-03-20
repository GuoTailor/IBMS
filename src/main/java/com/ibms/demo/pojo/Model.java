package com.ibms.demo.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 模型
 *
 * @apiDefine Model
 * @apiParam {Integer} id id
 * @apiParam {String} name 模型名字
 * @apiParam {Integer} buildingId 所属楼宇
 * @apiParam {String} iotId iotId
 * @apiParam {String} productKey productKey
 * @apiParam {String} deviceName deviceName
 * @apiParam {Date} createTime 创建时间
 */
public class Model implements Serializable {

    private Integer id;

    /**
     * 模型名称
     */
    private String name;

    /**
     * 所属楼宇
     */
    private Integer buildingId;

    /**
     * 创建时间
     */
    private Date createTime;

    private String iotId;
    private String productKey;
    private String deviceName;
    private String buildingName;

    /**
     *
     */
    public Integer getId() {
        return id;
    }

    public String getIotId() {
        return iotId;
    }

    public void setIotId(String iotId) {
        this.iotId = iotId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     *
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 模型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 模型名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 所属楼宇
     */
    public Integer getBuildingId() {
        return buildingId;
    }

    /**
     * 所属楼宇
     */
    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}