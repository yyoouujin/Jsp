<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});

	
      
      //axaj호출. url:centerChart.do
      let centerAry = [];
      centerAry.push(['시도명', '센터갯수']);
      
      fetch('centerChart.do')
      .then(result =>  result.json())
      .then(result => {
    	  console.log(result);
    	  /*
	    	  	result가 객체로(centerMap으로) 출력될 때 사용(CenterChart 클래스 참고) : Map 타입
	    	  	for in 반복문(key, value값이 있을때 사용)
	    	  	객체의 value값을 얻으려면 obj[key] 로 객체를 순회하여 얻을 수 있다
    	  for(let prop in result){ //for in : 객체의 속성에 접근해서 반복
    		  centerAry.push([prop, result[prop]]);
    	  }
    	  */
    	  
    	  	//result가 배열로(result으로) 출력될 때 사용(CenterChart 클래스 참고) : List타입
    	  result.forEach(center => {
    		  centerAry.push([center.sido, center.cnt]);
    	  })
    	  google.charts.setOnLoadCallback(drawChart); //비동기처리의순서(fetch문 내에 있어야한다)
      });
          
      


      
      
      function drawChart() {
    	  console.log(centerAry.length);
		//[{},{},{}...] => [[],[],[]...]
		 var data = google.visualization.arrayToDataTable(centerAry);
		 
		/*
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work',     11],
          ['Eat',      2],
          ['Commute',  2],
          ['Watch TV', 2],
          ['Sleep',    7]
        ]);
		*/

        var options = {
          //title: 'My Daily Activities'
          title: '시도별 센터갯수'
        	  
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>