package com.work.finance.entity;

import java.io.Serializable;

/**
 * 日志
 * @author Jat
 *
 */
public class Log implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7645861694231086160L;
	
	private int id;
	private String type;
	private String className;
	private String methodName;
	private String params;
	private String result;
	private int creatorId;
	private String creator;
	private String createTime;
	private String updateTime;
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
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

	@Override
	public String toString() {
		return "Log [id=" + id + ", type=" + type + ", className=" + className
				+ ", methodName=" + methodName + ", params=" + params
				+ ", result=" + result + ", creatorId=" + creatorId
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}

	
	
	

}
