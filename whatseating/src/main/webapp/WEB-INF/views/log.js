
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