<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}"  var="rootPath" />

<form method="POST" class="book">
<h1>BOOK DETAIL</h1>
	<div class="book errorMSG"></div>
	<div><label>도서코드</label><input placeholder="* 도서코드" name="b_code" value = "${BOOK.b_code}" readonly></div>
	<div><label>도서명</label><input placeholder="* 도서명" name="b_name"  value = "${BOOK.b_name}" class="bookDetail"></div>
	<div><label>저자</label><input placeholder="* 저자" name="b_auther" value = "${BOOK.b_auther}" ></div>
	<div><label>출판사</label><input placeholder="출판사" name="b_comp" value = "${BOOK.b_comp}" ></div>
	<div><label>구입연도</label><input placeholder="* 구입연도" name="b_year" value = "${BOOK.b_year}"  type="number"></div>
	<div><label>구입가격</label><input placeholder="구입가격" name="b_iprice" value = "${BOOK.b_iprice}"  type="number"></div>
	<div><label>대여가격</label><input placeholder="* 대여가격" name="b_rprice" value = "${BOOK.b_rprice}"  type="number"></div>
	<div><button>등록하기</button></div>
</form>