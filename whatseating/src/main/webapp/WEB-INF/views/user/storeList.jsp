<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StoreList</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
body
{
  margin: 0 auto;
  width: 70%;
}

h2 { text-align: center; }

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
.category{
	list-style: none;
    padding-left: 0px;
}
.page-ui{
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
<jsp:include page="../header.jsp" />
<form action="/user/storeList" method="GET"> 
	<section class="search section">
    	<div id="search_box">
        	<select class="form-select form-select-sm" name="condition" id="condition">
				<option value="all" selected >::::: 전체 :::::</option> 
				<option value="ST_NAME" ${condition eq 'ST_NAME' ? 'selected' : '' }>가게이름</option>
				<option value="ST_ADDRESSDETAIL" ${condition eq 'ST_ADDRESSDETAIL' ? 'selected' : '' }>주소</option>
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
        			<th style="visibility:hidden">매장코드</th>
	       	 		<th>매장이름</th>
	       	 		<th>소개</th>
					<th>오픈시간</th>
					<th>마감시간</th>
					<th>평점</th>
					<th>상세보기</th>
					
	       	 	</tr>	
      		</thead> 
      		<tbody>
      			<c:forEach items="${list}" var="str">
				   <tr>
					<td style="visibility:hidden">${str.ST_CODE}</td><td style="display:none;">
					<td><a class="btn btn-link" id="OpenModal" onclick="OpenModal()">${str.st_NAME}</a></td>
			       	<td>${str.ST_CONTENT}</td>
					<td>${str.ST_STARTTIME}</td>
			       	<td>${str.ST_ENDTIME}</td>
					<td>${str.ST_AVGSCORE }</td>
					<td><a class="btn btn-outline-warning btn-sm m-1" data-bs-toggle="modal" href="#exampleModalToggle" role="button">상세정보</a></td>
					</tr>
				</c:forEach>
		    </tbody>
		 </table>
		 
	<form action="/store/modal">
			<div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalToggleLabel">Modal 1</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			     
			      <ul> 
				 	<li>${detail.ST_NAME }</li>
				 </ul>
			      </div>
			      <div class="modal-footer">
			        <button class="btn btn-outline-success btn-sm m-1" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">예약하기</button>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalToggleLabel2">시간&인원을 선택하세요</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			      <div class="reserv_time">
			      	<label class="form-label" for="reserv-time">Choose your reservation date</label>
				  	<input type="date" name="date" min="2022-04-12" max="2030-12-31">
				  	<label class="form-label" for="reserv-time2">Choose your reservation time</label>
				  	<input type="time" step="3600000" />
			      </div> 
				  <div class="reserv_person">
					  <label for="reserv-person">예약인원</label>
					  <select class="form-select" aria-label="Default select example" name="RESERV_PERSON">
						  <option selected>인원선택</option>
						  <option value="1">1</option>
						  <option value="2">2</option>
						  <option value="3">3</option>
						  <option value="4">4</option>
						  <option value="4">4</option>
						</select>
				  </div>
			      </div>
			      <div class="modal-footer">
			      	<button class="btn btn-primary" data-bs-target="#exampleModalToggle" data-bs-toggle="modal">Back to 1111</button>
			        <button class="btn btn-primary" data-bs-target="#exampleModalToggle3" data-bs-toggle="modal">33333</button>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="modal fade" id="exampleModalToggle3" aria-hidden="true" aria-labelledby="exampleModalToggleLabel3" tabindex="-1">
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalToggleLabel3">Modal 33333</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
				 	33333
			      </div>
			      <div class="modal-footer">
			        <button class="btn btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">Back to 2222</button>
			         <button class="btn btn-primary" data-bs-target="#exampleModalToggle4" data-bs-toggle="modal">44444</button>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="modal fade" id="exampleModalToggle4" aria-hidden="true" aria-labelledby="exampleModalToggleLabel4" tabindex="-1">
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalToggleLabel4">Modal 44444</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
				 	44444
			      </div>
			      <div class="modal-footer">
			        <button class="btn btn-primary" data-bs-target="#exampleModalToggle3" data-bs-toggle="modal">Back to 3333</button>
			         <button class="btn btn-primary" data-bs-target="#exampleModalToggle4" data-bs-toggle="modal">5555</button>
			      </div>
			    </div>
			  </div>
			</div>
	</form>
				<!-- 페이징 -->
				<div class ="page-ui">
				<c:if test="${startPageNum ne 1 }">
					<a href="storeList?pageNum=${startPageNum-1 }&condition=${condition }&keyword=${encodedK }"></a>&nbsp;
	            </c:if>
	            <c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
                  <c:choose>
                      <c:when test="${pageNum eq i }">
	           		 	<a href="storeList.do?pageNum=${i }&condition=${condition }&keyword=${encodedK }">${i }</a>&nbsp;
	           		 </c:when>	 
	           		 <c:otherwise>
	           			 <a href="storeList.do?pageNum=${i }&condition=${condition }&keyword=${encodedK }">${i }</a>&nbsp;
	         		</c:otherwise>	 
	         	  </c:choose>
               </c:forEach>
                    <c:if test="${endPageNum lt totalPageCount }">
	          		 <a href="storeList.do?pageNum=${endPageNum+1 }&condition=${condition }&keyword=${encodedK }"></a>
	             	</c:if>
	           </div>	
</body>
<script>

</script>

</html>
