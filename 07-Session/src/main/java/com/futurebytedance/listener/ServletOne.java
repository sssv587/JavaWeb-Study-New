package com.futurebytedance.listener;

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
 * @date 2024/4/15 - 23:52
 * @Description 监听器
 */
@WebServlet("/servletOne")
public class ServletOne extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向应用域中放入数据
        ServletContext application = this.getServletContext();
        application.setAttribute("keya","valuea");

        HttpSession session = req.getSession();
        // 手动销毁session
        session.invalidate();
    }
}
