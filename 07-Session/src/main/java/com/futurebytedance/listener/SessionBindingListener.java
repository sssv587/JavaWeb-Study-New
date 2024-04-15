package com.futurebytedance.listener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/16 - 0:12
 * @Description Session绑定监听器
 * 需要在session中显式set
 */
public class SessionBindingListener implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 当前监听器实例放入某个session中作为数据  绑定
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // 当前监听器实例从某个session中移除  绑定
    }
}
