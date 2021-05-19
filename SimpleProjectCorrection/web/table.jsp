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
    <title>Title</title>

</head>
<body>
<div id="testRefresh">
    输出全部：
    <div id="tableMessage">
        <c:forEach items="${sessionScope.info}" var="mem">
            ${mem}
        </c:forEach>
    </div>

</div>
<script>
    var result = "${info}"
    console.log(result)
    console.log("加载")
</script>
</body>
</html>
