package com.ibms.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 楼宇
 * @apiDefine Building
 * @apiParam {Integer} parentId 上级id
 * @apiParam {Integer} unitId 部门id
 * @apiParam {String} name 名称
 * @apiParam {Integer} type 类型{1:楼宇,2:楼层,3:房间}
 * @apiParam {String} comment 备注
 * @apiParam {Date} createTime 创建时间
 */
public class Building {
    // 栋
    public static final int BUILDING = 1;
    // 层
    public static final int TOWER = 2;
    // 房间
    public static final int ROOM = 3;

    private Integer id;

    /**
     * 上级id
     */
    private Integer parentId;

    /**
     * 部门id
     */
    private Integer unitId;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型{1:楼宇,2:楼层,3:房间}
     */
    private Integer type;

    /**
     * 备注
     */
    private String comment;

    /**
     *
     */
    private LocalDateTime createTime;

    /**
     * 创建房间时检查类型是否是已知类型
     * @return true:是已知类型，否则不是
     */
    @JsonIgnore
    public boolean checkType() {
        return type == BUILDING || type == TOWER || type == ROOM;
    }

    /**
     * 检查给定的类型是否为当前建筑的直接父类型，
     * 栋是楼的直接父类型，楼是层的直接父类型，层是房间的直接父类型，
     * 如果当前建筑类型是栋，则传入类型必须为null
     * @param type 要检查的父类型
     * @return true:传入的类型是直接父类型，false:不是
     */
    @JsonIgnore
    public boolean isParentType(Integer type) {
        return (this.type == TOWER && type == BUILDING) ||
                (this.type == ROOM && type == TOWER) ||
                (this.type == BUILDING && type == null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 上级id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 上级id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 部门id
     */
    public Integer getUnitId() {
        return unitId;
    }

    /**
     * 部门id
     */
    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    /**
     * 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 类型{1:楼宇,2:楼层,3:房间}
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型{1:楼宇,2:楼层,3:房间}
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 备注
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}