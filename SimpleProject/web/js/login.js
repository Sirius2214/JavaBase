$(function () {
    //从Cookies获取账号ID和密码
    getMessage();
    $(login).click(function () {
        var savePassword = trim($('[name="savePassword"]:checked').val());
        var saveAccount = trim($('[name="saveAccount"]:checked').val());
        console.log();
        var user = {
            userName: trim($('[name="userName"]').val()),
            userPassword: trim($('[name="userPassword"]').val()),

        }
        var userFiled = {
            userName: '用户名',
            userPassword: '口令'
        }
        var s = []
        for (var i in user) {
            if (user[i] == '') {
                s.push(userFiled[i])
            }
        }
        if (s.length) {
            alert('请输入：' + s.join('、'));
            return;
        } else {
            user.saveAccount = saveAccount;
            user.savePassword = savePassword;
            var result = getAjax("/login", "POST", user)
            console.log(result)
            if (result.code == 100) {
                alert(result.resultMessage)
            } else {
                window.location.replace("http://localhost:8080/tableInfo.jsp");

            }
            return false;

        }


    })

    function getMessage() {
        var userName = getCookie("userName")
        var userPassword = getCookie("userPassword");
        $('[name="userName"]').val(userName);
        $('[name="userPassword"]').val(userPassword);
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
})