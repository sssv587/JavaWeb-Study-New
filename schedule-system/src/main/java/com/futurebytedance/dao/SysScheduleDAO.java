package com.futurebytedance.dao;


import com.futurebytedance.pojo.SysSchedule;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/7 - 23:56
 * @Description
 */
public interface SysScheduleDAO {
    /**
     * 用于向数据库中增加一条日程记录
     * @param schedule 日程数据以SysSchedule实体类对象形式入参
     * @return 返回影响数据库记录的行数,行数为0说明增加失败,行数大于0说明增加成功
     */
    int addSchedule(SysSchedule schedule);
}
