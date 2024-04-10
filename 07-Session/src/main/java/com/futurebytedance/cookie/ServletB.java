package com.futurebytedance.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/10 - 23:50
 * @Description
 */
@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求中携带的cookie
        Cookie[] cookies = req.getCookies();
        // 请求中的多个cookie会进入该数组 请求中如果没有cookie cookies数组是为null 还是长度为0?
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + "=" + cookie.getValue());
            }
        }
    }
}
