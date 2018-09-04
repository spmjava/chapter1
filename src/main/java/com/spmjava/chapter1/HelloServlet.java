package com.spmjava.chapter1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 齐伟超
 * @date 2018-09-04 13:55
 * @since 1.0.0
 **/
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setAttribute("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ssss").format(new Date()));
        req.getRequestDispatcher("WEB-INF/jsp/hello.jsp").forward(req, resp);
    }
}
