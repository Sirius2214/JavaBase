<%--
  Created by IntelliJ IDEA.
  User: 2680
  Date: 2021/5/18
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/connect.js"></script>
<script type="text/javascript" src="/js/getTableInfo.js"></script>
<script type="text/javascript" src="/js/tableInfo.js"></script>
<link rel="stylesheet" href="css/tableInfo.css"/>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items='${sessionScope.departTree}' var="products" varStatus="v">
    <ul id="depart${v.index}"
        onclick="clickDepart(${fn:length(departTree) },${v.index})"
        onmouseover="moveIn(${fn:length(departTree) },${v.index})"
        onmouseout="moveOut(${fn:length(departTree)},-1)"
    >${products} </ul>

</c:forEach>
</body>
</html>
