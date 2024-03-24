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
 *  2 抽象的类  侧重除了Service方法以外的其他方法的基础处理
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
 *
 *  3 HttpServlet 抽象类 侧重Service方法的处理
 *  public abstract class HttpServlet extends GenericServlet
 *  // 参数的父转子 调用重载的service方法
 *  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
 *         HttpServletRequest request;
 *         HttpServletResponse response;
 *         try {
 *             // 参数的父转子
 *             request = (HttpServletRequest)req;
 *             response = (HttpServletResponse)res;
 *         } catch (ClassCastException var6) {
 *             throw new ServletException(lStrings.getString("http.non_http"));
 *         }
 *         // 调用重载的service
 *         this.service(request, response);
 *     }
 *
 *   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 *         // 获取请求的方式
 *         String method = req.getMethod(); // GET POST PUT DELETE OPTIONS...
 *         long lastModified;
 *         // 根据请求方法,调用对应do..方法
 *         if (method.equals("GET")) {
 *             lastModified = this.getLastModified(req);
 *             if (lastModified == -1L) {
 *                 this.doGet(req, resp);
 *             } else {
 *                 long ifModifiedSince;
 *                 try {
 *                     ifModifiedSince = req.getDateHeader("If-Modified-Since");
 *                 } catch (IllegalArgumentException var9) {
 *                     ifModifiedSince = -1L;
 *                 }
 *
 *                 if (ifModifiedSince < lastModified / 1000L * 1000L) {
 *                     this.maybeSetLastModified(resp, lastModified);
 *                     this.doGet(req, resp);
 *                 } else {
 *                     resp.setStatus(304);
 *                 }
 *             }
 *         } else if (method.equals("HEAD")) {
 *             lastModified = this.getLastModified(req);
 *             this.maybeSetLastModified(resp, lastModified);
 *             this.doHead(req, resp);
 *         } else if (method.equals("POST")) {
 *             this.doPost(req, resp);
 *         } else if (method.equals("PUT")) {
 *             this.doPut(req, resp);
 *         } else if (method.equals("DELETE")) {
 *             this.doDelete(req, resp);
 *         } else if (method.equals("OPTIONS")) {
 *             this.doOptions(req, resp);
 *         } else if (method.equals("TRACE")) {
 *             this.doTrace(req, resp);
 *         } else {
 *             String errMsg = lStrings.getString("http.method_not_implemented");
 *             Object[] errArgs = new Object[]{method};
 *             errMsg = MessageFormat.format(errMsg, errArgs);
 *             resp.sendError(501, errMsg);
 *         }
 *
 *     }
 *  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 *         String msg = lStrings.getString("http.method_get_not_supported");
 *         String protocol = req.getProtocol();
 *         this.sendMethodNotAllowed(req, resp, msg);
 *         if (protocol.length() != 0 && !protocol.endsWith("0.9") && !protocol.endsWith("1.0")) {
 *             // 故意相应 405 请求方式不允许的信息
 *             resp.sendError(405, msg);
 *         } else {
 *             resp.sendError(400, msg);
 *         }
 *  }
 *  // 故意响应405
 *  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 *         String msg = lStrings.getString("http.method_post_not_supported");
 *         this.sendMethodNotAllowed(req, resp, msg);
 *  }
 *
 *  4 自定义Servlet
 *  class Servlet1 extends HttpServlet {
 *     protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 *        // 接收用户请求信息
 *
 *        // 作出响应
 *
 *    }
 *  }
 *
 * 1、部分程序员推荐在servlet中重写do...方法处理请求 理由:service方法中可能做了一些处理,如果我们直接重写service的话,父类中service方法处理的功能则失效了
 * 2、目前直接重写service方法也没有什么问题
 * 3、后续使用了SpringMVC框架后,我们则无需继承HttpServlet,处理请求的方法也无需是 do*** service
 * 4、如果doGet和doPost方法中,我们定义的代码都一样,可以让一个方法直接调用另一个方法
 *
 * 总结,掌握的技能
 *     继承HttpServlet后,要么重写service方法,要么重写 doGet/doPost
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

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("服务");
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get请求处理的方法");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post请求处理的方法");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
