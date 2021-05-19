<%--
  Created by IntelliJ IDEA.
  User: 2680
  Date: 2021/4/26
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/connect.js"></script>
<script type="text/javascript" src="/js/getTableInfo.js"></script>
<script type="text/javascript" src="/js/updateUser.js"></script>
<link rel="stylesheet" href="css/updateUser.css"/>
<body>

<form  style="text-align: center; vertical-align: middle; background-color: #ebfbee;" id="info" method="post" onsubmit="return submitForm();">
    <div style="text-align: center; vertical-align: middle;">
        <div>基本信息</div>
        <table border="1" cellspacing="0" style="margin-left:auto;margin-right:auto;">
            <tbody>
            <tr>

                <th class="name_td">
                    <div>
                        <label><span>用户ID</span></label>
                    </div>
                </th>
                <td class="name_tbody ">
                    <div class="input_depart"><input class="input_div" type="text" name="userId"
                                                     data-verify="required"></div>
                </td>
                <th class="name_td">
                    <div>
                       <label> <span>口令</span></label>
                    </div>
                </th>
                <td>
                    <div><input class="input_div" type="password" name="userPassword" data-verify="required">
                    </div>
                </td>
                <th class="name_td">
                    <div>
                        <label> <span>确认口令</span></label>
                    </div>
                </th>
                <td>
                    <div><input class="input_div" style="width: 99%;" type="password" name="userRePassword">
                    </div>
                </td>
            </tr>

            <tr>
                <th class="name_td">
                    <div>
                        <label><span>姓名</span></label>
                    </div>
                </th>
                <td>
                    <div style="text-align: left;">
                        <div class="input_depart"><input class="input_div" type="text" name="userName"
                                                         data-verify="required"></div>
                    </div>
                </td>
                <th class="name_td">
                    <div>
                        <label>性别</label>
                    </div>
                </th>
                <td>
                    <div class="input_depart">
                        <select class="input_depart" data-verify="required" >
                            <option selected disabled style="display: none;"  name="sexList">---请选择性别---
                            </option>
                            <option value="男" name="sex">男</option>
                            <option value="女" name="sex">女</option>
                        </select>
                    </div>

                </td>
                <th class="name_td">
                    <div>
                        <label>部门</label>
                    </div>
                </th>
                <td>
                    <div class="input_depart">
                        <select class="input_depart" data-verify="required" id="depart" name="depart">


                        </select>
                    </div>

                </td>
            </tr>
            <tr>
                <th class="name_td">
                    <div>
                        <label>出生日期</label>
                    </div>
                </th>
                <td class="name_tbody ">
                    <div class="input_depart"><input class="input_div" type="date" name="birthday"
                                                     value="<fmt:formatDate value="${Time}" pattern="yyyy-MM-dd" />"
                                                     data-verify="required"></div>
                </td>
                <th class="name_td">
                    <div>
                        <label>排序后号</label>
                    </div>
                </th>
                <td>
                    <div><input class="input_div" type="number" name="sort" data-verify="required">
                    </div>
                </td>
                <th class="name_td">
                    <div>
                        <label>禁用</label>
                    </div>
                </th>
                <td>
                    <div><input class="input_div" style="width: 99%;" type="checkbox" name="isDisable" checked="checked">
                    </div>
                </td>
            </tr>


            </tbody>
        </table>
    </div>

    <div style="align-content: center;">
        <!-- <button id="save" type="button">保存</button>
        <button id="close">关闭</button> -->
        <input id="save" type="submit" value="保存"/>
        <input id="reset" type="reset" style="display:  none;" value="重置"/>
        <input id="close" type="button" value="取消"/>

    </div>

</form>
<script>

</script>
</body>
</html>
