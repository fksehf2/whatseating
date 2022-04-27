<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>

body
{
  margin: 0 auto;
} 
h2 { text-align: center; }

.member_login{
	display: flex;
	justify-content: center;
	align-items: center;
}

.mainImg { 
	padding-left: -180px;
	text-align: center;
}
</style>
</head>
<body>
	<div class="mainImg">
	<img src="${pageContext.request.contextPath}/resources/img/main.png"/>
	<input type="hidden" name="ijs" value="${pageContext.request.contextPath}">
</div>
<br>
 <div class="member_login" >
      <form id="loginForm" method="post" action="loginck">
        <div>
        <input type="radio" name="CUST_TYPE" value="1" checked>
                              일반회원 
        <input type="radio" name="CUST_TYPE" value="2">
                              점주
        </div>
        <br>
        <div>
        	<label class="control-label" for="id">id</label>	
            <input class="form-control" type="text" id="CUST_ID" name="CUST_ID" placeholder="아이디" >
        </div>

        <div>
        	<label class="control-label" for="pwd">pw</label>	
            <input class="form-control" type="password" id="CUST_PW" name="CUST_PW" placeholder="비밀번호">
        </div>
        <br>
        <div class="find_password">
                <a href="find_id_pw">아이디 또는 비밀번호를 잊으셨나요?</a>
            </div>
			<br>
			<a class="btn btn-sm btn btn-outline-primary" id="logBtn" onclick="loginCk();">로그인</a>
			<a class="btn btn-sm btn btn-outline-secondary" href="${pageContext.request.contextPath}/users/signup_form.do">회원가입</a>
       </form>
       </div>
</body>
<script>
function loginCk(){
	params={
			CUST_ID : document.querySelector("#CUST_ID").value,
			CUST_PW : document.querySelector("#CUST_PW").value,
			CUST_TYPE :document.querySelector('input[name="CUST_TYPE"]:checked').value,
	}
     //var logData={"CUST_ID":CUST_ID, "CUST_PW":CUST_PW, "CUST_TYPE":CUST_TYPE};
     console.log(params);
     $.ajax({
		 type:"POST", //url 정보가 보임
		 url:"/user/loginck",
		 data : params,
		 dataType:"json",
		 success:function(jsonObj){
			 let{result} =jsonObj;
			 if(result === 'S'){
				 alert("로그인 성공");
				 location.href = 'storeList.do';
			 }else if(result === 'N'){
				 alert("아이디 혹은 비밀번호가 틀립니다.");
			 }else{
				 alert("실패");
				 document.location.reload();
			 }
		 },
	 }); 
 };

</script>
</html>