$(function(){
   $("#id").on("focusin",function(){
 			$(this).css({
 	 			"border":"2px solid #C6F1E7"});
 	 		$(".changedetailid").css({
 	 			"color": "#8BF7AF",
 	 			"font-size": "10pt",
 	 			"top":"-10px",
 	 			"background-color": "white",
 	 			"width": "76px",
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
	 			"width": "76px",
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
 			"width": "89px",
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
	 			"width": "89px",
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
 			"width": "89px",
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
	 			"width": "89px",
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
 			"width": "89px",
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
	 			"width": "89px",
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
		        "width": "86px",
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
	 			"width": "76px",
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
 			"width": "76px",
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
	
	/*????????? ?????? ??????*/
	$("#id2").on("click",function(){
		var id = $("#id").val();
		var idLength = $("#id").val().length;
		
		if(id == ""){
			$(".iddetail").html("???????????? ??????????????????.");
			$(".iddetail").attr("style","color:#e52528;");
		} else if(idLength < 8){
			$(".iddetail").html("?????? ????????? ????????? 8??? ???????????? ???????????? ??????????????????.");
			$(".iddetail").attr("style","color:#e52528;");
		} else{
			$.ajax({
				type:"post",
				url:"iddbCheck",
				data:{id:id},
				success:function(result){  // ?????? '??????' ???????????? ??? 
					if(result.idCheck == 1){
						$(".iddetail").html("????????? ??? ?????? ????????? ?????????.");
						$(".iddetail").attr("style","color:#e52528;");
					} else if(result.idCheck == 0) {
						$(".iddetail").html("????????? ??? ?????? ????????? ?????????.");
						$(".iddetail").attr("style","color:#1a73e8;");
					} 
				},
				error:function(result){
					alert("??????");
				}
				
			});
		}
	});
	/*???????????? ??????*/
	$("#pw").on("keyup",function(){
		var pw = $("#pw").val();
		var id = $("#id").val();
		
		if(pw == id){
			$(".pwdetail").html("???????????? ????????? ??????????????? ????????? ??? ????????????.");
			$(".pwdetail").attr("style","color:#e52528;");
		}
	});
	
	$("#pwck").on("keyup",function(){
		var pw = $("#pw").val();
		var pwck = $("#pwck").val();
		console.log(pw);
		console.log(pwck);
		
		if(pw != pwck){
			$(".pwdetail2").html("??????????????? ???????????? ????????????.");
			$(".pwdetail2").attr("style","color:#e52528;");
		} else if(pw == pwck){
			$(".pwdetail2").html("??????????????? ???????????????.");
			$(".pwdetail2").attr("style","color:#1a73e8;");
		}
	});
	
	function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // ???????????? ???????????? ????????? ??????????????? ????????? ????????? ???????????? ??????.

                // ??? ????????? ?????? ????????? ?????? ????????? ????????????.
                // ???????????? ????????? ?????? ?????? ????????? ??????('')?????? ????????????, ?????? ???????????? ?????? ??????.
                var addr = ''; // ?????? ??????
                var extraAddr = ''; // ???????????? ??????

                //???????????? ????????? ?????? ????????? ?????? ?????? ?????? ?????? ????????????.
                if (data.userSelectedType === 'R') { // ???????????? ????????? ????????? ???????????? ??????
                    addr = data.roadAddress;
                } else { // ???????????? ?????? ????????? ???????????? ??????(J)
                    addr = data.jibunAddress;
                }

                // ???????????? ????????? ????????? ????????? ???????????? ??????????????? ????????????.
                if(data.userSelectedType === 'R'){
                    // ??????????????? ?????? ?????? ????????????. (???????????? ??????)
                    // ???????????? ?????? ????????? ????????? "???/???/???"??? ?????????.
                    if(data.bname !== '' && /[???|???|???]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // ???????????? ??????, ??????????????? ?????? ????????????.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // ????????? ??????????????? ?????? ??????, ???????????? ????????? ?????? ???????????? ?????????.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // ????????? ??????????????? ?????? ????????? ?????????.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // ??????????????? ?????? ????????? ?????? ????????? ?????????.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // ????????? ???????????? ????????? ????????????.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
});

