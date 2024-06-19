<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ajax.jsp -->


<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default (block:바로보여줌)*/
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  position: relative;
  background-color: #fefefe;
  margin: auto;
  padding: 0;
  border: 1px solid #888;
  width: 80%;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
  -webkit-animation-name: animatetop;
  -webkit-animation-duration: 0.4s;
  animation-name: animatetop;
  animation-duration: 0.4s
}

/* Add Animation */
@-webkit-keyframes animatetop {
  from {top:-300px; opacity:0} 
  to {top:0; opacity:1}
}

@keyframes animatetop {
  from {top:-300px; opacity:0}
  to {top:0; opacity:1}
}

/* The Close Button */
.close {
  color: white;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

.modal-header {
  padding: 2px 16px;
  background-color: #5cb85c;
  color: white;
}

.modal-body {padding: 2px 16px;}

.modal-footer {
  padding: 2px 16px;
  background-color: #5cb85c;
  color: white;
}
</style>






<h3>ajax연습</h3>

<div id="register">
	<table class="table">
		<tr>
			<th>아이디</th><td><input type="text" id="uid"></td>
		</tr>
		<tr>
			<th>비밀번호</th><td><input type="password" id="upw"></td>
		</tr>
		<tr>
			<th>이름</th><td><input type="text" id="uname"></td>
		</tr>
		<tr>
			<th>권한</th>
			<td>
				<select id="auth">
					<option value="User">사용자</option>
					<option value="Admin">관리자</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="1"><button id="addBtn" class="btn btn-primary">등록</button></td>
		</tr>
	</table>

</div>

<div id="show">
<table class="table">

	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>권한</th>
			<th><button type="button" id="select" class="btn btn-dark">삭제</button></th>
		</tr>
	</thead>
	
	<tbody id="list">
	
	<!-- 
		<tr>
			<td>
			id
			first_name
			email
			salary
			<input type="checkbox" id="select"></th>
			
			</td>
			-> 루핑 1개가 끝나면 appendChild 해서 tr의 끝에 계속 추가할 수 있다
			
		</tr>
		
	 -->
	 
	</tbody>
</table>


</div>



<!-- modal창 -->
<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <div class="modal-header">
      <span class="close">&times;</span>
      <h2>사용자 정보 수정</h2>
    </div>
    <div class="modal-body">
    <input type="hidden" id="modify_id">
      <p>이름 : <input type="text" id="modify_name"></p>
      <p>비밀번호 : <input type="text" id="modify_pass"></p>
      <p><button id="modBtn">수정</button></p>
    </div>
    <div class="modal-footer">
      <h3>Modal Footer</h3>
    </div>
  </div>
  
</div>




<script>

//Get the modal
var modal = document.getElementById("myModal");


// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];


// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

</script>




<script src="js/ajax3.js"></script>