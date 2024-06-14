<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
ader.jsp" />

<h3>수정화면</h3>
<p>${board }</p>

<%
	BoardVO board = (BoardVO) request.getAttribute("board");
%>


<!-- action 에는 폼을 처리하는 서버쪽 url을 명시!  -->

<form name ="myfrm" action="modifyBoard.do">

<input type="hidden" value="${page }" name="page">
<input type="hidden" value="${searchCondition }" name="searchCondition">
<input type="hidden" value="${keyword }" name="keyword">

 <table class="table">
 	<tr>
 		<th>글번호</th>
 		<td><input type="text" class="form-control" readonly value="${board.boardNo }" name="bno">
 		</td>
 		<th>조회수</th><td><c:out value="${board.clickCnt }" /></td>
 	</tr>
 	<tr>
 		<th>제목</th>
 		<td colspan="3"><input type="text" class="form-control" value="${board.title }" name="title">
 		</td>
 	</tr>
 	<tr>
 		<th>내용</th>
 		<td colspan="3">
 		<textarea name = "content"><c:out value="${board.content }" /></textarea>
 		</td>
 	</tr>
 	<tr>
 		<th>작성자</th>
 		<td><c:out value="${board.writer }" /></td>
 		<th>작성일시</th>
 		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.creationDate }" /></td>
 	</tr>
 	<tr>
 	<td colspan="4"><input class="btn btn-warning" type="submit" value="수정하기"></td>
 	</tr>
 
 </table>
 
</form>


