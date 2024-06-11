<%@page import="java.util.List"%>
<%@page import="co.yedam.vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 다른 페이지를 현재 페이지에 삽입 @include -->
<%@include file="header.jsp" %>

	<h3>main 페이지</h3>
	
	<%
		Student student = (Student)request.getAttribute("student");
		//student 라는 Attribute를 읽어서 반환!
		List<Student> list = (List<Student>) request.getAttribute("studentList");
	%>
	
	<p>학생번호 : <%=student.getStdNo() %></p>
	<p>학생이름 : <%=student.getStdName() %></p>
	
	<h3>학생목록</h3>
	<ul>
		<% for(Student std : list) {%>
		<li>학번 : <%=std.getStdNo() %> 이름 : <a href="product.do?stdNo=<%=std.getStdNo() %>"><%=std.getStdName() %></a> 전화번호 : <%=std.getPhone() %> </li>
		<%} %>
	</ul>
	

<%@include file="footer.jsp" %>