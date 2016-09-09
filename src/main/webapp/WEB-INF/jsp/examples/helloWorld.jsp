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
	<h2>Hello World!</h2>
	<hr>
	<h2>Test Controller</h2>
	<a href="contex">Test1</a>
	<br>
	<a href="contex/new">Test2</a>
	<br>
	<a href="contex/2016-09-05">Test3</a>
	<br>

	<hr>
	<h2>Composed RequestMapping</h2>
	<a href="composed/get">Test1</a>
	<br>
	<a href="composed/2016-09-05">Test2</a>
	<br>
	<!-- 一个以 POST 方式提交的表单 -->
	<form action="composed/post" method="post">
		Username:<input type="text" name="username" placeholder="用户名..."><br>
		Password:<input type="password" name="password" placeholder="用户名..."><br>
		<button type="submit">Sign In</button>
	</form>
	
	
	<hr>
	<h2>URI Template Pattern</h2>
	<a href="uritpl/get/owners/Angrynut/pets/98421">Map</a>
	<a href="uritpl/regex/file/techmap_report.pdf">Regex</a>

	<hr>
	<h2>Path Pattern</h2>	
	<a href="pathpattern/findPet/Jennifer/Jennifer_1234/pets/pdog_2134">Jennifer`s Pets</a>
	<a href="pathpattern/findPet/manager/admin/pets/pdog_0001">Manager`s Pets</a>

</body>
</html>
