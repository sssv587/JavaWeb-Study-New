package com.futurebytedance.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/3/27 - 23:13
 * @Description ServletContext获取文件路径和上下文
 */
@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = getServletContext();
        // 获得一个指向项目部署位置下的某个文件/目录的磁盘真实路径的API
        String path = servletContext.getRealPath("upload");
        System.out.println(path);

        // 获得项目部署的上下文路径 项目的访问路径
        // 获取项目的上下文路径 项目的访问路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
    }
}
