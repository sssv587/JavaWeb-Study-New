package com.futurebytedance.controller;

import com.futurebytedance.pojo.SysUser;
import com.futurebytedance.service.SysUserService;
import com.futurebytedance.service.impl.SysUserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
     * 接收用户注册请求的业务处理方法(业务接口 不是java中的interface)
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、接收客户端提交的参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        // 2、调用服务层方法,完成注册功能
        // 将参数放入一个SysUser对象中,再调用regist方法时传入
        SysUser sysUser = new SysUser(null, username, userPwd);
        int rows = userService.regist(sysUser);
        // 3、根据注册结果(成功、失败) 做页面跳转
        if (rows > 0) {
            resp.sendRedirect("/registSuccess.html");
        } else {
            resp.sendRedirect("/registFail.html");
        }
    }
}
