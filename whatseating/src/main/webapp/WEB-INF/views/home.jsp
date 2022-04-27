<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
body
{
  margin: 0 auto;
  width: 70%;
} 
.mainImg { 
	padding-left: -180px;
	text-align: center;
	}
	
.info{
	display: flex;
	justify-content: center;
	align-items: center;
}	
	
</style>
</head>
<body>
<div class="mainImg">
	<img src="${pageContext.request.contextPath}/resources/img/main.png"/>
	<input type="hidden" name="ijs" value="${pageContext.request.contextPath}">
</div>
<br>
<p class="info">
<c:choose>
		<c:when test="${ empty sessionScope.CUST_ID}">
			<a class="btn btn-sm btn btn-outline-secondary" id="logBtn" href="/user/loginform">로그인</a>
			<a class="btn btn-sm btn btn-outline-secondary " href="/customer/registerForm">회원가입</a>
		</c:when>
		<c:otherwise>
			<p class="info">
				<a href="${pageContext.request.contextPath}/userDetail.do">${sessionScope.CUST_ID }</a> 로그인중... 
				<a class="btn btn-danger btn-sm m-2" id="logoutBtn" onclick="logout();">로그아웃</a>
			
		</c:otherwise>
	</c:choose>
</p>	
</body>
<script>
console.log(${sessionScope.CUST_ID });
function logout(){
    $.ajax({
        type:"POST",
        url:"/logout.do",
        success:function(data){
            //alert("로그아웃 성공");
        	
        } 
    }); // ajax 
}; 
</script>
</html>
