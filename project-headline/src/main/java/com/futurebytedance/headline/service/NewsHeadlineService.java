package com.futurebytedance.headline.service;

import com.futurebytedance.headline.pojo.NewsHeadline;
import com.futurebytedance.headline.pojo.vo.HeadlineDetailVo;
import com.futurebytedance.headline.pojo.vo.HeadlineQueryVo;

import java.util.Map;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:44
 * @Description
 */
public interface NewsHeadlineService {
    Map findPage(HeadlineQueryVo headlineQueryVo);

    HeadlineDetailVo findHeadlineDetail(int hid);

    int addNewsHeadline(NewsHeadline newsHeadline);

    NewsHeadline findByHid(Integer hid);

    int update(NewsHeadline newsHeadline);
}
