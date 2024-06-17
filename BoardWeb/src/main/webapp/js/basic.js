/**
 * 
 */


	//DOM연습 (DOM : 문서객체모델)
	//https://poiemaweb.com/js-dom
	document.querySelector('ul#fruit>li').innerHTML = '사과';
	
	
	//DOM에서 노드 추가 및 생성
		//createElement(노드명) : 요소 노드 <li> 생성
	let li = document.createElement('li'); //<li></li>
	li.innerHTML = '<b>오렌지</b>' //<li><b>오렌지</b></li>
		//appendChild(자식노드) : 자식노드 연결 (부모 노드가 가지고있는 자식 노드 목록의 끝에 매개변수로 전달받은 노드 추가)
	document.querySelector('ul#fruit').appendChild(li);
		//remove() : 노드 삭제
	document.querySelector('ul#fruit>li').remove();
	
	//css속성에 접근 및 수정 : 요소명.style.속성명='속성값'
		//두단어 이상 속성명 수정 시 하이픈('-') 삭제 및 두번째 단어의 첫글짜는 대문자로! : backgroundColor
	document.querySelector('ul#fruit>li').style.backgroundColor='yellow';
	
	console.log(document.querySelectorAll('#fruit>li'));
	let lists = document.querySelectorAll('#fruit>li');
	
	for (let list of lists){
		//DOM을 활용하여 button태그 생성
		let btn = document.createElement('button');
		btn.innerText = '삭제' //<bttton>삭제</button>
		
		//DOM을 활용한 속성을 가져오거나 수정
			//setAttribute("속성명", "값") : 원하는 속성명으로 지정
				//값 = 'btn btn-primary' 은 startbootstrap을 사용하고있어서 사용가능!
		btn.setAttribute('class', 'btn btn-primary');
		
			//표준이벤트 처리
			//addEventListener(이벤트유형지정,이벤트처리 함수연결);
				//이벤트 유형 지정시 : on을 붙이지않고 사용 ex) 'click' 
		btn.addEventListener('click', function(){
			//btn.remove() : 버튼 자기자신을 지운다
			btn.parentElement.remove() //btn을 감싸는 부모노드인 li자체를 지운다
		});
		
		list.appendChild(btn); //자식노드 연결 (부모노드 li의 끝에 매개변수 btn 연결)
		//for문을 돌려 반복했기 때문에 모든 li 에 btn이 추가된다
	}
	
