<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--contentType指定输出页面的格式和编码，pageEncoding的指定页面转换为servlet时使用的编码--%>
<html>
  <head>
    <title>include静态包含测试1</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
  </head>
  <body>
  <%@include file="MyJsp5.jsp"%>
      <h1>
        <br>
         这是原本的页面数据
         <br>
        </h1>
  </body>
</html>
