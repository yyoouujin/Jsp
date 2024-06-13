<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="../Public/header.jsp" />

<h3>게시글등록화면</h3>




<form name = "myFrm" action="addBoard.do">

	<table class="table">
		<tr>
			<th>제목</th><td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>작성자</th><td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<th>내용</th><td><input type="text" name="content"></td>
		</tr>
		<tr>
			<td><input type="submit" class="btn btn-dark" value="저장"></td>
		</tr>
	</table>
	
</form>

<jsp:include page="../Public/footer.jsp" />