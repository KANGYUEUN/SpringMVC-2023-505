<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form method="POST" action="/user/join">
		<div><input name="username" placeholder="USERNAME" /></div>
		<div><input name="password" placeholder="비밀번호" /></div>
		<div><input name="re_password" placeholder="비밀번호_확인" /></div>
		<div><input name="name" placeholder="사용자이름" /></div>
		<div><input name="tel" placeholder="전화번호" /></div>
		<div><input name="addr" placeholder="주소" /></div>
		<div><button>회원가입</button></div>
	</form>
</body>
</html>