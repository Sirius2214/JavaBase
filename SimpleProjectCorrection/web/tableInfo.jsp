<%--
  Created by IntelliJ IDEA.
  User: 2680
  Date: 2021/4/25
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/connect.js"></script>
    <script type="text/javascript" src="/js/getTableInfo.js"></script>
    <script type="text/javascript" src="/js/tableInfo.js"></script>
    <link rel="stylesheet" href="css/tableInfo.css"/>
    <title>用户信息</title>
</head>
<body>
<div class="tb_div" style="background-color: #ffe4c4;">
    <div class="header  ">
        <div style="width: 80%">
            <label>姓名/账户:</label>
            <input type="text" id="userid">
        </div>

        <div class="div_depart">
            <button id="search" onclick="search(${fn:length(departTree)})">查询</button>
            <button id="add" onclick="add()">新增</button>
            <form action="/logout" method="get">
<%--                <button id="logout" onclick="logout()">注销</button>--%>
                <input type="submit" value="注销">
            </form>

        </div>
    </div>
    <div class="tb_body tb_div" style="border-left: 0; border-bottom: 0;">
        <div class="tb_bodyleft  " style="width: 15% ; " id="departTree">
            <c:forEach items='${sessionScope.departTree}' var="products" varStatus="v">
                <ul id="depart${v.index}"
                    onclick="clickDepart(${fn:length(departTree) },${v.index})"
                    onmouseover="moveIn(${fn:length(departTree) },${v.index})"
                    onmouseout="moveOut(${fn:length(departTree)},-1)"
                >${products} </ul>

            </c:forEach>


        </div>
        <div style="width: 65% ; ">
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
                <tr></tr>
<%--                <c:forEach items="${sessionScope.tableInfo}" var="info">--%>
<%--                    <tr class="layout">--%>

<%--                        <td>${info.sort}</td>--%>
<%--                        <td>${info.userName}</td>--%>
<%--                        <td>${info.account}</td>--%>
<%--                        <td>${info.department}</td>--%>
<%--                        <td>${info.sex}</td>--%>
<%--                        <td>--%>
<%--                            <button onclick="deleteUser('${info.account}')">删除</button>--%>
<%--                        </td>--%>
<%--                        <td>--%>
<%--                            <button onclick="updateUser('${info.account}')">--%>
<%--                                修改--%>
<%--                            </button>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>

                </tbody>
            </table>
        </div>
    </div>

</div>
<p>-eee--</p>


</body>
</html>
