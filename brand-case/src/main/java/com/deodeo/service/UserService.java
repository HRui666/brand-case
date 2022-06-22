package com.deodeo.service;

import com.deodeo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserService {
    /**
     * 注册
     */
    void add(User user);

    /**
     * 查询账户（登录）
     */
    User select(int id);

    /**
     * 修改密码信息(根据账号)
     */
    void update(User user);
}
