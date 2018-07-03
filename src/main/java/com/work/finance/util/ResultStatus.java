package com.work.finance.util;

/**
 * 返回状态码和描述的枚举
 * @author Jat
 *
 */
public enum ResultStatus {
	
	SUCCESS(0, "success"),
	PASSWORD_ERROR(1,"密码错误"),
	ACCOUNT_NOTFOUND(2,"找不到用户"),
	DATA_NOTFOUND(3,"找不到数据"),
	DATA_EXISTS(4,"数据已存在"),
	USER_PERMISSION_ERROR(5,"当前用户不能操作该功能,请联系管理员"),
	DATA_ERROR(8,"数据出现异常"),
	USER_EXISTENCE(9,"该用户已存在"),
	USER_PASSWORD_ERROR(11,"用户密码错误"),
	USER_PASSWORD_REPEAT(12,"新密码与原密码重复"),
	ROLE_EDIT_ISDEFAULT(13,"默认角色不允许编辑"),
	ROLE_DELETE_ISDEFAULT(14,"默认角色不允许删除"),
	
	DEPART_USER_ERROR(101,"部门下有人员,不允许删除,请先移除人员"),
	TASK_HAS_REPORT(102,"任务已有报工记录"),
	TASK_EDIT_NOPERMISSION(103,"您没有编辑该任务的权限"),
	TASK_REPORT_NOPERMISSION(104,"您不是该任务的责任人,不允许报工该任务"),
	TASK_LOOK_NOPERMISSION(105,"您不是该项目的责任人,不允许审核该项目任务报工"),
	DEMAND_DELETE_HAS_TASK(106,"当前需求已有任务关联,不允许删除"),
	PROJECT_DELETE_HAS_TASK(107,"当前项目已创建任务,不允许删除"),
	PROJECTITERA_DELETE_HAS_TASK(108,"当前项目迭代周期已关联任务,不允许删除"),
	PROJECT_ISDONE(109,"当前项目已完成"),
	TASK_DAY_HAS_REPORT(110,"该任务今日已有报工记录"),
	REPORT_FACTTIME_ERROR(111,"您当日报工超过24小时"),
	REPORT_OVERTIME_ERROR(112,"您当日报工(加班)超过16小时"),
	DEMAND_NOT_ITERAID(113,"任务关联的需求还未分配迭代周期,请先分配迭代周期"),
	DEMAND_START(114,"当前需求进入开发阶段,不允许修改迭代周期"),
	REPORT_OVERRIED_ERROR(115,"您的报工时间与当日已报工时间重复"),
	TASK_WILL_REPORT(116,"该任务已标为任务已完成，请等待审核"),
	OUT_PLAN_TIME(117,"您的报工超过任务的计划时间"),
	DEMAND_NOT_UPDATE(118,"已修改过一次，需求计划人天无法变更"),
	TASK_NOT_UPDATE(119,"已修改过一次，任务计划工时无法变更"),
	TASK_NOT_UPDATE_PLANTIME(120,"任务计划工时不能大于任务计划可用工时"),
	DEMAND_NOT_UPDATE_PLANTIME(121,"需求计划人天不能大于需求计划可用人天"),
	REPORT_IN_REST_ERROR(122,"您的报工时间为午休时间"),

	
	//同步
	SYNC_PROJECT_EXIST(301,"该项目编号已存在"),
	SYNC_PARENT_PROJECT_NOTFOUND(302,"上级项目不存在"),
	SYNC_MANAGER_NOTFOUND(303,"项目经理用户不存在"),
	SYNC_PERMISSION(304,"key认证失败"),
	SYNC_PARAM_ERROR(305,"参数不完整"),
	SYNC_PROJECT_NOTFOUND(306,"找不到该项目信息"),
	SYNC_JSON_ERROR(307,"数据转换出现异常"),
	SYNC_DMMANAGER_NOTFOUND(308,"项目部长信息错误"),
	
	NO_PERMISSION(202,"没有权限"),
	SHIRO_NO_PERMISSION(201,"没有权限"),
	NO_LOGIN(203,"登录已失效,请刷新页面重新登录"),
	FAIL(10001, "操作失败."),
	NO_CONTROL(10003, "无操作."),
	PARAMS_ERROR(10004, "参数错误."),
	TIME_OUT(10002,"请求超时"),

	NO_WORK_NO(1011, "没有员工编号");

	
	private int status;
	private String msg;

	ResultStatus(int status, String msg){
		this.status = status;
		this.msg = msg;
	}

	public int getStatus(){
		return this.status;
	}

	public String getMsg() {
		return this.msg;
	}
}
