package com.example.springtest.chapter001.dao;

import java.util.Date;

public class UserGroup {
    private Integer id;

    private String userId;

    private String userGroup;

    private String updateFlow;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup == null ? null : userGroup.trim();
    }

    public String getUpdateFlow() {
        return updateFlow;
    }

    public void setUpdateFlow(String updateFlow) {
        this.updateFlow = updateFlow == null ? null : updateFlow.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}