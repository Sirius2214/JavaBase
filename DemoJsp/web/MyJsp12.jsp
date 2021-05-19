<%@ page import="tdh.bean.TUser" %>
<%@ page import="java.util.List" %>
<%@ page import="tdh.bean.TDepart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--contentType指定输出页面的格式和编码，pageEncoding的指定页面转换为servlet时使用的编码--%>
<%
  session.removeAttribute("users");
  session.removeAttribute("user");
  session.removeAttribute("depart");
%>
<html>
  <head>
    <title>session测试</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
  </head>
  <body>
      <h1>
        <br>
          这是清除session属性的页面
        <br>
        </h1>
  </body>
</html>
