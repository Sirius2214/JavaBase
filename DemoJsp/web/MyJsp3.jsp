<%@ page import="tdh.bean.TestUtils" %>
<%@ page import="tdh.bean.TUser" %>
<%@ page import="java.util.List" %>
<%@ page import="tdh.bean.TDepart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%!
    //这里的代码在_jspService方法之外，可以定义类变量，方法等
    public String convertBmmc(String bmdm) {
        TDepart depart = TestUtils.getDepart("32010001");
        return depart.getBmmc();
    }
%>
<%
    List<TUser> users = TestUtils.queryUserList();
%>
<html>
  <head>
    <title>第一个JSP页面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
  </head>
  <body>
      <table>
          <tr>
              <td>用户代码</td>
              <td>用户ID</td>
              <td>用户姓名</td>
              <td>用户部门</td>
          </tr>
          <!-- 这是html注释 -->
          <%-- 这是jsp注释 --%>
          <% /**
           这是多行注释
           */
            //这是java注释
              for (TUser user : users) { %>
          <tr>
              <td><%= user.getYhdm() %></td>
              <td><%= user.getYhid() %></td>
              <td><%= user.getYhxm() %></td>
              <td><%= convertBmmc(user.getYhbm()) %></td>
          </tr>
          <% } %>
      </table>
  </body>
</html>
