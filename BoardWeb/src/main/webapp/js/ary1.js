/**
 ary1.js
 forEach, filter, map, reduce
 */





//1) forEach : 배열의 모든 요소를 순환하는 배열 전용 메서드 (매개값으로함수가 온다.)

	const numAry = [23,17,5,41,30,12];
	let result = 0;
	
	/*
	numAry.forEach(function(elem, idx, ary){
		console.log(elem, idx, ary);
		if(elem%2==0){
			result+=elem;
		}
		
	}); 
	*/
	
	//forEach : 자신을 호출한 배열을 순회하는 고차함수 
	
	
	//함수를 따로 선언 후 매개값으로 선언된 함수를 넣어줘도된다
	let evenSum = function(elem, idx, ary){
		console.log(elem, idx, ary);
		if(elem%2==0){
			result+=elem;
		}
	}
	numAry.forEach(evenSum);
	console.log('짝수의 합은 : ',result);
	
	
	result = 0;
	
	let oddSum = function(elem, idx, ary){
		if(idx%2==0){ //index는 0부터 시작하니까!
			result+=elem;
		}	
	}
	numAry.forEach(oddSum);
	console.log('홀수번쨰의 합은 : ',result);
	
	
	
	result = 0;
	
	//35보다 작은 값들의 합을 저장.
	let less35 = function(elem, idx, ary){
		if(elem<35){
			result+=elem;
		}
	}
	numAry.forEach(less35);
	console.log('35보다 작은 값들의 합은 : ' + result);
	
	
	
	
	

	const dupAry = [10,27,32,55,27,10];
	const ary = [];
		//indexOf메소드 : 검색된 요소의 인덱스를 리턴해준다 없으면 -1리턴
		//ex) dupAry.indexOf(10) = 1;
		//(*중복된 요소가 여러개일시 첫번쨰 인덱스만 반환해준다!)
		//dupAry.indexOf(elem) -> 해당 요소 전체를 검색
		
	//중복된 값을 제거 후 새로운 배열에 담아주기
	dupAry.forEach(function(elem){
		
		if(dupAry.indexOf(elem)!=1){
			ary.push(elem);
		}
		
	});
	
	console.log('중복된 값을 제거한 배열',ary);