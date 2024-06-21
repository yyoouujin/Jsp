/**
reply.js
replyService.js에서 기능을 만들어놓고 reply.js에서 호출에서 사용
*/


//1)댓글목록 출력하기
	//board.jsp 파일 내 해당 스크립트 파일을 연결해줬기 때문에 스크립트 파일끼리도 연동이 가능하다
let page = 1; //댓글페이지 전역변수로 설정
svc.replyList({bno, page}, replyListFnc);


//replyList의 두번째 매개값으로 사용될 함수
function replyListFnc(){
	
	//5개 댓글을 지워주고 새롭게 목록출력 (댓글페이징! 4)
	document.querySelectorAll('div.content>ul>li').forEach((item, idx) => {
			if(idx > 2) {
			item.remove();
		}
	});

	
	//onload는 이벤트처리기라서 this는 이벤트가 걸린 대상 (xhtp 그 자체가 된다)
	let data = JSON.parse(this.responseText);
	console.log(data);
	data.forEach(reply => {
		let li = cloneRow(reply);
		document.querySelector('div.content>ul').appendChild(li);
	})
	
	makePagingFnc(); //페이지 새로 그려주기
	
} //replyListFnc끝


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


//4-1) 페이징 a 태그를 클릭하면 목록보여주기.
document.querySelectorAll('div.pagination a').forEach(item => {
	
	item.addEventListener('click', function(e) {
			//item = a태그 (a 태그 내 #은 최상위로 이동하는 기능)
		e.preventDefault(); //a태그의 기본기능 (#기능/페이지이동기능)을 차단한다
		page = item.innerHTML; //요기서 page를 돌려줌
		svc.replyList({bno, page}, replyListFnc);
	})
	
});



//5-1) 댓글 건수를 활용해서 건수만큼 페이징계산, a태그를 가지고 페이지 목록출력
//makePagingFnc(); -> 건수출력
function makePagingFnc(){
	svc.replyTotalCnt(bno, createPagintList);
}

let pagination = document.querySelector('div.pagination');



//createPagintList 는이벤트 처리함수 : replyTotalCnt 의 두번째 매개변수로 들어가는 콜백 함수이다
		//함수를 등록하기만 하고, 이벤트가 발생하거나 특정 시점에 도달하면 시스템에서 호출함 createPaginList
function createPagintList(){
	//이쪽의 this 는 xhtp가 걸리는 객체 그 자체가된다
	let totalCnt = this.responseText;
	console.log(totalCnt); //632건/5 => 127page
	let startPage, endPage;
	let prev, next;
	let realEnd = Math.ceil(totalCnt / 5); //127page
	
	endPage = Math.ceil(page / 10) * 10; //10page까지 출력.
	startPage = endPage - 9; //1부터~
	endPage = endPage > realEnd ? realEnd : endPage;
	
	prev = startPage > 1;
	next = endPage < realEnd;
	
	
	//startPage, endPage, prev, next 를 활용해서 => a태그 생성
	pagination.innerHTML = '';
	
	//이전 페이지
	if(prev) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', startPage-1);
		aTag.setAttribute('href', '#');
		aTag.innerHTML = "&laquo;"; //<<
		pagination.appendChild(aTag);
		
	}
	
	//현재페이지(1~10)
	for(let p = startPage; p <= endPage; p++) {
		
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', p); //data-속성명="속성값" : data-page=p
		aTag.setAttribute('href', '#');
		aTag.innerHTML = p;
		if(page==p){
			aTag.className = 'active'; //선택된 페이지 정보 초록색으로 출력
		}
		pagination.appendChild(aTag);
		
	}
	
	//다음페이지
	if(next) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', endPage+1);
		aTag.setAttribute('href', '#');
		aTag.innerHTML = "&raquo;"; //>>
		pagination.appendChild(aTag);
		
	}
	
	//여기서 이벤트 처리함수를 걸어준다
	document.querySelectorAll('div.pagination a').forEach(item => {
		
	item.addEventListener('click', function(e) {
			//item = a태그 (a 태그 내 #은 최상위로 이동하는 기능)
		e.preventDefault(); //a태그의 기본기능 (#기능/페이지이동기능)을 차단한다
		page = item.dataset.page;
		svc.replyList({bno, page}, replyListFnc); //목록 출력
	})
	
});


} //createPagintList 끝


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
	//console.log(this.responseText);
	//화면에 댓글정보 목록에 추가.
	let result = JSON.parse(this.responseText);
	if(result.retCode=='OK'){
		alert('등록성공');
		page = 1;
			//let page = 1; -> 이렇게 되면 addReplyCallback 함수 내에서만 실행 후 없어지는 변수가 된다
		svc.replyList({bno, page}, replyListFnc);
		//이제 페이지를 옮겨임마
		
		/*
		let li = cloneRow(result.retVal); //retVal에는 rvo객체를 담고있다
		document.querySelector('div.content>ul').appendChild(li);
		*/
		
		document.getElementById('reply').value=''; //댓글입력부에 공백을넣어줌 (새 댓글을 쓸 수 있게 빈 박스로 만들어줌)
	} else {
		alert('등록실패=>' + result.retVal);
	}
	
	
} //end of addReplyCallback메소드




//3)한건삭제
function deleteRow(e){ //<button onclick="deleteRow(event)"> : 버튼의 속성값으로 이미 지정해둠 
						//(event)라고 명시하지 않으면 타겟을 다시 찾아야 하기 때문에 event를 적어준다

	//console.log(this); //버튼 = e.target
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
			svc.replyList({bno, page}, replyListFnc); //지워진 목록 바로 출력
		} else {
			alert('Error=>' + result.retMsg);
		}
		
	}
	
}





