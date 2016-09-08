<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request
            .getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basepath%>">
</head>
<body>
	<h2>首页</h2>
	<a href="helloWorld">Hello World</a>
</body>
</html>
