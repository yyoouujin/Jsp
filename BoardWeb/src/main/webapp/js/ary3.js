/**
 ary3.js
 */


//4) reduce()
//acc : 그 다음 실행의 초기값으로 쓰여짐 (초깃값 설정이 가능하다)
//리턴값을 그 다음실행의 초가값으로 쓴다 (초깃값 설정이 가능하다)
//초기값을 배열로설정이 가능하다

//elem : 요소 ,idx : 인덱스번호 ,ary : 배열
//배열에 정의된 갯수만큼 함수를 실행 (약속)
let sum =
	[10, 20, 30, 40, 50].reduce(function(acc, elem, idx, ary) {
		console.log(acc, elem, idx, ary);
		if (elem > 25) {
			acc.push(elem);
		}
		return acc;
	}, []);

console.log('결과 : ', sum, "배열길이는:", sum.length);


//제일 큰 값을 sum2라는 변수에다가 담기!

let sum2 = 0;
[10, 20, 30, 40, 50].reduce(function(acc, elem, idx, ary) {
	console.log(acc, elem, idx, ary);
	if (acc < elem) {
		return sum2 = elem;
	}
}, 0);

console.log('가장 큰 숫자 : ', sum2);


/*
[교수님 방법]
let sum2 = 
[10,20,30,40,50].reduce(function(acc,elem,idx,ary){
	console.log(acc,elem,idx,ary);
	if(acc>elem){
		return acc;
	}
	return elem;
}, 0);

console.log('가장 큰 숫자 : ', sum2);

*/

/*
[윤경민 방법]
let sum2 = 0;
[10,20,30,40,50].reduce(function(acc,elem,idx,ary){
	console.log(acc,elem,idx,ary);
	if(acc>elem){
		acc.push(ele);
	}
	return ele;
}, 0);
	
*/


let sum3 =
	[10, 20, 30, 40, 50].reduce(function(acc, elem, idx, ary) {
		console.log(acc, elem);
		if (acc < elem) {
			return acc;
		}
		return elem;
	}, 0);

console.log("가장작은숫자:", sum3);


//let result =
	['Sun', 'Mon', 'Tue', 'Wed', 'Thr'].reduce(function(acc, elem) {

		let li = document.createElement('li');
		li.innerHTML = elem;
		acc.appendChild(li);

		return acc;
	}, document.getElementById('fruit'));

