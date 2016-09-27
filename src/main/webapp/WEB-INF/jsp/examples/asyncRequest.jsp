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
<title>Asynchronous Request Processing</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"/>
</head>
<body>

<div class="container">

	<h2>异步请求处理</h2>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Callable&lt;T&gt; 和 DeferredResult&lt;T&gt;</h3>
		</div>
		
		<!-- 上传文件 -->
		<div class="panel-body">
			<form role="form" action="async/fileupload/callable" method="post" enctype='multipart/form-data'>
				<div class="form-group">
					<label for="name">名称：</label>
					<input type="text" name="name">
				</div>
				<div class="form-group">
					<label for="inputfile">文件上传：</label>
					<input type="file" name="file">
					<p class="help-block">帮助：点击按钮选择上传文件</p>
				</div>
				<button type="submit" class="btn btn-default">提交【测试 Callable】</button>
			</form>
		</div>
	</div>

</div>

	<script>
	</script>

</body>
</html>
