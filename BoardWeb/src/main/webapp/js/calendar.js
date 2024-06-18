/**
 calendar.js
 */

 document.querySelectorAll('.container-fluid h3')//NodeList
 	.forEach(item => item.remove());
 //querySelectorAll는 NodeList타입반환
 //forEach 사용가능
 document.querySelectorAll('.table').forEach(item => item.remove());
 	
 document.querySelectorAll('#fruit').forEach(item => item.remove());
 //화살표함수는 이름이 없는 익명함수 사용
 //화살표 함수는 자신만의 this가 없기 때문에 간단하게 배열을 순회할 때 사용하면 좋다 (this는 querySelectorAll로 가져온 애 자체가 된다)
 
 /*
 //화살표 함수
 const add = function(a,b){
	return a+b;
 }
 const add = (a,b) => {
	return a+b;
 }
 const add = (a,b) => a+b;
 //익명함수 : 이름이 없는 함수, 함수를 변수에 할당하거나, 다른함수의 매개변수로 사용
 
 */



//월을 변경하면 달ㄹ력을 출력하는 이벤트를 등록 (selectMonth)
document.querySelector('select#selectMonth').addEventListener('change', function(){
	makeCalendar(parseInt(this.value)); //select 태그 내 value 속성을 정수값으로 변경해준다 (문자 -> 숫자)
});




 //달력만들기
 	//첫째날 계산하는 함수
 	//마지막날 계산하는 함수


//1)첫째날 계산하는 함수
 function getFirstDay(month = 6){ //매개변수의 값을 고정시켜줌 (month = 6)
	
	//월 정보를 넣어주면 시작날짜의 위치를 리턴(매개변수의 값을 유동적으로 바꿔줌 switch문)
	switch(month){
		case 5 :
			return 4;
		case 7 :
			return 2;
	}

	return 7;
 }
 

 
 //2)마지막날 계산하는 함수
  function getLastDay(month = 6){
	
	//월 정보를 넣어주면 마지막날짜의 위치를 리턴
	switch(month){
		case 5 :
		case 7 :
			return 31;
	}

	return 30;
 }
 
 
 //3)달력만들기
   function makeCalendar(month = 6){
	let firstDate = getFirstDay(month); //1일의 위치를 지정하기 위해서 공란의 갯수를 반환.
	let lastDate = getLastDay(month); //마지막날의 위치를 지정하기 위해
	document.getElementById('show').innerHTML = " ";
	
	//table생성. border = "2"
	let tbl = document.createElement('table'); //<table></table>생성 
	//tbl.setAttribute('border', '2'); //DOM을 활용해서 만들어줌
	tbl.setAttribute('class', 'table');
	let thd = document.createElement('thead'); //<thead></thead>생성
	let tbd = document.createElement('tbody'); //<tbody></tbody>생성
	
	//thead 하위요소
	let days = ['Sun', 'Mon', 'Tue', 'Wed','Tur', 'Fri', 'Sat'];
	let tr = document.createElement('tr');
	days.forEach(day => {
		let td = document.createElement('th'); //배열을 순회하며 <th></th>생성
		td.innerHTML = day;
		tr.appendChild(td);
		
	})
	thd.appendChild(tr);
	//thead작업끝
	
	
	
	//tbody 하위요소 
	tr = document.createElement('tr');
	//빈날짜. 
	for(let i=1; i<getFirstDay(month); i++){
		let td = document.createElement('td'); 
		tr.appendChild(td); //tr의 자식으로 td 붙여주기
	}
	//날짜 출력 부분
	for(let d = 1; d <= getLastDay(month); d++ ){
		let td = document.createElement('td'); 
		td.innerHTML = d;
		tr.appendChild(td);
	
		 //7일마다 줄바꿈.
		if((d+getFirstDay(month) -1) % 7 == 0 ){
			tbd.appendChild(tr);
			tr = document.createElement('tr');
		}
		``
		
		//토요일은 배경색 파란색
		if((d+getFirstDay(month) -1) % 7 == 0){
			td.style.color = 'blue';
		} else if ((d+getFirstDay(month) -1) % 7 == 1) {
			td.style.color = 'red';
		}
		
		
		
	}
	tbd.appendChild(tr);
	

	tbl.appendChild(thd);
	tbl.appendChild(tbd);
	
	document.getElementById('show').appendChild(tbl);
	 
 } //end of makeCalendar메소드
 

 makeCalendar(7);
 //js.jsp에 지정한 id= show 위치 하위에 tbl을 보여줌 
 
 
 
 

	