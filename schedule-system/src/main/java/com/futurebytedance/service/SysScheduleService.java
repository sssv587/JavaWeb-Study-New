package com.futurebytedance.service;

import com.futurebytedance.pojo.SysSchedule;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/8 - 23:38
 * @Description
 */
public interface SysScheduleService {
    List<SysSchedule> findItemListByUid(int uid);
}
