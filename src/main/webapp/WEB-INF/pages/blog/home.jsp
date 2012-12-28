<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>7Stack-HOME</title>
</head>
<body>
	<s:url value="SFSSF" ></s:url>
	<a href="<s:url value='/sdf'/>" >fs</a>
	<ul>
		<s:iterator value="userList">
			<li><s:property /></li>
		</s:iterator>
	</ul>
</body>
</html>