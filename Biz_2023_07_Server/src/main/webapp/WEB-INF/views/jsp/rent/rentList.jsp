<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />
<h1>LENT LIST</h1>
<table class="userList">
	<tr>
		<th>회원코드</th>
		<th>회원명</th>
		<th>전화번호</th>
		<th>주소</th>
	</tr>
	<c:forEach items="${LENTS}" var="LENT">
		<tr>
			<td class="${USER.u_code}">${USER.u_code}</td>
			<td class="${USER.u_code}">${USER.u_name}</td>
			<td class="${USER.u_code}">${USER.u_tel}</td>
			<td class="${USER.u_code}">${USER.u_addr}</td>
		</tr>
	</c:forEach>
</table>