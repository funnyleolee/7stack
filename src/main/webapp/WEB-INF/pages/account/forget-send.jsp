<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/pages/include/home-resource.jsp" %>
<title>找回密码</title>
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
            <form action="">
                <legend>找回密码</legend>
                <p><span class="help-inline"><i class="icon-info-sign"></i> 密码重置链接已发送</span></p>
                <div class="forget-content">请登录 <strong><s:property value="email"/></strong> 查收邮件（没有收到邮件？<a class="btn-link">点此</a>再次发送）
                </div>
                <p> 
                    <a class="btn btn-link" href="<s:url value='/'/>"><i class="icon-home"></i> 回首页</a>
                    <a class="btn btn-link" href="<s:url value='/account/sign-in'/>">登录</a>
                </p>
            </form>
        </div>
    </div>
    
</body>
</html>