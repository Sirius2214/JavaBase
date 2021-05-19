<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--如何在页面中显示0到1千，为什么jsp被称作动态页面，html叫静态页面--%>
<html>
  <head>
    <title>第一个JSP页面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
  </head>
  <body>
      <h1>
          <% for (int i = 0; i < 1000; i++) { %>
          <br>
          这是第<%= i + 1 %>次
          <br>
          <% } %>
        </h1>
  </body>
</html>
