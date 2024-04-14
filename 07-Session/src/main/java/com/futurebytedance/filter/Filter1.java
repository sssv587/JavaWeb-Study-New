package com.futurebytedance.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/14 - 23:55
 * @Description 03-过滤器链及执行顺序
 * 如果是使用web.xml配置,则和servlet-mapping的顺序有关系
 * 如果是使用注解配置，则和类名的大小有关系
 */
@WebFilter("/*")
public class Filter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("fileter1 before doFilter invoked");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("fileter1 after doFilter invoked");
    }
}
