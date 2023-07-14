<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차계부-2023</title>
<link href="${rootPath}/static/css/main.css?2023-07-14-002"
	rel="stylesheet">
</head>
<body>
	<header>♡ MY CAR MANAGER ♡</header>
	<form class="main" method="POST" action="${rootPath}/insert">
		<table class="main insert">
			<tr>
				<td>운행등록 Service</td>
				<td><input name="cd_inout" placeholder="구분" /></td>
				<td><input name="cd_stdistance" placeholder="시작거리(km)" /></td>
				<td><input name="cd_place" placeholder="장소" /></td>
			</tr>
			<tr>
				<td><input name="cd_ardistance" placeholder="종료거리(km)" /></td>
				<td><input name="cd_price" placeholder="소요비용" /></td>
				<td><button class="main button">저장</button></td>
			</tr>
		</table>
	</form>
	<form class="main" method="POST" action="${rootPath}/update">
		<table>
			<tr>
				<td>운행등록 Service</td>
				<td><input name="cd_inout" placeholder="구분" /></td>
				<td><input name="cd_stdistance" placeholder="시작거리(km)" /></td>
				<td><input name="cd_place" placeholder="장소" /></td>
			</tr>
			<tr>
				<td><input name="cd_ardistance" placeholder="종료거리(km)" /></td>
				<td><input name="cd_price" placeholder="소요비용" /></td>
				<td><button class="main button">저장</button></td>
			</tr>
		</table>
	</form>
	<table class="main list">
		<tr>
			<th>No.</th>
			<th>구분</th>
			<th>출발일자</th>
			<th>출발시간</th>
			<th>출발거리(km)</th>
			<th>도착일자</th>
			<th>도착시간</th>
			<th>도착거리(km)</th>
			<th>장소</th>
			<th>소요비용</th>
		</tr>
		<c:forEach items="${CD_LIST}" var="CD">
			<tr>
				<td>${CD.cd_seq}</td>
				<td>${CD.cd_inout}</td>
				<td>${CD.cd_stdate}</td>
				<td>${CD.cd_sttime}</td>
				<td>${CD.cd_stdistance}</td>
				<td>${CD.cd_ardate}</td>
				<td>${CD.cd_artime}</td>
				<td>${CD.cd_ardistance}</td>
				<td>${CD.cd_place}</td>
				<td>${CD.cd_price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>