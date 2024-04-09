package com.futurebytedance.dao.impl;

import com.futurebytedance.dao.BaseDao;
import com.futurebytedance.dao.SysUserDao;
import com.futurebytedance.pojo.SysUser;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/8 - 0:00
 * @Description
 */
public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "insert into sys_user values(DEFAULT,?,?)";
        return baseUpdate(sql, sysUser.getUsername(), sysUser.getUserPwd());
    }

    @Override
    public SysUser findByUsername(String username) {
        String sql = "select uid,username,user_pwd as userPwd from sys_user where username=?";
        List<SysUser> sysUsersList = baseQuery(SysUser.class, sql, username);
        return sysUsersList != null && sysUsersList.size() > 0 ? sysUsersList.get(0) : null;
    }
}
