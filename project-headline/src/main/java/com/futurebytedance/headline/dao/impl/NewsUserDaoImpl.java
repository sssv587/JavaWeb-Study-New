package com.futurebytedance.headline.dao.impl;

import com.futurebytedance.headline.dao.BaseDao;
import com.futurebytedance.headline.dao.NewsUserDao;
import com.futurebytedance.headline.pojo.NewsUser;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:42
 * @Description
 */
public class NewsUserDaoImpl extends BaseDao implements NewsUserDao {
    @Override
    public NewsUser findByUsername(String username) {
        String sql = "select uid,username,user_pwd as userPwd,nick_name as nickName from news_user where username=?";
        List<NewsUser> newsUserList = baseQuery(NewsUser.class, sql, username);
        return newsUserList != null && newsUserList.size() > 0 ? newsUserList.get(0) : null;
    }

    @Override
    public NewsUser findByUid(Integer userId) {
        String sql = "select uid,username,user_pwd as userPwd,nick_name as nickName from news_user where uid=?";
        List<NewsUser> newsUserList = baseQuery(NewsUser.class, sql, userId);
        return newsUserList != null && newsUserList.size() > 0 ? newsUserList.get(0) : null;
    }
}
