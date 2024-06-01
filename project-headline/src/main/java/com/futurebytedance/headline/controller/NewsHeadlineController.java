package com.futurebytedance.headline.controller;

import com.futurebytedance.headline.common.Result;
import com.futurebytedance.headline.pojo.NewsHeadline;
import com.futurebytedance.headline.service.NewsHeadlineService;
import com.futurebytedance.headline.service.impl.NewsHeadlineServiceImpl;
import com.futurebytedance.headline.utils.JwtHelper;
import com.futurebytedance.headline.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:46
 * @Description
 */
@WebServlet("/headline/*")
public class NewsHeadlineController extends BaseController {
    private NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();

    // 发布头条的接口实现
    protected void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Long userId = JwtHelper.getUserId(token);
        NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
        newsHeadline.setPublisher(userId.intValue());

        // 将信息存入数据库
        headlineService.addNewsHeadline(newsHeadline);

        WebUtil.writeJson(resp, Result.ok(null));
    }
}