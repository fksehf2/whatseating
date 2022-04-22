<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class="mainImg">
	<img src="resources/img/main.png"/>
</div>
<br>	
		<c:if test="${ not empty sessionScope.id }">
			<p class="info">
				<a class="btn btn-link">${sessionScope.id }</a>님 로그인중..
			    <a class="btn btn-outline-success btn-sm m-1" href="${pageContext.request.contextPath}/users/info.do">예약정보 </a> 
				<a class="btn btn-outline-dark btn-sm m-1" href="${pageContext.request.contextPath}/users/info.do">회원정보</a> 
				<a class="btn btn-outline-dark btn-sm m-1" href="${pageContext.request.contextPath}/store/test">가게보기</a>
				<a class="btn btn-outline-dark btn-sm m-1" id="storeList" onclick="storeList();" >가게보기222</a>
				<a class="btn btn-danger btn-sm m-2" id="logoutBtn" onclick="logout();">로그아웃</a>
			</p>
			<form action="/store/test" method="GET"> 
     			<section class="search section">
                 	<div id="search_box">
                 		<select class="form-select form-select-sm" name="condition" id="condition">
							<option value="all" selected >::::: 전체 :::::</option> 
							<option value="ST_NAME" ${condition eq 'ST_NAME' ? 'selected' : '' }>가게이름</option>
							<option value="ST_ADDRESSdetail2" ${condition eq 'ST_ADDRESSdetail2' ? 'selected' : '' }>주소</option>
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
			       	 		<th scope="col" style="display:none;">매장코드</th>
			       	 		<th scope="col">매장이름</th>
			       	 		<th scope="col">소개</th>
							<th scope="col">오픈시간</th>
							<th scope="col">마감시간</th>
							<th scope="col">평점</th>
							
	       	 			</tr>	
      				</thead>
      				<tbody class="data">
      					<%@ include file="store/test2.jsp" %>
      				</tbody>
      			</table>
		</c:if>
		<%@ include file="store/modal.jsp" %>
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

function storeList(){
	$.ajax({
		type: "get",
		url : 'api/list', //불러올 list
		//data : data /*data속성 : data-> 서버로 보낼 데이터*/
		success:function(list){/*서버가 나에게 응답해준 데이터*/
		//console.log(list);
		$('.data').empty();
		for(var i in list){
			//console.log(i);
			var table="<tr>";
			table += "<td style='display:none'>"+list[i].st_CODE+"</td>";
			table += "<td><button class='btn btn-link' id='OpenModal' onclick='OpenModal();'>"
				 +list[i].st_NAME+
				 "</button></td>";
			table += "<td>"+list[i].st_CONTENT+"</td>";
			//table += "<td>"+list[i].st_ADDRESSBASIC+"</td>";
			//table += "<td>"+list[i].st_PHNO+"</td>";
			table += "<td>"+list[i].st_STARTTIME+"</td>";
			table += "<td>"+list[i].st_ENDTIME+"</td>";
			table += "<td>"+list[i].st_AVGSCORE+"</td>";
			//table += "<td><button class='btn btn-outline-warning btn-sm'>가게상세보기</button></td>";
			table += "</tr>";
			
			$('table').append(table);
		}
		},
		//실패시
		error : function(){
			console.log("실패ㅠㅠ");
		}
	});
};
function OpenModal(){
	const modal =document.querySelector("#Modal");
	modal.click();
	$.ajax({
		type: "get",
		url : 'api/detail', //불러올 list
		//data : data /*data속성 : data-> 서버로 보낼 데이터*/
		success:function(detail){/*서버가 나에게 응답해준 데이터*/
			for(var i in detail){
				$("#exampleModalToggleLabel").html(detail[i].ST_NAME);
			}
			for(var i in detail){
			$("#store_name").html(detail.ST_NAME);
			$("#store_content").html(detail.ST_CONTENT);
			//$("#store_addr").html(detail.ST_ADDRESS);
			$('#store_menu').html(detail[i].MENU_NAME);
		};
		},
		//실패시
		error : function(){
			console.log("실패ㅠㅠ");
			}
	}); //AJAX 	
};

</script>