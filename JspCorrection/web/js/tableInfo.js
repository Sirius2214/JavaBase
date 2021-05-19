function setDepartTree() {
    var data = getAjax('/departTree.jsp', 'POST', null);
    $('[id="departTree"]').empty();
    $('[id="departTree"]').append(data.responseText)
}

function dataRefresh() {
//获取表格数据
    getAjax('/tableInfo', 'Post', null)
    setTableBody()
}

function setTableBody() {
    var data = getAjax('/table.jsp', 'POST', null);
    $('[id="tb_body"]').empty();
    $('[id="tb_body"]').append(data.responseText)
}

/**
 * 点击部门树实现高亮,并查询当前部门下的用户
 * @param len 部门总数
 * @param index 当前部门
 */
function clickDepart(len, index) {
    var depart = '';
    for (var i = 0; i < len; i++) {
        //如果是当前部门
        if (i === index) {
            //获取标签对象
            var obj = document.getElementById("depart" + i);
            //获取标签的内容
            depart = obj.textContent
            //进行高亮显示
            obj.style.color = 'red';
        } else {
            //其余黑色显示
            var obj = document.getElementById("depart" + i);
            obj.style.color = 'black';
        }
    }
    console.log(depart)
    //获取当前部门数据
    getAjax('/GetUserInfoByDepart', "POST", {depart: encodeStr(depart)})
    //属性表格
    setTableBody()

}

//鼠标移入时进行高亮
function moveIn(len, index) {
    console.log("进入")
    for (var i = 0; i < len; i++) {
        if (i === index) {
            var obj = document.getElementById("depart" + i);

            obj.style.color = 'red';
        } else {
            var obj = document.getElementById("depart" + i);

            obj.style.color = 'black';
        }
    }

}

//鼠标移除时,恢复高亮
function moveOut(len, flag) {
    if (flag === -1) {
        for (var i = 0; i < len; i++) {
            var obj = document.getElementById("depart" + i);
            obj.style.color = 'black';

        }
    }
}

/**
 * 查找函数,根据ID/用户名查找数据,并刷新表格数据
 * @param len
 */
function search(len) {
    moveOut(len, 0)
    //获取当前input标签的内容
    var userID = $(userid).val();
    // 进行空值的校验
    if (!userID) {
        //为空时,查找所有数据,并刷新表格
        getAjax('/tableInfo', 'Post', null);
    } else {
        // 不为空时.根据name查找用户数据,并刷新表格
        var to = {
            name: userID
        }
        getAjax('/getByName', 'POST', to)
    }
    setTableBody();

}


/**
 * 新增按钮触发事件
 */
function add() {
    // console.log("添加")
    // console.log("-----")
    // 弹出弹窗显示新增的form表单并传参数model=add表示为新增功能
    var url = '../updateUser.jsp?model=add'
    // 弹出弹窗显示新增的form表单
    openwindow(url, '用户信息', 800, 250)


}

/**
 * 删除功能：根据传入的账户ID删除当前用户
 * @param account
 */
function deleteUser(account) {
    console.log("删除")
    console.log(account)
    var data = {
        account: account
    }
    let b = window.confirm("是否删除当前账号：" + account + "\n请单击“确定”或“取消”。");
    if (b) {
        // 删除用户
        var data = getAjax("/deleteUser", 'POST', data)
        dataRefresh();

        if (data.code = 200) {
            alert(data.resultMessage)

        } else {
            alert(data.resultMessage)

        }
        // 刷新表格数据
        console.log(data)
    }

}

/**
 * 产看用户的详细信息
 * @param account
 */
function detailMessage(account) {
    console.log("查看")
    // console.log(account)
    // 弹出弹窗显示查询的form表单并传参数model=message表示为查询功能,传入参数账号ID
    var url = '../updateUser.jsp?account=' + account + "&model=message"
    // 弹出弹窗显示查询的form表单
    openwindow(url, '用户信息', 800, 250)
}

/**
 * 更新用户的信息
 * @param account
 */
function updateUser(account) {
    console.log("更新")
    console.log(account)
    // 弹出弹窗显示查询的form表单并传参数账户ID
    var url = '../updateUser.jsp?account=' + account
    // 弹出弹窗显示更新的form表单
    openwindow(url, '用户信息', 800, 250)


}

//注销功能函数
function logout(len) {
    // moveOut(len, 0)
    getAjax("/logout", 'GET', null)

}

//去掉空格
function trim(value) {
    if (value) {
        value = value.replace(/^\s*|\s*$/g, "");

    }
    if (!value) {
        return "";

    } else {
        return value;

    }
}

// url需要跳转的地址
function openwindow(url, name, iWidth, iHeight) {
    var url;
    var name;
    var iWidth;
    var iHeight;
    var iTop = (window.screen.height - 30 - iHeight) / 2;
    var iLeft = (window.screen.width - 10 - iWidth) / 2;
    window.open(url, name, 'height=' + iHeight + ',innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}

//字符进行编码
function encodeStr(val) {
    return encodeURIComponent((trim(val)));
}
