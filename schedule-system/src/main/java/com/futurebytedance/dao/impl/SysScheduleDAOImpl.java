package com.futurebytedance.dao.impl;

import com.futurebytedance.dao.BaseDao;
import com.futurebytedance.dao.SysScheduleDAO;
import com.futurebytedance.pojo.SysSchedule;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/8 - 0:00
 * @Description
 */
public class SysScheduleDAOImpl extends BaseDao implements SysScheduleDAO {
    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        return baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql = "select sid,uid,title,completed from sys_schedule";
        return baseQuery(SysSchedule.class, sql);
    }

    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        String sql = "select sid,uid,title,completed from sys_schedule where uid = ?";
        return baseQuery(SysSchedule.class, sql, uid);
    }

    @Override
    public Integer addDefaultSchedule(int uid) {
        String sql = "insert into sys_schedule values (DEFAULT,?,'请输入日程',0)";
        return baseUpdate(sql, uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule schedule) {
        String sql = "update sys_schedule set title = ?,completed=? where sid = ?";
        return baseUpdate(sql, schedule.getTitle(), schedule.getCompleted(), schedule.getSid());
    }

    @Override
    public Integer removeSchedule(int sid) {
        String sql = "delete from sys_schedule where sid = ?";
        return baseUpdate(sql, sid);
    }
}