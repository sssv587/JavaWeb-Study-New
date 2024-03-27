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

        // 作为域对象
        // void setAttribute(String key,Object value); 向域中存储/修改数据
        servletContext.setAttribute("ka", "va");
        // Object getAttribute(String key); 获得域中的数据
//        String ka = (String) servletContext.getAttribute("ka");
        // void removeAttribute(String key); 移除域中的数据
//        servletContext.removeAttribute("ka");
    }
}
