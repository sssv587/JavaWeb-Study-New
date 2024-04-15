package com.futurebytedance.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/8 - 23:41
 * @Description 增加日程的请求 /sysSchedule/add
 * 查询日程的请求 /sysSchedule/find
 * 修改日程的请求 /sysSchedule/update
 * 删除日程的请求 /sysSchedule/remove
 * ... ...
 */
@WebServlet(value = "/schedule/*",name = "servletSchedule")
public class SysScheduleController extends BaseController {
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
    }

    protected void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("find");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("update");
    }

    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("remove");
    }
}
