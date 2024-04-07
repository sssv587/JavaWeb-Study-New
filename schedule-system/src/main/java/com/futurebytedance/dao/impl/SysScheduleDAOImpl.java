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
}
