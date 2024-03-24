package com.futurebytedance.servlet.config;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/3/25 - 0:10
 * @Description ServletConfig
 */
// 注解形式获取初始配置信息,这里注释掉了,目前使用的是xml形式
//@WebServlet(
//        urlPatterns = "servletConfig1",
//        initParams = {@WebInitParam(name = "keyc",value = "valueC"),
//                @WebInitParam(name = "keyd",value = "valueD")}
//)
public class ServletConfig1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        // 获取初始配置信息即可
        // 根据参数名获取参数值
        String keya = servletConfig.getInitParameter("keya");
        System.out.println("keya:" + keya);

        // 获取所有的初始参数的名字
        // hasMoreElements() 判断有没有下一个参数 如果有返回true 如果没有返回false
        // nextElement()     取出下一个元素  向下移动游标
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String pname = initParameterNames.nextElement();
            System.out.println(pname + "=" + getInitParameter(pname));
        }
    }
}
