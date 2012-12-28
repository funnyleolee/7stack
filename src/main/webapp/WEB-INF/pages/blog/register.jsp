<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link type="text/css" rel="stylesheet" href="<s:url value='/resources/css/basic.css'/>"/>
<title>7Stack-REGISTER</title>
<style type="text/css">

form label{
	width: 7em;
	text-align: right;
	padding-right: 5px;
	display: inline-block;
}
.form-ul li{
	list-style: none;
	vertical-align: middle;
	margin: 10px;
}
.form-ul .bottom-bar{
	margin-left: 7em;
	padding-left: 6px;
}
</style>
</head>
<body>
	<s:form id="register-form" action="/register" name="user" namespace="/sdfs" method="post" theme="simple">
		<ul class="form-ul">
			<li>
				<s:label for="user-name" value="用户名"/> 
				<s:textfield name="user.name" id="user-name" />
			<li>
				<s:label for="user-password" value="密码"/> 
				<s:password name="user.password" id="user-password" />
			</li>
			<li>
				<s:label for="user-repassword" value="再次输入密码"/>
			</li>
			<li>
				<s:label for="user-email" value="邮箱"/> 
				<s:textfield name="user.email" id="user-email" />
			</li>
			<li>
				<s:label for="user-mobile" value="手机号"/> 
				<s:textfield name="user.mobile" id="user-mobile" />
			</li>
			<li>
				<s:label for="user-telephone" value="电话号码"/> 
				<s:textfield name="user.telephone" id="user-telephone" />
			</li>
			<li>
				<s:label for="user-sns" value="MSN"/> 
				<s:textfield name="user.sns" id="user-sns" />
			</li>
			<li>
				<s:label for="user-address" value="地址"/> 
				<s:textarea name="user.address" id="user-address"></s:textarea>
			</li>
			<li>
				<div class="bottom-bar">
					<s:submit value="保存"/>
					&nbsp;
					<s:reset value="重置"/>
				</div>
				
			</li>
		</ul>
	</s:form>
</body>
</html>