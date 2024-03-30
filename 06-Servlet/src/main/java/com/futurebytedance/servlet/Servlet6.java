package com.futurebytedance.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/3/30 - 20:49
 * @Description HttpServletResponse设置响应信息相关API
 */
@WebServlet("/servlet6")
public class Servlet6 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应行相关的API Http/1.1 200/404/405..
        response.setStatus(200);

        String info = "<h1>hello</h1>";
        // 设置响应头相关的API
//        response.setHeader("aaa", "valuea");
//        response.setHeader("Content-Type", "text/html");
        response.setContentType("text/html");
        response.setContentLength(info.getBytes().length);

        // 设置响应体内容API
        // 获得一个向响应体中输出文本字符输出流
        PrintWriter writer = response.getWriter();
        writer.write(info);

        // 获得一个向响应体中输入二进制信息的字节输出流
        // ServletOutputStream outputStream = response.getOutputStream();
    }
}
