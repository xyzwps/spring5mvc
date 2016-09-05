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
	<h2>Hello World!</h2>
	<h2>Test Controller</h2>
	<a href="contex">Test1</a><br>
	<a href="contex/new">Test2</a><br>
	<a href="contex/2016-09-05">Test3</a><br>
</body>
</html>
