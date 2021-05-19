<%--
  Created by IntelliJ IDEA.
  User: 2680
  Date: 2021/4/29
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/connect.js"></script>
    <script type="text/javascript" src="/js/getTableInfo.js"></script>
    <script type="text/javascript" src="/js/tableInfo.js"></script>
    <link rel="stylesheet" href="css/tableInfo.css"/>
    <title>Title</title>

</head>
<body>
<div id="testRefresh">
    <table style="width: 100% ; " cellspacing="0">
        <thead style="background-color:#9e9891 ;">
        <tr>
            <th style="width: 10%; border-right: black solid 1px;">排序号</th>
            <th style="width: 20%; border-right: black solid 1px;">姓名</th>
            <th style="width: 20%;border-right: black solid 1px;">帐号</th>
            <th style="width: 20%;border-right: black solid 1px;">用户部门</th>
            <th style="width: 10%;border-right: black solid 1px;">性别</th>
            <th style="width: 7%;border-right: black solid 1px;">查看</th>

            <th style="width: 7%;border-right: black solid 1px;">删除</th>
            <th style="width: 7%;border-right: black solid 1px;">修改</th>
        </tr>

        </thead>
        <tbody align="center" id="message">
        <c:forEach items="${sessionScope.tableInfo}" var="info">
            <tr class="layout">
                <td>${info.sort}</td>
                <td>${info.userName}</td>
                <td>${info.account}</td>
                <td>${info.department}</td>
                <td>${info.sex}</td>
                <td>
                    <button onclick="detailMessage('${info.account}')">查看</button>
                </td> <td>
                    <button onclick="deleteUser('${info.account}')">删除</button>
                </td>
                <td>
                    <button onclick="updateUser('${info.account}')">
                        修改
                    </button>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>


</div>
<script>
    var result = "${info}"
    console.log(result)
    console.log("加载")
</script>
</body>
</html>
