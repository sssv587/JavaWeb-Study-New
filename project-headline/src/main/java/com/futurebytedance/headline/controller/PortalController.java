package com.futurebytedance.headline.controller;

import jakarta.servlet.annotation.WebServlet;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:47
 * @Description 门户 控制器
 * 那些不需要登录,不需要做增删改查的门户页的请求都放在这里
 */
@WebServlet("/portal/*")
public class PortalController extends BaseController {

}