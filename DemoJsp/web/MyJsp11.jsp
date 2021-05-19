<%@ page import="tdh.bean.TUser" %>
<%@ page import="java.util.List" %>
<%@ page import="tdh.bean.TDepart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--contentType指定输出页面的格式和编码，pageEncoding的指定页面转换为servlet时使用的编码--%>
<%
  List<TUser> users = (List<TUser>) session.getAttribute("users");
  TUser user = (TUser) session.getAttribute("user");
  TDepart depart = (TDepart) session.getAttribute("depart");
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
          这是获取session属性的页面
        <br>
        users 的长度<%= users == null ? "users 为空" : users.size() %>
        <br>
        user 的信息<%= user == null ? "user 为空" : user.getYhdm() %>
        <br>
        depart 的信息<%= depart == null ? "depart 为空" : depart.getBmdm() %>
        <br>
        </h1>
  </body>
</html>
