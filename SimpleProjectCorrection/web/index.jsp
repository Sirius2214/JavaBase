<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static javax.servlet.jsp.PageContext.REQUEST_SCOPE" %>
<%@ page import="static javax.servlet.jsp.PageContext.SESSION_SCOPE" %><%--
  Created by IntelliJ IDEA.
  User: 2680
  Date: 2021/4/23
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/connect.js"></script>
    <script type="text/javascript" src="/js/login.js"></script>
</head>

<%--<script type="text/javascript" src="/js/login.js"></script>--%>
<body>
<div style="text-align: center ;height: 200px">
    <form action="" method="post">
        <div style="height: 30% ;">
            <div style="margin-top: 20%;">
                <label>用户名</label>
                <input type="text" name="userName" id="userName">
                <input type="checkbox" name="saveAccount" checked="checked">
                <label>保存账号</label>
            </div>

        </div>
        <div style="height: 30%">
            <label>口&nbsp &nbsp令</label>
            <input type="password" name="userPassword" id="userPassword">
            <input type="checkbox" name="savePassword" checked="checked">
            <label>保存口令</label>
        </div>
        <div style="text-align: center">
            <input type="submit" id="login" value="登录"></input>
            <input type="reset" id="reset" value="重置"></input>
        </div>
    </form>

</div>
<div>
    <%
        List list = new ArrayList();
        list.add("qq");
        list.add("ww");
        list.add("ee");
        pageContext.setAttribute("info", list,SESSION_SCOPE);
    %>
     <button onclick="getDepart()">获取</button>
        <div id="testRefresh">
            <div id="tableMessage">
                <c:forEach items="${sessionScope.info}" var="mem">
                    ${mem}
                </c:forEach>
            </div>
        </div>

    <p>结束</p>
</div>
</body>
<script type="text/JavaScript">
$(function () {


    var result = "${requestScope.info}"
    console.log(result)


})
function  getDepart() {
    <%--var t = "${pageContext.request.contextPath}";--%>
    <%--console.log(t)--%>
    <%
    List list1 = new ArrayList();
    list1.add("q1q");
    list1.add("ww1");
    list1.add("e1e");

    pageContext.setAttribute("info", list1);
    pageContext.setAttribute("task", list1);

%>
    var result = "${info}"
    console.log(result)

    var data=getAjax('/table.jsp', 'POST', null);
    console.log(data)

    $('[id="testRefresh"]').empty();
    $('[id="testRefresh"]').append(data.responseText)
    console.log(data)

}

</script>
</html>
