package com.work.finance.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.work.finance.controller.base.BaseController;
import com.work.finance.entity.User;
import com.work.finance.entity.UserRole;
import com.work.finance.service.UserService;
import com.work.finance.util.Result;
import com.work.finance.util.ResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户管理
 * @author wei
 *
 */
@Controller
@RequestMapping("/api/sys/user")
public class UserController extends BaseController {

	private static final Logger L = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * <p>
	 * 根据角色查询所有用户
	 * <p>
	 * * @param null * * @return null see {@link null} * @author wei
	 */
	@RequestMapping(value="roleUsers",method=RequestMethod.GET)
	@ResponseBody
	public Result<Object> roleUsers(Integer roleId,Integer deptId){
		Result r = new Result();
		r.setContent(this.userService.getUsersByRole(roleId,deptId));
		r.setStatus(ResultStatus.SUCCESS);
		return  r;
	}

	/**
	 * <p>
	 * 查询所有在职用户
	 * <p>
	 * * @param null * * @return null see {@link null} * @author wei
	 */
	@RequestMapping(value="allUsers",method=RequestMethod.GET)
	@ResponseBody
	public Result<Object> allUsers(){
		Result r = new Result();
		r.setContent(this.userService.getAllUser());
		r.setStatus(ResultStatus.SUCCESS);
		return  r;
	}

	/**
	 * <p>
	 * 查询用户角色
	 * <p>
	 * * @param workNo员工编号
	 * @author wei
	 */
	@RequestMapping(value="getUserRole",method=RequestMethod.GET)
	@ResponseBody
	public Result<Object> getUserRole(String workNo){
		Result r = new Result();
		List<User> roles =  userService.getUserRole(workNo);
		r.setContent(roles);
		return  r;
	}

	/**
	 * <p>
	 * 查询用户角色
	 * <p>
	 * * @param workNo员工编号
	 * @author wei
	 */
	@RequestMapping(value="simpleRole",method=RequestMethod.GET)
	@ResponseBody
	public Result<Object> simpleRole(String workNo){
		Result r = new Result();
		List<User> roles =  userService.getUserRole(workNo);
		User user = userService.selectByWorkNo(workNo);
		String roleString =null;
		for(final User u:roles){
			Integer role = u.getRoleId();
			if (role==6) {
				roleString="boss";
			}else if(role==7){
				roleString="pmo";
			}else if (role ==24) {
				roleString="leader";
			}else if(user.getIsManager()==1){
				roleString="major";
			}else if (role==1||role==3||role==5) {
				roleString="finance";
			}else{
				roleString="worker";
			}
		}
		r.setContent(roleString);
		return  r;
	}

	/**
	 * <p>
	 * 刷新用户缓存
	 * <p>
	 * * @param null * * @return null see {@link null} * @author wei
	 */
	@RequestMapping(value="flushUserCache",method=RequestMethod.GET)
	@ResponseBody
	public Result<Object> flushUserCache(){
		Result r = new Result();
		userService.flushUserCache();
		r.setStatus(ResultStatus.SUCCESS);
		return  r;
	}

	@RequestMapping(value="test",method=RequestMethod.POST)
	@ResponseBody
	public Result<PageInfo> test(@RequestBody JSONObject json){
		return  userService.test(json);
	}
}
