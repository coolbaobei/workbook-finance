package com.work.finance.mapper;

import com.work.finance.entity.UserRole;
import com.work.finance.util.mybatis.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author developer
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 获取角色信息
     *
     * @param roleId 角色id
     * @param deptId 部门id
     * @return list
     */
    List<HashMap<String, Object>> selectUserNameByRoleId(@Param("roleId") int roleId, @Param("deptId") int deptId);
}
