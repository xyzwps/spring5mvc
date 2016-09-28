<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basepath%>">
<title>Interceptors</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"/>
</head>
<body>

<div class="container">

	<h2>拦截器</h2>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Callable&lt;T&gt; 和 DeferredResult&lt;T&gt;</h3>
		</div>
		<div class="panel-body">
			<a href="test/interceptor">测试拦截器</a>
			<br>
		</div>
	</div>

</div>

	<script>
	</script>

</body>
</html>
