<%@page import="org.springframework.web.servlet.support.ServletUriComponentsBuilder"%>
<%@page import="org.springframework.web.util.UriComponentsBuilder"%>
<%@page import="com.techmap.utils.reqresp.ReqUtils"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.techmap.examples.controllers.BuildURIController"%>
<%@page import="org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder"%>
<%@page import="org.springframework.web.util.UriComponents"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%
    String basepath = request.getScheme() + "://" + ReqUtils.getHost(request)
					+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basepath%>">
<title>Build URIs</title>
<jsp:include page="/WEB-INF/jsp/common/include.jsp"/>
</head>
<body>

<div class="container">

	<h2>测试</h2>

	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">构建 URL</h3>
		</div>
		<div class="panel-body">
		
			<%
				UriComponents uc = UriComponentsBuilder.newInstance()
				        .scheme(request.getScheme()).host(ReqUtils.getHost(request))
				        .path(request.getContextPath() +  "/buildUri/country/{country}/city/{city}/street/{street}").build()
				        .expand("Japan", "Tokyo", "Ginza")
				        .encode();
			%>
			<a href="<%= uc.encode().toUriString()%>">通过 UriComponentsBuilder 构建 URI</a><br>
			
			<%
				UriComponents suc = ServletUriComponentsBuilder.fromContextPath(request)
				        .path("/buildUri/country/{country}/city/{city}/street/{street}").build()
				        .expand("China", "Beijing", "Jianguo")
				        .encode();
			%>
			<a href="<%= suc.encode().toUriString()%>">通过 ServletUriComponentsBuilder 构建 URI</a><br>
		
			<%
				UriComponents mvcuc = MvcUriComponentsBuilder
						.fromMethodName(BuildURIController.class, "getAddress", "New York", "Broadway", null)
						.buildAndExpand("America");
			%>
			<a href="<%= mvcuc.encode().toUriString()%>">通过 MvcUriComponentsBuilder 构建 URI</a><br>
			
			<%-- 
				方法 buildAndExpand 只有一个 String 类型的可变参数。下面的代码  ${s:mvcUrl... } 相当于:
				MvcUriComponentsBuilder.fromMappingName...
				--%>
			<a href="${s:mvcUrl('BURIC#getAddress').arg(0, 'Beijing').arg(1, 'Shuangqiao').buildAndExpand('China')}">通过Spring标签构建 URI</a>
			<br>
		</div>
	</div>
	

</div>

	
</body>
</html>
