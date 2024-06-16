<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>회원가입 페이지</p>

<form name="myFrm" action="join.do">
	
	<table class="table">
	
	<tr>
		<th>이름</th><td><input type="text" name="name"></td>
	</tr>
	<tr>
		<th>아이디</th><td><input type="text" name="id"></td>
	</tr>
	<tr>
		<th>비밀번호</th><td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<td><input type="submit" class="btn btn-primary" value="회원가입"></td>
	</tr>
	
	</table>
</form>


</body>
</html>