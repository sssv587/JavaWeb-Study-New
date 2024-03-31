package com.futurebytedance.servlet.encoding;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/3/31 - 23:43
 * @Description GET/POST请求参数乱码
 *
 * GET乱码问题：GET方式时,form表单提交的参数会放在uri后面,编码受到charset的影响       server.xml connector URIEncoding=""
 *                                               请求行 GET URI?username=101010101 http/1.1
 * POST乱码问题：POST方式时,form表单提交的参数会放在请求体中,编码受到charset的影响    req.setCharacterEncoding("")
 *                                               请求行 GET URI http/1.1
 *                                               请求体 username=101010101
 */
@WebServlet("/useServlet")
public class UseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // tomcat10 默认以UTF-8为请求体的解码字符集
        // 客户端提交数据时,要是以其它字符集对请求体中的数据进行编码则就会出现乱码
        // 设置请求体的解码使用的字符集
//        req.setCharacterEncoding("UTF-8");

        System.out.println(req.getParameter("username"));
    }
}
