<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOOK-service</title>
<link href="${rootPath}/static/css/main.css" rel="stylesheet">
<link href="${rootPath}/static/css/tableList.css" rel="stylesheet">

<script>var rootPath = "${rootPath}"</script>
<script src="${rootPath}/static/js/book.js"></script>
<script src="${rootPath}/static/js/user.js"></script>
</head>
<body>
	<header class="main">
		<h1>♥ BOOK RENT ♥</h1>
		<p>BOOK RENT MANAGER 2023</p>
	</header>
	<nav class="main">
		<ul>
			<li><a href="${rootPath}/">도서정보관리</a></li>
			<li><a href="${rootPath}/">회원정보관리</a></li>
			<li><a href="${rootPath}/">도서대출</a></li>
		</ul>
		<article>
			
		
		
		
		
		
		</article>
	</nav>
</body>
</html>