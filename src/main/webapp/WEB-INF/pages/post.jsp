<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/WEB-INF/pages/include/home-resource.jsp" %>
<title>Home</title>
</head>
<body>
    <jsp:include page="/WEB-INF/pages/include/home-head.jsp" />
	<div class="container-fluid stack-content">
		<div class="row-fluid">
			<!-- right -->
			<div class="span9 rht">
				<div class="doc">
					<h4>
						<span class="title"><s:property value="post.title" /></span>
					</h4>
					<div class="author">
						<strong>Alex Lee</strong>
					</div>
					<div class="content">
						<s:property value="post.content" escape="false" />
					</div>
				</div>
			</div>
			<!-- right end -->
			<!-- left -->
			<div class="span3 lft"></div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/pages/include/home-foot.jsp" />
</body>
</html>