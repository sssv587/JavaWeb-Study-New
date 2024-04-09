package com.futurebytedance.dao;

import com.futurebytedance.pojo.SysUser;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/7 - 23:55
 * @Description
 * Data Access Object 数据访问对象
 * 该类中用于定义针对表格的CRUD的方法
 * DAO层一般需要定义接口和实现类
 */
public interface SysUserDao {
    /**
     * 向数据库中增加一条用户记录的方法
     * @param sysUser 要增加的记录的username和user_pwd字段以SysUser实体类对象的形式接收
     * @return 增加成功返回1 增加失败返回0
     */
    int addSysUser(SysUser sysUser);

    SysUser findByUsername(String username);
}
