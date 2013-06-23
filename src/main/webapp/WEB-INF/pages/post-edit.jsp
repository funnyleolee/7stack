<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String contextPath = request.getContextPath();
request.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/post.base.css'/>">
<link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/bootstrap-wysihtml5.css'/>">

<%@include file="/WEB-INF/pages/include/home-resource.jsp" %>
<script type="text/javascript" src="<s:url value='/resources/js/wysihtml5-0.3.0.min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/resources/js/bootstrap-wysihtml5-0.0.2.min.js'/>"></script>
<!--script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/ckeditor/4.0.1/ckeditor.js"></script-->
<script type="text/javascript">
$(function(){
	$('#context').wysihtml5();
});
</script>
<title>编辑博客</title>
</head>
<body>
	<div class="main-container">
	    <jsp:include page="/WEB-INF/pages/include/home-head.jsp" />
	    <div class="container stack-content">
	        <div class="doc span8">
	            <s:form action="post-edit" method="post">
	                <input type="hidden" name="post.postId" value="<s:property value='post.postId'/>">
	                <legend>写博客</legend>
	                <div class="control-group">
	                    <label class="control-label" id="title">标题</label>
	                    <div class="controls">
	                        <input type="text" class="input-xlarge" id="title" name="post.title" value="<s:property value='post.title'/>">
	                    </div>
	                </div>
	                <div class="control-group">
	                    <label class="control-label" for="content">正文</label>
	                    <div class="controls">
	                        <textarea id="context" name="post.content"><s:property value="post.content"/></textarea>
	                        <script type="text/javascript">//<![CDATA[
	                            //CKEDITOR.replace('context');
	                        //]]>
	                        </script>
	                    </div>
	                </div>
	                <div class="control-group">
	                    <div class="controls">
	                        <input type="submit" class="btn btn-primary pull-right" value="发表">
	                    </div>
	                </div>
	            </s:form>
	        </div>
	    </div>
	    <jsp:include page="/WEB-INF/pages/include/home-foot.jsp" />
    </div>
</body>
</html>