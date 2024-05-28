package com.futurebytedance.headline.service;

import com.futurebytedance.headline.pojo.NewsType;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:44
 * @Description
 */
public interface NewsTypeService {
    // 查询所有头条类型的方法
    List<NewsType> findAll();
}
