<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<form class="main" method="POST" action="${rootPath}/userinput">
	<div class="userinput">
		<input name="u_code" placeholder="회원코드" value="${USER.u_code}" />
		<div class="error u_code"></div>
	</div>
	<div class="userinput">
		<input name="u_name" placeholder="회원명" value="${USER.u_name}" />
		<div class="error u_name"></div>
	</div>
	<div class="userinput">
		<input name="u_tel" placeholder="전화번호" value="${USER.u_tel}" />
		<div class="error u_tel"></div>
	</div>
	<div class="userinput">
		<input name="u_addr" placeholder="주소" value="${USER.u_addr}" />
		<div class="error u_addr"></div>
	</div>
</form>