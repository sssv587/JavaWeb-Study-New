package com.futurebytedance.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/3/21 - 23:48
 * @Description Servlet生命周期
 * <p>
 * 1、实例化                     构造器       第一次请求/服务启动时(取决于loan-on-start)     1
 * 2、初始化                      init        构造完毕                                     1
 * 3、接收请求,处理请求 服务      service      每次请求                                    多次
 * 4、销毁                      destroy      关闭服务                                      1
 *
 * Servlet在Tomcat中是单例的
 * Servlet的成员变量在多个线程栈之中是共享的
 * 不建议在service方法中修改成员变量   在并发请求时,会引发线程安全问题
 *
 * default-servlet:主要是加载静态资源的
 *
 *
 */
// loadOnStartup建议从6开始写,因为在Tomcat的conf/web.xml中,有些值已经被占用了
@WebServlet(value = "/servletLifeCycle",loadOnStartup = 6)
public class ServletLifeCycle extends HttpServlet {
    public ServletLifeCycle() {
        System.out.println("构造器");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("服务");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
