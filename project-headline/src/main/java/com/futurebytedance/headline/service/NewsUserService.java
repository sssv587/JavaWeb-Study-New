package com.futurebytedance.headline.service;

import com.futurebytedance.headline.pojo.NewsUser;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:44
 * @Description
 */
public interface NewsUserService {
    // 根据用户登录的账号找用户信息的方法
    NewsUser findByUsername(String username);

    NewsUser findByUid(Integer userId);

    Integer registUser(NewsUser registUser);
}
