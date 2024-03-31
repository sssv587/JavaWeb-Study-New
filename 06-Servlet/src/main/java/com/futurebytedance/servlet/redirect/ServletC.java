package com.futurebytedance.servlet.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/3/31 - 22:59
 * @Description 响应重定向
 * 1、重定向是通过HttpServletResponse对象实现的
 * 2、响应重定向是在服务端提示下的,客户端的行为
 * 3、客户端的地址栏是变化的
 * 4、客户端至少发送了两次请求 客户端产生了多次请求
 * 5、请求产生了多次 后端就会有多个request对象 此时请求中的参数不能继续自动传递
 * 6、目标资源可以是视图资源
 * 7、目标资源不可以是WEB-INF下的资源
 * 8、目标资源可以是外部资源
 *
 * 重点：同样能够实现页面跳转,优先使用相应重定向
 */
@WebServlet("/servletC")
public class ServletC extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受用户请求
        System.out.println("servletC 执行了...");

        // 响应重定向 设置响应状态码为302 同时设置location响应头
//        resp.sendRedirect("servletD");
//        resp.sendRedirect("a.html");
//        resp.sendRedirect("WEB-INF/b.html");
        resp.sendRedirect("https://www.baidu.com");
    }
}
