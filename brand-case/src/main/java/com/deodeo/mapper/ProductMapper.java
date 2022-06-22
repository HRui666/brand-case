package com.deodeo.mapper;

import com.deodeo.pojo.Product;
import com.deodeo.pojo.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {
    /**
     * 添加商品数据
     *
     * @param product
     */
    @Insert("insert into tb_product values(null,#{number},#{tradeName},#{date},#{quality},#{stock},#{unit},#{type})")
    void add(Product product);

    /**
     * 查询所有商品
     *
     * @return Products
     */
    @Select("select * from tb_product")
    @ResultMap("productResultMap")
    List<Product> selectAll();

    /**
     * 修改商品数据
     *
     * @param product
     */
    @Update("update tb_product set number = #{number},trade_name = #{tradeName},date = #{date},quality = #{quality},stock = #{stock},unit = #{unit},type = #{type} where id = #{id}")
    void update(Product product);

    /**
     * 删除商品数据
     *
     * @param id
     */
    @Delete("delete from tb_product where id = #{id}")
    void delete(int id);

    /**
     * 模糊查询
     *
     * @return Products
     */
    List<Product> selectAndCondition(@Param("product") Product product);

    /**
     * 批量删除商品数据
     *
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 查询商品类型名
     *
     * @return String
     */
    @Select("select typename from tb_type where id = #{id}")
    String selectTypeAndDate(Integer id);

    /**
     * 查询全部商品类型名
     *
     * @return Type
     */
    @Select("select * from tb_type")
    List<Type> selectAllType();


}
