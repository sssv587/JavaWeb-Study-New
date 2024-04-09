package com.futurebytedance.dao.impl;

import com.futurebytedance.dao.BaseDao;
import com.futurebytedance.dao.SysUserDao;
import com.futurebytedance.pojo.SysUser;

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
}
