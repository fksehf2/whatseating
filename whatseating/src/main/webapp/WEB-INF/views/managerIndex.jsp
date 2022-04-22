<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("UTF-8");
	String CUST_ID = null;
	if(session.getAttribute("CUST_ID") != null){
		CUST_ID = (String) session.getAttribute("CUST_ID");
	}
	
	pageContext.setAttribute("CUST_ID", CUST_ID);
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/managerIndex.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-latest.js"></script> 
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/store_reservationDetail.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/storeList.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</head>
<body>
	<jsp:include page="managerHeader.jsp" />
    <section class="totalSection"> 
    	<input type="hidden" name="getContextPath" id="getContextPath" value="${pageContext.request.contextPath}">
        <div class="left-category">
            <ul>
               
            </ul>
            <div id="storeAddImg">
       			<a href="#" class="plusCenter" id="storeAddBtn"> <!-- 모달창을 이용한 insert로 만들 예정 -->
                    <img src="${pageContext.request.contextPath}/resources/img/plus.png" alt="사진없음">
                </a>
            </div>
        </div>
        <!-- 메인 index페이지 -->
        <div class="right-content" id="managerIndex">
            <div class="right-contentTop">
                <p>매장 관리</p>
            </div>
            <div class="right-content-middle">
                <div class="store-number">
                    <span>총 매장 수 :</span>
                    <span id="storeCount"></span>
                    <span>개</span>
                </div>
                <div class="store-sales">
                    <div class="store-number">
                        <span>총 매출 :</span>
                        <span>300000000 </span>
                        <span>원</span>
                    </div>
                </div>
            </div>
        </div>
        <!----------------------------------------- store 디테일 부분 --------------------------------------------->
         <div class="right-content" id="store-detail">
            <div class="right-contentTop">
                <span class="store_title"></span>
                <button type="button" id="detailInfo">매장정보보기</button>
                <button type="button" id="reservationInfo">예약 현황</button>
            </div>
            <div class="right-content-middle">
                <div class="month-search">
                    <table>
                        <tr>
                            <td class="tb-cell-1">
                                <div class="orderprocesstul">
                                    <input type="date" name="calrender" id="car">
                                </div>
                            </td>
                            <td class="tb-cell-3">
                                <div class="ordersearchbtn">
                                    <a href="#a">조회</a>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
             </div>
             <div id="confirm"></div>
             <div class="menu-frameBox">
             	<div class="menu-btns">
             		<button type="button" class="btn btn-primary btn-lg" style="margin-top: 20px;" id="menuInfo">메뉴 등록</button>
             	</div>
             </div>
             <div class="menu-detailBox">
             	<ul class="menu-list-box">
             		<li class="menu-list-frame">
             			<img alt="사진없음" src="">
             			<div class="menu-title">삼겹살</div>
             		</li>
             	</ul>
             </div>
        </div>
    </section>
    <!----------------------------------------- 모달창 --------------------------------------------------->
     <!-- 상세보기 Modal -->
   <div id="detailModal" class="modal">
        <!-- Modal content -->
        <div id="detail-content">
            <div class="modal-title">
                <p>매장 상세</p>
            </div>
            <div style="cursor:pointer;text-align: center; "id="detail_close">
                  <span class="pop_bt" style="font-size: 25pt;" >
                       +
                  </span>
             </div>
            <div class="member-check-table">
           		<form action="storeModify" method="post" id="storeForm">
           		<input type="hidden" name="ST_CODE" value="">
					<table>
						<colgroup>
							<col width="130px">
						</colgroup>
						<tr class="table-col">
							<td>매장명</td>
							<td class="first-row">
								<input type="text" name="ST_NAME" value="" disabled class="infoDisabled">
							</td>
						</tr>
						<tr class="table-col">
							<td>매장 주소</td>
							<td class="first-row">
								<input type="text" name="ST_ADDRESSNO" value="" disabled class="infoDisabled">
								&nbsp;<input type="text" name="ST_ADDRESSBASIC" value="" disabled class="infoDisabled">
								&nbsp;<input type="text" name="ST_ADDRESSDETAIL" value="" disabled class="infoDisabled">
								<input type="hidden" name="ST_ADDRESSEXTRA" value="">
							</td>
						</tr>
						<tr class="table-col">
							<td>매장 연락처</td>
							<td class="first-row">
								<input type="text" name="ST_PHNO" value="" disabled class="infoDisabled">
							</td>
						</tr>
						<tr class="table-col">
							<td>매장 운영시간</td>
							<td class="first-row">
								<input type="text" name="ST_STARTTIME" value="" disabled class="infoDisabled">
								&nbsp;~&nbsp;
								<input type="text" name="ST_ENDTIME" value="" disabled class="infoDisabled">
							</td>
						</tr>
						<tr class="table-col">
							<td>매장 설명</td>
							<td class="first-row">
								<input type="text" name="ST_CONTENT" value="" disabled class="infoDisabled">
							</td>
						</tr>
					</table>
					<div class="btns">
						<button type="button" class="btn btn-outline-success modifyBtn">수정</button>
						<button type="submit" class="btn btn-outline-success" id="updateBtn">수정 완료</button>
						<button type="button" class="btn btn-outline-danger deleteBtn">삭제</button>
					</div>
				</form>
			</div>
        </div>
    </div>
    <!--------------------------------- 예약 현황 상세보기 Modal ----------------------------------->
    <div id="reservationModal" class="modal">
        <!-- Modal content -->
        <div id="reservation-content">
            <div class="modal-title">
                <p>예약 현황판</p>
            </div>
            <div style="cursor:pointer;text-align: center; "id="reservation_close">
                  <span class="pop_bt" style="font-size: 25pt;" >
                       +
                  </span>
             </div>
            <div class="member-check-table">
           		<form method="post" id="reservationForm">
           		<input type="hidden" name="ST_CODE" value="">
					<table>
	                     <colgroup>
	                        <col width="40px" />
	                    </colgroup>
	                     <tr class="table-col">
	                        <td>시간</td>
	                        <td>1 테이블</td>
	                        <td>2 테이블</td>
	                        <td>3 테이블</td>
	                        <td>4 테이블</td>
	                        <td>5 테이블</td>
	                        <td>6 테이블</td>
	                    </tr>
	                    <tr class="table-col">
	                        <td>9~11</td>
	                        <td class="left-td">
	                            <div class="reservation-chart">
	                                <span>예약 인원 : </span><br/>
	                                <span>예약자 : </span><br/>
	                                <span>예약 메뉴 : </span>
	                            </div>
	                        </td>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                    </tr>
                </table>
					<div class="btns">
						<button type="button" class="btn btn-outline-success" id="uploadSubmit">등록</button>
						<button type="reset" class="btn btn-outline-danger">취소</button>
					</div>
				</form>
			</div>
        </div>
    </div>
    <!--------------------------------------- 메뉴 등록 --------------------------------------------->
    <div id="menuModal" class="modal">
        <!-- Modal content -->
        <div id="menu-content">
            <div class="modal-title">
                <p>메뉴 등록</p>
            </div>
            <div style="cursor:pointer;text-align: center; "id="menu_close">
                  <span class="pop_bt" style="font-size: 25pt;" >
                       +
                  </span>
             </div>
            <div class="member-check-table">
           		<form method="post" id="menuForm" enctype="multipart/form-data">
           		<input type="hidden" name="ST_CODE" value="">
					<table>
						<colgroup>
							<col width="130px">
						</colgroup>
						<tr class="table-col">
							<td>메뉴명</td>
							<td class="first-row">
								<input type="text" name="MENU_NAME" id="MENU_NAME">
							</td>
						</tr>
						<tr class="table-col">
							<td>메뉴 가격</td>
							<td class="first-row">
								<input type="text" name="MENU_PRICE" id="MENU_PRICE">
							</td>
						</tr>
						<tr class="table-col">
							<td>메뉴 설명</td>
							<td class="first-row">
								<textarea name="MENU_CONTENT" maxlength="2000" style="height: 200px;" id="MENE_CONTENT"></textarea>
							</td>
						</tr>
						<tr class="table-col">
							<td>메뉴 설명</td>
							<td class="first-row">
								<button id="uploadBtn">업로드</button>
								<input type="file" name="MENU_PIC" multiple="multiple" id="real-uploadBtn" style="display: none;">
								<span>※최대 사진은 10장까지 올릴 수 있습니다.※</span>
								<span>첨부파일</span>
								<div class="show-uploadFile">
									<table id="show-uploadTable">
									
									</table>
								</div>
							</td>
						</tr>
					</table>
					<div class="btns">
						<button type="button" class="btn btn-outline-success" id="uploadSubmit">등록</button>
						<button type="reset" class="btn btn-outline-danger">취소</button>
					</div>
				</form>
			</div>
        </div>
    </div>
    <!-- <button id="confirm">확인</button> -->
    <!-- 매장 추가 모달 -->
   <div id="storeAddModal" class="modal">
        <!-- Modal content -->
        <div id="detail-content">
            <div class="modal-title">
                <p>매장 상세</p>
            </div>
            <div style="cursor:pointer;text-align: center; "id="storeAdd_close">
                  <span class="pop_bt" style="font-size: 25pt;" >
                       +
                  </span>
             </div>
            <div class="member-check-table">
           		<form action="storeRegister" method="post" id="storeAddForm" onsubmit="return chkform();">
           		
           		<!-- value에 세션 값을 넣을 수 있도록 함 -->
           		<input type="hidden" name="ST_MANAGER" value="bum">
					<table>
						<colgroup>
							<col width="130px">
						</colgroup>
						<tr class="table-col">
							<td>매장명</td>
							<td class="first-row">
								<input type="text" name="ST_NAME" id="ST_NAME">
							</td>
						</tr>
						<tr class="table-col">
							<td>매장 주소</td>
							<td class="first-row">
								<input type="text" name="ST_ADDRESSNO" id="sample6_postcode" placeholder="우편번호" class="textbox address1">
								<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
								<input type="text" name="ST_ADDRESSBASIC" id="sample6_address" placeholder="주소" class="textbox address2"><br>
								<input type="text" name="ST_ADDRESSDETAIL" id="sample6_detailAddress" placeholder="상세주소" class="textbox address3">
								<input type="text" name="ST_ADDRESSEXTRA" id="sample6_extraAddress" placeholder="참고항목" class="textbox address4">
							</td>
						</tr>
						<tr class="table-col">
							<td>매장 연락처</td>
							<td class="first-row">
								<input type="text" name="ST_PHNO" id="ST_PHNO">
								<div>'-' 없이 적어주세요. ex) 00011112222</div>
							</td>
						</tr>
						<tr class="table-col">
							<td>매장 운영시간</td>
							<td class="first-row">
								<select name="ST_STARTTIME" id="ST_STARTTIME">
									<c:forEach begin="1" end="24" var="i">
										<c:choose>
											<c:when test="${i <= 9}">
												<option value="0${i}:00">0<c:out value="${i}" />:00</option>
											</c:when>
											<c:otherwise>
												<option value="${i}:00"><c:out value="${i}" />:00</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select> ~ 
								<select name="ST_ENDTIME" id="ST_ENDTIME">
									<c:forEach begin="1" end="24" var="i">
										<c:choose>
											<c:when test="${i <= 9}">
												<option value="0${i}:00">0<c:out value="${i}" />:00</option>
											</c:when>
											<c:otherwise>
												<option value="${i}:00"><c:out value="${i}" />:00</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr class="table-col">
							<td>매장 설명</td>
							<td class="first-row">
								<textarea maxlength="2000" name="ST_CONTENT" style="width: 170px;" id="ST_CONTENT"></textarea>
							</td>
						</tr>
					</table>
					<div class="btns">
						<button type="submit" class="btn btn-outline-success" id="storeRegisterBtn">등록</button>
						<button type="reset" class="btn btn-outline-danger">취소</button>
					</div>
				</form>
			</div>
        </div>
    </div>
    
    <!------------------------------------ 메뉴 정보 상세 보기 모달 ----------------------------------------------->
   <div id="menuDetailModal" class="modal">
        <!-- Modal content -->
        <div id="menuDetail-content">
            <div class="modal-title">
                <p>메뉴 상세</p>
            </div>
            <div style="cursor:pointer;text-align: center; "id="menuDetail_close">
                  <span class="pop_bt" style="font-size: 25pt;">
                       +
                  </span>
             </div>
            <div class="member-check-table">
            	<form method="post" id="menuPicForm" enctype="multipart/form-data">
            		<input type="hidden" name="MENU_NUM" value="">
            		<table>
						<colgroup>
							<col width="130px">
						</colgroup>
						<tr class="table-col">
							<td class="first-row" colspan="2" id="img-container">
								<div class="picAddFrame">
								
								</div>
								<div class="upload-fileView">
								</div>
							</td>
						</tr>
					</table>
            	</form>
            	
           		<form method="post" id="menuDetailForm">
           		<!-- value에 세션 값을 넣을 수 있도록 함 -->
           		<input type="hidden" name="MENU_NUM" value="">
					<table>
						<colgroup>
							<col width="130px">
						</colgroup>
						<tr class="table-col">
							<td>메뉴명</td>
							<td class="first-row">
								<input type="text" name="MENU_NAME" id="MENU_NAME" disabled class="menuInfoDisabled">
							</td>
						</tr>
						<tr class="table-col">
							<td>메뉴 가격</td>
							<td class="first-row">
								<input type="text" name="MENU_PRICE" id="MENU_PRICE" disabled class="menuInfoDisabled">
							</td>
						</tr>
						<tr class="table-col">
							<td>매장 상세</td>
							<td class="first-row">
								<textarea maxlength="2000" style="width: 170px;" name="MENU_CONTENT" disabled class="menuInfoDisabled"></textarea>
							</td>
						</tr>
					</table>
					<div class="btns">
						<button type="button" class="btn btn-outline-success" id="menuPicModifyBtn">사진 수정</button>
						<button type="button" class="btn btn-outline-success" id="menuPicUpdateBtn">사진 수정 완료</button>
						<button type="button" class="btn btn-outline-success" id="menuModifyBtn">메뉴 수정</button>
						<button type="button" class="btn btn-outline-success" id="menuUpdateBtn">메뉴 수정 완료</button>
						<button type="button" class="btn btn-outline-danger" id="menuDeleteBtn">삭제</button>
					</div>
				</form>
			</div>
        </div>
    </div>

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

