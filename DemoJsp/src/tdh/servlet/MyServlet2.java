package tdh.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * servlet输出页面
 * @author hanzc
 * @date 2021/4/20
 */
public class MyServlet2 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //暂时所有的请求都交给POST处理
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //设置响应的类型和编码，给游览器解析提供指导
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();

        //下面的字符串就是游览器将接收到的内容
        out.println("<html>");
        out.println("  <head>");
        out.println("    ");
        out.println("    <title>第一个Servlet页面</title>");
        out.println("    <meta http-equiv=\"pragma\" content=\"no-cache\">");
        out.println("    <meta http-equiv=\"cache-control\" content=\"no-cache\">");
        out.println("    <meta http-equiv=\"expires\" content=\"0\">    ");
        out.println("  </head>");
        out.println("  ");
        out.println("  <body>");
        out.println("      <h1>");
        out.println("    <br>");
        out.println("     你好,这就是一个Servlet输出的页面");
        out.println("     <br>");
        out.println("    </h1>");
        out.println("  </body>");
        out.println("</html>");
        out.flush();
        out.close();

        //如果需要修改内容，或者其中包含css或者js等更多内容时，如何输出和修改
    }
}
