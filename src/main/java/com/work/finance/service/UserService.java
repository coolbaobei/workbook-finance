package com.work.finance.service;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.work.finance.entity.User;
import com.work.finance.entity.UserRole;
import com.work.finance.common.ApplicationConsts;
import com.work.finance.mapper.UserMapper;
import com.work.finance.mapper.UserRoleMapper;
import com.work.finance.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * 用户
 * @author Jat
 *
 */
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	/**
	 * <p>
	 *根据员工编号查询用户
	 * </p>
	 *
	 * @return null see {@link null}
	 * @author wei
	 */
	public User selectByWorkNo(String workNo){
		Object obj = redisTemplate.opsForHash().get(ApplicationConsts.CACHE_USER,workNo);
		User user;
		if(null != obj){
			user = (User)obj;
		}else{
			user = userMapper.selectByWorkNo(workNo);
			redisTemplate.opsForHash().put(ApplicationConsts.CACHE_USER,workNo,user);
		}
		return user;
	}

	public List<User> getUserRole(String workNo) {
		return userMapper.getUserRole(workNo);
	}

	/**
	 * 根据角色查询用户
	 * @return
     */
	public List<HashMap<String,Object>> getUsersByRole(Integer roleId,Integer deptId){
		Object obj = redisTemplate.opsForHash().get(ApplicationConsts.CACHE_ROLE_USERS,roleId+"-"+deptId);
		if(null == obj){
			List<HashMap<String,Object>> users = userRoleMapper.selectUserNameByRoleId(roleId,deptId);
			redisTemplate.opsForHash().put(ApplicationConsts.CACHE_ROLE_USERS,roleId+"-"+deptId,users);
			return users;
		}else{
			return (List<HashMap<String,Object>>)obj;
		}
	}

	/**
	 * 所有人员基本信息
	 * @return
     */
	public Object getAllUser(){
		Object obj = redisTemplate.opsForValue().get(ApplicationConsts.CACHE_ALLUSER_BASEINFO);
		if(null == obj){
			List<HashMap<String,Object>> users = userMapper.selectAll();
			redisTemplate.opsForValue().set(ApplicationConsts.CACHE_ALLUSER_BASEINFO,users);
			return users;
		}
		return obj;
	}

	public void flushUserCache(){
		redisTemplate.delete(ApplicationConsts.CACHE_ALLUSER_BASEINFO);
		redisTemplate.delete(ApplicationConsts.CACHE_ROLE_USERS);
		redisTemplate.delete(ApplicationConsts.CACHE_USER);
	}

	public Result<PageInfo> test(JSONObject json) {
		Result<PageInfo> result = new Result<>();
//		Example example = new Example(UserRole.class);
//		Example.Criteria criteria = example.createCriteria();
//		criteria.andEqualTo("roleId", json.getInteger("roleId"));
		UserRole queryEntity = new UserRole();
		queryEntity.setRoleId(json.getInteger("roleId"));
		PageHelper.startPage(json.getInteger("currentPage"), json.getInteger("pageSize"));
//		List<UserRole> userRoles = userRoleMapper.selectByExample(example);
//		PageInfo<UserRole> page = new PageInfo<>(userRoles);
		List<UserRole> userRoles = userRoleMapper.select(queryEntity);
		PageInfo<UserRole> page = new PageInfo<>(userRoles);
		result.setContent(page);
		return result;
	}

}
