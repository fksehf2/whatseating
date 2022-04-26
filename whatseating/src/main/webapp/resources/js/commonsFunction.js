$(function(){
	//로그인 여부 체크
	$("#logBtn").on("click", function(){
		var id = $("#id").val();
		var pw = $("#pw").val();
		
		$.ajax({
			type : "post",
			data : {id : id, pw : pw},
			url : "customer/login",
			success : function(result){
				if(result.login == 1){
					alert("로그인 되었습니다.");
					sessionStorage.setItem("CUST_ID",id);
					//일반회원과 점주회원 구분
					$.ajax({
						type : "post",
						data : {id : id} ,
						url : "customer/typeCheck",
						success : function(data){
							if(data.typeCheck == "회원"){
								location.href = "home";
							} else {
								location.href = "/manager/store/main";
							}
						}, error : function(){
							alert("이용 서비스 확인 불가");
						}
					});
					
				} else if(result.login == -1) {
					alert("개인 정보가 맞지 않습니다.");
				} else {
					alert("해당하는 아이디가 없습니다.");
				}
				
			}, error : function(){
				alert("로그인 에러");
			}
		});
	});
	
	//로그아웃 기능
	$("#logoutBtn").on("click",function(){
		$.ajax({
			type : "post",
			url : "/customer/logoutFunction",
			success : function(data){
				if(data == 1){
					alert("로그아웃 성공");
					location.href="/home";
				}else{
					alert("로그아웃 실패");
				}
			},error : function(){
				alert("로그아웃 에러");
			}
		});
	});
	
	
	//개인 정보 수정 버튼이 눌리면 수정 완료 버튼 활성화되고 disabled가 풀림
    $("#accountModifyBtn").on("click",function(){
		$(".infoDisabled").removeAttr("disabled");
		$(this).css("display","none");
		$("#accountModifyCompleteBtn").css("display","inline-block");
		$("#gender-info, #type-info").css("display","none");
		$(".gender-frame, .type-frame").css("display","block");
	});
	
	$("#accountModifyCompleteBtn").on("click",function(){
		$.ajax({
			type : "post",
			data : $("#accountInfoForm").serialize(),
			url : "/customer/userModify",
			success : function(data){
				if(data.modifyResult == 1){
					$(".infoDisabled").attr("disabled", "disabled");
					$("#accountModifyBtn").css("display","inline-block");
					$("#accountModifyCompleteBtn").css("display","none");
					$("#gender-info, #type-info").css("display","block");
					$(".gender-frame, .type-frame").css("display","none");
					alert("개인정보 수정 완료");
					
					//일반회원과 점주회원을 다시한번 구분하여 회원으로 바뀌었을 경우, 
					//로그인페이지로 보냄
					$.ajax({
						type : "post",
						data : {id : sessionStorage.getItem("CUST_ID")} ,
						url : "/customer/typeCheck",
						success : function(data){
							if(data.typeCheck == "회원"){
								location.href = "home";
							} 
						}, error : function(){
							alert("이용 서비스 확인 불가");
						}
					});
					
				}else {
					alert("개인정보 수정 실패");
				}
			}, error : function(){
				 alert("개인정보 수정 에러");
			}
			
		});
	});
	
	//만약 세션 값이 있다면 아이디를 보여줄 수 있도록 한다.
	if(sessionStorage.getItem("CUST_ID") != null){
		$("#membershipInfo").html(sessionStorage.getItem("CUST_ID") +"님");
	}
	
	//아이디 값을 이용한 개인 정보를 가지고 올 수 있도록 함
	$("#membershipInfo").on("click",function(){
		$.ajax({
			type : "post",
			url : "/customer/userDetail",
			data : {id : sessionStorage.getItem("CUST_ID")},
			success : function(data){
				console.log(data);
					$("#accountInfoForm").find(".INFO_CUST_ID").html(data.accountDTO.cust_ID);
					$("#accountInfoForm").find("input[name='CUST_PW']").attr("value",data.accountDTO.cust_PW);
					$("#accountInfoForm").find("input[name='CUST_NAME']").attr("value",data.accountDTO.cust_NAME);
					$("#accountInfoForm").find("input[name='CUST_PHNO']").attr("value",data.accountDTO.cust_PHNO);
					$("#accountInfoForm").find("input[name='CUST_EMAIL']").attr("value",data.accountDTO.cust_EMAIL);
					$("#accountInfoForm").find("input[name='CUST_EMAIL2']").attr("value",data.accountDTO.cust_EMAIL2);
					$("#accountInfoForm").find("input[name='CUST_ADDRESSNO']").attr("value",data.accountDTO.cust_ADDRESSNO);
					$("#accountInfoForm").find("input[name='CUST_ADDRESSBASIC']").attr("value",data.accountDTO.cust_ADDRESSBASIC);
					$("#accountInfoForm").find("input[name='CUST_ADDRESSDETAIL']").attr("value",data.accountDTO.cust_ADDRESSDETAIL);
					$("#accountInfoForm").find("input[name='CUST_ADDRESSEXTRA']").attr("value",data.accountDTO.cust_ADDRESSEXTRA);
					$("#accountInfoForm").find("#gender-info").html(data.accountDTO.cust_GENDER);
					$("#accountInfoForm").find("#type-info").html(data.accountDTO.cust_TYPE);
				
			},error : function(){
				alert("개인정보 출력 에러");
			}
		});
	});
});