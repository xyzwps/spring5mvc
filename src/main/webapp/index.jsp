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
	<a href="helloWorld/jump/requestMapping">Request Mapping</a>
	<a href="helloWorld/jump/asyncRequest">Asynchronous Request Processing</a>
	<a href="helloWorld/jump/interceptors">Interceptors</a>
	<a href="helloWorld/jump/view">Views</a>
	<a href="helloWorld/jump/builduri">Build URIs</a>
	<a href="helloWorld/jump/multipart">Multipart File Upload</a>
</body>
</html>
