<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<s:set name="loginUser" value="#session['session-me.sevenstack.web.model.user']" />
<div class="navbar navbar-inverse navbar-header">
  <div class="navbar-inner">
    <div class="container">
      <a class="brand btn btn-link" href="<s:url value='/'/>">7STACK</a>
      <ul class="nav pull-right">
      	<s:if test="#loginUser != null">
      		<li><a href="#"><img  src="<s:url value='/resources/img/u-mini.png'/>"></a></li>
      		<li>
	          <a href="#" style="padding: 10px 0px">
	            <s:property value="#loginUser.userName"/>
	          </a>
	        </li>
	        <li class="divider-vertical"></li>
	        <li>
	        	<a href="<s:url value='/account/logout'/>" id="logout">退出</a>
	        	<script type="text/javascript">
	        		$("#logout").click(function(){
	        			location = this.href+"?param.url="+location
	        			return false;
	        		});
	        	</script>
	        </li>
      	</s:if>
      	<s:else>
	        <li>
	          <a href="/account/signUp" class="btn btn-link color-white">注册</a>
	        </li>
	        <li class="divider-vertical"></li>
	        <li>
	          <a href="<s:url value='/account/signIn'/>" class="btn btn-link color-black">
	            <span class="icon-lock"></span>&nbsp;登录
	          </a>
	        </li>
        </s:else>
      </ul>
    </div>
  </div>
</div>