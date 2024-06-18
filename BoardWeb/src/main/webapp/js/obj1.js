/**
obj1.js
*/

document.getElementById('dom').remove();

const obj = {
	data:'',
	fields: ['id', 'first_name', 'email', 'salary'],
	
	showList: function(ary=[]){
		ary.forEach((emp,idx) => { //id list에 목록 출력
			if(idx<3)
			document.querySelector('#list').appendChild(this.makeRow(emp));
		});
	}, //end of showList 메소드
	//한건한건 tr 생성
	makeRow(emp = {id, first_name, email, salary}){
		let tr = document.createElement('tr');
		this.fields.forEach(field => {
			let td = document.createElement('td');
			td.innerHTML = emp[field]; //유동적인 변수값을 가져오기 위함
			tr.appendChild(td);
		});
		return tr;
	} //end of makeRow 메소드
	

} //end of obj


	/*
	
	//객체명.키값;
	//객체명[키값]; -> 가변적인 값을 가져올 수 있다.
	
	let prop = 'age';
	
	person.prop; //변수 처리가 불가능 (유동적인 값을 가져올 수 없다)
	person[prop]; //변수 처리가 가능 (유동적인 값을 가져올 수 있다)
		
	*/
	

obj.showList(employees);


//추가 버튼 클릭 시 몰곡 출력
document.querySelector('#addBtn').addEventListener('click', function(e){
	//사용자의 입력값을 받을 emp객체 생성
	const emp = {id : document.getElementById('empno').value,
				first_name : document.getElementById('empname').value,
				email : document.getElementById('email').value,
				salary: document.getElementById('salary').value
				}
	
	//목록에 추가하기			
	document.querySelector('#list').appendChild(obj.makeRow(emp));
	
});


/*

//obj.makeRow 의 매개값으로 obj전달 (객체타입을 전달)
//obj 의 필드값으로는 배열을 전달해줘야한다
//추가 버튼에 클릭이벤트, obj.makeRow로 실행


	//추가 버튼 클릭 시 목록에 출력(이벤트 핸들러 등록)
	document.querySelector('#addBtn').addEventListener('click', employeeList);
	
	
	//이벤트 처리 함수
	function employeeList(){
		
		const id = document.getElementById('empno').value
		const firstname = document.getElementById('empname').value
		const email = document.getElementById('email').value
		const salary = document.getElementById('salary').value
		fields : ['id', 'firstname', 'email', 'salary'],
		
	}


*/

//------------------

const today = new Date();

	//2024-06-19
	//prototype : 생성자 함수로 생성된 객체가 공통으로 가지는 공간
	
Date.prototype.format = function(){
	let yy = this.getFullYear();
	let mon = this.getMonth() + 1;
	let dd = this.getDate();
	
	return yy+'-'+mon+'-'+dd;
	
}

console.log(today.format());