//유효성 검사
function chkform(){
	var st_name = $("#ST_NAME").val();
	var address1 = $("#sample6_postcode").val();
	var address2 = $("#sample6_address").val();
	var address3 = $("#sample6_detailAddress").val();
	var address4 = $("#sample6_extraAddress").val();
	var st_phno = $("#ST_PHNO").val();
	var st_content = $("#ST_CONTENT").val();
	var eng = phno.search(/[a-z]/ig);  //영문자가 있는지 검색
	var spe = phno.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi); //특수 문자가 있는지 검색
	
	if(st_name == ""){
		alert("매장명을 입력해주세요.");
		st_name.focus();
		return false;
	} else if(address1 == "" || address2 == "" || address3 == ""){
		alert("입력되지 않은 주소가 있습니다.");
		address1.focus();
		return false;
	} else if(st_phno == "" || eng > 0 || spe > 0) {
		alert("형식에 맞는 매장 전화번호를 입력해주세요.");
		st_phno.focus();
		return false;
	} else if(st_content == "") {
		alert("매장 내용을 입력해주세요.");
		st_content.focus();
		return false;
	}
}


/* function chkform2(){
	var menu_name = $("#MENU_NAME").val();
	var menu_price = $("#MENU_PRICE").val();
	var menu_content = $("#MENU_CONTENT").val();
	
	if(menu_name == ""){
		alert("메뉴명을 입력해주세요.");
		$("#MENU_NAME").focus();
		return false;
	} else if(menu_price == ""){
		alert("메뉴 가격을 입력해주세요.");
		$("#MENU_PRICE").focus();
		return false;
	} else if(menu_content == ""){
		alert("메뉴 설명을 입력해주세요.");
		$("#MENU_CONTENT").focus();
		return false;
	}
} */

</script>
</body>
</html>