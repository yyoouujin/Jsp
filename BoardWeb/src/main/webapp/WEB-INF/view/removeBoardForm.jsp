<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../Public/header.jsp" %>
 
 
 <%
 BoardVO board = (BoardVO) request.getAttribute("board");
 %>
 
 <!-- 
 BoardWeb/removeBoard.do?boardNo=61
 -->
 
 <p>삭제페이지 구현화면</p>
 
 <table class="table" class="col-sm-10">
 	<tr>
 		<th class="col-sm-1">글번호</th>
 		<td class="col-sm-3"><%=board.getBoardNo() %></td>
 		<th class="col-sm-1">조회수</th>
 		<td class="col-sm-3"><%=board.getClickCnt() %></td>
 	</tr>
 	<tr>
 		<th>제목</th><td colspan="3"><%=board.getTitle() %></td>
 	</tr>
 	<tr>
 		<th>내용</th>
 		<td colspan="3">
 		<textarea class="form-control" readonly><%=board.getContent() %></textarea></td>
 	</tr>
 	<tr>
 		<th>작성자</th><td colspan="3"><%=board.getWriter() %></td>
 	</tr>
 	<tr>
 		<th>작성일시</th><td colspan="3"><%=board.getCreationDate() %></td>
 	</tr>
 	<tr>
 		<td><input type="submit" class="btn btn-dark" value="삭제"></td>
 	</tr>
 </table>
 
 
 
 
 
 <%@include file="../Public/footer.jsp" %>