/**
 * 
 */

//화면에서 ul#fruit 가리기
document.getElementById('fruit').style.display = 'none';

//추가 버튼 가운데 정렬하기
	//querySelector사용 시 첫번째를 가져옴
	//table.table tr:nth-of-type(5)
	//table 클래스 하위의 table에 있는 tr태그의 5번째 요소를 가져온다
document.querySelector('table.table tr:nth-of-type(5)').setAttribute('align', 'center');


// 페이지 로딩하면서 회원 3명 출력
//(data.js 파일 내myMembers 목록출력)
for (let mem of myMembers){ //myMembers가 배열이라 of를 사용해줌
	document.getElementById('memberList')//
	.appendChild(addRow(mem));

}




//입력값들을 가져오고 출력하기
	//추가버튼 클릭이벤트 등록 (이벤트처리 함수만 연결)
document.getElementById('addBtn').addEventListener('click', addMemberFunc);
	//수정버튼 클릭이벤트 등록
document.getElementById('modBtn').addEventListener('click', modMemberFunc);
	//수정버튼 클릭이벤트 등록
document.getElementById('delBtn').addEventListener('click', removeMemberFunc);


	//전체선택 클릭이벤트 등록
document.querySelector('thead input[type="checkbox"]').addEventListener('change', allCheckFunc);

	//this => 1.이벤트(이벤트대상), 2.function(window), 객체(객체자신)
	const obj = {
		name:'홍길동',
		age:20,
		showInfo(){
			return '이름은' + this.name + '나이는' + this.age
		}
	}
	
	obj.showInfo();
	
	
	//하나라도 풀리면 해제이벤트 등록
document.querySelector('thead input[type="checkbox"]').addEventListener('change', clearAllCheckFunc);


	//clearAllCheckFunc 이벤트 처리함수 생성(전체선택해제)
function clearAllCheckFunc(){
	
	let checkboxes = document.querySelectorAll('tbody#memberList tr');
	//전체체크박스개수
	let totalCnt = checkboxes.length;
	let checkedCnt = document.querySelectorAll('tbody#memberList tr').checked;
	
	
	
} //end of 전체선택해제 메소드

	

	//allCheckFunc 이벤트 처리함수 생성(전체선택)
function allCheckFunc(){
	console.log(this.checked);
	document.querySelectorAll('tbody#memberList tr').forEach(item => item.children[5].children[0].checked = this.checked);
	/*
	document.querySelectorAll('#memberList tr')//
		.forEach(item => item.children[5].children[0].checked = this.checked);
	*/
}


	//removeMemberFunc 이벤트 처리함수 생성 (선택삭제)
function removeMemberFunc(){
	let targetTr = document.querySelectorAll('#memberList tr');
	for(let tr of targetTr){
		console.log(tr.children[5].children[0].checked);
		if(tr.children[5].children[0].checked){
			tr.remove();
		}
	}
} // end of removeMemberFunc 함수



	//modMember 이벤트 처리 함수 생성 (수정)
function modMemberFunc(){
	
	let targetTr = document.querySelectorAll('#memberList tr');
	//입력화면의 회원아이디 값을 가져와서 mid변수에저장.
	let mid = document.getElementById('mid').value;
	let mname = document.getElementById('mname').value;
		
		
		//for of : 컬렉션 전용 반복문
		for(let tr of targetTr){
		if(tr.children[0].innerHTML == mid){
			tr.children[1].innerHTML = mname;
			tr.children[2].innerHTML = document.getElementById('mphone').value;
			tr.children[3].innerHTML = document.getElementById('mpoint').value;
			
		}//end if문
		
		
	} //end for문
	
	
	
} //end modMemberFunc()


	//addMember 이벤트 처리 함수 생성
function addMemberFunc(){
	

	const id = document.getElementById('mid').value;
	const name = document.getElementById('mname').value;
	const phone = document.getElementById('mphone').value;
	const point = document.getElementById('mpoint').value;
	
		
	if(!id || !name || !phone || !point) { //id값이 없거나, name값이 없거나, point값이 없다면
		alert('필수값을 입력');
		return;
	}
	
	
	document.getElementById('memberList')//
	.appendChild(addRow({id, name, phone, point}));
	
	
	//값 입력 후 input박스 비워주기
	document.getElementById('mid').value = "";
	document.getElementById('mname').value = "";
	document.getElementById('mphone').value = "";
	document.getElementById('mpoint').value ="";
	
	
} //end of addMemberFunc()



	//출력함수 생성 (매개값으로 object 타입을 받는다)
function addRow(member = {id, name, phone, point}){ //jsc라서 배열변수를 따로 선언하지 않고도 사용가능!
	//tr > td * 4
	const tr = document.createElement('tr');
	tr.addEventListener('click', showDetailFnc); //이벤트유형, 이벤트함수(함수만 연결해주기 실행x)
	
	for(let prop in member){ //매개변수로 받고있는 member를 말한다
		const td = document.createElement('td');
		td.innerHTML = member[prop];
		tr.appendChild(td);
		
	} //end of for문
	
	
	//삭제버튼 생성
	//<td><button>삭제</button></td>
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', removeTrElement);
	btn.innerText = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	
	//체크박스 생성
	td = document.createElement('td');
	btn = document.createElement('input');
	btn.setAttribute('type', 'checkbox');
	td.appendChild(btn);
	tr.appendChild(td);
	
	
	return tr;
	
} //end of addRow 함수



//이벤트핸들러함수
function removeTrElement(e){
	console.log('btn', e);
	e.stopPropagation(); //상위요소 이벤트 전파 차단
	console.log(this.parentElement.parentElement.remove());
	
} //end of removeTrElement함수





//tr부분 클릭 시 ID,이름, 연락처, 점수 input 박스 내 재추가
function showDetailFnc(e) {
	console.log('tr', e)
	//this = 이벤트를 받는 대상 (tr)
	//tr의 자식요소의 값을 입력 input에 반환
	console.dir(this.children[1].innerText);
	document.getElementById('mid').value = this.children[0].innerText;
	document.getElementById('mname').value = this.children[1].innerText;
	document.getElementById('mphone').value = this.children[2].innerText;
	document.getElementById('mpoint').value = this.children[3].innerText;
	
	
} //end of showDetailFnc함수

