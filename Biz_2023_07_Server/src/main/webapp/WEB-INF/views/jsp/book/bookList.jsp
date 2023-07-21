<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />

<h1>BOOK_LIST</h1>
<table class="bookList">
	<tr>
		<th>도서코드</th>
		<th>도서명</th>
		<th>저자</th>
		<th>출판사</th>
		<th>구입연도</th>
		<th>구입가격</th>
		<th>대여가격</th>
	</tr>
	<c:forEach items="${BOOKS}" var="BOOK">
		<tr>
			<td class="${BOOK.b_code}">${BOOK.b_code}</td>
			<td class="${BOOK.b_code}">${BOOK.b_name}</td>
			<td class="${BOOK.b_code}">${BOOK.b_auther}</td>
			<td class="${BOOK.b_code}">${BOOK.b_comp}</td>
			<td class="${BOOK.b_code}">${BOOK.b_year}</td>
			<td class="${BOOK.b_code}">${BOOK.b_iprice}</td>
			<td class="${BOOK.b_code}">${BOOK.b_rprice}</td>
		</tr>
	</c:forEach>
</table>

