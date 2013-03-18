<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/pages/include/home-resource.jsp" %>
<title>密码忘记</title>
<style type="text/css">

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
        <div class="forget-box sign-box cfix">
            <form action="forget-send" method="post">
                <legend>找回密码</legend>
                <p><span class="help-inline"><i class="icon-info-sign"></i> 请输入您在注册时使用的邮箱，我会把密码重置链接发送到您的邮箱，谢谢！</span></p>
                <div class="forget-content">
                    <div class="control-group">
                        <label class="control-label" for="email-send"><span class="help-inline spl-0">邮箱</span></label>
                      </div>
                      <div class="control-group">
                           <div class="controls">
                                <input type="text" name="email" id="email-send" value="<s:property value='email'/>">
                            </div>
                      </div>
                      <div class="control-group">
                          <button class="btn btn-success">发送验证电子邮件</button>
                      </div>
                </div>
                <p>
                    <a class="btn btn-link" href="<s:url value='/account/sign-in'/>">返回登录页面</a>
                </p>
            </form>
        </div>
    </div>
    
</body>
</html>