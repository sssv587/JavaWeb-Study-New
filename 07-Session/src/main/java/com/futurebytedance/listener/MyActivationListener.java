package com.futurebytedance.listener;

import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionEvent;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/16 - 0:18
 * @Description Session的钝化和活化
 * 需要在session中显式set
 */
public class MyActivationListener implements HttpSessionActivationListener {
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        // session 对象即将进行钝化之前执行
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        // session 活化完毕之后执行
    }
}
