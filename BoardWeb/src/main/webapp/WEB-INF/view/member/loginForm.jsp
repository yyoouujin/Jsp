<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cust" %>


<!--
url = "태그 라이브러리의 네임 스페이스 URI 식별자"
prefix = "태그를 사용할때 태그 이름 앞에 붙일 접두사"
-->



<h3>로그인화면(loginForm.jsp)</h3>
<cust:line />



<c:forEach var="i" begin="1" end="10" step="1" >
	<p>${i }</p>
</c:forEach>



<!--
로그인 (버튼) 실행 시 - Login.do 페이지로 이동!
-->

<form name="myFrm" action="Login.do">

	<table class="table">
	<tr>
		<th>아이디</th><td><input type="text" name="id"></td>
	</tr>
	<tr>
		<th>비밀번호</th><td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<td colspan="1"><input type="submit" class="btn btn-primary" value="로그인"></td>
		<td colspan="1"><button type="button" class="btn btn-warning">회원가입</button></td>
	</tr>

	</table>
	
	
<script>
	document.querySelector('button.btn-warning').addEventListener('click', function(e){
		//로그인 버튼일 경우에는 Login.do
		//회원가입 버튼일 경우에는 action="joinForm.do"
		document.forms.myFrm.action = "joinForm.do"
		document.forms.myFrm.submit();
	})
	

</script>

</form>
