package com.futurebytedance.headline.service.impl;

import com.futurebytedance.headline.dao.NewsTypeDao;
import com.futurebytedance.headline.dao.impl.NewsTypeDaoImpl;
import com.futurebytedance.headline.pojo.NewsType;
import com.futurebytedance.headline.service.NewsTypeService;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:45
 * @Description
 */
public class NewsTypeServiceImpl implements NewsTypeService {
    private NewsTypeDao typeDao = new NewsTypeDaoImpl();

    @Override
    public List<NewsType> findAll() {
        return typeDao.findAll();
    }
}
