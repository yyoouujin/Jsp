<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@include file="../Public/header.jsp" %>
 
 <%
 BoardVO board = (BoardVO) request.getAttribute("board");
 String paging = (String) request.getAttribute("page");
 //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초");
 String yyyymmdd = sdf.format(board.getCreationDate());
 %> 
 
 
 
	 <!-- 
	 class="col-sm-1" : 전체 12등분의 1정도 차지하겠습니다~
	 비율로 움직이게 해줌
	 -->
 <p><%=board %></p>
 <table class="table" class="col-sm-10">
 	<tr>
 		<th class="col-sm-1">글번호</th>
 		<td class="col-sm-3"><%=board.getBoardNo() %></td>
 		<th class="col-sm-1">조회수</th>
 		<td class="col-sm-2"><%=board.getClickCnt() %></td>
 	</tr>
 	<tr>
 		<th>제목</th><td colspan="3"><%=board.getTitle() %></td>
 	</tr>
 	<tr>
 		<th>내용</th>
 		<td colspan="3">
 		<textarea class="form-control" readonly><%=board.getContent() %></textarea>
 		</td>
 	</tr>
 	<tr>
 		<th>작성자</th><td colspan="3"><%=board.getWriter() %></td>
 	</tr>
 	<tr>
 		<th>작성일시</th><td colspan="3"><%=yyyymmdd %></td>
 	</tr>
 	
 </table>
 
 <a href="boardList.do?page=<%=paging %>">목록으로 이동하기</a>
 
 

 
<!-- 
http://localhost/BoardWeb/boardList.do?page=5
http://localhost/BoardWeb/getBoard.do?bno=92
-->
 
 
 <%@include file="../Public/footer.jsp" %>
 
 