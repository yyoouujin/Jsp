/**
replyService.js
목록, 단건, 등록, 삭제
*/

const svc = {
	
	//목록
	replyList(bno=1, successCall) {
		//매개값으로 board.jsp에 지정된 bno 를 사용한다
		//매개값으로 successCall 이라는 함수를 받는다 (콜백함수)
		// 콜백함수 : 어떠한 조건이 되면 실행하는 함수
		const xhtp = new XMLHttpRequest();
		let url='replyListJson.do?bno='+bno;
		xhtp.open('get',url);
		xhtp.send();
		xhtp.onload	= successCall;
	},
	
	
	//단건조회
	getReply() {
		
	},
	
	
	//댓글등록
	addReply(rvo = {replyer, reply, bno}, successCall) {
		
		const xhtp = new XMLHttpRequest();
		//post방식으로 처리 시 정보(데이터)를 함께 전달 가능하다
		xhtp.open('post', 'addReply.do');
		//특정 Http요청의 헤더값을 설정해준다
		xhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); //
		//자체가 파라미터가 되기때문에 ?필요x
		xhtp.send('bno='+rvo.bno+'&reply='+rvo.reply+'&replyer='+rvo.replyer);
		xhtp.onload = successCall;
		
		
	},
	
	
	//댓글삭제
	removeReply(rno=1, successCall) { //removeReply.do
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'removeReply.do?rno='+rno);	
		xhtp.send();
		xhtp.onload = successCall;

	}
	
}