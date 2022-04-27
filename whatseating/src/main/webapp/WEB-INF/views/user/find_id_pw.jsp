<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디&비밀번호 찾기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
body
{
  margin: 0 auto;
  text-align: center;
}

h2 { 
	text-align: center;
	marign-top:15px;
 }

.form-check {
	display:inline-block;
}
.form {
	margin:0 auto;
	display:block;
	width:30%;
	justify-content: center;
	text-align: center;
 }
</style>
</head>
<body>
<br>
<h2> 아이디&비밀번호 찾기</h2>
<br>
<div class="box" style="margin-top:20px;">
			<div class="form-check">
					<input class="form-check-input" type="radio" value="0" id="user" name="user" onclick="check(1);" checked>
					<label class="form-check-label" for="findId">
					    아이디 찾기
					</label>
			</div>
			<div class="form-check">
				  <input class="form-check-input" type="radio" value="1" id="pw" name="user" onclick="check(2);">
				  <label class="form-check-label" for="findpw">
			    	비밀번호 찾기
			  	  </label>
		   </div>		     		
	<div class="form">	   
		<form action="/IdCheck" method="post">
		  	<div id="find_user">
			  	<input class="form-control" type="text" placeholder="핸드폰 번호를 입력하세요" id="CUST_PHNO" name="CUST_PHNO">
			  	<br>
			  	<button type="submit" id="submitId" class="btn btn-outline-info">아이디 찾기</button>
		 	 </div>
	  	</form>	
	 	 <div id="find_pw" style="display:none">
	 		 <form action="/PwChange" method="post">
	 		 	<input class="form-control" type="text" placeholder="아이디를 입력하세요" id="CUST_ID" name="CUST_ID">
	 	 		<input class="form-control" type="text" placeholder="이메일을 입력하세요" id="email" name="CUST_EMAIL">	
	  			<select class="form-select" aria-label="Default select example" name="CUST_EMAIL2">
				  <option selected>이메일 선택</option>
				  <option value="@gmail.com">@gmail.com</option>
				  <option value="@naver.com">@naver.com</option>
				  <option value="@yahoo.com">@yahoo.com</option>
				</select>
				<br>
				<button type="submit" id="submitEmail" class="btn btn-outline-info">비밀번호 찾기</button>
			</form>
		</div>
	</div>
</div>
</body>
<script> 
function check(num) {
	if (num == '1') {
		document.getElementById("find_pw").style.display = "none";
		document.getElementById("find_user").style.display = "";	
	} else {
		document.getElementById("find_user").style.display = "none";
		document.getElementById("find_pw").style.display = "";
	}
}
</script>
</html>
