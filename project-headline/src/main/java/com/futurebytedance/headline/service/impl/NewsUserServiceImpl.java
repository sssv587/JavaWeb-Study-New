package com.futurebytedance.headline.service.impl;

import com.futurebytedance.headline.dao.NewsUserDao;
import com.futurebytedance.headline.dao.impl.NewsUserDaoImpl;
import com.futurebytedance.headline.pojo.NewsUser;
import com.futurebytedance.headline.service.NewsUserService;
import com.futurebytedance.headline.utils.MD5Util;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/5/28 - 23:44
 * @Description
 */
public class NewsUserServiceImpl implements NewsUserService {
    private NewsUserDao userDao = new NewsUserDaoImpl();

    @Override
    public NewsUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public NewsUser findByUid(Integer userId) {
        return userDao.findByUid(userId);
    }

    @Override
    public Integer registUser(NewsUser registUser) {
        // 处理增加数据的业务
        // 将明文密码转换成密文密码
        registUser.setUserPwd(MD5Util.encrypt(registUser.getUserPwd()));

        return userDao.insertUser(registUser);
    }
}
