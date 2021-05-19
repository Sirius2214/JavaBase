package tdh.jsp2servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import tdh.bean.TestUtils;
import tdh.bean.TUser;
import java.util.List;
import tdh.bean.TDepart;

/**
 * 这是tomcat吧MyJsp3.jsp转换后的java文件
 */
public final class MyJsp3_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    //这里的代码在_jspService方法之外，可以定义类变量，方法等
    public String convertBmmc(String bmdm) {
        TDepart depart = TestUtils.getDepart("32010001");
        return depart.getBmmc();
    }

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static List _jspx_dependants;

//  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
//    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');

    List<TUser> users = TestUtils.queryUserList();

      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <title>第一个JSP页面</title>\n");
      out.write("    <meta http-equiv=\"pragma\" content=\"no-cache\">\n");
      out.write("    <meta http-equiv=\"cache-control\" content=\"no-cache\">\n");
      out.write("    <meta http-equiv=\"expires\" content=\"0\">\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("      <table>\n");
      out.write("          <tr>\n");
      out.write("              <td>用户代码</td>\n");
      out.write("              <td>用户ID</td>\n");
      out.write("              <td>用户姓名</td>\n");
      out.write("              <td>用户部门</td>\n");
      out.write("          </tr>\n");

      //html的注释会被输出到游览器，游览器的源码中可以看到
      out.write("          <!-- 这是html注释 -->\n");
      out.write("          ");
      out.write("\n");
      out.write("          ");

      //java注释会原封不动在此方法中
 /**
           这是多行注释
           */
            //这是java注释
              for (TUser user : users) { 
      out.write("\n");
      out.write("          <tr>\n");
      out.write("              <td>");
      out.print( user.getYhdm() );
      out.write("</td>\n");
      out.write("              <td>");
      out.print( user.getYhid() );
      out.write("</td>\n");
      out.write("              <td>");
      out.print( user.getYhxm() );
      out.write("</td>\n");
      out.write("              <td>");
      out.print( convertBmmc(user.getYhbm()) );
      out.write("</td>\n");
      out.write("          </tr>\n");
      out.write("          ");
 } 
      out.write("\n");
      out.write("      </table>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
