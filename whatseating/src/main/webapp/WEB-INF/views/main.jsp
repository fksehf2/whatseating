<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<main>
            <div class="category" data-category="${st_code }">
                <ul>
                    <li data-category ='100' onclick="location.href='/store/100'"><span>한식</span></li>
                    <li data-category ='101' onclick="location.href='/store/101'"><span>양식</span></li>
                    <li data-category ='102' onclick="location.href='/store/102'"><span>중식</span></li>
                    <li data-category ='103' onclick="location.href='/store/103'"><span>일식</span></li>
                    <li data-category ='104' onclick="location.href='/store/104'"><span>패스트푸드</span></li>
                    <li data-category ='105' onclick="location.href='/store/105'"><span>카페/디저트</span></li>
                </ul>
            </div>
                
	<div class="box">
				<c:if test="${empty store }">
					<img class="temp_img" alt="이미지" src="/resources/img/temp2.png">
					<style>.box {background: #F6F6F6; height: 100%; }</style>
				</c:if>
				
			<ul class="store">
                	<c:set var="store_admin" value="/store" />
                	<c:forEach items="${storeList }" var="storeList">
  
                    </c:forEach>
                </ul>
</div>	
</main>
</body>
</html>
