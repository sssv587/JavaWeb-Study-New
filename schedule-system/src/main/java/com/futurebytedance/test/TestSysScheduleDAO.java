package com.futurebytedance.test;

import com.futurebytedance.dao.SysScheduleDAO;
import com.futurebytedance.dao.impl.SysScheduleDAOImpl;
import com.futurebytedance.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/8 - 0:35
 * @Description
 */
public class TestSysScheduleDAO {
    private static SysScheduleDAO sysScheduleDAO;

    @BeforeClass
    public static void intiScheduleDao() {
        sysScheduleDAO = new SysScheduleDAOImpl();
    }

    @Test
    public void testAddSchedule() {
        int rows = sysScheduleDAO.addSchedule(new SysSchedule(null, 2, "学习数据库", 1));
        System.out.println(rows);
    }

    @Test
    public void testFindAll() {
        List<SysSchedule> scheduleList = sysScheduleDAO.findAll();
        scheduleList.forEach(System.out::println);
    }
}
