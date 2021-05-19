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
        </div>
        <div style="width: 65% ; " id="tb_body">

        </div>
    </div>

</div>
<div id='dialog-modal'></div>
</body>
<script>
    $(function () {
        console.log("页面加载")

        //获取部门树
        getAjax('/getDepartTree', 'Post', null)
        setDepartTree();
        dataRefresh();
    })
</script>
</html>
