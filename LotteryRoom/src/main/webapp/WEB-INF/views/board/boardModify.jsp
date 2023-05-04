<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>공지사항수정 페이지.(cbModify.jsp)</h3>

<form action="cmodifyboard.do" method="post">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><input type="text" name="nid"
				value="${boardInfo.cbId }" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"
				value="${boardInfo.cbTitle }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="20" name="subject">${boardInfo.cbSubject }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit">저장(수정)</button>
				<button type="button" onclick="location.href='remove.do?CbId='${boardInfo.cbId }">삭제</button>
				<!--  <button type="button" onclick="location.href=''"-->
			</td>
		</tr>
	</table>
</form>
<script>
	
</script>