<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/layout/nav.css">
<link rel="stylesheet" href="resources/css/home.css">
<style>
.category{
	list-style: none;
    padding-left: 0px;
}
</style>
	<title>Home</title>
</head>
<body>
 <div class="wrap">
        <main>
            <section class="address_search">
                 <div id="search_box">
                     <div>
                         <input type="hidden" id="deleveryAddress1" placeholder="우편번호" value="${BMaddress.address1 }" name="address1" readonly>
                         <input type="text" value="${BMaddress.address2 }"
                             id="deleveryAddress2" readonly placeholder="주소를 입력해 주세요" name="address2"><br>
                     </div>
 
                     <div class="search_btn">
                         <label for="search_btn">
                             <i class="fas fa-search"></i>
                         </label>
 
                         <input type="button" name="search" id="search_btn">
 
                     </div>
 
                 </div>
            </section>
            <section class="category_box">
                <div class="box">
                    <ul class="category">
                    
                                <li>
									<div>
										<div class="img_box">
                                           <img src="resources/img/bibimbap.jpg" onclick="location.href='/store/100/" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">한식</div>
                                </li>
                                
                                <li>
									<div>
										<div class="img_box">
                                           <img src="resources/img/steak.jpeg" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">양식</div>
                                </li>
                    
                                <li>
									<div>
										<div class="img_box">
                                           <img src="resources/img/chinese1.png" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">중식</div>
                                </li>
                    
                                <li>
									<div>
										<div class="img_box">
                                           <img src="resources/img/sushi.jpg" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">일식</div>
                                </li>
                    
                                <li>
									<div>
										<div class="img_box">
                                           <img src="resources/img/hamburger2.png" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">패스트푸드</div>
                                </li>
                                
                    
                                <li>
									<div>
										<div class="img_box">
                                           <a href="${pageContext.request.contextPath}/store/store.do"></a> <img src="resources/img/dessert2.png" alt="이미지">
										</div>
                                    </div>
                                    <div class="name">카페/디저트</div>
                                </li>
                            </ul>
                	</div>
            </section>
        </main>
    </div>
</body>
<script>
	const move = document.querySelector(".category");
	move.addEventListener('click', ()=>{
		//console.log("작동?");
	const index = this.index();	
	location.href = "/store/" + (100+index);
	}); 
	/* .click(function(){
		let address1 = $("#deleveryAddress1").val();
		if(!address1) {
			swal("배달 받으실 주소를 입력해 주세요");
			return false;
		} */
</script>
</html>
