package com.futurebytedance.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/11 - 0:28
 * @Description
 */
@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + "=" + cookie.getValue());
            }
        }

        // 获得session对象
        HttpSession session = req.getSession();
        System.out.println(session.getId());
        System.out.println(session.isNew());

        // 读取session中存储的用户名
        String username = (String) session.getAttribute("username");
        System.out.println("servlet2 get username:" + username);
    }
}
