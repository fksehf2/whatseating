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
        
    $(".modifyBtn").on("click",function(){
		$(".infoDisabled").removeAttr("disabled");
		$(this).css("display","none");
		$("#updateBtn").css("display","inline-block");
	});
	$(".updateBtn").on("click",function(){
		$(this).attr("type","submit");
	});
	
	$("#storeForm").on("submit",function(){
		$.ajax({
			type : "post",
			data : $("#storeForm").serialize(),
			datatype : "html",
			url : "storeModify",
			success : function(data){
				if(data == 1){
					console.log(data);
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
	
	$(".deleteBtn").on("click",function(){
		$(this).attr("type","submit");
		$("#storeForm").attr("action","storeDelete");
	});
	
});

