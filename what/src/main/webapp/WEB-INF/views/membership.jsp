<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/home.css">
<style>
.category{
   list-style: none;
    padding-left: 0px;
}

#signup{
   position: absolute;
     top: 24px;
     right: 100px;
     font-size: 16px;
     color: blue;
}
#login{
  position: absolute;
  top: 24px;
  right: 32px;
  font-size: 16px;
  color: blue;
}

</style>
   <title>Home</title>
</head>
<body>
<!-- header -->
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
                 <div>
         <a class="btn btn-outline-light btn-sm m-1" id="signup"
         href="${pageContext.request.contextPath}/users/signup_form.do">
            회원가입
         </a>
         <a class="btn btn-outline-warning btn-sm m-1" id="login"
         href="${pageContext.request.contextPath}/loginform.do">
            로그인
         </a>
         </div>
            </section>
            <section class="category_box">
                <div class="box">
                    <ul class="category">
                    
                                <li>
                           <div>
                              <div class="img_box">
                                           <img src="resources/img/bibimbap.jpg" alt="이미지">
                              </div>
                                    </div>
                                    <div class="name">한식</div>
                                    <div id="listDiv"></div>
                                </li>
                                
                                <li>
                           <div>
                              <div class="img_box">
                                           <img src="resources/img/steak.jpeg" alt="이미지">
                              </div>
                                    </div>
                                    <div class="name">양식</div>
                                    <div id="listDiv"></div>
                                </li>
                    
                                <li>
                           <div>
                              <div class="img_box">
                                           <img src="resources/img/chinese1.png" alt="이미지">
                              </div>
                                    </div>
                                    <div class="name">중식</div>
                                    <div id="listDiv"></div>
                                </li>
                    
                                <li>
                           <div>
                              <div class="img_box">
                                           <img src="resources/img/sushi.jpg" alt="이미지">
                              </div>
                                    </div>
                                    <div class="name">일식</div>
                                    <div id="listDiv"></div>
                                </li>
                    
                                <li>
                           <div>
                              <div class="img_box">
                                           <img src="resources/img/hamburger2.png" alt="이미지">
                              </div>
                                    </div>
                                    <div class="name">패스트푸드</div>
                                    <div id="listDiv"></div>
                                </li>
                                
                    
                                <li>
                           <div>
                              <div class="img_box">
                                           <img src="resources/img/dessert2.png" alt="이미지">
                              </div>
                                    </div>
                                    <div class="name">카페/디저트</div>
                                    <div id="listDiv"></div>
                                </li>
                            </ul>
                   </div>
            </section>
        </main>
    </div>
    
    <!-- body -->
    
    
</body>


<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>

</script>   
</html>