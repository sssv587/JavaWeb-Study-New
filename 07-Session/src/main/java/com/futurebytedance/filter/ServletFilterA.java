package com.futurebytedance.filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/14 - 23:05
 * @Description 过滤器
 */
@WebServlet(value = "/servletFilterA",name = "servletFilterA")
public class ServletFilterA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletFilterA service invoked");
        resp.getWriter().write("servletFilterA message");
    }
}
