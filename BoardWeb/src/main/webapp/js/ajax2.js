/**
ajax2.js
*/

//XMLHttpRequest
//자바스크립트를 사용

const xhtp = new XMLHttpRequest();

//서버상에있는 페이지를 요청 가능
xhtp.open('get','data/MOCK_DATA.json');
//open() : HTTP 요청 초기화 (페이지를 요청한다)
//open(method, url) (get : 모든 특정 리소스를 취득한다) / 데이터를 url의 일부분인 쿼리 문자열로 서버에 전송해줌


xhtp.send(); //XMLHttpRequest 객체의 메서드 send() : HTTP 요청 전송

xhtp.onload = function(){
	
	//JSON문자열 -> 자바스크립트 객체(객체로 사용할 수있다)
	//JSON포맷의 문자열을 객체로 변환(역직렬화)
	let data = JSON.parse(xhtp.responseText); //responseText : 서버가 전송한 http 요청에 대한 응답 문자열
	
	//console.log(data);
	//console.log(xhtp.responseText);
	
	//DOM 활용해서 페이지 작성
	data.forEach(function(emp){
		console.log(emp);
		document.getElementById('list').appendChild(makeRow(emp));
		//여기서 makeRow 함수를 사용해서 출력해준다
	});
	
	
}


let fields = ['id', 'first_name', 'email', 'salary'];



//makeRow : 배열의 요소를 순회하며, 줄을 바꿔주는 메서드
function makeRow(obj = {}){ //파라미터로 어떤 형태로 기재를 해도 상관없으나, 보기 편하라고 풀어서 기재해줌 (obj)로 적어도 무방

	let tr = document.createElement('tr');
	fields.forEach(field => { //forEach(): 배열의 모든 요소를 순회하는 배열 전용 메서드 (field : 배열요소)
		//field는 파라미터가 된다, 화살표 함수는 익명함수로 this 자신이 가지는 객체가 없다
		//화살표 함수의 화살표 뒤에 오는 중활호 {} 내에는 리턴 값이 들어온다
		
		let td = document.createElement('td');
		td.innerHTML = obj[field]; //유동적인 변수가 들어올 수 있도록 []붙여준다(obj.field -> 유동적인 값을 가져올 수 없다)
		tr.appendChild(td);
		
	})
	
	/*
	forEach(function (배열요소, 인덱스, 배열){
	});
	forEach는 따로 리턴하는 값이 없다
	배열 요소의 개수에 따라 콜백 함수가 호출되는 개수 결정된다
	주어진 함수는 배열의 크기만큼 반복 실행된다
	각 요소에 대해 함수 호출 시 해당 요소의 값, 인덱스, 원본 배열을 인수로 넘긴다
	*/
	
	return tr;
	
} //end of makeRow메서드





/*

자바스크립트 객체
{id:"hong", name:"홍길동", age:20}

=>
JSON객체(=JSON문자열)
{"id":"hong", "name":"홍길동", "age":20}

[{"id":"hong", "name":"홍길동", "age":20}, {...}, ...]

*/



//---------------------------
const xhtm = new XMLHttpRequest();
xhtm.open('get', 'loginForm.do');
xhtm.send();
xhtm.onload = function() {
	console.log(xhtm);
	//document.getElementById('show').innerHTML = xhtm.responseText;
}

console.log('end')