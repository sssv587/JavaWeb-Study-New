package com.futurebytedance.servlet.encoding;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/1 - 0:23
 * @Description 响应乱码问题
 */
@WebServlet("/resEncodingServlet")
public class ResEncodingServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("GBK");

        // 设置响应体使用UTF-8来进行编码
        resp.setCharacterEncoding("UTF-8");
        // 设置Content-Type响应头,告诉客户端使用UTF-8解码
        resp.setContentType("text/html;charset=UTF-8");

        // 向客户端响应一些文字
        resp.getWriter().write("牛逼的");

        /*
        tomcat10中,响应体中默认的编码字符集使用的是UTF-8

        解决思路:
            1、可以设置响应体的编码字符集和客户端的保持一致 不推荐 客户端解析的字符集无法预测
            2、可以告诉客户端使用指定的字符集进行编码 通过设置Content-Type响应头
        注意的是    明确响应体的编码,然后再设置Content-Type
        响应行
        响应头
        响应体     牛逼的(GBK)
         */
    }
}
