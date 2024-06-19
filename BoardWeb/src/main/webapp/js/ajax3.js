/**
ajax3.js
*/


//목록 가져오기

const xthp = new XMLHttpRequest();
xthp.open('get', 'memberAjax.do');

xthp.send();

xthp.onload = function (){
	console.log(xthp);
	let data = JSON.parse(xthp.responseText);
	//console.log(data);
	data.forEach(user => {
		document.getElementById('list').appendChild(makeRow(user));
	})
}

//json문자열의 필드이름을 출력
const fields = ['userId', 'userName', 'userPw', 'responsibility'];



function makeRow(obj = {}){ //파라미터로 어떤 형태로 기재를 해도 상관없으나, 보기 편하라고 풀어서 기재해줌 (obj)로 적어도 무방

	let tr = document.createElement('tr');
	tr.setAttribute('id', obj.userId); //<tr id="user01">
	
	
	//tr더블클릭 시 모달 창 출력
	tr.addEventListener('dblclick', function(e){
		document.getElementById('myModal').style.display = 'block';	
		
		//선택된 사용자의 이름, 비밀번호를 모달에 출력.
		console.log(e, this);
		document.getElementById('modify_name').value = this.children[1].innerHTML;
		document.getElementById('modify_pass').value = this.children[2].innerHTML;
		document.getElementById('modify_id').value = this.children[0].innerHTML;
		
	}) ////tr더블클릭 시 모달 창 출력 end
	
	
	
	let btn=document.createElement('button');
		btn.innerText="삭제";
		btn.setAttribute('delId', obj.userId); //data-붙인건 
		
		btn.setAttribute('onclick', 'removeMemberFnc(event)');
		//btn.setAttribute('type', 'button');
		
	
	
	fields.forEach(field => {
		
		let td = document.createElement('td');
		//체크박스 생성
		//td = document.createElement('td');
		
		//td.appendChild(btn);
		td.innerHTML = obj[field];
		tr.appendChild(td);
		
		
		
		/*
			//체크박스 생성
			td = document.createElement('td');
			btn = document.createElement('input');
			btn.setAttribute('type', 'checkbox');
			td.appendChild(btn);
			tr.appendChild(td);
	
		*/
		
		
	})
	tr.appendChild(btn);
	
	
	return tr;
	
}


//수정이벤트
document.getElementById('modBtn').addEventListener('click', function(){
	let id = document.getElementById('modify_id').value;
	let name = document.getElementById('modify_name').value;
	let pass = document.getElementById('modify_pass').value;
	
	//ajax 생성
	const modAjx = new XMLHttpRequest();
	let url = 'modifyAjax.do?nm='+name+'&pw='+pass
	modAjx.open('get', url);
	modAjx.send()
	modAjx.onload = function(){
		
		let result = JSON
		
	}
	
	let targetTr = document.getElementById('id'); //
	targetTr.children[1].innerHTML = name;
	targetTr.children[2].innerHTML = pass;
	
	
	//모달창 닫기
	document.getElementById('myModal').style.display = 'none';
	
	
	
	
	})
	
	


//등록버튼 이벤트 추가 addBtn에다가!
document.getElementById('addBtn').addEventListener('click', function(){
	let id = document.getElementById('uid').value;
	let pw = document.getElementById('upw').value;
	let nm = document.getElementById('uname').value;
	let auth = document.getElementById('auth').value;
	
	const addAjx = new XMLHttpRequest();
	//addAjax.do?id=user10&pw=1234&nm=Hongkildong&auth=User
	let url = 'addAjax.do?id='+id+'&pw='+pw+'&nm='+nm+'&auth='+auth;
	addAjx.open('get', url);
	addAjx.send();
	addAjx.onload = function(){
		let result = JSON.parse(addAjx.responseText);
		if(result.retCode == 'OK'){
			let newMem = {userId: id, userName: nm, userPw: pw, responsibility: auth};
			alert(result.retMsg);
			document.getElementById('list').appendChild(makeRow(newMem));
			
			
		} else {
			alert('실패');
		}

		
	}
	
})


//아이디가 존재하는지 체크이벤트
document.getElementById('uid').addEventListener('change', function(){
	let checkId = this.value;
	
	const checkAjx = new XMLHttpRequest();
	
	let url2 = 'checkIdAjax.do?id='+checkId;
	checkAjx.open('get', url2);
	checkAjx.send();
	checkAjx.onload = function(){
		
		let result = JSON.parse(checkAjx.responseText);
		if(result.retCode=='Exist'){
			alert('이미 존재하는 아이디입니다.');
			document.querySelector('#addBtn').disabled = true;
		} else {
			alert('등록 가능한 아이디입니다.');
			document.querySelector('#addBtn').disabled = false;
		}
		
	}
})






	
	
	
/*
	function del () {
		
		let a = document.querySelectorAll('#list tr')
		a.forEach(elem => elem.children[4])
		
		console.log(this);
		let delid = this.value;
		
		const delAjx = new XMLHttpRequest();
		
		let url3 = 'removeIdAjax.do?id='+delid;
		delAjx.open('get', url3);
		delAjx.send();
		delAjx.onload = function(){
			
			let result = JSON.parse(delAjx.responseText);
			if(result.retCode='Remove Success'){
				alert('삭제완료');
				
				//출력해주려고
				let pw = document.getElementById('upw').value;
				let nm = document.getElementById('uname').value;
				let auth = document.getElementById('auth').value;
				let delMem = {userId: id, userName: nm, userPw: pw, responsibility: auth};
				document.getElementById('list').appendChild(makeRow(delMem));
				
				
			} else {
				alert('삭제실패');
			}
			
		}
		
		
		
	}

*/


//삭제버튼 이벤트 추가

function removeMemberFnc(e) {
	
	//let did = this.dataset.delId;
	let did = e.target.getAttribute('delId');
	//let did = console.log(e.target.parentElement.parentElement.children[0].innerText;)
	
	let tr = document.getElementById(did);
	
	const delAjax2 = new XMLHttpRequest();
	delAjax2.open('get', 'removeIdAjax.do?id='+did);
	delAjax2.send();
	delAjax2.onload = function () {
		
		let result = JSON.parse(delAjax2.responseText);
		if(result.retCode='Remove Success'){
			alert('삭제완료');
			tr.remove();
		} else {
			alert('삭제실패');
			
		}
				
		
	}
	
}





//tr에 더블클릭을 하면 모달창이 새로 뜨고, 거기에 수정내용을 입력할 수 있도록 (w3schools modal 검색 후 사이트에서 복붙)
//더블클릭하면 -> class="modal" -> 해당 클래스의 속성을 -> display:block(바로 보여줌) 으로 바꿔준다




/*
[경민언니 방법]
console.log(e.target.parentElement.parentElement.children[0].innerText;)



/*


document.getElementById('delBtn').addEventListener('click', function(){
	
	let id = document.getElementById('uid').value;

	
	const delAjx = new XMLHttpRequest();
	
	let url3 = 'removeIdAjax.do?id='+id;
	delAjx.open('get', url3);
	delAjx.send();
	delAjx.onload = function(){
		
		let result = JSON.parse(delAjx.responseText);
		if(result.retCode='Remove Success'){
			alert('삭제완료');
			
			//출력해주려고
			let pw = document.getElementById('upw').value;
			let nm = document.getElementById('uname').value;
			let auth = document.getElementById('auth').value;
			let delMem = {userId: id, userName: nm, userPw: pw, responsibility: auth};
			document.getElementById('list').appendChild(makeRow(delMem));
			
			
		} else {
			alert('삭제실패');
		}
		
	}
	
})

/*
*/