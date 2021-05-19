$(function () {
    //获取账户ID
    var account = getUrlParam("account")
    // alert(account)
    //获取当前执行的模式
    var model = getUrlParam("model")
    // alert(model)
    //更新部门树的下拉框
    pushDepartSelect()
    //根据用户ID查询数据，并填充form表单
    setFormData(account)
    //当为查询功能时，将便签的编辑功能禁用
    if(model=="message"){
        $('[name="userId"]').attr('disabled', 'disabled')
        $('[name="userName"]').attr('disabled', 'disabled')
        $('[name="userPassword"]').attr('disabled', 'disabled')
        $('[name="userRePassword"]').attr('disabled', 'disabled')
        $('[name="sex"]').attr('disabled', 'disabled')
        $('[name="depart"]').attr('disabled', 'disabled')
        $('[name="birthday"]').attr('disabled', 'disabled')
        $('[name="sort"]').attr('disabled', 'disabled')
        $('[name="isDisable"]').attr('disabled', 'disabled')
        $('#save').hide();
    }
    //当为新增功能时，用户ID实现不可编辑
    else if(model!="add"){
        $('[name="userId"]').attr('disabled', 'disabled')
    }
    //校验口令和重复口令是否一致
    $('[name="userRePassword"]').blur(function () {
        if ($('[name="userPassword"]').val() != $('[name="userRePassword"]').val()) {
            alert("口令不一致")
        }

    })
    // 保存按钮触发的功能
    $('#save').click(function () {
        var form = getForm();
        form.model = model;
        // console.log("form")
        // console.log(form)
        // alert(form)
        //当为新增功能时，校验用户ID是否与管理员ID冲突
        if(model=="add"){
            if(form.userId=="admin"){
                alert("用户名不能为admin")
                return;
            }
        }
        // alert(form)
        // 进行请求，实现新增和更新操作
        $.ajax({
            url: '/updateUser',
            type: 'POST',
            data: form,
            async:false, // 异步请求
            cache:false, // 设置为 false 将不缓存此页面
            dataType: 'json', // 返回对象
            success: function(data) {
                alert("=====")
                console.log(data)
                if(!data){
                    alert("=====")
                    pushParentTable(getAjax('/tableInfo', 'Post', null))

                }
            },

        })
        // getAjax('/updateUser','POST',form);


        return false;
    })
    // 关闭按钮触发.关闭当前的页面
    $('#close').click(function () {
        window.close();
    })


})
//根据关键字，从url获取参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
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
//获取表单的所有数据
function getForm() {
    // 获得当前表单的所有数据
    var user = {
        userId: trim($('[name="userId"]').val()),
        userName: trim($('[name="userName"]').val()),
        userPassword: trim($('[name="userPassword"]').val()),
        userRePassword: trim($('[name="userRePassword"]').val()),
        sex: trim($('[name="sex"]:checked').val()),
        depart: trim($('[name="depart"]:checked').val()),
        birthday: trim($('[name="birthday"]').val()),
        sort: trim($('[name="sort"]').val()),
        isDisable: $('[name="isDisable"]:checked').val(),

    }
    // 用于信息为空时,弹出时,文字的输出
    var userField = {
        userId: '用户ID',
        userName: "姓名",
        userPassword: '口令',
        userRePassword: '确认口令',
    }
    var s = [];
    var userMessage = '';
    // 遍历user,对应值为空时,加入到为空的验证集合中
    for (var key in user) {
        if (user[key] == '' || key == undefined) {
            if (userField[key]) {
                s.push(userField[key]);
            }
        } else {

            userMessage = userMessage + '&' + key + '=' + encodeStr(user[key]);
        }
    }
    // console.log(s)
    // 如果校验的集合长度大于0时,进行校验出现问题的提示
    if (s.length) {
        // 弹窗提示
        alert('请检查必须填写：' + s.join("、"));
        // 自动触发表单rest的功能
        $(reset).click();
        // 函数结束
        return;
    }

    // 校验通过的情况下,进行数据的返回
    return user;
}
//填充表单数据
function setFormData(account) {
    var data = {
        account:account
    }
    //根据ID获取当前用户信息
    var info = getAjax('/getUserInfo', 'POST', data);
    console.log(info)
    //进行数据的填充
    if (info) {
        $('[name="userId"]').val(info.account)
        $('[name="userName"]').val(info.userName)
        $('[name="userPassword"]').val(info.userPassword)
        $('[name="userRePassword"]').val(info.userPassword)
        $('[name="birthday"]').val(info.birthday)
        $('[name="sort"]').val(info.sort)
        $('[name="isDisable"]').attr('checked', (info.isDisable == 1) ? true : false);
        setSelect($('[name="sex"]'), info)
        setSelect($('[name="depart"]'), info)

    }
}
function pushParentTable(data) {
    // var data = getAjax('/tableInfo', 'Post', null)
    //由获取的数据,进行便签的拼接,返回拼接后的结果
    var tableInfo = getTableInfo(data);
    //清空该标签下的所有数据
    $('[id="message"]',window.opener.document).empty();
    for (var i in tableInfo){
        //进行标签的插入
        $('[id="message"]',window.opener.document).append(tableInfo[i]);
    }
}
//对下拉框进行填充选择
function setSelect(data, info) {
    for (var i = 0; i < data.length; i++) {
        if (data[i].value == info.sex || data[i].value === info.department) {
            data[i].selected = 'true'
        }
    }
}
//字符进行编码
function encodeStr(val) {
    return encodeURIComponent((trim(val)));
}