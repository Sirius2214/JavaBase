$(function () {


    function getForm() {
        // 获得当前表单的所有数据
        checkedPassword();
        var user = {
            userName: trim($('[name="userName"]').val()),
            userPasswd: trim($('[name="userPasswd"]').val()),
            userSex: trim($('[name="sex"]:checked').val()),
            hobby: [],
            depart: trim($('[name="depart"]:checked').val()),
            myProflie: trim($('[name="myProflie"]').val()),
        }
        // 复选框较为特殊获得数组
        var hobby = $('[name="hobby"]');
        // 将复选框被选中的数据加入到user
        for (var i = 0; i < hobby.length; i++) {
            if (hobby[i].checked == true) {
                user.hobby.push(hobby[i].value)
            }

            // user.hobby.push(hobby[key].val())
        }
        // 用于信息为空时,弹出时,文字的输出
        var userField = {
            userName: "用户姓名",
            userPasswd: '用户口令',
            userSex: '用户性别',
            hobby: '兴趣爱好',
            depart: '用户部门',
            myProflie: '自我介绍',
        }
        //用于表单提交时的,key值
        var userFieldShorthand = {
            userName: "yhxm",
            userPasswd: 'yhkl',
            userSex: 'yhxb',
            hobby: 'xqao',
            depart: 'yhbm',
            myProflie: 'zwjs',
        }
        // 数组用于存放,数据为空的属性
        var s = [];
        var userMessage = '';
        // 遍历user,对应值为空时,加入到为空的验证集合中
        for (var key in user) {
            if (user[key] == '' || key == undefined) {
                if (userField[key]) {
                    s.push(userField[key]);
                }
            } else {
                // 如果是兴趣爱好属于集合的单独处理
                if (key === 'hobby') {
                    for (var i in user.hobby) {
                        userMessage = userMessage + '&' + userFieldShorthand[key] + '=' + encodeStr(user.hobby[i]);

                    }
                    //其他单个属性的直接进行拼接
                } else {
                    userMessage = userMessage + '&' + userFieldShorthand[key] + '=' + encodeStr(user[key]);

                }
            }
        }
        // 如果校验的集合长度大于0时,进行校验出现问题的提示
        if (s.length) {
            // 弹窗提示
            alert('请检查必须填写：' + s.join("、"));
            // 自动触发表单rest的功能
            // 函数结束
            return;
        }

        // 校验通过的情况下,进行数据的返回
        return userMessage;
    }


    //校验口令和重复口令是否一致
    $('[name="userRePasswd"]').blur(function () {
        checkedPassword()
    })
    function checkedPassword(){
        if ($('[name="userPasswd"]').val() != $('[name="userRePasswd"]').val()) {
            alert("口令不一致")
        }
    }

    // 保存按钮触发的功能
    $('#save').click(function () {
        var message = getForm();
        if (message != null) {
            // 校验成功的情况下,弹出正确的结果
            alert( message)
        }
        return false;
    })
    // 关闭按钮触发.关闭当前的页面
    $('#close').click(function () {
        window.close();
    })
})