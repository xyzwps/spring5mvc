<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basepath%>">
<title>Tags</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"/>
</head>
<body>

<div class="container">

	<h2>测试</h2>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">构建 URL</h3>
		</div>
		<div class="panel-body">
			<!-- 方法 buildAndExpand 只有一个 String 类型的可变参数 -->
			<a href="${s:mvcUrl('BURIC#getAddress').arg(0, 'Beijing').arg(1, 'Shuangqiao').buildAndExpand('China')}">构建 URI</a>
			<br>
		</div>
	</div>
	

</div>

	
</body>
</html>
