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

<form name="myFrm" action="join.do" method="post" enctype="multipart/form-data">
	
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
		<th>이미지</th>
		<td><input class="form-control" type="file" name="myImage"></td>
	</tr>
			
			
	<tr align="center">
		<td colspan="2"><input type="submit" value="등록" class="btn btn-primary"></td>
	</tr>
	
	</table>
</form>


</body>
</html>