package com.futurebytedance.service.impl;

import com.futurebytedance.dao.SysUserDao;
import com.futurebytedance.dao.impl.SysUserDaoImpl;
import com.futurebytedance.pojo.SysUser;
import com.futurebytedance.service.SysUserService;
import com.futurebytedance.uitl.MD5Util;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/8 - 23:37
 * @Description
 */
public class SysUserServiceImpl implements SysUserService {
    private final SysUserDao sysUserDao = new SysUserDaoImpl();

    @Override
    public int regist(SysUser sysUser) {
        // 将用户的明文密码转换为密文密码
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        // 调用dao层的方法将sysUser信息存入数据库
        return sysUserDao.addSysUser(sysUser);
    }
}
