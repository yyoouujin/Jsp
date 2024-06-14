<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<jsp:include page="../Public/header.jsp" />

<h3>학생등록화면</h3>

<%
	String msg = (String) request.getAttribute("message");
%>


<!-- 학생등록 화면에서 등록을 하다가 등록이 안 된 값으로  -->


<%
	if (msg != null){
%>
	<p><%=msg %></p>
	
<%} %>




<form name ="myfrm" action="addStudent.do">
	<table class="table">
		<tr>
			<th>학생번호</th><td><input type="text" name="sno"></td>
		</tr> 
		<tr>
			<th>학생이름</th><td><input type="text" name="sname"></td>
		</tr> 
		<tr>
			<th>전화번호</th><td><input type="text" name="phone"></td>
		</tr> 
		<tr>
			<th>혈액형</th><td><input type="text" name="btype"></td>
		</tr> 
		<tr>
			<td colspan="2">
			<input type="submit" class="btn btn-dark" value="저장">
			</td>
		</tr> 
	</table>
</form>


<jsp:include page="../Public/footer.jsp" />
