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
 * Servlet生命周期
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
 * Servlet继承接口
 *  1 顶级的Servlet接口
 *    public interface Servlet {
 *     // 初始化方法,构造完毕后,由tomcat自动调用完成初始化功能的方法
 *     void init(ServletConfig var1) throws ServletException;
 *
 *     // 获得ServletConfig对象的方法
 *     ServletConfig getServletConfig();
 *
 *     // 接收用户请求,向用户响应信息的方法
 *     void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
 *
 *     // 返回Servlet字符串形式描述信息的方法
 *     String getServletInfo();
 *
 *     // Servlet在回收前,由tomcat调用的销毁方法,往往用于做资源的释放工作
 *     void destroy();
 *  }
 *
 *  2 抽象的类
 *  public abstract class GenericServlet implements Servlet, ServletConfig, Serializable
 *       // 将抽象方法,重写为普通方法,在方法内部没有任何的视线代码
 *       // 平庸实现
 *       public void destroy() {}
 *
 *  // tomcat在调用init方法时,会读取配置信息,记录一个ServletConfig并将该对象传入init方法
 *  public void init(ServletConfig config) throws ServletException {
 *       // 将config对象存储为当前的属性
 *       this.config = config;
 *       // 调用了重载的无参的init
 *       this.init();
 *  }
 *  // 重载的初始化方法,我们重写初始化方法时对应的方法
 *  public void init() throws ServletException {}
 *  // 方法ServletConfig的方法
 *  public ServletConfig getServletConfig() {
 *         return this.config;
 *  }
 *  // 再次抽象声明Service方法
 *  public abstract void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
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
