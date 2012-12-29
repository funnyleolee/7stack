<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE>
<html language="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>7Stack-HOME</title>
<link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/basic.css'/>"/>
<link rel="stylesheet" type="text/css" href="<s:url value='/resources/css/doc.css'/>"/>
<link rel="stylesheet" type="text/css" href="<s:url value='/bootstrap/css/bootstrap.css'/>"/>
<link rel="stylesheet" type="text/css" href="<s:url value='/bootstrap/css/bootstrap-responsive.css'/>"/>
<script type="text/javascript" src="<s:url value='/resources/js/jquery-latest.js'/>"></script>
<script type="text/javascript" src="<s:url value='/bootstrap/js/bootstrap.js'/>"></script>
<style type="text/css">
	body{
		margin: 33px auto 10px;
	}
</style>
</head>
<body>
	<div class="row show-grid">
		<div class="span1">...</div>
		<div class="span2">....</div>
		<div class="span3">...</div>
		<div class="span4">...</div>
	</div>
	<div class="row show-grid">
		<div class="span3">...</div>
		<div class="span2">....</div>
		<div class="span4">...</div>
		<div class="span1">...</div>
	</div>
	<div class="row show-grid">
		<div class="span4">...</div>
		<div class="span6">...</div>
	</div>
	<div class="row show-grid">
		<div class="span4">...</div>
		<div class="span6 offset3">...</div>
	</div>
	<div class="row show-grid">
		<div class="span7">...
			<div class="row">
				<div class="span2">...</div>
				<div class="span5">...</div>
			</div>
		</div>
		<div class="span3">...</div>
	</div>

	<div class="container">
		个人认为Bootstrap比其他框架要好的原因之一是他有许多优秀的组件，可以帮助开发者快速开发一个网站（快到可以只导入Bootstrap的CSS代码，直接使用里面的属性，就可以实现一个简洁又灵活的网站）。而且还有许许多多第三方插件和样式的支持。同样的，Bootstrap也包含了响应式的功能。
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">...</div>
			<div class="span7">...</div>
		</div>
	</div>
	
</body>
</html>