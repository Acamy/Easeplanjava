package com.hebaohua.part4_servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Hebh
 * @date 2018/1/31
 * @description:
 */
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        //向浏览器输出内容
        PrintWriter writer = response.getWriter();
        writer.write("<html>");
        writer.write("<body>");
        writer.write("<h2>This is a servlet Test");
        writer.write("</body></html>");
    }

    @Override
    public void init() throws ServletException {
        //获取初始化参数
        ServletConfig config = this.getServletConfig();
        System.out.println(config.getInitParameter("key1"));
        System.out.println(config.getInitParameter("key2"));

        //全局参数
        ServletContext ctx = this.getServletContext();
        System.out.println(ctx.getInitParameter("globalData1"));
        System.out.println(ctx.getInitParameter("globalData2"));

        ctx.setAttribute("arrt1","attrvalue1");
        System.out.println(ctx.getAttribute("arrt1"));


//        ctx.getRealPath()
//                ctx.getResource()
//                        ctx.getResourceAsStream()

    }

}
