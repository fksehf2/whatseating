<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<style>
body
{
  margin: 0 auto;
  width: 70%;
}

h2 { text-align: center; }

.info{
	display: flex;
	justify-content: center;
	align-items: center;
}

#search_box{
	display: flex;
	justify-content: center;
	align-items: center;
	margin-left: -10px;
	width: 20%;
}
.search{
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
<h2>오늘 뭐 먹지?</h2>
</br>	
		<c:if test="${ not empty sessionScope.id }">
			<p class="info">
				<a class="btn btn-link">${sessionScope.id }</a>님 로그인중..
			    <a class="btn btn-outline-success btn-sm m-1" href="${pageContext.request.contextPath}/users/info.do">예약정보 </a> 
				<a class="btn btn-outline-dark btn-sm m-1" href="${pageContext.request.contextPath}/users/info.do">회원정보</a> 
				<a class="btn btn-outline-dark btn-sm m-1" href="${pageContext.request.contextPath}/store/test">가게보기</a>
				<a class="btn btn-outline-dark btn-sm m-1" id="storeList">가게보기222</a>
				<a class="btn btn-danger btn-sm m-2" id="logoutBtn" onclick="logout();">로그아웃</a>
			</p>
			<form action="/store/test" method="GET"> 
     			<section class="search section">
                 	<div id="search_box">
                 		<select class="form-select form-select-sm" name="condition" id="condition">
							<option value="all" selected >::::: 전체 :::::</option> 
							<option value="ST_NAME" ${condition eq 'ST_NAME' ? 'selected' : '' }>가게이름</option>
						</select>
					</div>
                     <div class="search">
                    		 <input type="text" id="keyword" name="keyword" placeholder="검색어..." value="${keyword }"/>
                     </div>
                     <div class="search_btn">
                             <button class="btn btn-primary btn-sm" type="submit" name="search" id="search_btn">검색</button>
                     </div>        
            	</section>
			</form> 
			 	<table class= "table">
					<thead>
        				<tr>
			       	 		<th scope="col">매장코드</th>
			       	 		<th scope="col">매장이름</th>
			       	 		<th scope="col">소개</th>
			       	 		<th scope="col">주소</th>
			       	 		<th scope="col">전화번호</th>
							<th scope="col">오픈시간</th>
							<th scope="col">마감시간</th>
							<th scope="col">평점</th>
	       	 			</tr>	
      				</thead>
      				<tbody>
      					<%@ include file="store/test2.jsp" %>
      				</tbody>
      			</table>
		</c:if>
<script>
function logout(){
    $.ajax({
        type:"POST",
        url:"/logout.do",
        success:function(data){
            //alert("로그아웃 성공");
        	document.location.reload();  
        } 
    }); // ajax 
}; 

const storeList=document.querySelector('#storeList');
storeList.addEventListener('click', ()=>{
	$.ajax({
		type: "get",
		url : 'api/list', //불러올 list
		dataType : "json",
		//data : data /*data속성 : data-> 서버로 보낼 데이터*/
		success:function()/*서버가 나에게 응답해준 데이터*/ {
		console.log(data);
		for(var i in data){
			console.log(data[i]);
			var table="<tr>";
			table += "<td>"+data[i].ST_CODE+"</td>";
			table += "<td>"+data[i].ST_NAME+"</td>";
			table += "<td>"+data[i].ST_CONTENT+"</td>";
			table += "<td>"+data[i].ST_ADDRESSBASIC+""+data[i].ST_ADDRESSDETAIL+
			"+data[i].ST_ADDRESSEXTRA"+"</td>";
			table += "<td>"+data[i].ST_PHNO+"</td>";
			table += "<td>"+data[i].ST_STARTTIME+"</td>";
			table += "<td>"+data[i].ST_ENDTIME+"</td>";
			table += "<td>"+data[i].ST_AVGSCORE+"</td>";
			table += "</tr>";
	
			$('table').append(table);
		}
		},
		//실패시
		error : function(){
			console.log("실패ㅠㅠ");
		}
	});
});
</script>