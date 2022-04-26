<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>header</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/commonsFunction.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/store_reservationDetail.js"></script>
</head>
<body>
    <header>
        <div class="header-top">
            <span class="header-title">점주 관리자 페이지</span>
        </div>
        <div class="top-navi">
            <ul>
                <li id="membershipInfo"></li>
                <li id="logoutBtn">로그아웃</li>
            </ul>
        </div>
    </header>
    
    <!--------------------------------------- 개인정보 상세보기 모달창 --------------------------------------------->
    <div id="accountInfoModal" class="modal">
        <!-- Modal content -->
        <div id="accountInfo-content">
            <div class="modal-title">
                <p>개인 정보 상세</p>
            </div>
            <div style="cursor:pointer;text-align: center; "id="accountInfo_close">
                  <span class="pop_bt" style="font-size: 25pt;" >
                       +
                  </span>
             </div>
            <div class="member-check-table">
           		<form method="post" id="accountInfoForm">
					<table>
						<colgroup>
							<col width="130px">
						</colgroup>
						<tr class="table-col">
							<td>아이디</td>
							<td class="first-row">
								<div class="INFO_CUST_ID"></div>
							</td>
						</tr>
						<tr class="table-col">
							<td>패스워드</td>
							<td class="first-row">
								<input type="password" name="CUST_PW" id="INFO_CUST_PW" class="infoDisabled" disabled>
							</td>
						</tr>
						<tr class="table-col">
							<td>이름</td>
							<td class="first-row">
								<input type="text" name="CUST_NAME" id="INFO_CUST_NAME" class="infoDisabled" disabled>
							</td>
						</tr>
						<tr class="table-col">
							<td>성별</td>
							<td class="first-row">
								<div id="gender-info"></div>
								<div class="gender-frame">
									<label for="gender1">
										<input type="radio" name="CUST_GENDER" value="남자" id="gender1">남자
									</label>
									<label for="gender2">
										<input type="radio" name="CUST_GENDER" value="여자" id="gender2">여자
									</label>
								</div>
							</td>
						</tr>
						<tr class="table-col">
							<td>전화번호</td>
							<td class="first-row">
								<input type="text" name="CUST_PHNO" id="INFO_CUST_PHNO" class="infoDisabled" disabled>
							</td>
						</tr>
						<tr class="table-col">
							<td>이메일</td>
							<td class="first-row">
								<input type="text" name="CUST_EMAIL" id="INFO_CUST_EMAIL" class="infoDisabled" disabled> @ 
								<input type="text" name="CUST_EMAIL2" id="INFO_CUST_EMAIL2" class="infoDisabled" disabled>
							</td>
						</tr>
						<tr class="table-col">
							<td>주소</td>
							<td class="first-row">
								<input type="text" name="CUST_ADDRESSNO" id="INFO_CUST_ADDRESSNO" class="infoDisabled" disabled>
								<input type="text" name="CUST_ADDRESSBASIC" id="INFO_CUST_ADDRESSBASIC" class="infoDisabled" disabled>
								<input type="text" name="CUST_ADDRESSDETAIL" id="INFO_CUST_ADDRESSDETAIL" class="infoDisabled" disabled>
								<input type="hidden" name="CUST_ADDRESSEXTRA" id="INFO_CUST_ADDRESSEXTRA" class="infoDisabled" disabled>
							</td>
						</tr>
						<tr class="table-col">
							<td>이용서비스</td>
							<td class="first-row">
								<div id="type-info"></div>
								<div class="type-frame">
									<label for="type1">
										<input type="radio" name="CUST_TYPE" value="회원" id="type1">회원
									</label>
									<label for="type2">
										<input type="radio" name="CUST_TYPE" value="점주" id="type2">점주
									</label>
								</div>
							</td>
						</tr>
					</table>
					<div class="btns">
						<button type="button" class="btn btn-outline-success" id="accountModifyBtn">수정</button>
						<button type="button" class="btn btn-outline-success" id="accountModifyCompleteBtn">수정 완료</button>
						<button type="button" class="btn btn-outline-danger" id="cancelBtn">취소</button>
					</div>
				</form>
			</div>
        </div>
    </div>
</body>
</html>