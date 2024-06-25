<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 
1. <img width='200px' src='images/${member.image }'>
2. <img width='200px' src="${empty member.image ? '' : 'images/'.concat(member.image) }">
-->

<!-- memberList.jsp -->
<h3>회원목록(관리자용)</h3>


<table>
<!-- 회원아이디/이름/비밀번호/이미지 -->


		<c:forEach var="member" items="${memberList }">
			<tr>
				<th>id : </th><td>${member.userId }</td>
				<th>name : </th><td>${member.userName }</td>
				<th>password : </th><td>${member.userPw }</td>
				<td> <img width='100px' height='100px' src="${empty member.image ? ' ' : 'images/'.concat(member.image) }"> </td>
			</tr>
		</c:forEach>
<!--	
	<ul>	
			<li>
			id : <b>${member.userId }</b>
			name : <b>${member.userName }</b>
			password : <b>${member.userPw }</b>
			
			<c:choose>
				<c:when test="${empty member.image }">
					<img src="" width='200px'>
				</c:when>
				<c:otherwise>
					<img src="images/${member.image }" width='200px'>
				</c:otherwise>
			</c:choose>
			
			</li>

	</ul>
-->

</table>