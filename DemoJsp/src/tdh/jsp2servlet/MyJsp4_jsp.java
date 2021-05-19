package tdh.jsp2servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

/**
 * 这是tomcat吧MyJsp4.jsp转换后的java文件
 * include静态包含的测试
 */
public final class MyJsp4_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  //多了一个这个属性
  private static java.util.List _jspx_dependants;
  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/MyJsp5.jsp");
  }

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

      out.write('\n');
      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <title>include静态包含测试1</title>\n");
      out.write("    <meta http-equiv=\"pragma\" content=\"no-cache\">\n");
      out.write("    <meta http-equiv=\"cache-control\" content=\"no-cache\">\n");
      out.write("    <meta http-equiv=\"expires\" content=\"0\">\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("  ");

      //MyJsp5的数据开始
      out.write('\n');
      out.write("\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <title>include静态包含测试2</title>\n");
      out.write("    <meta http-equiv=\"pragma\" content=\"no-cache\">\n");
      out.write("    <meta http-equiv=\"cache-control\" content=\"no-cache\">\n");
      out.write("    <meta http-equiv=\"expires\" content=\"0\">\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("      <h1>\n");
      out.write("        <br>\n");
      out.write("         这是被包含的的页面数据\n");
      out.write("         <br>\n");
      out.write("        </h1>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
      out.write("\n");
      //MyJsp5的数据结束

      out.write("      <h1>\n");
      out.write("        <br>\n");
      out.write("         这是原本的页面数据\n");
      out.write("         <br>\n");
      out.write("        </h1>\n");
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
