package com.futurebytedance.area;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/12 - 0:10
 * @Description 域对象的使用
 */
@WebServlet("/servletD")
public class ServletD extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求域中的数据
        String requestMessage = (String) req.getAttribute("request");
        System.out.println("请求域:" + requestMessage);

        // 获取会话域中的数据
        HttpSession session = req.getSession();
        String sessionMessage = (String) session.getAttribute("session");
        System.out.println("会话域:" + sessionMessage);

        // 获取应用域中的数据
        ServletContext application = getServletContext();
        String appMessage = (String) application.getAttribute("application");
        System.out.println("应用域:" + appMessage);
    }
}
