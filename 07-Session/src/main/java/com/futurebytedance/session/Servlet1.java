package com.futurebytedance.session;

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
 * @date 2024/4/11 - 0:20
 * @Description Session
 * Session的过期时间可以通过web.xml配置,如果没配置,默认会找tomcat中的web.xml中的配置
 */
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求中username参数
        String username = req.getParameter("username");

        // 获得session对象
        HttpSession session = req.getSession();
        // 判断请求中有没有一个特殊的cookie JSESSIONID 值 *** ***
        // 1、有
        // 根据JSESSIONID找对应session对象
        // 1.1 找到了 返回之前的session
        // 1.2 没找到 创建一个新的session返回,并向response对象中存放一个JSESSIONID的cookie
        // 2、没有 创建一个新的session返回,并向response对象中存放一个JSESSIONID的cookie
        System.out.println(session.getId());
        System.out.println(session.isNew());

        // 将username存储session
        session.setAttribute("username", username);

        // 客户端响应信息
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("成功");
    }
}
