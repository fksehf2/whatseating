<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.info{
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
<h2>오늘 뭐 먹지?</h2>
 </br>
 <c:if test="${ not empty sessionScope.id }">
			<p class="info">
				<a class="btn btn-link">${sessionScope.id }</a>님 ..
			    <a class="btn btn-outline-success btn-sm m-1" href="${pageContext.request.contextPath}/users/info.do">예약정보 </a> 
				<a class="btn btn-outline-dark btn-sm m-1" href="${pageContext.request.contextPath}/users/info.do">회원정보</a> 
				<a class="btn btn-outline-dark btn-sm m-1" href="${pageContext.request.contextPath}/store/test.do">가게보기</a>
				<a class="btn btn-danger btn-sm m-2" id="logoutBtn" onclick="logout();">로그아웃</a>
			</p>
<%-- 			<c:choose>
			<c:when test="${member.status == customer }">
			<%@ include file="store/test.jsp" %>
			</c:when>
			<c:otherwise>
			ggggg
			</c:otherwise>
			</c:choose> --%>

</c:if>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script>
function logout(){
    $.ajax({
        type:"POST",
        url:"/logout.do",
        success:function(data){
            //alert("로그아웃 성공");
        	location.href="${pageContext.request.contextPath}/home.do"
        } 
    }); // ajax 
}; 
</script>