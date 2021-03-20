package com.ibms.demo.pojo;

import java.time.LocalDateTime;

/**
 * null
 * @apiDefine Unit
 * @apiParam {Integer} id 单位id
 * @apiParam {String} site 单位地址
 * @apiParam {Integer} userId 用户id(负责人id)
 * @apiParam {String} name 单位名字
 * @apiParam {Date} [createTime] 注册日期
 */
public class Unit {

    private Integer id;

    /**
     * 单位名字
     */
    private String name;

    /**
     * 单位地址
     */
    private String site;

    /**
     * 单位负责人
     */
    private Integer userId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 单位名字
     */
    public String getName() {
        return name;
    }

    /**
     * 单位名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 单位地址
     */
    public String getSite() {
        return site;
    }

    /**
     * 单位地址
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * 单位负责人
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 单位负责人
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}