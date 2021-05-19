package tdh.jsp2servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

/**
 * 这是tomcat吧MyJsp2.jsp转换后的java文件
 */
public final class MyJsp2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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
      out.write("    <title>第一个JSP页面</title>\n");
      out.write("    <meta http-equiv=\"pragma\" content=\"no-cache\">\n");
      out.write("    <meta http-equiv=\"cache-control\" content=\"no-cache\">\n");
      out.write("    <meta http-equiv=\"expires\" content=\"0\">\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("      <h1>\n");
      out.write("          ");

      //所有被百分号括号括起来的内容都会原封不动搬到_jspService方法中<% //这里的内容会 %>
 for (int i = 0; i < 1000; i++) { 
      out.write("\n");
      out.write("          <br>\n");
      out.write("          这是第");

      //所有被百分号括号等于号包裹起来的都会执行表达式，然后将结果输出到页面中
      out.print( i + 1 );
      out.write("次\n");
      out.write("          <br>\n");
      out.write("          ");
 } 
      out.write("\n");
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
