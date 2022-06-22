package com.deodeo.web.productservlet;


import com.alibaba.fastjson.JSON;
import com.deodeo.pojo.Product;
import com.deodeo.pojo.Type;
import com.deodeo.service.ProductService;
import com.deodeo.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/product/*")
public class ProductServlet extends BaseServlet {
    private ProductService productService = new ProductServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用service查询
        List<Product> products = productService.selectAll();
        for (int i = 0; i < products.size(); i++) {
            String typename = productService.selectTypeAndDate(products.get(i).getType());
            products.get(i).setTypeName(typename);
        }

        //2. 转为JSON
        String jsonString = JSON.toJSONString(products);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectAllType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用service查询
        List<Type> types = productService.selectAllType();

        //2. 转为JSON
        String jsonString = JSON.toJSONString(types);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收商品数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //Product
        Product product = JSON.parseObject(params, Product.class);

        //2. 调用service添加
        productService.add(product);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收数据
        String id = request.getParameter("id");

        //2. 调用service删除
        productService.delete(Integer.parseInt(id));

        //3. 响应成功的标识
        response.getWriter().write("success");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        ///转为Product对象
        Product product = JSON.parseObject(params, Product.class);

        //2. 调用service修改
        productService.update(product);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收数据  [1,2,3]
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为 int[]
        int[] ids = JSON.parseObject(params, int[].class);

        //2. 调用service添加
        productService.deleteByIds(ids);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }

    public void selectAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取查询条件对象
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为 Product
        Product product = JSON.parseObject(params, Product.class);


        //2. 调用service查询
        List<Product> products = productService.selectAndCondition(product);

        //写入商品类名
        for (int i = 0; i < products.size(); i++) {
            String typename = productService.selectTypeAndDate(products.get(i).getType());
            products.get(i).setTypeName(typename);
        }

        if (products.size() == 0){ //找不到商品
            response.getWriter().write("null");
        }else {
            //转为JSON
            String jsonString = JSON.toJSONString(products);
            //写数据
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }




    }


}
