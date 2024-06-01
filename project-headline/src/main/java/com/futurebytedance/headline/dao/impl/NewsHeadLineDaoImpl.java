package com.futurebytedance.headline.dao.impl;

import com.futurebytedance.headline.dao.BaseDao;
import com.futurebytedance.headline.dao.NewsHeadLineDao;
import com.futurebytedance.headline.pojo.NewsHeadline;
import com.futurebytedance.headline.pojo.vo.HeadlineDetailVo;
import com.futurebytedance.headline.pojo.vo.HeadlinePageVo;
import com.futurebytedance.headline.pojo.vo.HeadlineQueryVo;

import java.util.ArrayList;
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
        List<Object> param = new ArrayList<Object>();

        String sql = "select hid,title,type,page_views pageViews,TIMESTAMPDIFF(HOUR,create_time,now()) pastHours,publisher from news_headline where is_deleted = 0";
        if (headlineQueryVo.getType() != 0) {
            sql = sql.concat(" and type = ? ");
            param.add(headlineQueryVo.getType());
        }
        if (headlineQueryVo.getKeyWords() != null && !headlineQueryVo.getKeyWords().equals("")) {
            sql = sql.concat(" and title like ?");
            param.add("%" + headlineQueryVo.getType() + "%");
        }
        sql = sql.concat(" order by pastHours asc,page_views desc");
        sql = sql.concat(" limit ?,?");
        param.add((headlineQueryVo.getPageNum() - 1) * headlineQueryVo.getPageSize());
        param.add(headlineQueryVo.getPageSize());
        return baseQuery(HeadlinePageVo.class, sql, param.toArray());
    }

    @Override
    public int findPageCount(HeadlineQueryVo headlineQueryVo) {
        List<Object> param = new ArrayList<>();

        String sql = "select count(1) from news_headline where is_deleted = 0";
        if (headlineQueryVo.getType() != 0) {
            sql = sql.concat(" and type = ? ");
            param.add(headlineQueryVo.getType());
        }
        if (headlineQueryVo.getKeyWords() != null && !headlineQueryVo.getKeyWords().equals("")) {
            sql = sql.concat(" and title like ?");
            param.add("%" + headlineQueryVo.getType() + "%");
        }

        return baseQueryObject(Long.class, sql, param.toArray()).intValue();
    }

    @Override
    public int incrPageViews(int hid) {
        String sql = "update news_headline set page_views = page_views + 1 where hid = ?";
        return baseUpdate(sql, hid);
    }

    @Override
    public HeadlineDetailVo findHeadLineDetail(int hid) {
        String sql = "select hid,title,article,type,tname typeName ,page_views pageViews,TIMESTAMPDIFF(HOUR,create_time,NOW()) pastHours,publisher,nick_name author from news_headline h left join  news_type t on h.type = t.tid left join news_user u  on h.publisher = u.uid where hid = ?";
        List<HeadlineDetailVo> list = baseQuery(HeadlineDetailVo.class, sql, hid);

        return null != list && list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public int addNewsHeadline(NewsHeadline newsHeadline) {
        String sql = "insert into news_headline values(DEFAULT,?,?,?,?,0,now(),now(),0)";
        return baseUpdate(sql, newsHeadline.getTitle(),
                newsHeadline.getArticle(),
                newsHeadline.getType(),
                newsHeadline.getPublisher());
    }
}
