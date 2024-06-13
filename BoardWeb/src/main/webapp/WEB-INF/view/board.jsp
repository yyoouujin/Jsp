<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../Public/header.jsp" />

<!-- board라는 attribute 값을 읽어오겠습니다! -->
<p>${board }</p>
<!-- 
	 class="col-sm-1" : 전체 12등분의 1정도 차지하겠습니다~
	 비율로 움직이게 해줌
	 submit일 경우 form action 실행
	 -->
	 
	 
<form name="myFrm" action="removeForm.do">

	<input type="hidden" value="${board.boardNo }" name="bno">

	<table class="table" class="col-sm-10">
		<tr>
			<th class="col-sm-1">글번호</th>
			<td class="col-sm-3"><c:out value="${board.boardNo }" /></td>
			<th class="col-sm-1">조회수</th>
			<td class="col-sm-2"><c:out value="${board.clickCnt }" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><c:out value="${board.title }" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea class="form-control" readonly><c:out
						value="${board.content }" /></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><c:out value="${board.writer }" /></td>

		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan="3"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
					value="${board.creationDate }" /></td>
		</tr>
		<tr align="center">
			<td colspan="3">
				<c:choose>
					<c:when test="${!empty loginId && loginId == board.writer }">
						<button type="submit" class="btn btn-danger">삭제이동</button>
						<button type="button" class="btn btn-warning">수정이동</button>
					</c:when>
					<c:otherwise>
						<button type="submit" disabled class="btn btn-danger">삭제이동</button>
						<button type="button" disabled class="btn btn-warning">수정이동</button>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>

	</table>


<a href="boardList.do?page=${page }" class="btn btn-success" colspan="3">목록으로 이동하기</a>


<script>
	document.querySelector('button.btn-warning').addEventListener('click',
			function(e) {
				//삭제화면 이동일 경우에는 removeForm.do
				//수정화면 이동일 경우에는 action="modifyForm.do";
				document.forms.myFrm.action = "modifyForm.do"
				document.forms.myFrm.submit();
			});
</script>


</form>



<jsp:include page="../Public/footer.jsp" />