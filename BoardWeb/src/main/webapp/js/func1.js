/*
 func1.js
 함수정의문.
 
 */
function sum(a = 0,b = 0) {
	
	/*
	if(b=undifined){
		return a;
	}
	*/
	return a+b;
	
}

//함수표현식 
sum = function sum(a=0,b=0){
	return a+b;
}
console.log(sum);//함수의 정의구문 출력
console.log(sum(30,40)); //70 값을 보고싶을 땐 함수를 호출! ()붙여서


//--------------
let result = sum(10,20); //30
result = sum(10);
//NaN (정의되지 않은 값은 null 또는 undefined로 대체)
//매개변수에 디폴트값 지정 가능
console.log('결과 : ' , result);

/*

const obj = {
	name: '홍길동',
	age:20,
	
}
*/


//객체 타입의 변수를 미리 지정해서 함수에 간단히 대입가능
let name ="홍길동";
let age=20;

const obj = {
	name,
	age
}

function showObj(obj = {name:'홍길순', age:25}){ //obj = {name:'홍길순', age:25}->매개변수의 값을 지정해둔다
	return obj.name + '-' + obj.age; //함수 내에서만 사용한 obj변수
	
}

console.log(showObj()); //지정해둔 초기값을 출력한다 (홍길순 25)
console.log(showObj(obj)); //오브젝트값이 들어간다 (홍길동 20)



function sumAry(ary=[]){
	let sum = 0;
	for(let i=0; i<ary.length; i++){
		sum += ary[i];
	}
	return sum;
}
result = sumAry([1,2,3,4,5]);

console.log('sumAry 결과 : ', result);



//매개값으로 받는 범위가 다양하다 (유연한언어 자바스크립트!)
//자바스크립트에서 함수의 매개값으론 어떤 유형이든지 들어올 수 있따
function showItem(item){ 
	let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Fri', 'Sat'];
	
	days.forEach(function(val){
		let span = document.createElement('span');
		span.innerHTML = val + " ";
		item.appendChild(span);
	});
	
	
}

showItem(document.getElementById('show'));
//js.jsp에 id값으로 show를 지정해둔 위치에 배열이 출력


//window 에 소속된 객체는 어디서든 사용가능 (전역변수)
//함수내에선언된 변수는 함수 내에서만 사용가능 (지역변수) 
//기존 변수를 잊고 새로운 변수를 덮어써도 오류가 생기지 않음 (var 선언) : undefined 의 값을 가질 수 있다
//그래서 let선언을 권장한다 (블록 영역 스코프 let, const)
console.log(window);

