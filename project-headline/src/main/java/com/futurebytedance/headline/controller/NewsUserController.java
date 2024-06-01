package com.futurebytedance.headline.controller;

import com.futurebytedance.headline.common.Result;
import com.futurebytedance.headline.common.ResultCodeEnum;
import com.futurebytedance.headline.pojo.NewsUser;
import com.futurebytedance.headline.service.NewsUserService;
import com.futurebytedance.headline.service.impl.NewsUserServiceImpl;
import com.futurebytedance.headline.utils.JwtHelper;
import com.futurebytedance.headline.utils.MD5Util;
import com.futurebytedance.headline.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:46
 * @Description 用户登录Controller
 */
@WebServlet("/user/*")
public class NewsUserController extends BaseController {
    private NewsUserService userService = new NewsUserServiceImpl();

    // 完成注册的业务接口
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收JSON信息
        NewsUser registUser = WebUtil.readJson(req, NewsUser.class);
        // 调用服务层将用户信息存入数据库
        Integer rows = userService.registUser(registUser);
        // 根据存入是否成功处理响应值
        Result result = Result.ok(null);
        if (rows == 0) {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp, result);
    }

    // 校验用户名是否被占用的业务接口实现
    protected void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取账号
        String username = req.getParameter("username");

        // 根据用户名查询用户信息 找到了 返回505 找不到 200
        NewsUser newsUser = userService.findByUsername(username);
        System.out.println(newsUser);
        Result result = Result.ok(null);
        if (null != newsUser) {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp, result);
    }

    // 处理登录表单提交的业务接口的实现
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受用户名和密码
        NewsUser paramUser = WebUtil.readJson(req, NewsUser.class);

        // 调用服务层方法 实现登录
        NewsUser loginUser = userService.findByUsername(paramUser.getUsername());

        Result result = null;
        if (null != loginUser) {
            if (MD5Util.encrypt(paramUser.getUserPwd()).equalsIgnoreCase(loginUser.getUserPwd())) {
                Map data = new HashMap();
                data.put("token", JwtHelper.createToken(loginUser.getUid().longValue()));
                result = Result.ok(data);
            } else {
                result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            }
        } else {
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        // 向客户端响应登录验证信息
        WebUtil.writeJson(resp, result);
    }

    // 根据token口令获得用户信息的接口实现
    protected void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求中的token
        String token = req.getHeader("token");

        Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        if (null != token && (!"".equals(token))) {
            if (!JwtHelper.isExpiration(token)) {
                Integer userId = JwtHelper.getUserId(token).intValue();
                NewsUser newsUser = userService.findByUid(userId);
                if (null != newsUser) {
                    // 通过校验 查询用户信息放入Result
                    Map data = new HashMap();
                    newsUser.setUserPwd("");
                    data.put("loginUser", newsUser);
                    result = Result.ok(data);
                }
            }
        }
        // 未通过响应Result code 504

        WebUtil.writeJson(resp, result);
    }
}