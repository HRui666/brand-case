package com.deodeo.service.impl;

import com.deodeo.mapper.ProductMapper;
import com.deodeo.mapper.UserMapper;
import com.deodeo.pojo.User;
import com.deodeo.service.UserService;
import com.deodeo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServiceImpl implements UserService {
    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public void add(User user) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //4. 调用方法
        mapper.add(user);
        //提交事务
        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public User select(int id) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //4. 调用方法
        User user = mapper.selectAll(id);

        //5. 释放资源
        sqlSession.close();
        return user;
    }

    @Override
    public void update(User user) {

    }
}
