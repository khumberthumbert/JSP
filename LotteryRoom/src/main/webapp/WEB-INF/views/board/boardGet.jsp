<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>공지사항상세 페이지. (noticeGet.jsp)</h3>
<style>
	#content {
		padding: 15px auto;   
	}
</style>
<form action="cmodifyboard.do" method="get">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><input type="text" name="cbId" value="${boardInfo.cbId }" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="cbTitle" value="${boardInfo.cbTitle }" readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea readonly rows="3" cols="20" name="cbSubject">${boardInfo.cbSubject }</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="userName" value="${boardInfo.userName }" readonly></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><input type="text" name="cbAttach" value="${boardInfo.cbAttach }" readonly></td>
		<tr>
			<td colspan="2" align="center">
				<button type="submit">수정</button>
				<button type="button" onclick="location.href='cremoveBoard.do?cbId=${boardInfo.cbId}'">삭제</button>
				<button type="button" onclick="location.href='cboardList.do?cbGrade=${boardInfo.cbGrade}'">목록</button>
			</td>
		</tr>
	</table>
</form>
