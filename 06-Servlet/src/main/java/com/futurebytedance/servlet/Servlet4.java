package com.futurebytedance.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Enumeration;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/3/27 - 23:48
 * @Description HttpServletRequest获取请求行和请求体
 */
@WebServlet("/servlet04")
public class Servlet4 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        // 行相关 GET/POST uri http/1.1
        System.out.println(request.getMethod()); // 获取请求方式
        System.out.println(request.getScheme()); // 获取请求协议
        System.out.println(request.getProtocol()); // 获取请求协议及版本号
        System.out.println(request.getRequestURI()); // 获取请求的uri 项目内的资源路径
        System.out.println(request.getRequestURL()); // 获取请求的url 项目内资源的完整路径

        /*
         URI 统一资源标识符  /web02/servlet04 interface URI{}   资源定位的要求和规范
         URL 统一资源定位符  http://localhost:8080/web02/servlet04 class URL implements URI{}  一个具体的资源路径
         */
        System.out.println(request.getLocalPort()); // 本应用容器的端口号
        System.out.println(request.getServerPort()); // 客户端发请求时使用的端口号 代理
        System.out.println(request.getRemotePort()); // 客户端软件的端口号

        // 头相关 key:value key:value ....
        // 根据名字单独获取某个请求头
        System.out.println("Accept:" + request.getHeader("Accept"));
        // 获取本次请求中所有的请求头的名字
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String hname = headerNames.nextElement();
            System.out.println(hname + ":" + request.getHeader(hname));
        }

        // 获取请求参数
    }
}
