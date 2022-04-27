<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class="mainImg">
	<img src="${pageContext.request.contextPath}/resources/img/main.png"/>
	<input type="hidden" name="ijs" value="${pageContext.request.contextPath}">
</div>
<br>	
		<c:if test="${sessionScope.CUST_ID != null}">
			<p class="info">
				<a class="btn btn-link">${sessionScope.CUST_ID }</a>님 로그인중..
			    <a class="btn btn-outline-success btn-sm m-1" href="${pageContext.request.contextPath}/users/info.do">예약정보 </a> 
				<a class="btn btn-outline-dark btn-sm m-1" href="${pageContext.request.contextPath}/users/info.do">회원정보</a> 
<%-- 			<a class="btn btn-outline-dark btn-sm m-1" href="${pageContext.request.contextPath}/store/test">가게보기</a>
				<a class="btn btn-outline-dark btn-sm m-1" id="storeList" onclick="storeList();" >가게보기222</a> --%>
				<a class="btn btn-danger btn-sm m-2" id="logoutBtn" onclick="logout();">로그아웃</a>
			</p>
		</c:if>
<script>
function logout(){
    $.ajax({
        type:"POST",
        url:"/logout.do",
        success:function(data){
            //alert("로그아웃 성공");
        	location.href = '../home.do';
        } 
    }); // ajax 
}; 
</script>