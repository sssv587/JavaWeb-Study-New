package com.futurebytedance.filter;

import com.futurebytedance.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/16 - 0:33
 * @Description
 */
//@WebFilter({"/showSchedule.html", "/schedule/*"}
//        , servletNames = "servletSchedule"
//)
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        // 参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获得session域对象
        HttpSession session = request.getSession();
        // 从session域中获得登录的用户对象
        SysUser sysUser = (SysUser) session.getAttribute("sysUser");

        // 判断用户对象是否为空
        if (null == sysUser) {
            // 没登录 到login.html
            response.sendRedirect("/login.html");
        } else {
            // 登陆过 放行
            chain.doFilter(request, response);
        }

    }
}
