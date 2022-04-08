<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
</head>
<body>
 <div class="container">
            <div class="category" data-category="${st_code }">
                <ul>
                    <li data-category ='100' onclick="location.href='/store/100'"><span>한식</span></li>
                    <li data-category ='101' onclick="location.href='/store/101'"><span>양식</span></li>
                    <li data-category ='102' onclick="location.href='/store/102'"><span>중식</span></li>
                    <li data-category ='103' onclick="location.href='/store/103'"><span>일식</span></li>
                    <li data-category ='104' onclick="location.href='/store/104'"><span>패스트푸드</span></li>
                    <li data-category ='105' onclick="location.href='/store/105'"><span>카페/디저트</span></li>
                </ul>
            </div>
            
           <div class="option">
                <ul>    
                	<li data-sort="기본순">기본순</li>
                 <!--    <li data-sort="배달 빠른 순">배달 빠른 순</li> -->
                    <li data-sort="별점 높은 순">별점 높은 순</li>
                    <li data-sort="리뷰 많은 순">리뷰 많은 순</li>
                </ul> 
           </div>
           
           

            <div class="box">
				
				<c:if test="${empty storeList }">
					<img class="temp_img" alt="이미지" src="resources/img/temp2.png">
					<style>main .box {background: #F6F6F6; max-width: 100%; }</style>
				</c:if>
				
				
                <ul class="store">
                	<c:set var="store_code" value="/store" />
                	<c:forEach items="${storeList }" var="str">
                    	<%@ include file="/WEB-INF/views/store/store-li.jsp" %>
                    </c:forEach>
                </ul>
            </div>

        </div>
</body>
<script>
const category = document.querySelector('.category');
category.addEventListener('click', () => {
	console.log("what!!!");
});
/* navbarMenu.addEventListener('click', (event) => {
  //console.log(event.target.dataset.link);
  const target = event.target;
  const link= target.dataset.link;
  if(link == null){
    return; 
  }
  
$(document).ready(function() {
	const category = $(".category").data("category");
	const address1 = $(".address1").val();
	
	let sort = "기본순";
	$(".option li[data-sort='기본순']").addClass("active");

	$("li[data-category = '" + category + "'] > span").css("border-bottom", "3px solid #333333");
	$("li[data-category = '" + category + "'] > span").css("color", "#333333");

	let winHeight = 0;
	let docHeight = 0;
	let page = 1;
	let run = false;
	
	$(window).scroll(function(){
		winHeight = $(window).height();
		docHeight = $(document).height();
		
		const top = $(window).scrollTop();
		
		if(docHeight <= winHeight + top + 10 ) {
			if(run) {
				return;
			}
			console.log("페이지 추가");
			console.log("sort= " + sort);
			
			page++;
			run = true;
			
			const data = {
				category : category,
				address1 : address1,
				sort : sort,
				page : page
			}
			
			$.ajax({
				url: "/store/storeList",
				type: "GET",
				data : data
			})
			.done(function(result){
				const storeHtml = storeList(result);
				
				$(".store").append(storeHtml);
				
				if(storeHtml != "") {
					run = false;
				}
			})
			.fail(function(data, textStatus, errorThrown){
				swal("다시 시도해주세요");
			})	
		} // if
	}) // scroll */
</script>
</html>
