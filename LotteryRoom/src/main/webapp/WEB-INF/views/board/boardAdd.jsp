<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>공지사항등록 페이지.</h3>

<form action="addBoard.do" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="cbTitle"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="20" name="cbSubject"></textarea></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><input type="text" name="cbAttach"></td>
		<tr>
			<td colspan="2" align="center">
				<button type="submit">등록</button>
				<button type="reset">취소</button>
			</td>
		</tr>
	</table>
</form>