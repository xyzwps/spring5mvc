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
			<a href="modelAttrArgs/save/ownerId/987/petId/123">测试方法参数级别的 @ModelAttribute</a><br>
			<a href="modelAttrArgs/edit/pet/{ownerId%3A987,petId%3A123,petName%3A%22Jerry%22}">测试方法参数级别的 @ModelAttribute 2nd</a><br>
			<!-- “%3A”表示英文冒号，“%22”表示英文双引号 -->
			<a href="modelAttrArgs/set/pet/age/1">测试方法参数级别的 @ModelAttribute 3rd</a><br>
		</div>
	</div>
	
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">@SessionAttribute 和 @RequestAttribute</h3>
		</div>
		<div class="panel-body">
			<a href="sesAndReqAttr/sesAttr">测试 @SessionAttribute（获取会话属性）</a><br>
			<a href="sesAndReqAttr/reqAttr">测试 @RequestAttribute（获取来自拦截器、过滤器等的请求属性）</a><br>
		</div>
	</div>
	
	
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">@CookieValue 和 @RequestHeader</h3>
		</div>
		<div class="panel-body">
			<a href="cookieAndHeader/jSessionId">测试 @CookieValue（获取 cookie 值）</a><br>
			<a href="cookieAndHeader/reqHeader">测试 @RequestHeader（获取请求头属性）</a><br>
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
