$(function(){
   $("#id").on("focusin",function(){
 			$(this).css({
 	 			"border":"2px solid #C6F1E7"});
 	 		$(".changedetailid").css({
 	 			"color": "#8BF7AF",
 	 			"font-size": "10pt",
 	 			"top":"-10px",
 	 			"background-color": "white",
 	 			"width": "77px",
 	 			"padding-right": "0px",
 	 			"transition" : ".5s"
 	 		});
    });
		
	$("#id").on("focusout",function(){
		if($(this).val() != null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailid").css({
	 			"color": "#5f6368",
	 			"font-size": "10pt",
	 			"top":"-10px",
	 			"background-color": "white",
	 			"width": "77px",
	 			"padding-right": "0px",
	 			"transition" : ".5s"
	 		});
		}
		else if($(this).val() == null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailid").css({
				"top": "11px",
		        "left": "11px",
		        "color": "#5f6368",
		        "width": "86px",
		        "padding": "0 5px",
		        "font-size":"11pt"
				});
		}
   });
		
	
	$("#pw").on("focusin",function(){
 		$(this).css({
 			"border":"2px solid #C6F1E7"});
 		$(".changedetailpw").css({
 			"color": "#8BF7AF",
 			"font-size": "10pt",
 			"top":"-10px",
 			"background-color": "white",
 			"width": "90px",
 			"padding-right": "0px",
 			"transition" : ".5s"
 		});
 	});
	
	$("#pw").on("focusout",function(){
		if($("#pw").val() != null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailpw").css({
	 			"color": "#5f6368",
	 			"font-size": "10pt",
	 			"top":"-10px",
	 			"background-color": "white",
	 			"width": "90px",
	 			"padding-right": "0px",
	 			"transition" : ".5s"
	 		});
		}
		else if($("#pw").val() == null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailpw").css({
				"top": "11px",
		        "left": "11px",
		        "color": "#5f6368",
		        "width": "95px",
		        "padding": "0 5px",
		        "font-size":"11pt"
				});
		}
   });
	
	
	$("#pwck").on("focusin",function(){
 		$(this).css({
 			"border":"2px solid #C6F1E7"});
 		$(".changedetailpw2").css({
 			"color": "#8BF7AF",
 			"font-size": "10pt",
 			"top":"-10px",
 			"background-color": "white",
 			"width": "90px",
 			"padding-right": "0px",
 			"transition" : ".5s"
 		});
 	});
	
	$("#pwck").on("focusout",function(){
		if($("#pwck").val() != null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailpw2").css({
	 			"color": "#5f6368",
	 			"font-size": "10pt",
	 			"top":"-10px",
	 			"background-color": "white",
	 			"width": "90px",
	 			"padding-right": "0px",
	 			"transition" : ".5s"
	 		});
		}
		else if($("#pwck").val() == null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailpw2").css({
				"top": "11px",
		        "left": "11px",
		        "color": "#5f6368",
		        "width": "95px",
		        "padding": "0 5px",
		        "font-size":"11pt"
				});
		}
   });
	
	$("#name").on("focusin",function(){
 		$(this).css({
 			"border":"2px solid #C6F1E7"});
 		$(".changedetailname").css({
 			"color": "#8BF7AF",
 			"font-size": "10pt",
 			"top":"-10px",
 			"background-color": "white",
 			"width": "65px",
 			"padding-right": "0px",
 			"transition" : ".5s"
 		});
 	});
	
	$("#name").on("focusout",function(){
		if($("#name").val() != null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailname").css({
	 			"color": "#5f6368",
	 			"font-size": "10pt",
	 			"top":"-10px",
	 			"background-color": "white",
	 			"width": "65px",
	 			"padding-right": "0px",
	 			"transition" : ".5s"
	 		});
		}
		else if($("#name").val() == null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailname").css({
				"top": "11px",
		        "left": "11px",
		        "color": "#5f6368",
		        "width": "95px",
		        "padding": "0 5px",
		        "font-size":"11pt"
				});
		}
   });
	
	$("#nick").on("focusin",function(){
 		$(this).css({
 			"border":"2px solid #C6F1E7"});
 		$(".changedetailnick").css({
 			"color": "#8BF7AF",
 			"font-size": "10pt",
 			"top":"-10px",
 			"background-color": "white",
 			"width": "76px",
 			"padding-right": "0px",
 			"transition" : ".5s"
 		});
 	});
	
	$("#nick").on("focusout",function(){
		if($(this).val() != null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailnick").css({
	 			"color": "#5f6368",
	 			"font-size": "10pt",
	 			"top":"-10px",
	 			"background-color": "white",
	 			"width": "76px",
	 			"padding-right": "0px",
	 			"transition" : ".5s"
	 		});
		}
		else if($(this).val() == null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailnick").css({
				"top": "11px",
		        "left": "11px",
		        "color": "#5f6368",
		        "width": "86px",
		        "padding": "0 5px",
		        "font-size":"11pt"
				});
		}
   });
	
	$("#birth").on("focusin",function(){
 		$(this).css({
 			"border":"2px solid #C6F1E7"});
 		$(".changedetailbirth").css({
 			"color": "#8BF7AF",
 			"font-size": "10pt",
 			"top":"-10px",
 			"background-color": "white",
 			"width": "89px",
 			"padding-right": "0px",
 			"transition" : ".5s"
 		});
 	});
	
	$("#birth").on("focusout",function(){
		if($(this).val() != null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailbirth").css({
	 			"color": "#5f6368",
	 			"font-size": "10pt",
	 			"top":"-10px",
	 			"background-color": "white",
	 			"width": "89px",
	 			"padding-right": "0px",
	 			"transition" : ".5s"
	 		});
		}
		else if($(this).val() == null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailbirth").css({
				"top": "11px",
		        "left": "11px",
		        "color": "#5f6368",
		        "width": "86px",
		        "padding": "0 5px",
		        "font-size":"11pt"
				});
		}
   });
	
	$("#phno").on("focusin",function(){
 		$(this).css({
 			"border":"2px solid #C6F1E7"});
 		$(".changedetailph").css({
 			"color": "#8BF7AF",
 			"font-size": "10pt",
 			"top":"-10px",
 			"background-color": "white",
 			"width": "92px",
 			"padding-right": "0px",
 			"transition" : ".5s"
 		});
 	});
	
	$("#phno").on("focusout",function(){
		if($(this).val() != null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailph").css({
	 			"color": "#5f6368",
	 			"font-size": "10pt",
	 			"top":"-10px",
	 			"background-color": "white",
	 			"width": "90px",
	 			"padding-right": "0px",
	 			"transition" : ".5s"
	 		});
		}
		else if($(this).val() == null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changedetailph").css({
				"top": "11px",
		        "left": "11px",
		        "color": "#5f6368",
		        "width": "89px",
		        "padding": "0 5px",
		        "font-size":"11pt"
				});
		}
   });
	
	$("#email1").on("focusout",function(){
		if($(this).val() != null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changeemaildetail").css({
	 			"color": "#5f6368",
	 			"font-size": "10pt",
	 			"top":"-10px",
	 			"background-color": "white",
	 			"width": "78px",
	 			"padding-right": "0px",
	 			"transition" : ".5s"
	 		});
		}
		else if($(this).val() == null){
			$(this).css({
				"border":"1px solid #A6A6A6"
		     });
			$(".changeemaildetail").css({
				"top": "11px",
		        "left": "11px",
		        "color": "#5f6368",
		        "width": "86px",
		        "padding": "0 5px",
		        "font-size":"11pt"
				});
		}
   });
	
	$("#email1").on("focusin",function(){
 		$(this).css({
 			"border":"2px solid #C6F1E7"});
 		$(".changeemaildetail").css({
 			"color": "#8BF7AF",
 			"font-size": "10pt",
 			"top":"-10px",
 			"background-color": "white",
 			"width": "78px",
 			"padding-right": "0px",
 			"transition" : ".5s"
 		});
 	});
	
	$("#emailinput2").on("focusin",function(){
 		$(this).css({
 			"border":"2px solid #C6F1E7",
 		});
 	});
	
	$("#emailinput2").on("focusout",function(){
		$(this).css({
		"border":"1px solid #A6A6A6",
     });
	});
	
	/*아이디 중복 체크*/
	$("#id2").on("click",function(){
		var id = $("#id").val();
		var idLength = $("#id").val().length;
		
		if(id == ""){
			$(".iddetail").html("아이디를 입력해주세요.");
			$(".iddetail").attr("style","color:#e52528;");
		} else if(idLength < 8){
			$(".iddetail").html("숫자 포함한 영문자 8자 이상으로 아이디를 만들어주세요.");
			$(".iddetail").attr("style","color:#e52528;");
		} else{
			$.ajax({
				type:"post",
				url:"iddbCheck",
				data:{id:id},
				success:function(result){  // 계속 '실패' 오작동이 됨 
				console.log(result.idCheck);
					if(result.idCheck == 1){
						$(".iddetail").html("사용할 수 없는 아이디 입니다.");
						$(".iddetail").attr("style","color:#e52528;");
					} else if(result.idCheck == 0) {
						$(".iddetail").html("사용할 수 있는 아이디 입니다.");
						$(".iddetail").attr("style","color:#1a73e8;");
					} 
				},
				error:function(result){
					alert("에러");
				}
				
			});
		}
	});
	/*비밀번호 체크*/
	$("#pw").on("keyup",function(){
		var pw = $("#pw").val();
		var id = $("#id").val();
		
		if(pw == id){
			$(".pwdetail").html("아이디와 동일한 비밀번호는 사용할 수 없습니다.");
			$(".pwdetail").attr("style","color:#e52528;");
		}
	});
	
	$("#pwck").on("keyup",function(){
		var pw = $("#pw").val();
		var pwck = $("#pwck").val();
		console.log(pw);
		console.log(pwck);
		
		if(pw != pwck){
			$(".pwdetail2").html("비밀번호가 일치하지 않습니다.");
			$(".pwdetail2").attr("style","color:#e52528;");
		} else if(pw == pwck){
			$(".pwdetail2").html("비밀번호가 일치합니다.");
			$(".pwdetail2").attr("style","color:#1a73e8;");
		}
	});
	
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
});

