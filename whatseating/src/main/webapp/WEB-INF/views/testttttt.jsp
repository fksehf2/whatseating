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

<a class="btn btn-outline-dark btn-sm m-1" id="storeList">가게보기222</a>

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
      				</table>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
// json 형식으로 데이터 set
var params = {
          name      : $("#name").val()
        , sex       : $("#sex").val()
        , age       : $("#age").val()
        , tellPh    : $("#tellPh").val()
}
    
// ajax 통신
$.ajax({
    type : "POST",            // HTTP method type(GET, POST) 형식이다.
    url : "/test/ajax",      // 컨트롤러에서 대기중인 URL 주소이다.
    data : params,            // Json 형식의 데이터이다.
    success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
        // 응답코드 > 0000
        alert(res.code);
    },
    error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
        alert("통신 실패.")
    }
});
});

</script>

</body>
</html>
