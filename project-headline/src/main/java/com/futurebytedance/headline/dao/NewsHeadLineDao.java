package com.futurebytedance.headline.dao;

import com.futurebytedance.headline.pojo.vo.HeadlinePageVo;
import com.futurebytedance.headline.pojo.vo.HeadlineQueryVo;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:41
 * @Description
 */
public interface NewsHeadLineDao {
    List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo);

    int findPageCount(HeadlineQueryVo headlineQueryVo);
}
