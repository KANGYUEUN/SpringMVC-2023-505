<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${rootPath}/static/css/input.css" rel="stylesheet">
<script type="text/javascript">
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/main.js"></script>
<script src="${rootPath}/static/js/member.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>회원검색</h1>
	<div>
		<p>도서코드:${RENT_WORK.rent_bcode}, 도서명:${RENT_WORK.b_name},
			도서출판사:${RENT_WORK.b_comp}</p>
	</div>
	<form:form action="${rootPath}/rent/go/complete"
		modelAttribute="RENT_WORK">
		<%
		/*
		첫 화면에서 입력된 도서정보를 
		이 화면에서 입력하는 회원정보와 함게 묶어서 다음 화면으로 전달 하기 위해서는 
		감춰진 또는 다른 위치에 있는 input tag 를 생성하고 그 input tag에 데이터를 담아 놓아야 한다.
		<div>
			<input hidden="hidden" name="rent_bcode" value="${RENT_WORK.rent_bcode}"/>
			<input hidden="hidden" name="b_name"  value="${RENT_WORK.b_name}"/ >
			<input hidden="hidden" name="b_comp" value="${RENT_WORK.b_comp}"/>
		</div>
		이런 귀찮은 짓을 session, model, Spring form tag를 사용하여
		이것들이 알아서 해주기 때문에 일일히 코드 작성을 안해도 된다. 
		*/
		%>
		<div>
			<label>회원명</label>
			<div class="search container">
				<form:input path="m_name" />
				<div class="search list"></div>
			</div>
		</div>


		<div>
			<label>회원코드</label>
			<form:input path="rent_mcode" />
		</div>
		<div>
			<label>전화번호</label>
			<form:input path="m_tel" />
		</div>
		<div>
			<button>다음 >></button>
		</div>
	</form:form>
</body>
</html>