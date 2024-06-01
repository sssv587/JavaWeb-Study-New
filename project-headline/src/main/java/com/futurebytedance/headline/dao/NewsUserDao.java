package com.futurebytedance.headline.dao;

import com.futurebytedance.headline.pojo.NewsUser;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:42
 * @Description
 */
public interface NewsUserDao {
    NewsUser findByUsername(String username);

    NewsUser findByUid(Integer userId);

    Integer insertUser(NewsUser registUser);
}
