/**
reply.js
*/

// 댓글 -> li생성 
function makeRow(reply = {}){
	let fields = ['replyNo', 'reply', 'replyer', 'replyDate'];
	let li = document.createElement('li');
	
	fields.forEach(field => {
		let span = document.createElement('span');
		span.innerHTML = reply[field];
		
		
		if(field == 'reply'){
			width = '4';
		} else if (field == 'replyDate'){
			width = '3';
		} else {
			width = '2';
		}
		
		span.setAttribute('class', 'col-sm-' + width);
		li.appendChild(span);
	})
	
	return li;
	
}



function cloneRow(reply = {}){ //div 의 class이름이 content의 ul 밑 li의 3번째
	let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true); //cloneNode() : 엘리먼트 노드를 복제해준다
	//console.dir(template);
	
	template.style.display = 'block';
	template.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo; //글번호
	template.querySelector('span:nth-of-type(2)').innerHTML = reply.reply; //글내용
	template.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer; //작성자
	template.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate; //작성일시
	//클론 노드를 사용해서 버튼자동생성
	return template;
}



//한건삭제
function deleteRow(e){ //<button onclick="deleteRow(event)"> : 버튼의 속성값으로 이미 지정해둠 
						//(event)라고 명시하지 않으면 타겟을 다시 찾아야 하기 때문에 event를 적어준다
						
	//버튼만 삭제 x 리스트 태그 전체 삭제
	
	let delRep = e.target.parentElement.parentElement.children[0].innerHTML;
	
	//let delRep = e.target.parentElement.parentElement.children[0];
	
	const removeAjax = new XMLHttpRequest();
	let url = 'removeReply.do?replyNo='+delRep;
	
	removeAjax.open('get', url);
	removeAjax.send();
	removeAjax.onload = function() {
		let result = JSON.parse(removeAjax.responseText);
		if(result.retCode=='OK'){
			alert('삭제완료');
			e.target.parentElement.parentElement.remove();
		} else {
			alert('삭제실패');
		}
	}
	
} //한건삭제end




const listAjax = new XMLHttpRequest();
let url = 'replyListJson.do?bno='+bno; //board.jsp파일 내 script영역에 변수를 지정해둠 (bno)
listAjax.open('get', url);
listAjax.send();
listAjax.onload = function(){
	let data = JSON.parse(listAjax.responseText);
	console.log(data);
	data.forEach(reply => {
		//document.querySelector('div.content>ul').appendChild(makeRow(reply));
		document.querySelector('div.content>ul').appendChild(cloneRow(reply));
	})
	
}