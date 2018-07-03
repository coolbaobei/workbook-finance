package com.work.finance.mapper;

import com.work.finance.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface UserMapper {
    /**
     * 根据员工号获取用户
     * @param workNo 员工号
     * @return 用户
     */
    User selectByWorkNo(String workNo);

    /**
     * 根据渊博那个好获取用户角色
     * @param workNo 员工号
     * @return 角色
     */
    List<User> getUserRole(String workNo);

    /**
     * 根据员工编码查询真实姓名
     * @param id
     * @return
     */
    String selectNameById(Integer id);


    /**
     * 查询所有用户基本信息
     * @return
     */
    List<HashMap<String,Object>> selectAll();

}
