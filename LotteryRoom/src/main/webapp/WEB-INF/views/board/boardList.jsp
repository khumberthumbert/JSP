<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.center {
  text-align: center;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
	
	<c:set var="no" value="0"></c:set>
	<table class="table">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>게시일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<c:forEach var="board" items="${list }">
			<tr>
				<td>
					<c:out value="${no=no+1 }"></c:out>
				</td>
				<td><a href="getBoard.do?cbId=${board.cbId}">${board.cbTitle }</a></td>
				<td>${board.userName }</td>
				<td>${board.cbDate }</td>
				<td>${board.cbHit }</td>
			</tr>
		</c:forEach>
	</table>
	<div class="center">
	<div class="pagination">
	
	</div>
	</div>