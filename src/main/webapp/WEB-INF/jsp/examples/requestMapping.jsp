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
<jsp:include page="/WEB-INF/jsp/common/include.jsp"/>
</head>
<body>

<div class="container">

	<h2>测试</h2>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">@RequestParam 和 @RequestBody</h3>
		</div>
		<div class="panel-body">
			<a href="paramAndBody/find/pet?petId=123&ownerId=986">测试 @RequestParam</a>
			<br>
			<a href="paramAndBody/find/pet/map?petId=123&ownerId=986">测试 @RequestParam（参数参数放进 Map 中）</a>
			<br>
			<button class="btn btn-success" onclick="requestBody()">测试 @RequestBody</button>
		</div>
	</div>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">@ResponseBody 和 @RestController</h3>
		</div>
		<div class="panel-body">
			<button class="btn btn-success" onclick="respBody('find/pet')">测试 @ResponseBody</button>
			<button class="btn btn-success" onclick="respBody('find/pet/byId')">测试 @ResponseBody 2</button>
			<button class="btn btn-success" onclick="theRest()">测试 @RestController</button>
		</div>
	</div>
	
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">HttpEntity</h3>
		</div>
		<div class="panel-body">
			<button class="btn btn-success" onclick="httpEntity()">测试 HttpEntity</button>
		</div>
	</div>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">@ModelAttribute</h3>
		</div>
		<div class="panel-body">
			<a href="modelAttr/findPet/owner/987?petId=123&sth=HelloWorld">测试方法级别的 @ModelAttribute</a><br>
		</div>
	</div>

	

</div>

	<script>
		function requestBody() {
			$.ajax({  
				url : 'paramAndBody/handle',// 跳转到 handler  
				data : JSON.stringify({ petId : 123, ownerId : 987 }),  
				type : 'put',  
				cache : false,
				dataType : 'text',  
				success : function(data) { alert(data); },  
				error : function(data) {  } 
			});
		};
		
		function respBody(url) {
			$.ajax({  
				url : 'respBody/' + url,// 跳转到 handler  
				data : { petId : 123, ownerId : 987 },  
				type : 'get',
				dataType : 'text',  
				success : function(data) { alert(data); },  
				error : function(data) {  } 
			});
		};
		
		function theRest() {
			$.ajax({  
				url : 'theRest/find/pet/byId',// 跳转到 handler  
				data : { petId : 123, ownerId : 987 },  
				type : 'get',
				dataType : 'text',  
				success : function(data) { alert(data); },  
				error : function(data) {  } 
			});
		};
		
		function httpEntity() {
			var url = 'httpEntity/something';
			var data = { petId : 123, ownerId : 987 };
			var callback = function(data) { alert(data); };
			$.post(url, data, callback, 'text');
		};
	</script>

</body>
</html>
