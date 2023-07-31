<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<c:set value="20230705-003" var="version"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todolist2023</title>
<link href="${rootPath}/static/css/todolist.css?${version}" rel="stylesheet"/>
</head>
<body>
	<header>
		<h1>TO DO List 2023</h1>
	</header>
	<%@ include file="/WEB-INF/views/list.jsp" %>
	<section class = "main">
	
	
	
	
	</section>
	<footer>
		<address>CopyRight &copy; yu1128eun@kakao.com</address>
	</footer>
</body>
</html>