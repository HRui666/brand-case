package com.deodeo.web.productservlet;


import com.alibaba.fastjson.JSON;
import com.deodeo.pojo.Product;
import com.deodeo.pojo.Type;
import com.deodeo.pojo.User;
import com.deodeo.service.ProductService;
import com.deodeo.service.UserService;
import com.deodeo.service.impl.ProductServiceImpl;
import com.deodeo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    public void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        ///user
        User user = JSON.parseObject(params, User.class);

        //2. 调用service查找
        User select = userService.select(user.getAccount());

        if (select.getPassword().equals(user.getPassword())){
            //3. 响应成功的标识
            response.getWriter().write("success");
        }

    }

    public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1. 接收数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //User
        User user = JSON.parseObject(params, User.class);

        //2. 调用service添加
        userService.add(user);

        //3. 响应成功的标识
        response.getWriter().write("success");
    }



}
