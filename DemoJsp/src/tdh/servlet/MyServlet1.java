package tdh.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 一个简单的servlet
 * @author hanzc
 * @date 2021/4/18
 */
public class MyServlet1 extends HttpServlet {

    /**
     * 处理GET类型的请求
     * @param request 请求
     * @param response 响应
     * @throws IOException 异常
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //暂时所有的请求都交给POST处理
        doPost(request, response);
    }

    /**
     * 处理POST类型的请求
     * @param request 请求
     * @param response 响应
     * @throws IOException 异常
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //设置响应的类型和编码，给游览器解析提供指导
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        out.println("<h1>这是一个简单的Servlet</h1>");
        out.flush();
        out.close();
    }
}
