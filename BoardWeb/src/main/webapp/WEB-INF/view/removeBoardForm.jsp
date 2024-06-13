<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<p>${board }</p>


<jsp:include page="../Public/header.jsp" />
 
 
 <%
 BoardVO board = (BoardVO) request.getAttribute("board");
 %>
 
 <!-- 
 BoardWeb/removeBoard.do?boardNo=61
 -->
 
 <form name="myFrm" action="removeBoard.do">

<input type ="hidden" value="${board.boardNo }" name="bno">
 
 <p>삭제페이지 구현화면</p>
 
 <table class="table" class="col-sm-10">
 	<tr>
 		<th class="col-sm-1">글번호</th>
 		<td class="col-sm-3"><c:out value="${board.boardNo }" /></td>
 		<th class="col-sm-1">조회수</th>
 		<td class="col-sm-3"><c:out value="${board.clickCnt }" /></td>
 	</tr>
 	<tr>
 		<th>제목</th><td colspan="3"><c:out value="${board.title }" /></td>
 	</tr>
 	<tr>
 		<th>내용</th>
 		<td colspan="3">
 		<textarea class="form-control" readonly><c:out value="${board.content }" /></textarea></td>
 	</tr>
 	<tr>
 		<th>작성자</th><td colspan="3"><c:out value="${board.writer }" /></td>
 	</tr>
 	<tr>
 		<th>작성일시</th><td colspan="3"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.creationDate }" /></td>
 	</tr>
 	<tr>
 		<td><input type="submit" class="btn btn-dark" value="삭제"></td>
 	</tr>
 </table>
 
 
</form>
 
<jsp:include page="../Public/footer.jsp" />