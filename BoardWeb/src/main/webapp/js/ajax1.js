/**
ajax1.js
비동기 방식 처리
*/
	
	//setTimeout() : 윈도우가 가진 메소드
	//첫번째 매개값으로 실행할 함수, 두번째 매개값으론 지연시간을 받음
setTimeout(function() {
	console.log("1번");
}, 1000);

setTimeout(function() {
	console.log("2번");
}, 2000);

setTimeout(function() {
	console.log("3번");
}, 3000);

console.log("end");