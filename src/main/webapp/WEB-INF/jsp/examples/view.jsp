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
<title>Views</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"/>
</head>
<body>

<div class="container">

	<h2>测试</h2>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">XlsView</h3>
		</div>
		<div class="panel-body">
			<a href="excel/view/xls">Xls 视图</a>
			<br>
		</div>
	</div>
	
	
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">重定向</h3>
		</div>
		<div class="panel-body">
			<a href="redict/get/owner/987">重定向前缀 —— redirect:</a>
			<a href="redict/get/pet/Tom">重定向视图 —— RedirectView</a>
			<hr>
			<a href="redict/target">重定向目标</a>
			<br>
		</div>
	</div>
	
	

</div>

	
</body>
</html>
