/**
reply.js
*/


//1)목록출력
	//board.jsp 파일 내 해당 스크립트 파일을 연결해줬기 때문에 스크립트 파일끼리도 연동이 가능하다
svc.replyList(bno, replyListFnc);


//replyList의 두번째 매개값으로 사용될 함수
function replyListFnc(){
	
	//onload는 이벤트처리기라서 this는 이벤트가 걸린 대상 (xhtp 그 자체가 된다)
	let data = JSON.parse(this.responseText);
	console.log(data);
	data.forEach(reply => {
		let li = cloneRow(reply);
		document.querySelector('div.content>ul').appendChild(li);
	})
	

}


function cloneRow(reply = {}){ //div 의 class이름이 content의 ul 밑 li의 3번째
	let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true); //cloneNode() : 엘리먼트 노드를 복제해준다
	//console.dir(template);
	
	template.style.display = 'block';
	template.setAttribute('id',reply.replyNo);
	template.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo; //글번호
	template.querySelector('span:nth-of-type(2)').innerHTML = reply.reply; //글내용
	template.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer; //작성자
	template.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate; //작성일시
	//클론 노드를 사용해서 버튼자동생성
	return template;
}



//2-1) 댓글등록 이벤트.
document.getElementById('addReply').addEventListener('click', addReplyFnc);

//2-2) 등록 버튼이 눌러지면 실행되는 함수.
	//bno(글번호), replyer(작성자)
function addReplyFnc() {
	if(!replyer){
		alert('로그인하세요!');
		return;
	}
	
	let reply = document.getElementById('reply').value;
		if(!reply){
		alert('댓글을 등록하세요!');
		return;
	}
	
	svc.addReply({replyer, reply, bno}, addReplyCallback); //속성과 변수의 값이 같으면 줄일 수 있다
	//svc.addReply({replyer: replyer, reply: reply, bno: bno}, addReplyCallback);
	
} //end of addReplyFnc메소드


function addReplyCallback() {
	console.log(this.responseText);
	//화면에 댓글정보 목록에 추가.
	let result = JSON.parse(this.responseText);
	if(result.retCode=='OK'){
		alert('등록성공');
		let li = cloneRow(result.retVal); //retVal에는 rvo객체를 담고있다
		document.querySelector('div.content>ul').appendChild(li);
		document.getElementById('reply').value=''; //댓글입력부에 공백을넣어줌 (새 댓글을 쓸 수 있게 빈 박스로 만들어줌)
	} else {
		alert('등록실패=>' + result.retVal);
	}
	
	
} //end of addReplyCallback메소드




//3)한건삭제
function deleteRow(e){ //<button onclick="deleteRow(event)"> : 버튼의 속성값으로 이미 지정해둠 
						//(event)라고 명시하지 않으면 타겟을 다시 찾아야 하기 때문에 event를 적어준다

	console.log(this); //버튼 = e.target
	let li = e.target.parentElement.parentElement; //li라는 변수에다가 한 줄을 지정해둠
	let rno = li.getAttribute('id');
	
	svc.removeReply(rno, deleteReplyFnc);
	//removeReply메소드의 매개값으로 전달될 함수. 화면에서 한건 지우기
	
	function deleteReplyFnc(){
		console.log(this);
		let result = JSON.parse(this.responseText);
		if(result.retCode=='OK'){
			alert(result.retMsg);
			document.getElementById(rno).remove();
		} else {
			alert('Error=>' + result.retMsg);
		}
		
	}
	
}





