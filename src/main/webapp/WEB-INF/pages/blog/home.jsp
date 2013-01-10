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
	<jsp:include page="home-main.jsp" />
	<jsp:include page="/WEB-INF/pages/include/home-foot.jsp" />
</body>
</html>