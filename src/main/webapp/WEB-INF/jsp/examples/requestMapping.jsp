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
<title>Controller</title>
<script src="frameworks/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>

	<a href="paramAndBody/find/pet?petId=123&ownerId=986">测试@RequestParam</a>
	<a href="paramAndBody/find/pet/map?petId=123&ownerId=986">测试@RequestParam（参数参数放进 Map 中）</a>

	<button onclick="requestBody()">测试@RequestBody</button>


	<script>
		function requestBody() {
			$.ajax({  
				url : 'paramAndBody/handle',// 跳转到 action  
				data : JSON.stringify({ petId : 123, ownerId : 987 }),  
				type : 'put',  
				cache : false,
				dataType : 'text',  
				success : function(data) {
					alert(data);
				},  
				error : function(data) {  } 
			});
		};
	</script>

</body>
</html>
