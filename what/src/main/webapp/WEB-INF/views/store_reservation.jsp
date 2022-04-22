<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("UTF-8");
	String CUST_ID = null;
	if(session.getAttribute("CUST_ID") != null){
		CUST_ID = (String) session.getAttribute("CUST_ID");
	}
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>매장1 예약 현황</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/managerIndex.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-latest.js"></script> 
<script src="${pageContext.request.contextPath}/resources/js/store_reservationDetail.js"></script>
</head>
<body>
	<jsp:include page="managerHeader.jsp" />
    <section class="totalSection"> 
        <div class="left-category">
            <ul>
                <li>
                    <a href="reservationDetail">
                        <div class="store-list">
                            <a href="reservationDetail" class="store-picture">
                                <img src="사진없음" alt="">
                            </a>
                            <a href="reservationDetail" class="store-info">
                                <div class="store-title">
                                    <div>매장 가게
                                        <span>매장 카테고리</span>
                                    </div>
                                </div>
                                <div class="store-menu">매장 메뉴</div>
                            </a>
                        </div>
                    </a>
                </li>
                <li>
                    <a href="#" class="plusCenter">
                        <img src="img/plus.png" alt="사진없음">
                    </a>
                </li>
            </ul>
        </div>
        <div class="right-content">
            <div class="right-contentTop">
                <span><c:out value="${ storeDTO.ST_NAME }"/></span>
                <button type="button" id="detailInfo">매장정보보기</button>
                <button type="button" id="replyInfo">상세 후기보기</button>
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
             <div class="menu-frameBox">
             	<div class="menu-btns">
             		<button type="button" class="btn btn-primary btn-lg" style="margin-top: 20px;" id="menuInfo">메뉴 등록</button>
             	</div>
             </div>
             <div class="menu-detailBox">
             	<ul>
             		<c:forEach var="item" items="${menuList}">
             			<c:forEach var="key" items="${menuList.picList}">
             				<li>
		             			<a href="#a">
		             				<img alt="사진 없음" src=""><c:out value="${menuList[key].value}" />
		             			</a>
		             		</li>
             			</c:forEach>
             		</c:forEach>
             		
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
           		<input type="hidden" name="ST_CODE" value="${storeDTO.ST_CODE}">
					<table>
						<colgroup>
							<col width="130px">
						</colgroup>
						<tr class="table-col">
							<td>매장명</td>
							<td class="first-row">
								<input type="text" name="ST_NAME" value="${storeDTO.ST_NAME}" disabled class="infoDisabled">
							</td>
						</tr>
						<tr class="table-col">
							<td>매장 주소</td>
							<td class="first-row">
								<input type="text" name="ST_ADDRESSNO" value="${storeDTO.ST_ADDRESSNO}" disabled class="infoDisabled">
								&nbsp;<input type="text" name="ST_ADDRESSBASIC" value="${storeDTO.ST_ADDRESSBASIC}" disabled class="infoDisabled">
								&nbsp;<input type="text" name="ST_ADDRESSDETAIL" value="${storeDTO.ST_ADDRESSDETAIL}" disabled class="infoDisabled">
								<input type="hidden" name="ST_ADDRESSEXTRA" value="${storeDTO.ST_ADDRESSEXTRA}">
							</td>
						</tr>
						<tr class="table-col">
							<td>매장 연락처</td>
							<td class="first-row">
								<input type="text" name="ST_PHNO" value="${storeDTO.ST_PHNO}" disabled class="infoDisabled">
							</td>
						</tr>
						<tr class="table-col">
							<td>매장 운영시간</td>
							<td class="first-row">
								<input type="text" name="ST_STARTTIME" value="${storeDTO.ST_STARTTIME}" disabled class="infoDisabled">
								&nbsp;~&nbsp;
								<input type="text" name="ST_ENDTIME" value="${storeDTO.ST_ENDTIME}" disabled class="infoDisabled">
							</td>
						</tr>
						<tr class="table-col">
							<td>매장 설명</td>
							<td class="first-row">
								<input type="text" name="ST_CONTENT" value="${storeDTO.ST_CONTENT}" disabled class="infoDisabled">
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
    <!-- 후기 상세보기 Modal -->
    <div id="replyModal" class="modal">
        <!-- Modal content -->
        <div id="reply-content" class="modal-content">
            <div class="modal-title">
                <p>후기 receipt</p>
            </div>
            <div class="member-check-table">
				<table>
					<colgroup>
						<col width="130px">
					</colgroup>
					<tr class="table-col">
						<td>예약자</td>
						<td class="first-row">
							<input type="hidden" name="custom_emailinput" value="">
							<input type="hidden" name="custom_mailsearch" value="">
							<span>bunci123123@naver.com</span>
						</td>
					</tr>
					<tr class="table-col">
						<td>예약인원</td>
						<td class="first-row">
							<input type="hidden" name="custom_name" value="">
							<span>예약자</span>
						</td>
					</tr>
					<tr class="table-col">
						<td>예약 메뉴</td>
						<td class="first-row">
							<input type="hidden" name="custom_nickname" value="">
							<span>예약 메뉴</span>
						</td>
					</tr>
					<tr class="table-col">
						<td>예약 테이블</td>
						<td class="first-row">
							<input type="hidden" name="custom_phone" value="">
							<span>예약 테이블</span>
						</td>
					</tr>
				</table>
			</div>
              <div style="cursor:pointer;background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px;" id="reply_close">
                  <span class="pop_bt" style="font-size: 13pt;" >
                       닫기
                  </span>
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
           		<input type="hidden" name="ST_CODE" value="${storeDTO.ST_CODE}">
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
								<textarea name="MENE_CONTENT" maxlength="2000" style="height: 200px;" id="MENE_CONTENT"></textarea>
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
</body>
</html>