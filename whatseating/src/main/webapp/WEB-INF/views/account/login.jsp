<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

</style>
</head>
<body>
 <div class="member_login" >
 <c:choose>
		<c:when test="${empty sessionScope.CUST_ID}">
        <form id="loginFrm" name="loginFrm" action="loginCheck.do">
        <div>
        <input type="radio" name="CUST_STATUS" value="customer" checked>
                              일반회원 
        <input type="radio" name="CUST_STATUS" value="owner">
                              점주
        </div>
        <br>
            <div>
            <%-- <input type="hidden" name="url" value="${url}"/> --%>
            	<label class="control-label" for="id">id</label>	
                <input class="form-control" type="text" id="id" name="CUST_ID" placeholder="아이디" >
            </div>

            <div>
            	<label class="control-label" for="pwd">pw</label>	
                <input class="form-control" type="password" id="pw" name="CUST_PW" placeholder="비밀번호">
            </div>
            <br>
            <div class="find_password">
                <a href="/find_id_pw">아이디 또는 비밀번호를 잊으셨나요?</a>
            </div>
			<br>
			<c:if test="${msg == '실패'}">
							<tr>
								<td colspan=2>
									아이디 또는 패스워드가 틀렸습니다.
								</td>
							</tr>
						</c:if>
			<input type="button" id="login" value="로그인" />
			<a class="btn btn-sm btn btn-outline-secondary " href="${pageContext.request.contextPath}/users/signup_form.do">회원가입</a>
       </form>
  	</c:when>
			<c:otherwise>
				<h3>${sessionScope.CUST_ID}님 환영합니다.</h3>
				<a href="logout.do">로그아웃</a>
			</c:otherwise>
		</c:choose>     
		</div>               
</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(e){
	$('#login').click(function(){

		// 입력 값 체크
		if($.trim($('#id').val()) == ''){
			alert("아이디를 입력해 주세요.");
			$('#id').focus();
			return;
		}else if($.trim($('#pw').val()) == ''){
			alert("패스워드를 입력해 주세요.");
			$('#pw').focus();
			return;
		}
		
		//전송
		$('#loginFrm').submit();
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
</body>
</html>