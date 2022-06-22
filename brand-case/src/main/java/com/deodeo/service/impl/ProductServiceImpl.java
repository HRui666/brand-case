package com.deodeo.service.impl;


import com.deodeo.mapper.ProductMapper;
import com.deodeo.pojo.Product;
import com.deodeo.pojo.Type;
import com.deodeo.service.ProductService;
import com.deodeo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public void add(Product product) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取ProductMapper
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        //4. 调用方法
        mapper.add(product);
        //提交事务
        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public List<Product> selectAll() {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取ProductMapper
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        //4. 调用方法
        List<Product> products = mapper.selectAll();

        //5. 释放资源
        sqlSession.close();
        return products;

    }

    @Override
    public void update(Product product) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取ProductMapper
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        //4. 调用方法
        mapper.update(product);
        //提交事务
        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public void delete(int id) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取ProductMapper
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        //4. 调用方法
        mapper.delete(id);
        //提交事务
        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public List<Product> selectAndCondition(Product product) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取ProductMapper
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);


        // 处理brand条件，模糊表达式
        String tradeName = product.getTradeName();
        if (tradeName != null && tradeName.length() > 0) {
            product.setTradeName("%" + tradeName + "%");
        }



        List<Product> products = mapper.selectAndCondition(product);


        //8. 释放资源
        sqlSession.close();

        return products;

    }

    @Override
    public void deleteByIds(int[] ids) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取ProductMapper
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        //4. 调用方法
        mapper.deleteByIds(ids);
        //提交事务
        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();
    }

    @Override
    public String selectTypeAndDate(Integer id) {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取ProductMapper
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        //4. 调用方法
        String s = mapper.selectTypeAndDate(id);

        //5. 释放资源
        sqlSession.close();

        return s;

    }

    @Override
    public List<Type> selectAllType() {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取ProductMapper
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        //4. 调用方法
        List<Type> types = mapper.selectAllType();

        //5. 释放资源
        sqlSession.close();

        return types;
    }


}
