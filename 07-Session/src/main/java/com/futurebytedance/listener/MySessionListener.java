package com.futurebytedance.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/16 - 0:05
 * @Description Session域对象监听器
 */
@WebListener
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 任何一个session域对象的创建都会触发该方法的执行
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 任何一个session域对象的销毁都会触发该方法的执行
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        // 任何一个session域中增加了数据都会触发该方法的执行
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        // 任何一个session域中删除了数据都会触发该方法的执行
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        // 任何一个session域中修改了数据都会触发该方法的执行
    }
}
