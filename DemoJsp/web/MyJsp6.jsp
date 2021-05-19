<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--contentType指定输出页面的格式和编码，pageEncoding的指定页面转换为servlet时使用的编码--%>
<%
    request.getRequestDispatcher("/MyJsp7.jsp").forward(request, response);
%>
<html>
  <head>
    <title>转发和重定向测试1</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
  </head>
  <body>
      <h1>
        <br>
         这是转发前的页面
         <br>
        </h1>
  </body>
</html>
