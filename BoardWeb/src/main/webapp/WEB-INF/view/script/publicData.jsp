<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- publicData.jsp -->
<h3>공공데이터 연습.</h3>
<!-- 검색조건 입력하고 목록에서 출력. -->
 <input type="text" id="search" placeholder="주소 검색 ex)동구" ><button id="findBtn">검색</button>

 
<!-- sido 정보에서 중복된 값을 제거해서 위 option 태그를 생성하고 검색하기 -->
 <select id="searchList">
 	<!-- 
    <option value="서울">서울</option>
    <option value="인천">인천</option>
    <option value="대전">대전</option>
     -->
 </select>
 
 <button id="centerDB">센터DB생성</button>

<table class="table">
    <thead>
        <tr>
            <th>센터id</th>
            <th>센터명</th>
            <th>연락처</th>
            <th>주소</th>
        </tr>
    </thead>
    <tbody id="centerList">

    </tbody>

</table>

<script src="js/public.js">
</script>
