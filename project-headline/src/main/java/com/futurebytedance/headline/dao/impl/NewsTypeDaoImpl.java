package com.futurebytedance.headline.dao.impl;

import com.futurebytedance.headline.dao.BaseDao;
import com.futurebytedance.headline.dao.NewsTypeDao;
import com.futurebytedance.headline.pojo.NewsType;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:42
 * @Description
 */
public class NewsTypeDaoImpl extends BaseDao implements NewsTypeDao {
    @Override
    public List<NewsType> findAll() {
        String sql = "select  tid,tname from news_type";
        return baseQuery(NewsType.class, sql);
    }
}
