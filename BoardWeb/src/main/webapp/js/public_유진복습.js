/**
public_유진복습.js
*/

let url = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=76%2Fl7QiHLm%2B8Ur0Tf9Kmcoo3lGICCj0YZGsMjNPeJYTByPkqReYP%2B9YyQrL9ilZl1AXomyHqTo7t8%2BVs0ii%2FZw%3D%3D";
const target = document.querySelector('#centerList'); //출력할 위치

/*
fetch(url)
.then(function(result){
	return result.json()
})
.then(function(result) {
	console.log(result.data);
})
*/

//1) url 객체 확인, fetch함수, then메소드 사용
fetch(url)
.then(result => result.json())
.then(result => {
	console.log('객체는 이렇게 생겼습니다')
	console.log(result.data);
	console.log('----------- 객체확인용 -----------');
})

//2) 목록출력함수 생성

const fields = ['id', 'centerName', 'phoneNumber', 'address'];

function makeRow(center){
	let tr = document.createElement('tr'); //<tr></tr>생성
	fields.forEach(field => { //요소들을 field라는 변수에 저장하며 배열순회
		let td = document.createElement('td');
		td.innerHTML = center[field];
		tr.appendChild(td);
	});
	return tr;
}

//3) 객체 생성 및 목록출력함수호출
fetch(url)
.then(result => result.json())
.then(result => {
	result.data.forEach(center => {
		target.appendChild(makeRow(center));
	});
})


//4)select box 생성 (sido이름기준으로)

let selectBox = document.querySelector('#searchList');

function makeSelectBox() {
	
	let sidoArr = [];
	
	fetch(url)
	.then(result => result.json())
	.then(result => {
		result.data.forEach(sidos => {
			if(sidoArr.indexOf(sidos.sido) == -1) { //sido가 없으면
				sidoArr.push(sidos.sido);
			}
		});
		//console.log(sidoArr);
		sidoArr.forEach(select =>{
			let option = document.createElement('option'); //<option></option>
			option.setAttribute('value', select);
			option.innerHTML = select;
			selectBox.appendChild(option);
		});
	});
	
}

makeSelectBox();



//4-2) selectBox로 주소출력 (sido로 찾기)

document.querySelector('#searchList').addEventListener('change', selectAddress);

function selectAddress() {
	
	let selectAddress = document.querySelector('#searchList').value;
	target.innerHTML = '';
	
	fetch(url)
	.then(result => result.json())
	.then(result => {
		result.data.forEach(address => {
			if (address.sido == selectAddress){
				
				target.appendChild(makeRow(address));
			}
		});
	});
	
}



//5) 주소검색
//(sido 선택 중에=selectBox선택결과 내에서, address에 해당 검색어가 포함되어있으면 출력)


document.querySelector('#findBtn').addEventListener('click', findAddress);

function findAddress() {
	
	let search = document.querySelector('#search').value; //검색어
	let select = document.querySelector('#searchList').value; //선택지역
	target.innerHTML = '';
	
	fetch(url)
	.then(result => result.json())
	.then(result => {
		
		result.data.forEach(center => {
			if (center.sido.indexOf(select)!=-1){ //해당 검색어가 있으면
				if(center.address.indexOf(search)!=-1){
					target.appendChild(makeRow(center));
				}
			}
		});
	});
	
}



