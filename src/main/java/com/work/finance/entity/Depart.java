package com.work.finance.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Depart implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3375779780762402858L;

    private int id;
    private String title;
    private String remark;
    private int parentId;
    private String createTime;
    private String updateTime;
    private Depart parentDepart;
    private int isLeader;

    private int isStatistics;


    public int getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(int isLeader) {
        this.isLeader = isLeader;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Depart getParentDepart() {
        return parentDepart;
    }

    public void setParentDepart(Depart parentDepart) {
        this.parentDepart = parentDepart;
    }

    public int getIsStatistics() {
        return isStatistics;
    }

    public void setIsStatistics(int isStatistics) {
        this.isStatistics = isStatistics;
    }

    @Override
    public String toString() {
        return "Depart [id=" + id + ", title=" + title + ", remark=" + remark
                + ", parentId=" + parentId + ", createTime=" + createTime
                + ", updateTime=" + updateTime + ", parentDepart="
                + parentDepart + "]";
    }


}
