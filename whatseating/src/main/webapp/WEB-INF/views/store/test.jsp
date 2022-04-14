<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StoreList</title>
<link rel="stylesheet" href="../resources/css/home.css"> 
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
</style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
</br>
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
	 <%@ include file="100.jsp" %>
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
      			<c:forEach items="${list}" var="str">
				   <tr>
						<td>${str.ST_CODE}</td>
						<td>${str.ST_NAME}</td>
			       	 	<td>${str.ST_CONTENT}</td>
			       	 	<td>${str.ST_ADDRESSBASIC}${str.ST_ADDRESSDETAIL}${str.ST_ADDRESSEXTRA}</td>
						<td>${str.ST_PHNO}</td>
						<td>${str.ST_STARTTIME}</td>
			       	 	<td>${str.ST_ENDTIME}</td>
						<td>${str.ST_AVGSCORE}</td>
					</tr>
				</c:forEach>
      			</tbody>
      			</table>
				<!-- 페이징 -->
				<div class ="page-ui">
				<c:if test="${startPageNum ne 1 }">
					<a href="empList.do?pageNum=${startPageNum-1 }&condition=${condition }&keyword=${encodedK }"></a>&nbsp;
	            </c:if>
	            <c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
                  <c:choose>
                      <c:when test="${pageNum eq i }">
	           		 	<a href="test.do?pageNum=${i }&condition=${condition }&keyword=${encodedK }">${i }</a>&nbsp;
	           		 </c:when>	 
	           		 <c:otherwise>
	           			 <a href="test.do?pageNum=${i }&condition=${condition }&keyword=${encodedK }">${i }</a>&nbsp;
	         		</c:otherwise>	 
	         	  </c:choose>
               </c:forEach>
                    <c:if test="${endPageNum lt totalPageCount }">
	          		 <a href="test.do?pageNum=${endPageNum+1 }&condition=${condition }&keyword=${encodedK }"></a>
	             	</c:if>
	           </div>	
</body>
</html>
