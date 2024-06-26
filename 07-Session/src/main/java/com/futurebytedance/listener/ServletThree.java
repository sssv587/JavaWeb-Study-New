package com.futurebytedance.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/15 - 23:52
 * @Description 监听器
 */
@WebServlet("/servletThree")
public class ServletThree extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 删除应用域中放入数据
        ServletContext application = this.getServletContext();
        application.removeAttribute("keya");
    }
}
