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
            <s:if test="not #request['struts.request_uri'].endsWith('post-edit')">
	      	    <li>
	    	    <a class="btn btn-link" href="<s:url value='/post-edit'/>">
	    	        <span class="icon-edit icon-white"></span>
	    	        <span class="height-24">写博客</span>
	    	    </a>
	    	    </li>
    	    </s:if>
      		<li>
	          <a href="#" class="btn btn-link">
	            <img  src="<s:url value='/resources/img/u-mini.png'/>">
	            <s:property value="#loginUser.userName"/>
	          </a>
	        </li>
	        <!--li class="divider-vertical"></li>
	        <li>
	        	<a href="<s:url value='/account/logout'/>" id="logout" class="btn btn-link">退出</a>
	        	<script type="text/javascript">
	        		$("#logout").click(function(){
	        			location = this.href+"?param.url="+location
	        			return false;
	        		});
	        	</script>
	        </li-->
      	</s:if>
      	<s:else>
	        <li>
	          <a href="<s:url value='/account/sign-up'/>" class="btn btn-link color-white">注册</a>
	        </li>
	        <li class="divider-vertical"></li>
	        <li>
	          <a href="<s:url value='/account/sign-in'/>" class="btn btn-link color-black">
	            <span class="icon-lock"></span>&nbsp;登录
	          </a>
	        </li>
        </s:else>
      </ul>
    </div>
  </div>
</div>