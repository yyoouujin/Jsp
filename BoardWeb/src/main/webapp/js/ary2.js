/**
 ary2.js
 */

// 2)filter()
//리턴되는값을 새로운 배열에 담아줌
//특정 조건을 만족하는 요소 추출(새로운 배열을 생성해준다, 기존 배열은 유지)
//[A,A,A] -> [A,A]

	console.log(employees); //강력 새로고침 굿~
	 
	 let result = [23,45,22,39,10,56].filter(function(item,idx,ary){
		
		if(item % 2 ==0 ){
			return true;
			//return false;
			//true가 반환되는 값에 해당되는 아이템들을 반환
			//true 일 때 새로운 배열을 생성해준다, 기존 배열은 유지
			
		}
		
	 })
	 
	 console.log(result);
	 
	
	

	 
	
	 employees.forEach(console.log);
	 
	 
	 //급여가 5000이 넘는 여자만 필터링
	 
	 let over5000 = [];
	 let over5000Sum = 0;
	 //화살표함수로 사용
	 let filterFnc = emp => emp.gender == 'Female' && emp.salary > 5000;
	 over5000 = employees.filter(filterFnc);
	 console.log('over5000 사람들 목록 : ', over5000);
	 
	 /*
	  //함수를 선언하여 함수를 매개변수로 사용
	 filterFnc = function (emp){
		return emp.salary > 5000 && emp.gender == 'Female';
	 }) 
	  over5000 = employees.filter(filterFnc); //filterFnc라는 함수를 매개변수로 사용해준다
	 
	 
	 */
	//employees.filter(filterFnc).forEach(console.log);
	 employees.filter(filterFnc).forEach(function(emp){
		
		over5000Sum += emp.salary;
		//해당 배열의 요소값에 접근하기 위해서는 forEach로 순회 후 해당 배열에 접근 하여 필드명을 써줄 수 있다
		
	 });
	 
	console.log('조건만족사람들의 급여합계 : ', over5000Sum);
 

 
 
//3)map()
// map이 반환하는 형태는 배열, forEach로 접근가능
//[A,A,A] -> [A',A',A']
employees.map(function(elem,idx,ary){
	const obj ={}
	obj.name = elem.first_name + '-' + elem.last_name;
	obj.no = elem.id;
	obj.salary = elem.salary;
	return obj;
	
}).forEach(console.log);


