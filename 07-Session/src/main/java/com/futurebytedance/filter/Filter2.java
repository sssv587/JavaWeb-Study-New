package com.futurebytedance.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/14 - 23:55
 * @Description
 */
@WebFilter("/*")
public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("fileter2 before doFilter invoked");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("fileter2 after doFilter invoked");
    }
}
