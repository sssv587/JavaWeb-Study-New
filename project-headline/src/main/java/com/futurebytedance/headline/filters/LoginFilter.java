package com.futurebytedance.headline.filters;

import com.futurebytedance.headline.common.Result;
import com.futurebytedance.headline.common.ResultCodeEnum;
import com.futurebytedance.headline.utils.JwtHelper;
import com.futurebytedance.headline.utils.WebUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/6/1 - 21:37
 * @Description 增删改前登录校验
 */
@WebFilter("/headline/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");
        boolean flag = null != token && !JwtHelper.isExpiration(token);
        System.out.println("flag=" + flag);
        if (flag) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            WebUtil.writeJson(response, Result.build(null, ResultCodeEnum.NOTLOGIN));
        }
    }
}
