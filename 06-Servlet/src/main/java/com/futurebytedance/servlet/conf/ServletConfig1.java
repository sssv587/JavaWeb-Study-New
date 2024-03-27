package com.futurebytedance.servlet.conf;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
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
        System.out.println("----------ServletConfig获取参数------------");
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

        System.out.println("----------ServletContext获取参数------------");

        // 获取ServletContext
        ServletContext servletContext1 = getServletContext();
        ServletContext servletContext2 = servletConfig.getServletContext();
        ServletContext servletContext3 = req.getServletContext();

        System.out.println(servletContext1 == servletContext2);
        System.out.println(servletContext2 == servletContext3);

        String encoding = servletContext1.getInitParameter("encoding");
        System.out.println("encoding:" + encoding);

        Enumeration<String> parameterNames = servletContext1.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String pname = parameterNames.nextElement();
            System.out.println(pname + "=" + servletContext1.getInitParameter(pname));
        }

        String ka = (String)servletContext1.getAttribute("ka");
        System.out.println(ka);
    }
}
