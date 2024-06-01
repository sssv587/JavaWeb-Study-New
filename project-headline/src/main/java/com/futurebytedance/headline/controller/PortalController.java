package com.futurebytedance.headline.controller;

import com.futurebytedance.headline.common.Result;
import com.futurebytedance.headline.pojo.NewsType;
import com.futurebytedance.headline.pojo.vo.HeadlineQueryVo;
import com.futurebytedance.headline.service.NewsHeadlineService;
import com.futurebytedance.headline.service.NewsTypeService;
import com.futurebytedance.headline.service.impl.NewsHeadlineServiceImpl;
import com.futurebytedance.headline.service.impl.NewsTypeServiceImpl;
import com.futurebytedance.headline.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();

    // 分页查询头条信息接口实现
    /*   pageData:[{
            {
    				"hid":"1",                     // 新闻id
    				"title":"尚硅谷宣布 ... ...",   // 新闻标题
    				"type":"1",                    // 新闻所属类别编号
    				"pageViews":"40",              // 新闻浏览量
    				"pastHours":"3" ,              // 发布时间已过小时数
    				"publisher":"1"                // 发布用户ID
				}
         }],
         pageNum:1,
         pageSize:1,
         totalPage:1,
         totalSize:1,
    */
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求中的参数
        HeadlineQueryVo headlineQueryVo = WebUtil.readJson(req, HeadlineQueryVo.class);

        // 将参数传递给服务层 进行分页查询
        Map pageInfo = headlineService.findPage(headlineQueryVo);
        Map data = new HashMap();
        data.put("pageInfo", pageInfo);


        // 将分页查询的结果转换成json响应给客户端
        WebUtil.writeJson(resp, Result.ok(data));
    }

    //查询所有头条类型业务接口实现
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询所有的新闻类型,装入Result响应给客户端
        List<NewsType> newsTypeList = typeService.findAll();

        WebUtil.writeJson(resp, Result.ok(newsTypeList));
    }
}