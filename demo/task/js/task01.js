$(function () {
    // 表格基础数据
    var messages = [{
        userId: 'test1',
        userName: '测试1',
        userDepart: '部门1'
    }, {
        userId: 'test2',
        userName: '测试2',
        userDepart: '部门2'
    }, , {
        userId: 'test3',
        userName: '测试3',
        userDepart: '部门3'
    }, ];
    // 遍历数据，并加入到table中
    for (var obj in messages) {
        var s = "<tr style=\"background-color:#edf2ff ;\"><td>" + messages[obj].userId + "</td><td>" + messages[obj].userName + "</td><td>" + messages[obj].userDepart + "<td></td></td></tr>"
        $(message).append(s);
    }

    //查找的点击事件触发
    $(search).click(function () {
      
        // 获得用户ID和用户部门
        var userID = $(userid).val();
        var userDepart = $(user_department).val();
        // 进行空值的校验
        if (!userID || !userDepart) {
            var s = [];
            if (!userID) {
                s.push("用户名");
            }
            if (!userDepart) {
                s.push("用户部门")
            }
            alert("请输入：" + s.join('、'));
            return;
        }
        // 查询的数据进行加密显示
        alert(encodeStr(userID, userDepart))

    })
    // 新增按钮的点击事件
    $(add).click(function () {
        // 弹出弹窗显示新增的form表单
        openwindow('/task/task02.html', '用户信息', 800, 250)


    })
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
    // 对参数编码
    function encodeStr(val, val2) {
        return "&yhxx=" + encodeURIComponent(encodeURIComponent(trim(val))) +
            "&yhbm=" + encodeURIComponent(encodeURIComponent(trim(val2)));
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


})