package com.futurebytedance.listener;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/16 - 0:08
 * @Description 请求域对象监听器
 */
@WebListener
public class MyRequestListener implements ServletRequestListener, ServletRequestAttributeListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // 任何一个请求域对象的销毁都会触发该方法的执行
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // 任何一个请求域对象的初始化都会触发该方法的执行
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        // 任何一个请求域对象中增加了数据都会触发该方法的执行
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        // 任何一个请求域对象中移除了数据都会触发该方法的执行
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        // 任何一个请求域对象中修改了数据都会触发该方法的执行
    }
}
