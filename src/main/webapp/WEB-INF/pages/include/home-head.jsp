<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="navbar navbar-inverse navbar-header">
  <div class="navbar-inner">
    <div class="container">
      <a class="brand" href="<s:url value='/'/>">7STACK</a>
      <ul class="nav pull-right">
        <li>
          <a href="/account/signUp" class="btn btn-link color-white">注册</a>
        </li>
        <li class="divider-vertical"></li>
        <li>
          <a href="<s:url value='/account/signIn'/>" class="btn btn-link color-black">
            <span class="icon-lock"></span>&nbsp;登录
          </a>
        </li>
      </ul>
    </div>
  </div>
</div>