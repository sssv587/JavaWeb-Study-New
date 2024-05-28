package com.futurebytedance.headline.dao;

import com.futurebytedance.headline.pojo.NewsType;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:42
 * @Description
 */
public interface NewsTypeDao {
    List<NewsType> findAll();
}
