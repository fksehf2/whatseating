$(function(){
	// 모달창 열고 닫기
    $("#detailInfo").click(function() {
        $('#detailModal').show();
        });
    //팝업 Close 기능
    $("#detail_close").click(function() {
        $('#detailModal').hide();
        });
   
    $("#replyInfo").click(function() {
        $('#replyModal').show();
        });
        //팝업 Close 기능
    $("#reply_close").click(function() {
        $('#replyModal').hide();
        });
    $("#menuInfo").click(function() {
        $('#menuModal').show();
        });
        //팝업 Close 기능
    $("#menu_close").click(function() {
        $('#menuModal').hide();
        });
        
    //매장 추가 모달
    $("#storeAddBtn").click(function() {
        $('#storeAddModal').show();
        });
        //팝업 Close 기능
    $("#storeAdd_close").click(function() {
        $('#storeAddModal').hide();
        });
    
    //수정 버튼이 눌리면 수정 완료 버튼 활성화되고 disabled가 풀림
    $(".modifyBtn").on("click",function(){
		$(".infoDisabled").removeAttr("disabled");
		$(this).css("display","none");
		$("#updateBtn").css("display","inline-block");
	});
	
	$("#storeForm").on("submit",function(){
		$.ajax({
			type : "post",
			data : $("#storeForm").serialize(),
			datatype : "html",
			url : "storeModify",
			success : function(data){
				if(data == 1){
					$(".infoDisabled").attr("disabled", "disabled");
					$(".modifyBtn").css("display","inline-block");
					$("#updateBtn").css("display","none");
					
				}
			}, error : function(data){
				 alert("매장 수정 실패");
			}
			
		});
		event.preventDefault();
		
	});
	
	//매장 추가 submit
	$("#storeRegisterBtn").on("click",function(){
		$.ajax({
			url : "storeRegister",
			data : $("#storeAddForm").serialize(),
			type : "post",
			success : function(data){
				if(data.insertResult == 1){
					location.href="main";
				} else {
					alert("매장 등록 실패");
				}
			}, error : function(){
				alert("매장 등록 에러");
			}
			
		});
	});
	
	
	//메뉴 등록, 사진 업로드 관련
	
	var fileCount = 0;
	var totalCount = 5;
	var contents_file = Array();
	
	//파일 고유 넘버
	var fileNum = 0;
	
	
	$("#uploadBtn").on("click", function(){
		event.preventDefault();
		$("#real-uploadBtn").click();
	});
	
	$("#real-uploadBtn").on("change",function(){
		var files = $(this)[0].files;
		var filesArr = Array.prototype.slice.call(files);
		filesArr.forEach(function(file){
			var reader = new FileReader();
			reader.onload = function(){  //파일을 다 읽었다면
				contents_file.push(file);
				$(".show-uploadFile").append(
					'<div id="file' + fileNum + '" onclick="fileDelete(\'file' + fileNum + '\')">'
       		+ '<font style="font-size:15px">' + file.name + '</font>'  
       		+ '<img src="/img/icon_minus.png" style="width:20px; height:auto; vertical-align: middle; cursor: pointer;"/>' 
       		+ '<div/>'
				);
				fileNum++;
			};
			 reader.readAsDataURL(file);  //파일의 데이터 url을 문자열로 반환해줌
		});
		$("#real-uploadBtn").val("");
	});
	
	
	
	$("#uploadSubmit").on("click",function(){
		
		//메뉴 등록 창 유효성 검사
		var menu_name = $("#MENU_NAME").val();
		var menu_price = $("#MENU_PRICE").val();
		var menu_content = $("#MENU_CONTENT").val();
		var menu_file = $("#real-uploadBtn")[0].files;
		
		if(menu_name == ""){
			alert("메뉴명을 입력해주세요.");
			return false;
		} else if(menu_price == ""){
			alert("메뉴 가격을 입력해주세요.");
			return false;
		} else if(menu_content == ""){
			alert("메뉴 가격을 입력해주세요.");
			return false;
		} else if(menu_file == ""){ 
			alert("메뉴 사진을 1개이상 등록해주세요.");
			return false;
		}
		
		var formData = new FormData($("#menuForm")[0]);
		
		//이미지 배열을 담아 추가할 수 있도록 함
		for(var i = 0; i<contents_file.length; i++){
			
			//다른 내용들도 append해줘야 할듯
			formData.append("image" , contents_file[i]);
		}
		
		//파일 먼저 등록 여부 확인
		//값이 들어 가는데 406에러가 뜸  //dependency로 해결
		$.ajax({
			type : "post",
			data : formData,
			url : "menu/savePic",
			enctype : "multipart/form-data",
			dataType : "json",
			contentType : false,
			processData : false,
			success : function(data){
				alert("메뉴가 등록되었습니다.");
				// 사진 등록이 완료가 되면 db 등록이 될 수 있도록 함
				$("#menu_close").click();
				$("#menuForm input").val("");
				$("#menuForm textarea").val("");
				$("#menuForm input[type='file']").val("");
			},
			error : function(data){
				alert("메뉴 등록 실패");
			}
		});
	});
	
	
	
	/*var fileCount = 0;
	var totalCount = 10;
	
	//파일 고유 넘버
	var fileNum = 0;
	var content_files = new Array();
	
	$("#real-uploadBtn").on("change",function(){
		var files = $(this)[0].files;  //[0]을 붙이는건지?
		console.log(files);
		//파일 배열 담기
		var filesArr = Array.prototype.slice.call(files); //오브젝트 타입의 값을 배열로 바꿀 필요가 있을 떄
		
		//파일 개수 확인 및 제한
		if(fileCount + filesArr.length > totalCount){
			alert("파일은 최대"+totalCount+"개까지만 업로드 할 수 있습니다.");
		} else {
			fileCount = fileCount + filesArr.length;
		}
		
		//각각의 파일 배열담기
		filesArr.forEach(function(file){
			var reader = new FileReader();
			reader.onload = function(){  //파일을 다 읽었다면
				content_files.push(file);
				$(".show-uploadFile").append(
					'<div id="file' + fileNum + '" onclick="fileDelete(\'file' + fileNum + '\')">'
       		+ '<font style="font-size:12px">' + file.name + '</font>'  
       		+ '<img src="/img/icon_minus.png" style="width:20px; height:auto; vertical-align: middle; cursor: pointer;"/>' 
       		+ '<div/>'
				);
				fileNum++;
			};
			 reader.readAsDataURL(file);  //파일의 데이터 url을 문자열로 반환해줌
		});
		console.log(content_files);
		
		//다 작업이 끝났다면 초기화를 해준다.
		$("#real-uploadBtn").val("");
	});
	
	//파일 부분 삭제
	function fileDelete(fileNum){
		var no = fileNum.replace(/^0-9/g,""); //파일 num만 남도록 함
		content_files[no].is_delete = true;  //해당 num의 배열을 삭제함
		$("#"+fileNum).remove();
		fileCount--;
		console.log(content_files);
	}
	
	$("#uploadBtn").on("click", function(){
		event.preventDefault();
		$("#real-uploadBtn").click();
	});
	
		//폼 submit 시, 처리 내용
		
		$("#menuForm").on("submit",function(){
		
		var form = $("#menuForm")[0];
		console.log(form);
		//ajax를 통해 form데이터를 보낼 때 formData를 사용함
		//컨트롤러 단에서 키,밸류값으로 가져올 수 있도록 함
		var formData = new FormData(form);
		console.log(formData);
		
		for(var i = 0; i<content_files.length; i++){
			
			//is_delete 메소드의 정확한 의미를 모르겠음
			if(!content_files[i].is_delete){
				formData.append("article_file",content_files[i]);
			}
		}
		console.log(formData);
		
		//파일 업로드 ajax
		//url 쪽으로 넘어가버림...ajax로 보내면서 문제가 생기는 듯
		$.ajax({
			type : "post",
			url : "menu/menuRegister",
			data : formData,
			//entype : "multipart/form-data",
			success : function(data){
				if(data == 1){
					alert("파일 업로드 성공");
				} else {
					alert("파일 업로드가 되지 않았습니다")
				}
			},
			error : function(xhr, status, error, data){
				console.log(data);
				console.log(error);
				alert("서버 오류로 인한 파일 업로드 실패");
				return false;
			}
			
		});
		//스크립트 상의 동작 , 
		//event.preventDefault();
		//정상적으로 업로가 되지 않았을 때 리턴시킴
		return false;
	});
	
	$("#car").change(function(){
		console.log($(this).val());
	});*/
	
	
	//달 변화에 따라 일이 바뀔 수 있도록 설정
	/*$("#monthSelect").on("change",function(){
		$("#daySelect option").forEach(function(){
			if($("#monthSelect").val() == 2){
				for(var i = 29; i<32; i++){
					$("#daySelect option[value='i']").css("display","none");
				}
			} else if ($(this).val() == 4 || $(this).val() == 6 || $(this).val() == 9 || $(this).val() == 11){
				$("#daySelect option").css("display","inherit");
				$("#daySelect option[value='31']").css("display","none");
			} else {
				$("#daySelect option").css("display","inherit");
			}
		});
		
		
		
	});*/
	
});

