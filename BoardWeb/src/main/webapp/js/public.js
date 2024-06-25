/**
public.js
*/

let url = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=76%2Fl7QiHLm%2B8Ur0Tf9Kmcoo3lGICCj0YZGsMjNPeJYTByPkqReYP%2B9YyQrL9ilZl1AXomyHqTo7t8%2BVs0ii%2FZw%3D%3D";
const target = document.querySelector('#centerList');



/*
const xhtp = new XMLHttpRequest();
xhtp.open('get', url);
xhtp.send();
xhtp.onload = function() {
	let data = JSON.parse(xhtp.responseText);
	console.log(data);
}
*/

/*
fetch(url)
.then(function(result){ //이전에 처리된 결괏값을 then 메소드로 다시 받을 수 있다
	return result.json()
})
.then(function (result) { //바로 위의 return result.json() -> 요건 해당 then메소드의 매개값(result)으로 들어간다
	console.log(result.data);
})
*/

/*
fetch(url)
.then(result => result.json()) // [{"id":1, "center":..},{},{}] -> [{},{}] 
.then(result => { 
	//console.log(result.data);
	result.data.forEach(center => console.log(center));
})
*/

// fetch(url)
// .then(result => result.json()) // [{"id":1, "center":..},{},{}] -> [{},{}] (JSON문자열 -> 객체로 변경)
// .then(result => { //객체로 변환된 result
// 	console.log(result.data);
// 	result.data.forEach(center =>{
// 		target.appendChild(makeRow(center));
// 	});
// });

fetch(url).then(result => result.json()).then(result => {
	console.log('객체는 이렇게 생겼어요');
	console.log(result.data);
	console.log('객체 확인용');
})


// 1) 목록 출력하기
const fields = ['id', 'centerName', 'phoneNumber', 'address'];

function makeRow(center = {}) {
	let tr = document.createElement('tr');
	
	//5) tr클릭 시 맵 정보 출력
	tr.addEventListener('click', function(){
		//location.href = "map.do?x="+center.lat+"&y="+center.lng;
		window.open("map.do?x="+center.lat+"&y="+center.lng+"&cnm="+center.centerName.replace('코로나19',' '));
		
	});
	
	fields.forEach((field, index) => {
		let td = document.createElement('td');
		td.innerHTML = center[field];
		tr.appendChild(td);
	});
	return tr;
}


// 3-2) 셀렉트박스 (sido 이름으로 만들어주기)
let selectBox = document.querySelector('#searchList');

// 시도 문자열을 담을 배열 arr 생성
// 데이터의 시도를 전부 확인해서 arr에 없으면 arr.push();
// arr => ['서울', '인천', '대구']
function makeSelectBox () {

	fetch(url)
	.then(responseText => responseText.json())
	.then(result => {
		let sidoArr = [];
		result.data.forEach(center => {
			//console.log(sidoArr);
			if(sidoArr.indexOf(center.sido) == -1) { //sidoArr에 없으면 추가!
				sidoArr.push(center.sido);
				let option = document.createElement('option');
				option.setAttribute('value', center.sido);
				option.innerHTML = center.sido;
				selectBox.appendChild(option);
			}
		});
		
	}).catch(err => console.log(err));
	// return option; -> 이미 다 됐ㅇ기때문에 필요 x
}

makeSelectBox();



/*
// 2) 주소검색 기능

document.querySelector('#findBtn').addEventListener('click', findAddress);

function findAddress() {
	let searchBox = document.querySelector('#search').value; //검색하고자하는내용
	target.innerHTML=''; //tbody내의 값들을 다 지워줌
	fetch(url).
	then(result => result.json()).
	then(result => {
		//result.data -> 이게 객체임, 
		result.data.forEach(center => {
			if(center.address.indexOf(searchBox)!=-1){ //검색내용이 존재하지 않으면 의 반대
				target.appendChild(makeRow(center));
			}
		});
		//document.querySelector('#search').value = ''; //검색부분을 지워줌
	});

}
*/




// 3) 셀렉트박스 선택 주소 검색기능


document.querySelector('#searchList').addEventListener('change', findSelectAddress);

function findSelectAddress() {
	let selectAddress = document.querySelector('#searchList').value;
	fetch(url).
	then(result => result.json()).
	then(result => {
		target.innerHTML='';
		result.data.forEach(center => {
			if(center.sido.indexOf(selectAddress)!=-1){
				target.appendChild(makeRow(center));
			}
		});
	});
}




// 4) 주소검색 기능 심화

document.querySelector('#findBtn').addEventListener('click', findAddress);


function findAddress() {
	let searchBox = document.querySelector('#search').value; //검색하고자하는내용
	let selectAddress = document.querySelector('#searchList').value; //셀렉트박스의값
	target.innerHTML=''; //tbody내의 값들을 다 지워줌
	fetch(url).
	then(result => result.json()).
	then(result => {
		//result.data -> 이게 객체임, 
		result.data.forEach(center => {
			if(center.address.indexOf(searchBox)!=-1){ //검색내용이 존재하지 않으면 의 반대
				if(center.sido.indexOf(selectAddress)!=-1){ //
					target.appendChild(makeRow(center));
				}
			}
		});
		//document.querySelector('#search').value = ''; //검색부분을 지워줌
	});

}



//------------------- [promise 객체]

//6) 센터정보 생성. (JSON데이터 업로드 : https://developer.mozilla.org/ko/docs/Web/API/Fetch_API/Using_Fetch#json_%EB%8D%B0%EC%9D%B4%ED%84%B0_%EC%97%85%EB%A1%9C%EB%93%9C)
document.getElementById('centerDB').addEventListener('click', createCenterInfo);


function createCenterInfo() {
	//1.openAPI호출.(fetch사용)
		//fetch는 promise타입으로 결과를 반환해줌, 그래서 then메소드 사용이 가능하다
	fetch(url)
	.then(result => result.json())
	.then(result => {
		let centers = result.data; //배열의 형태(객체) [{},{},...] => JSON문자열 타입으로 변환 [{"id":"yujin",...}]
		return fetch('centerInfo.do', {//전달해야하는값까지기재
			method: 'post',//전달내용이 많을 때 post 사용, 전달되는 값이 body영역에 저장 ('get'방식은 헤드에 저장)
			headers: {'Content-Type': "application/json"}, //"application/x-www", -> 키=값&키=값
			body: JSON.stringify(centers) //객체->JSON문자열
		})
	})
	.then(result => result.json())
	.then(result => {
		console.log(result);
		if(result.txnCnt > 0){
			alert(result.txnCnt + '건 처리 성공');
		} else {
			alert('실패');
		}
	})
	.catch(err => console.log(err));
	//2.컨트롤 호출 DB입력.
	
}


