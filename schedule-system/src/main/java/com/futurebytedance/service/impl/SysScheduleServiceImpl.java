package com.futurebytedance.service.impl;

import com.futurebytedance.dao.SysScheduleDAO;
import com.futurebytedance.dao.impl.SysScheduleDAOImpl;
import com.futurebytedance.pojo.SysSchedule;
import com.futurebytedance.service.SysScheduleService;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/8 - 23:38
 * @Description
 */
public class SysScheduleServiceImpl implements SysScheduleService {
    private SysScheduleDAO sysScheduleDAO = new SysScheduleDAOImpl();

    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        return sysScheduleDAO.findItemListByUid(uid);
    }

    @Override
    public Integer addDefaultSchedule(int uid) {
        return sysScheduleDAO.addDefaultSchedule(uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule schedule) {
        return sysScheduleDAO.updateSchedule(schedule);
    }
}
