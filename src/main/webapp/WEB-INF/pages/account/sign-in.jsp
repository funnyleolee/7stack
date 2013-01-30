<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/pages/include/home-resource.jsp" %>
<title>登录</title>
<script type="text/javascript">
$(function(){
	var flag = false;
	$("#sign-form").submit(function(){
		flag = true;
		if($.trim($("#user-name").val()) == "" && $("#password").val() == ""){
            error("请输入用户名和密码");
        }else if($.trim($("#user-name").val()) == ""){
			error("请输入用户名");
		}else if($("#password").val() == ""){
			error("请输入密码");
		}
		return flag;
	});
	$("#user-name,#password").focus(function(){
		$("#sign-form .alert").fadeOut(3000);
	});
	function error(msg){
		$("#sign-form .alert .help-inline").html(msg);
		$("#sign-form .alert").show();
		flag = false;
	}
	<s:if test="message['msg'] != ''">
	   error("<s:property value='message["msg"]'/>");
	</s:if>
});
</script>
<style type="text/css">
.sign-box{
  width: 50%;
  margin: 50px auto 30px;
  background-color: #F9F9F9;
  border-radius: 3px;
  box-shadow: 0 1px 3px rgba(34, 25, 25, 0.5);
  -moz-box-shadow: 0 1px 3px rgba(34,25,25,0.5);
  -webkit-box-shadow: 0 1px 3px rgba(34, 25, 25, 0.5);
  padding: 45px 35px 45px;
  
}
.login-form {
  padding-right: 39px;
  border-right: 1px solid gainsboro;
}
.other-login{
  padding-left: 39px;
}
.other-login h4{
  border-bottom: 1px solid gainsboro;
}
.btn-signup{
  display: inline-block !important;
  padding-left: 36px;
  position: relative;
  text-align: center;
  text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
  width: 131px;
  font-size: 12px;
  font-weight: bold;
  height: 23px;
  line-height: 23px;
  border-radius:3px;
  display: inline-block;
}
.btn-fb-signup{
  background: linear-gradient(#6478B1, #4760A0) repeat scroll 0 0 transparent;
  border-color: #2F426F;
}

#footer{
    position: absolute;
    left: 0;
    right: 0;
    bottom: 0;
    min-width: 833px;
}
.alert{
    display: none;
}
</style>
</head>
<body>
  <div class="navbar navbar-inverse navbar-header">
  <div class="navbar-inner">
    <div class="container">
      <a class="brand" href="<s:url value='/'/>">7STACK</a>
      <ul class="nav pull-right">
        <li>
          <a href="<s:url value='/account/sign-up'/>" class="btn btn-link color-white">注册</a>
        </li>
      </ul>
    </div>
  </div>
  
</div>
  <div class="container">
    <div class="sign-box c-fix">
      <div class="login-form f-left">
        <s:form action="sign-in" namespace="/account" id="sign-form">
          <legend>登录</legend>
          <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <span class="help-inline"></span>
          </div>
          <div class="control-group">
            <div class="controls">
                <input type="text" class="span3" placeholder="Username" name="user.userName" id="user-name" value="<s:property value='user.userName'/>">
            </div>
          </div>
          <div class="control-group">
            <div class="controls">
                <input type="password" class="span3" placeholder="Password" name="user.password" id="password">
            </div>
          </div>
          <div class="control-group">
              <div class="controls">
                  <input type="submit" class="btn btn-primary pull-right" value="登录">
                  <label class="checkbox inline">
                    <input type="checkbox">记住我
                  </label>
              </div>
          </div>
        </s:form>
        <span class="help-inline pull-right">还没有帐号?<a href="<s:url value='/account/sign-up'/>">现在注册</a></span>
        <span ><a href="#" class="btn btn-link padding-zero"><span class="icon-question-sign"></span>忘记密码</a></span>
      </div>
      <div class="other-login f-left">
        <div>
          <h4 style="padding-bottom:7px;">第三方登录</h4>
          <div>
            <p>
              <button class="btn btn-small">
                <span class="icon-info-sign"></span> sign in with twitter
              </button>
            </p>
            <p>
              <button class="btn btn-small btn-info">
                <span class="icon-info-sign"></span> sign in with facebook
              </button>
            </p>
            <p>
              <button class="btn btn-small btn-danger">
                <span class="icon-info-sign"></span> sign in with linkedin
              </button>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <jsp:include page="/WEB-INF/pages/include/home-foot.jsp" />
</body>
</html>