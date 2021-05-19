<%@ page import="tdh.bean.TestUtils" %>
<%@ page import="tdh.bean.TUser" %>
<%@ page import="java.util.List" %>
<%@ page import="tdh.bean.TDepart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--contentType指定输出页面的格式和编码，pageEncoding的指定页面转换为servlet时使用的编码--%>
<%
  List<TUser> users = TestUtils.queryUserList();
  session.setAttribute("users", users);
  TUser user = users.get(0);
  session.setAttribute("user", user);
  TDepart depart = TestUtils.getDepart("32010001");
  session.setAttribute("depart", depart);
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
          这是将属性放入session的
         <br>
        </h1>
  </body>
</html>
