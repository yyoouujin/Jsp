<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style>
div.reply div {
	margin : auto;
}

div.reply ul {
	list-style-type:none;
	margin-top : 10px;
}
div.reply li {
	padding-top : 1px;
	padding-bottom : 1px;
}
div.reply span {
	display : inline-block;
}

</style>

<!-- board라는 attribute 값을 읽어오겠습니다! -->
<h3>상세화면(board.jsp)</h3>
<!-- 
	 class="col-sm-1" : 전체 12등분의 1정도 차지하겠습니다~
	 비율로 움직이게 해줌
	 submit일 경우 form action 실행
	 -->
	 
	 
	<!-- value 는 attribute 값을 읽어온다! -->
<form name="myFrm" action="removeForm.do">

	<input type="hidden" value="${page }" name="page">
	<input type="hidden" value="${board.boardNo }" name="bno">
	<input type="hidden" value="${searchCondition }" name="searchCondition">
	<input type="hidden" value="${keyword }" name="keyword">

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
				<a href="boardList.do?page=${page }" class="btn btn-success" colspan="3">목록으로 이동하기</a>
			</td>
		</tr>

	</table>

</form>




<!-- 댓글관련 시작 -->

<div class="container reply">

	<div class="header">
		<input class="col-sm-8" id="reply">
		<button class="col-sm-3" id="addReply">등록</button>
			<div class ="content">
				<ul>
					<li>
						<span class="col-sm-1">댓글번호</span>
						<span class="col-sm-4">글내용</span>
						<span class="col-sm-2">작성자</span>
						<span class="col-sm-3">작성일시</span>
						<span class="col-sm-1">삭제</span>
					</li>
					<li>
						<hr />
					</li>
					<li style="display: none">
						<span class="col-sm-1">3</span>
						<span class="col-sm-4">글잘봤어요</span>
						<span class="col-sm-2">user03</span>
						<span class="col-sm-3">2024-05-08 13:22:34</span>
						<span class="col-sm-1"><button onclick="deleteRow(event)">삭제</button></span>
					</li>
				</ul>
			</div>
		
	</div>

</div>

<!-- 댓글관련 끝 -->




<script>

	//jsp 페이지 내라서 가능하다
	//해당 변수의 값을 자바스크립트 내에서 사용가능하도록 지정
	const bno = "${board.boardNo }";
	const replyer = "${loginId }";


	document.querySelector('button.btn-warning').addEventListener('click',
			function(e) {
				//삭제화면 이동일 경우에는 removeForm.do
				//수정화면 이동일 경우에는 action="modifyForm.do";
				document.forms.myFrm.action = "modifyForm.do"
				document.forms.myFrm.submit();
			});
</script>

<script src="js/replyService.js"></script>
<script src="js/reply.js"></script>
