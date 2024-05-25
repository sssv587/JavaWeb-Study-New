package com.futurebytedance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.futurebytedance.common.Result;
import com.futurebytedance.common.ResultCodeEnum;
import com.futurebytedance.pojo.SysUser;
import com.futurebytedance.service.SysUserService;
import com.futurebytedance.service.impl.SysUserServiceImpl;
import com.futurebytedance.uitl.MD5Util;
import com.futurebytedance.uitl.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/8 - 23:40
 * @Description
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {
    private final SysUserService userService = new SysUserServiceImpl();

    /**
     * 注册时,接收要注册的用户名,校验用户名是否被占用的业务接口
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收用户名
        String username = req.getParameter("username");

        // 调用服务层业务处理方法查询该用户名是否有对应的用户
        SysUser sysUser = userService.findByUsername(username);

        Result result = Result.ok(null);

        // 如果有 响应 已占用
        if (null != sysUser) {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        // 将result对象转换为JSON串响应给客户端
        WebUtil.writeJson(resp, result);
    }

    /**
     * 接收用户注册请求的业务处理方法(业务接口 不是java中的interface)
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、接收客户端提交的Json参数,并转换为User对象,获取信息
        SysUser registUser = WebUtil.readJson(req, SysUser.class);

        // 2、调用服务层方法,完成注册功能
        int rows = userService.regist(registUser);
        // 3、根据注册结果(成功、失败) 做页面跳转
        Result result = Result.ok(null);
        if (rows < 1) {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp, result);
    }

    /**
     * 接收用户登录请求,完成登录的业务接口
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1、接收用户名和密码
        SysUser sysUser = WebUtil.readJson(req, SysUser.class);

        // 2、调用服务层方法,根据用户名查询用户信息
        SysUser loginUser = userService.findByUsername(sysUser.getUsername());

        Result result = Result.ok(null);
        if (null == loginUser) {
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        } else if (!MD5Util.encrypt(sysUser.getUserPwd()).equals(loginUser.getUserPwd())) {

            result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
        } else {
            result = Result.ok(null);
        }
        // 3、将登陆结果信息响应给客户端
        WebUtil.writeJson(resp, result);
    }
}
