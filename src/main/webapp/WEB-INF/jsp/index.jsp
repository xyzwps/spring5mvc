<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>H.W.</title>
</head>
<body>
	<h2>Hello World!</h2>
	
	
	
	<hr>
	<form method="post" action="/upload" enctype="multipart/form-data">
        <input type="text" name="name"/>
        <input type="file" name="file"/>
        <input type="submit"/>
    </form>

	
</body>
</html>
