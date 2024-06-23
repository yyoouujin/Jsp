<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
    #centerList b {
        color: rgb(7, 228, 55);
    }
</style>
<!-- publicData.jsp -->
<h3>공공데이터 연습(publicData).</h3>
<!-- 검색조건 입력하고 목록에서 출력. -->
시도 검색:<input type="hidden" id="search" class="col-sm-6" placeholder="ex)'동구' 입력하고 검색하면 동구를 포함한 목록이 출력 ">
<button id="findBtn" style="display:none;">검색</button>

<select id="searchList" >
</select>
<p>sido 정보에서 중복된 값을 제거해서 위 option태그를 생성하고 검색하기.</p>

<table class="table">
    <thead>
        <tr>
            <th>센터id</th>
            <th>센터명</th>
            <th>연락처</th>
            <th>주소</th>
        </tr>
    </thead>
    <tbody id="centerList"></tbody>
</table>

<script src="js/public_교수님.js"></script>