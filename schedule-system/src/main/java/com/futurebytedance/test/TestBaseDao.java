package com.futurebytedance.test;

import com.futurebytedance.dao.BaseDao;
import com.futurebytedance.pojo.SysUser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/8 - 0:20
 * @Description
 */
public class TestBaseDao {
    private static BaseDao baseDao;

    @BeforeClass
    public static void initBaseDao() {
        baseDao = new BaseDao();
    }

    @Test
    public void testBaseQueryObject() {
        // 查询用户数量  baseQueryObject查询结果集是单行 单列的 一个值的数据的方法
        String sql = "select count(1) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);
    }

    @Test
    public void testBaseQuery() {
        String sql = "select uid,username,user_pwd as userPwd from sys_user";
        List<SysUser> sysUserList = baseDao.baseQuery(SysUser.class, sql);
        sysUserList.forEach(System.out::println);
    }

    @Test
    public void testBaseUpdate() {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseDao.baseUpdate(sql, 1, "学习Java", 0);
        System.out.println(rows);
    }
}
