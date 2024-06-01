package com.futurebytedance.headline.dao.impl;

import com.futurebytedance.headline.dao.BaseDao;
import com.futurebytedance.headline.dao.NewsHeadLineDao;
import com.futurebytedance.headline.pojo.vo.HeadlinePageVo;
import com.futurebytedance.headline.pojo.vo.HeadlineQueryVo;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:43
 * @Description
 */
public class NewsHeadLineDaoImpl extends BaseDao implements NewsHeadLineDao {
    @Override
    public List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo) {
        return null;
    }

    @Override
    public int findPageCount(HeadlineQueryVo headlineQueryVo) {
        return 0;
    }
}
