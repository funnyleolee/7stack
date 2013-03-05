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
	/*$("#user-name,#password").focus(function(){
		$("#sign-form .alert").fadeOut(3000);
	});*/
	function error(msg){
		$("#sign-form").find(".alert-error").remove();
		var errObj = $("<div>").addClass("alert alert-error");
		errObj.append($("<button type='button' class='close' data-dismiss='alert'>").html("&times;"));
		errObj.append($("<span class='help-inline'>").html(msg));
		$("#sign-form legend").after(errObj);
		flag = false;
	}
	<s:if test="message['msg'] != ''">
	   error("<s:property value='message["msg"]'/>");
	</s:if>
});
</script>
<style type="text/css">
.other-login .btn-link{
    padding-left: 0;
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


#footer{
    position: absolute;
    left: 0;
    right: 0;
    bottom: 0;
    min-width: 833px;
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
  <div class="block-out">
    <div class="sign-box c-fix">
      <div class="login-form f-left">
        <s:form action="sign-in" namespace="/account" id="sign-form" theme="simple">
          <legend>登录</legend>
          <div class="control-group">
            <label class="control-label" for="user-name"><span class="help-inline spl-0">用户名或邮箱</span></label>
            <div class="controls">
                <input type="text" name="user.userName" id="user-name" value="<s:property value='user.userName'/>">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="password">
                <span class="help-inline spl-0">密码 &nbsp;<a href="<s:url value='/account/forget'/>"><span class="icon-question-sign"></span>忘记密码</a></span>
            </label>
            <div class="controls">
                
                <input type="password" name="user.password" id="password">
            </div>
          </div>
          <div class="control-group">
              <div class="controls">
                  <input type="submit" class="btn btn-primary pull-right mrt-17" value="登录">
                  <label class="checkbox">
                    <input type="checkbox">记住我
                  </label>
              </div>
          </div>
        </s:form>
      </div>
      <div class="other-login f-left">
        <div>
          <legend style="margin-bottom: 23px;width: 200px;">使用其他帐号登录</legend>
          <p class="hidden-block">使用其他帐号登录</p>
          <p>
            <a class="btn btn-link" href="#"><span class="social-signin social-twitter"></span></a>
          </p>
          <p>
              <a class="btn btn-link" href="#"><span class="social-signin social-facebook"></span></a>
          </p>
          <p>
            <a class="btn btn-link" href="#"><span class="social-signin social-linkedin"></span></a>
          </p>
      </div>
    </div>
    <div class="sign-bottom" style="clear: both;">
        <span>还没有帐号?<a href="<s:url value='/account/sign-up'/>">现在注册</a></span>
        <!--span ><a href="#" class="btn btn-link padding-zero"><span class="icon-question-sign"></span>忘记密码</a></span-->
    </div>
  </div>
 </div>
  
  <%-- jsp:include page="/WEB-INF/pages/include/home-foot.jsp" /--%>
</body>
</html>