package com.futurebytedance.headline.controller;

import com.futurebytedance.headline.common.Result;
import com.futurebytedance.headline.pojo.NewsType;
import com.futurebytedance.headline.service.NewsTypeService;
import com.futurebytedance.headline.service.impl.NewsTypeServiceImpl;
import com.futurebytedance.headline.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:47
 * @Description 门户 控制器
 * 那些不需要登录,不需要做增删改查的门户页的请求都放在这里
 */
@WebServlet("/portal/*")
public class PortalController extends BaseController {
    private NewsTypeService typeService = new NewsTypeServiceImpl();

    //查询所有头条类型业务接口实现
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询所有的新闻类型,装入Result响应给客户端
        List<NewsType> newsTypeList = typeService.findAll();

        WebUtil.writeJson(resp, Result.ok(newsTypeList))
        ;
    }
}