$(function(){
	//获取表单元素
	var username=$('input[name="username"]'),
		age=$('input[name="age"]'),
		worktext=$('input[name="worktext"]'),
		address=$('input[name="address"]'),
		phone=$('input[name="phone"]'),
		mail=$('input[name="mail"]');
	
	
	$('input[name="workbox"]').change(function(){
		if($('input[name="workbox"]').is(':checked')){
			worktext.attr('disabled','disabled')
		}else{
			worktext.removeAttr('disabled');
		}
	});
	
	phone.blur(function(){
		if(phone.val()!='' && !isPhoneNo(phone.val())){
			phone.val('').focus();
			alert('请检查联系方式是否正确！');
			phone.val('').focus();
		}
	});
	mail.blur(function(){
		if(mail.val()!='' && !isMail(mail.val())){
			alert('请检查电子邮箱是否正确！');
			mail.val('').focus();
		}
	});
	//确定按钮点击触发事件
	$('#btn1').bind('click',function(){
		//获取表单元素的值
		var usernameVal=trim(username.val()),
			sexVal='',
			ageVal=age.val(),
			workVal='',
			addressVal=address.val(),
			phoneVal=phone.val(),
			mailVal=mail.val();
		//获取radio选中的值
		sexVal=$('input[name="sex"]:checked').val();
		//获取工作经验
		var worktextVal=worktext.val(),
			workboxVal=$('input[name="workbox"]:checked').val();
		if(workboxVal){
			workVal=workboxVal;
		}else{
			workVal=worktextVal;
		}
		//非空验证
		var msg=[],params='';
		if(!usernameVal){
			msg.push('姓名');
		}
		if(!sexVal){
			msg.push('性别');
		}
		if(!ageVal){
			msg.push('年龄');
		}
		if(!workVal){
			msg.push('工作经验');
		}
		if(!addressVal){
			msg.push('现居地');
		}
		if(!phoneVal){
			msg.push('联系方式');
		}
		if(!mailVal){
			msg.push('电子邮箱');
		}
		if(msg.length){
			alert('请检查必填项：'+msg.join(','));
		}else{
			params += 'username='+usernameVal;
			params += '&sex='+sexVal;
			params += '&age='+ageVal;
			params += '&work='+workVal;
			params += '&address='+addressVal;
			params += '&phone='+phoneVal;
			params += '&mail='+mailVal;
			alert(params)
			alert(encodeStr(params));
		}
	});
	//重置按钮点击触发事件
	$('#btn2').bind('click',function(){
		worktext.removeAttr('disabled');
	});
});

// 验证手机号
function isPhoneNo(phone) {
	var regMobile = /^1[34578]\d{9}$/; //手机号正则
	return regMobile.test(phone);
}
// 验证邮箱
function isMail(mail) {
	var regMail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/; //邮箱正则
	return regMail.test(mail);
}
//只能输入数字含点
function onlyNum(athis) {
	athis.value = athis.value.replace(/[^\-?\d.]/g, '');
}
//只能输入数字没有点
function onlyNumber(athis) {
	athis.value = athis.value.replace(/[^\-?\d]/g, '');
}
//去掉空格
function trim(value) {
    if (value)
        value = value.replace(/^\s*|\s*$/g, "");
    if (!value)
        return "";
    else
        return value;
}
// 对参数编码
function encodeStr(val) {
    return encodeURIComponent(encodeURIComponent(trim(val)));
}
