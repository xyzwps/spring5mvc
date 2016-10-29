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
<title>Multipart</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"/>
</head>
<body>

<div class="container">

	<h2>测试</h2>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">使用Commons Fileupload进行文件上传</h3>
		</div>
		<div class="panel-body">
			<form method="post" action="/test/multipart/commons/fileupload" 
					enctype="multipart/form-data" target="myframe">
	            <input type="text" name="name"/>
	            <input type="file" name="file"/>
	            <input type="submit" value="上传"/>
	        </form>
	        <iframe name="myframe"></iframe>
		</div>
	</div>

</div>

	<script>

	</script>

</body>
</html>
