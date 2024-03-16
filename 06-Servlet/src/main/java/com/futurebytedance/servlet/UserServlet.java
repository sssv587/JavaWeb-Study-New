package com.futurebytedance.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/3/16 - 19:01
 * @Description Servlet开发流程
 * 1、创建javaweb项目,同时将tomcat添加为当前项目的依赖
 * 2、重写service(HttpServletRequest req, HttpServletResponse resp)方法
 * 3、在service方法中定义,定义业务处理代码
 * 4、在web.xml中,配置servlet对应的请求映射路径
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、从request对象中获取请求中的任何信息(username参数)
        String username = request.getParameter("username");//根据参数名称获取参数值 无论参数是在url?后 还是在请求体中

        // 2、处理业务的代码
        String info = "YES";

        if ("root".equals(username)) {
            info = "NO";
        }

        // 3、将要响应的数据放入response
        PrintWriter writer = response.getWriter(); // 该方法返回的是一个向响应体中打印字符串的 打印流
        writer.write(info);
    }
}
