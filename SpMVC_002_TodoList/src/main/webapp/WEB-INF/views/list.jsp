<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form method="POST" class="main input">
	<fieldset>
		<legend>todolist 추가</legend>
		<div><label>작성일자</label><input name="d_creat"/></div>
		<div class="message d_creat">
			<label></label><span></span>
		</div>	
		<div><label>작성시각</label><input name="d_time"/></div>
		<div class="message d_time">
			<label></label><span></span>
		</div>	
		<div><label>할일</label><input name="d_todo"/></div>
		<div class="message d_todo">
			<label></label><span></span>
		</div>	
	</fieldset>
</form>
