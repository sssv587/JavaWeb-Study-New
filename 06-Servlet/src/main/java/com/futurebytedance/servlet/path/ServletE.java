package com.futurebytedance.servlet.path;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/2 - 0:33
 * @Description
 */
@WebServlet("/servletE")
public class ServletE extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletE");
        // 重定向到servletF
        /*
            1、相对路径写法
                      和前端的相对路径规则一致
            2、绝对路径写法
                      http://localhost:8080/
         */
//        String contextPath = req.getServletContext().getContextPath();
//        resp.sendRedirect(contextPath + "/servletF");

        // 请求转发到ServletF
        /*
            1、相对路径写法   一致
                      http://localhost:8080/web02/servletE
            2、绝对路径
                      请求转发的绝对路径是不需要添加项目上下文
                      请求转发的/ 代表的路径是  http://localhost:8080/web02/
         */
        req.getRequestDispatcher("/servletF").forward(req, resp);
    }
}
