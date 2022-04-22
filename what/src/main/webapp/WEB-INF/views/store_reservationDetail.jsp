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
    <title><c:out value="${storeDTO.ST_NAME}" /> 예약 현황</title>
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
                    <a href="#">
                        <div class="store-list">
                            <a href="#" class="store-picture">
                                <img src="" alt="사진없음">
                            </a>
                            <a href="#" class="store-info">
                                <div class="store-title">
                                    <div><c:out value="${storeDTO.ST_NAME}" />
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
                <span><c:out value="${storeDTO.ST_NAME}" /></span>
                <button type="button" id="detailInfo">상세보기</button>
                <button type="button" id="replyInfo">상세 후기보기</button>
            </div>
            <div class="right-content-middle">
                <div class="month-search">
                    <table>
                        <tr>
                            <td class="tb-cell-2">
                                <div class="orderprocesstul">
                                    <select name="orderprocess" class="orderprocess">
                                        <option value="1">1월</option>
                                        <option value="2">2월</option>
                                        <option value="3">3월</option>
                                        <option value="4">4월</option>
                                        <option value="5">5월</option>
                                        <option value="6">6월</option>
                                        <option value="7">7월</option>
                                        <option value="8">8월</option>
                                        <option value="9">9월</option>
                                        <option value="10">10월</option>
                                        <option value="11">11월</option>
                                        <option value="12">12월</option>
                                    </select>
                                </div>
                            </td>
                            <!-- 월에 따라 일이 변할 수 있도록 설정 필요 -->
                            <td class="tb-cell-2">
                                <div class="orderprocesstul">
                                    <select name="orderprocess" class="orderprocess">
                                        <option value="1">1일</option>
                                        <option value="2">2일</option>
                                        <option value="3">3일</option>
                                        <option value="4">4일</option>
                                        <option value="5">5일</option>
                                        <option value="6">6일</option>
                                        <option value="7">7일</option>
                                        <option value="8">8일</option>
                                        <option value="9">9일</option>
                                        <option value="10">10일</option>
                                        <option value="11">11일</option>
                                        <option value="12">12일</option>
                                        <option value="13">13일</option>
                                        <option value="14">14일</option>
                                        <option value="15">15일</option>
                                        <option value="16">16일</option>
                                        <option value="17">17일</option>
                                        <option value="18">18일</option>
                                        <option value="19">19일</option>
                                        <option value="20">20일</option>
                                        <option value="21">21일</option>
                                        <option value="22">22일</option>
                                        <option value="23">23일</option>
                                        <option value="24">24일</option>
                                        <option value="25">25일</option>
                                        <option value="26">26일</option>
                                        <option value="27">27일</option>
                                        <option value="28">28일</option>
                                        <option value="29">29일</option>
                                        <option value="30">30일</option>
                                        <option value="31">31일</option>
                                    </select>
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
             <div class="right-content-bottom">
                 <table>
                     <colgroup>
                        <col width="70px" />
                    </colgroup>
                     <tr class="reservation-col">
                        <td>시간</td>
                        <td>1 테이블</td>
                        <td>2 테이블</td>
                        <td>3 테이블</td>
                        <td>4 테이블</td>
                        <td>5 테이블</td>
                        <td>6 테이블</td>
                    </tr>
                    <tr class="reservation-col">
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
             </div>
        </div>
    </section>
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
        
</body>
</html>