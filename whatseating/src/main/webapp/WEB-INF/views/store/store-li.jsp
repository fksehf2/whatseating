<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <style> 
    th:nth-of-type(1) { display: none; }   
    td:nth-of-type(1) { display: none; }
    </style>
	 <table class="store">
       	 	<thead>
	       	 	<tr>
	       	 		<th>매장코드</th>
	       	 		<th>번호</th>
	       	 		<th>매장이름</th>
	       	 		<th>메뉴</th>
	       	 		<th>소개</th>
	       	 		<th>주소</th>
					<th>오픈시간</th>
					<th>마감시간</th>
					<th>평점</th>
	       	 	</tr>	
       	 	</thead>
       	 	<tbody>
			<c:choose> 
			<c:when test="${str.st_code eq '101' }">
				<tr>
					<td>${str.st_code}</td>
		       	 	<td>${str.num}</td>
					<td>${str.st_name}</td>
		       	 	<td>${str.st_menu}</td>
					<td>${str.st_content}</td>
		       	 	<td>${str.st_addressNo}</td>
					<td>${str.st_startTime}</td>
		       	 	<td>${str.st_endTime}</td>
					<td>${str.st_avgScore}</td>
				</tr>
			</c:when>
			<c:otherwise> 
					<tr> 
					<td colspan="4" >조회된 정보가 없습니다.</td> 
					</tr> 
					</c:otherwise> 
			</c:choose>
			</tbody>	
		</table>