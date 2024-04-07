package com.futurebytedance.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/7 - 23:53
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysSchedule implements Serializable {
    private Integer sid;
    private Integer uid;
    private String title;
    private Integer completed;
}
