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
<title>RequestMapping</title>
<script src="frameworks/jquery/2.1.3/jquery.min.js"></script>
<style type="text/css">
.block{ width: 400px; height: 160px; float: left; }
.container { width: 800px; margin-left: auto; margin-right: auto; }
</style>
</head>
<body>
	
	
<div class="container">

	<div class="block" style="height: 50px; width: 800px;"><h2>Hello World!</h2></div>
	
	<div class="block">
		<hr>
		<h2>Test Controller</h2>
		<a href="contex">Test1</a> <br>
		<a href="contex/new">Test2</a> <br>
		<a href="contex/2016-09-05">Test3</a>
	</div>

	<div class="block">
		<hr>
		<h2>Composed RequestMapping</h2>
		<a href="composed/get">Test1</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="composed/2016-09-05">Test2</a> <br>
		<!-- 一个以 POST 方式提交的表单 -->
		<form action="composed/post" method="post">
			Username:<input type="text" name="username" placeholder="用户名..."><br>
			Password:<input type="password" name="password" placeholder="用户名..."> &nbsp;&nbsp;&nbsp;&nbsp;
			<button type="submit">Sign In</button>
		</form>
		
		</div>
	
	<div class="block">
		<hr>
		<h2>URI Template Pattern</h2>
		<a href="uritpl/get/owners/Angrynut/pets/98421">Map</a><br>
		<a href="uritpl/regex/file/techmap_report.pdf">Regex</a>
	</div>

	<div class="block">
		<hr>
		<h2>Path Pattern</h2>	
		<a href="pathpattern/findPet/Jennifer/Jennifer_1234/pets/pdog_2134">Jennifer`s Pets</a><br>
		<a href="pathpattern/findPet/manager/admin/pets/pdog_0001">Manager`s Pets</a>
	</div>
	
	<div class="block">
		<hr>
		<h2>Matrix Variables</h2>	
		<a href="matrix/owners/42;q=11/pets/21;q=22">Matrix</a><br>
		<a href="matrix/pets/21">Default Value</a>
	</div>


</div>

</body>
</html>
