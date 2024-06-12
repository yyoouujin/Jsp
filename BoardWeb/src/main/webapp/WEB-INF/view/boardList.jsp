<%@page import="co.yedam.common.PageDTO"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- "boardList"에 담긴 값을 읽어서 반복처리 -->

<%@include file="../Public/header.jsp" %>


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





<%
//request는 jsp의 내장객체
List<BoardVO> list = (List<BoardVO>)request.getAttribute("boardList");
PageDTO pageDTO = (PageDTO) request.getAttribute("paging");
%>

<p><%=pageDTO %></p>


<h3>게시글 목록</h3>

<table class="table">
	<thead>
		<tr>
			<th>글번호</th><th>제목</th><th>작성자</th><th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<% for (BoardVO vo : list) { %>
		<tr>
			<td><%=vo.getBoardNo() %></td> 
			<td><a href="getBoard.do?bno=<%=vo.getBoardNo() %>&page=<%=pageDTO.getPage() %>"><%=vo.getTitle()%></a></td>
			<td><%=vo.getWriter()%></td>
			<td> <%=vo.getClickCnt()%></td>
		</tr>
		<% } %>
	</tbody>
</table>




<!-- paging 2 -->

<div class="center">
  <div class="pagination">
  
   	 <!-- 이전페이지 여부 체크! : boolean 타입의 getter 메소드는 is로 시작!-->
  <%if (pageDTO.isPrev()) {%>
  <a href="boardList.do?page=<%=pageDTO.getStartPage()-1 %>">&laquo;</a>
  <%} %>
  
  
  	<!-- 현재페이지 : 초록색으로 표시(active 클래스) if문 사용-->
  <%for(int p = pageDTO.getStartPage(); p <= pageDTO.getEndPage(); p++){ %>
  <% if(p == pageDTO.getPage()) {%>
  <a href="boardList.do?page=<%=p %>" class="active"><%=p %></a>
  <%} else { %> 
  <a href="boardList.do?page=<%=p %>"><%=p %></a>
  <%} }%>
  
  
 	 <!-- 이후페이지 여부 체크! -->
  <%if (pageDTO.isNext()) {%>
  <a href="boardList.do?page=<%=pageDTO.getEndPage()+1 %>">&raquo;</a>
  <%} %>
  </div>
</div>



<!-- paging 1 -->
<!-- 
<div class="center">
  <div class="pagination">
  <a href="#">&laquo;</a>
  <a href="boardList.do">1</a>
  <a href="boardList.do?page=2" class="active">2</a>
  <a href="boardList.do?page=3">3</a>
  <a href="boardList.do?page=4">4</a>
  <a href="boardList.do?page=5">5</a>
  <a href="boardList.do?page=6">6</a>
  <a href="#">&raquo;</a>
  </div>
</div>
 -->
 
 


<%@include file="../Public/footer.jsp" %>
