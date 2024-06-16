
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 첫페이지입니다.</title>
</head>
<body>
	<!--
	jsp내에서 기능을 수행하는 태그 action태그
	forward - 요청을 재지정해줌
	-->
	<jsp:forward page="main.do"></jsp:forward>
	<h3>Hello, world</h3>
	
	<!--  
	<a href="main.do">main 페이지로 이동</a>
	 -->
</body>
</html>