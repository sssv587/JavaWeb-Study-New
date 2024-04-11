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
 * @date 2024/4/12 - 0:08
 * @Description 域对象的使用
 */
@WebServlet("/servletC")
public class ServletC extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向请求域存放数据
        req.setAttribute("request", "requestMessage");

        // 向会话域存放数据
        HttpSession session = req.getSession();
        session.setAttribute("session", "sessionMessage");

        // 向应用域存放数据
        ServletContext application = getServletContext();
        application.setAttribute("application", "applicationMessage");

        // 获取请求域数据
        String requestMessage = (String) req.getAttribute("request");
        System.out.println("请求域:" + requestMessage);

        // 请求转发
//        req.getRequestDispatcher("servletD").forward(req, resp);
    }
}
