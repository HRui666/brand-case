package com.deodeo.service;

import com.deodeo.pojo.Product;
import com.deodeo.pojo.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    /**
     * 添加数据
     */
    void add(Product product);

    /**
     * 查询所有
     */
    List<Product> selectAll();

    /**
     * 修改
     */
    void update(Product product);

    /**
     * 删除
     */
    void delete(int id);

    /**
     * 分页条件查询
     */
    List<Product> selectAndCondition(Product product);

    /**
     * 批量删除
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 查询商品类名
     */
    String selectTypeAndDate(Integer id);

    /**
     * 查询全部商品类
     */
    List<Type> selectAllType();
}
