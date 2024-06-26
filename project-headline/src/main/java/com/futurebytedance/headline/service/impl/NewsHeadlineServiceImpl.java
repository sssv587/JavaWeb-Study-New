package com.futurebytedance.headline.service.impl;

import com.futurebytedance.headline.dao.NewsHeadLineDao;
import com.futurebytedance.headline.dao.impl.NewsHeadLineDaoImpl;
import com.futurebytedance.headline.pojo.NewsHeadline;
import com.futurebytedance.headline.pojo.vo.HeadlineDetailVo;
import com.futurebytedance.headline.pojo.vo.HeadlinePageVo;
import com.futurebytedance.headline.pojo.vo.HeadlineQueryVo;
import com.futurebytedance.headline.service.NewsHeadlineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:45
 * @Description
 */
public class NewsHeadlineServiceImpl implements NewsHeadlineService {
    private NewsHeadLineDao headLineDao = new NewsHeadLineDaoImpl();

    @Override
    public Map<String, Object> findPage(HeadlineQueryVo headlineQueryVo) {
        int pageNum = headlineQueryVo.getPageNum();
        int pageSize = headlineQueryVo.getPageSize();
        List<HeadlinePageVo> pageData = headLineDao.findPageList(headlineQueryVo);
        int totalSize = headLineDao.findPageCount(headlineQueryVo);
        int totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;

        Map<String, Object> pageInfo = new HashMap<>();
        pageInfo.put("pageNum", pageNum);
        pageInfo.put("pageSize", pageSize);
        pageInfo.put("totalSize", totalSize);
        pageInfo.put("totalPage", totalPage);
        pageInfo.put("pageData", pageData);
        return pageInfo;
    }

    @Override
    public HeadlineDetailVo findHeadlineDetail(int hid) {
        // 查询头条的详情
        headLineDao.incrPageViews(hid);
        // 修改该头条的浏览量 + 1
        return headLineDao.findHeadLineDetail(hid);
    }

    @Override
    public int addNewsHeadline(NewsHeadline newsHeadline) {
        return headLineDao.addNewsHeadline(newsHeadline);
    }

    @Override
    public NewsHeadline findByHid(Integer hid) {
        return headLineDao.findByHid(hid);
    }

    @Override
    public int update(NewsHeadline newsHeadline) {
        return headLineDao.update(newsHeadline);
    }

    @Override
    public int removeByHid(String hid) {
        return headLineDao.removeByHid(hid);
    }
}
