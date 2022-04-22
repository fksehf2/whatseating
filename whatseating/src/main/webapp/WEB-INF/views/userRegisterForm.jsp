<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/layout/home.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/userRegisterForm.css">
<script src="${pageContext.request.contextPath}/resources/js/userRegisterForm.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>오늘 뭐 먹지? 회원가입</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<!-- body -->
	<div class="middle-content">
	<div class="gaiptop">
		<p class="main">기본정보</p>
		<hr class="line1">
		<hr class="line2">
	</div>
	<form name="myform" action="userRegister" method="post" onsubmit="return chkform();" id="userForm">
		<div class="gaipsection">
			<div class="gaipmiddle">
				<div class="idbox" id="idbox">
					<!--------------아이디 ------------>
					<div class="inputbox" id="idinput">
						<input type="text" name="CUST_ID" size="25" maxlength="15"
							class="textbox" id="id">
						<div class="changedetailid">아이디 입력</div>
					</div>
					<div>
						<input id="id2" type="button" name="id2" value="중복 확인">
					</div>
				</div>
				<div class="iddetail"></div>

				<div class="pwbox">
					<!---------------비밀번호 ------------>
					<div class="inputbox" id="pwinput">
						<input type="password" name="CUST_PW" size="25" maxlength="15"
							class="textbox" id="pw">
						<div class="changedetailpw">비밀번호 입력</div>
					</div>
				</div>
				<div class="pwdetail"></div>

				<div class="pwbox1">
					<!---------------비밀번호 확인 ------------>
					<div class="inputbox" id="pwinput2">
						<input type="password" name="CUST_PW2" size="25" maxlength="15"
							class="textbox" id="pwck">
						<div class="changedetailpw2">비밀번호 확인</div>
					</div>
				</div>
				<div class="pwdetail2"></div>

				<div class="namebox">
					<!---------------이름 ------------>
					<div class="inputbox" id="nameinput">
						<input type="text" name="CUST_NAME" size="25" maxlength="15"
							class="textbox" id="name">
						<div class="changedetailname">이름 입력</div>
					</div>
				</div>

				<div class="gendertitle">성별 선택</div>
				<!---------성별 ------->
				<div class="genderbox">
					<input class="gender_input" type="radio" name="CUST_GENDER" checked="on"
						value="남자" id="gender1"> <label class="gender_label"
						for="gender1">남자</label> <input class="gender_input" type="radio"
						name="CUST_GENDER" value="여자" id="gender2"> <label
						class="gender_label" for="gender2">여자</label>
				</div>

				<div class="phbox">
					<!---------------전화번호 ---------------->
					<div class="inputbox" id="phinput">
						<input type="text" name="CUST_PHNO" class="textbox" id="phno">
						<div class="changedetailph">전화번호 입력</div>
					</div>
				</div>
				<div class="phdetail">'-'을 제외하고 입력해주세요 ex) 01012345678</div>

				<div class="emailbox">
					<!---------------이메일 ---------------->
					<div class="emailinputbox" id="emailinput">
						<input type="text" name="CUST_EMAIL" class="textbox" id="email1">
						<div class="changeemaildetail">이메일 입력</div>
					</div>
					<div id="golbang">@</div>
					<select name="CUST_EMAIL2" class="textbox" id="emailinput2">
						<option>메일주소선택</option>
						<option>naver.com</option>
						<option>gmail.com</option>
						<option>hanmail.net</option>
						<option>yahoo.co.kr</option>
						<option>직접입력</option>
					</select>
				</div>
				<div class="emaildetail">이메일이 제대로 입력되지 않았습니다.</div>

				<div class="adrtul">
					<!---------------주소---------------->
					<div class="adrtitle">주소 찾기</div>
					<div class="adrbox">
							<input type="text" name="CUST_ADDRESSNO" id="sample6_postcode" placeholder="우편번호" class="textbox address1">
							<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
							<input type="text" name="CUST_ADDRESSBASIC" id="sample6_address" placeholder="주소" class="textbox address2"><br>
							<input type="text" name="CUST_ADDRESSDETAIL" id="sample6_detailAddress" placeholder="상세주소" class="textbox address3">
							<input type="text" name="CUST_ADDRESSEXTRA" id="sample6_extraAddress" placeholder="참고항목" class="textbox address4">
					</div>
				</div>

				<div class="susintitle">이용 서비스 선택</div>
				<!---------------이용 서비스 방법---------------->
				<div class="susinbox">
					<label for="type1">
						<input type="radio" name="CUST_TYPE" value="회원" id="type1">회원
					</label>
					<label for="type2">
						<input type="radio" name="CUST_TYPE" value="점주" id="type2">점주
					</label>
				</div>
				<div class="gaipbtn">
					<input type="submit" name="gaipbtn" value="회원가입" class="btn1"
						id="gaipbtn1">
				</div>
			</div>
		</div>
	</form>
	</div>
</body>


<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
//주소 api 스크립트
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}

/*유효성 검사*/
function chkform(){
	var userForm = true;
	var id = $("#id").val();
	var pw = $("#pw").val();
	var num = pw.search(/[0-9]/g);  //숫자가 있는지 검색
	var eng = pw.search(/[a-z]/ig);  //영문자가 있는지 검색
	var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi); //특수 문자가 있는지 검색
	var pw2 = $("#pwck").val();
	var name = $("#name").val();
	var phno = $("#phno").val();
	var email = $("#email1").val();
	var email2 = $("#emailinput2").val();
	var address1 = $(".address1").val();
	var address2 = $(".address2").val();
	var address3 = $(".address3").val();
	var service = $("input[name=CUST_TYPE]").val();
	var type1 = $("#type1").val();
	var type2 = $("#type2").val();
	
	if(id == "" || id.length < 10 || id.length > 21){
		alert("11~20 사이로 아이디를 만들어주세요.");
		$("#id").focus();
		return false;
	} else if(pw == "" || pw.length < 10 || pw.length > 21){
		alert("11~20 사이로 비밀번호를 만들어주세요.");
		$("#pw").focus();
		return false;
	} else if(num < 0 && eng < 0 || eng < 0 && spe < 0 || num < 0 && spe < 0){
		alert("영문, 숫자 특수문자 중 2가지 이상을 혼합하여 입력해주세요");
		$("#pw").focus();
		return false;
	} else if(pw != pw2){
		alert("비밀번호가 맞지 않습니다.");
		$("#pw2").focus();
		return false;
	} else if(email == "" || email2 == ""){
		alert("이메일을 제대로 입력해주세요.");
		$("#email").focus();
		return false;
	} else if(address1 == "" || address2 == "" || address3 == ""){
		alert("입력되지 않은 주소가 있습니다.");
		$(".address1").focus();
		return false;
	} else {
		//로그인 페이지로 돌아가 재로그인 할 수 있도록 함
		location.href="";
	}
}


</script>
</html>