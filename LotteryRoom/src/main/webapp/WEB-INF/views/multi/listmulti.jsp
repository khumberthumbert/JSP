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
.boardname{
	width:1110px;
	font-weight:bold; 
	font-size:30px;
	padding: 0px;
}
.table{
	width:1110px;	
	test-align : center;
}
.pagination a:hover:not(.active) {background-color: #ddd;}
.ccc{
	width:150px;
}
.cccc{
	width:300px;
}
.ccccc{
	width:510px
}
</style>
<div >
<c:choose>
<c:when test="${listInfo[0].mbGrade == 'E' }">
<p class="boardname">공지사항</p>
</c:when>
<c:when test="${listInfo[0].mbGrade == 'K' }">
<p class="boardname">언론보도</p>
</c:when>
<c:when test="${listInfo[0].mbGrade == 'J' }">
<p class="boardname">커뮤니티</p>
</c:when>
</c:choose>
	<c:set var="no" value="0"></c:set>
	<table class="table">
		<thead>
			<tr>
				<th class="ccc">글번호</th>
				<th class="ccccc">제목</th>
				<th class="cccc">작성자</th>
				<th class="ccc">조회수</th>
			</tr>
		</thead>
		<c:forEach var="multi" items="${listInfo }">
			<tr>
				<td>
					<c:out value="${no=no+1 }"></c:out>
				</td>
				<td><a href="listBoard.do?page=${pageInfo.pageNum }&multiId=${multi.mbId }">${multi.mbTitle }</a></td>
				<td>${multi.userName }</td>
				<td>${multi.mbHit }</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<div class="center">
	<div class="pagination">
	<c:if test="${pageInfo.prev }">
		<a href="noticeList.do?page=${pageInfo.startPage-1 }">Previous</a>
	</c:if>
	<c:forEach var="i" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
		<a class="${i == pageInfo.pageNum ? 'active' : '' }" href="noticeList.do?page=${i }">${i } </a>
	</c:forEach>
	<c:if test="${pageInfo.next }">
		<a href="noticeList.do?page=${pageInfo.endPage+1 }">Next</a>
	</c:if>
	</div></div>
	<p>${reqInfo}</p>
	</div>