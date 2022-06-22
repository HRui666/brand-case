package com.deodeo.mapper;

import com.deodeo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    /**
     * 注册
     * @param user
     */
    @Insert("insert into tb_user values(null,#{username},#{password},#{account})")
    void add(User user);

    /**
     * 查询账户（登录）
     * @return user
     */
    @Select("select * from tb_user where account = #{account}")
    User selectAll(int account);

    /**
     * 修改密码信息(根据账号)
     * @param user
     */
    @Update("update tb_user set username = #{username},password = #{password} where account = #{account}")
    void update(User user);


}
