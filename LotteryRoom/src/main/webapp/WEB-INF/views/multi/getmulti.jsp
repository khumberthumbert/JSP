<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="${control }?mbId=${boardInfo.mbId}" method="get">
	<h4>
		<strong>${boardInfo.mbTitle}</strong>
	</h4>
	<p>작성일 ${boardInfo.mbDate}</p>
	<div class="board-right">
		<c:choose>
			<c:when test="${boardInfo.userGrade=='A'}">
				<p>작성자: 관리자</p>
			</c:when>
			<c:otherwise>
				<p>작성자: ${boardInfo.userName }</p>
			</c:otherwise>
		</c:choose>
	</div>
	<br>
	<p>${boardInfo.mbAttach }</p>
	<p>${boardInfo.mbSubject }</p>
	<br> <br> <br> 
	<hr>
	<table>
		<tr>
		<td><button type="submit">수정</button></td>
		<td><button type="button">삭제</button></td>
		<!-- 전체 리스트페이지 이동 시 페이징 한 값이 필요 -->
		<td><button type="button"
		onclick="location.href='listMulti.do?mbGrade=${boardInfo.mbGrade}'">목록</button></td>
		</tr>
	</table>

</form>