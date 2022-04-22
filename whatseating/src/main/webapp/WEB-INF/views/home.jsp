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
} 
h2 { text-align: center; }

.member_login{
	display: flex;
	justify-content: center;
	align-items: center;
}

</style>
</head>
<body>
</br>
<%@ include file="header.jsp" %>

 	<c:if test="${ empty sessionScope.id }">
    <div class="member_login" >
        <form id="login_form" method="post" action="ajaxlogin.do">
        <c:choose>
			<c:when test="${ empty param.url }">
				<input type="hidden" name="url" value="${pageContext.request.contextPath}/"/>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="url" value="${param.url }"/>
			</c:otherwise>
		</c:choose>
		<%-- <%@ include file="store/test.jsp" %> --%>
        <div>
        <input type="radio" name="CUST_TYPE" value="customer" checked>
                              일반회원 
        <input type="radio" name="CUST_TYPE" value="owner">
                              점주
        </div>
        </br>
            <div>
            <input type="hidden" name="url" value="${url}"/>
            	<label class="control-label" for="id">id</label>	
                <input class="form-control" type="text" id="id" name="CUST_ID" placeholder="아이디" >
            </div>

            <div>
            	<label class="control-label" for="pwd">pw</label>	
                <input class="form-control" type="password" id="pw" name="CUST_PW" placeholder="비밀번호">
            </div>
            </br>
            <div class="find_password">
                <a href="/find_id_pw">아이디 또는 비밀번호를 잊으셨나요?</a>
            </div>
			</br>
			<button class="btn btn-sm btn btn-outline-secondary" id="logBtn">로그인</button>
			<a class="btn btn-sm btn btn-outline-secondary " href="/customer/registerForm">회원가입</a>
       </form>
    </div>                    
	</c:if>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script>
const logBtn=document.querySelector('#logBtn');
logBtn.addEventListener('click', ()=>{
	const id=document.querySelector("#id").value;
	const pw=document.querySelector("#pw").value;
	const type=document.querySelector('input[name="CUST_STATUS"]:checked').value;
	//console.log(type);
	const logData={"id":id, "pw":pw, "type":type};
	//console.log(logData);	
	$.ajax({
	        type:"POST", //url 정보가 보임
	        url:"/ajaxlogin.do",
	        /* data : JSON.stringfy(logData),
	        contentType : "application/json", */
	        success:function(){
	        	document.location.reload();
	        	}
	        }); 
        });
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
</script>

	
</html>
