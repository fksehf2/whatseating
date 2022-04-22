<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.test.one.Vo.AccountDTO" %>
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
<html>
<head>
<meta charset="UTF-8">
<title>개인 정보 확인</title>
<script src="${pageContext.request.contextPath}/resources/js/accountConfirm.js"></script>
</head>
<body>
<c:choose>
	<c:when test="${CUST_ID ne null}">
		<a href="#a"><c:out value="${accountDTO.CUST_ID}" /></a>
	</c:when>
	<c:otherwise>
		<a href="#a">로그인</a>
	</c:otherwise>
</c:choose>

<div class="accountModify">
	<button type="button" id="accountDeleteBtn">회원 삭제</button>
</div>


<div class="accountModify">
	<button type="button" id="accountModifyBtn">회원 수정</button>
</div>

	<!-- 회원 수정 폼 -->
	 <div id="detailModal" class="modal">
        <!-- Modal content -->
        <div id="detail-content">
            <div class="modal-title">
                <p>회원 정보</p>
            </div>
            <div style="cursor:pointer;text-align: center; "id="detail_close">
                  <span class="pop_bt" style="font-size: 25pt;" >
                       +
                  </span>
             </div>
            <div class="member-check-table">
           		<form action="userModify" method="post" id="userForm">
					<table>
						<colgroup>
							<col width="130px">
						</colgroup>
						<tr class="table-col">
							<td>회원 아이디</td>
							<td class="first-row">
								<input type="text" name="CUST_ID" value="${accountDTO.CUST_ID}" disabled>
							</td>
						</tr>
						<tr class="table-col">
							<td>회원 비밀번호</td>
							<td class="first-row">
								<input type="text" name="CUST_PW" value="${accountDTO.CUST_PW}" disabled class="infoDisabled">
							</td>
						</tr>
						<tr class="table-col">
							<td>회원 이름</td>
							<td class="first-row">
								<input type="text" name="CUST_NAME" value="${accountDTO.CUST_NAME}" disabled class="infoDisabled">
							</td>
						</tr>
						<tr class="table-col">
							<td>회원 성별</td>
							<td class="first-row">
								<label for="gender1">
									<input type="radio" name="CUST_GENDER" value="남자" id="gender1"> 남자
								</label>
								<label for="gender2">
									<input type="radio" name="CUST_GENDER" value="여자" id="gender2"> 여자
								</label>
							</td>
						</tr>
						<tr class="table-col">
							<td>회원 연락처</td>
							<td class="first-row">
								<input type="text" name="CUST_PHNO" value="${accountDTO.CUST_PHNO}" disabled class="infoDisabled">
							</td>
						</tr>
						<tr class="table-col">
							<td>회원 이메일</td>
							<td class="first-row">
								<input type="text" name="CUST_EMAIL" value="${accountDTO.CUST_EMAIL}" disabled class="infoDisabled"> @ 
								<input type="text" name="CUST_EMAIL2" value="${accountDTO.CUST_EMAIL2}" disabled class="infoDisabled">
							</td>
						</tr>
						<tr class="table-col">
							<td>회원 주소</td>
							<td class="first-row">
								<input type="text" name="CUST_ADDRESSNO" value="${accountDTO.CUST_ADDRESSNO}" disabled class="infoDisabled">
								&nbsp;<input type="text" name="CUST_ADDRESSBASIC" value="${accountDTO.CUST_ADDRESSBASIC}" disabled class="infoDisabled">
								&nbsp;<input type="text" name="CUST_ADDRESSDETAIL" value="${accountDTO.CUST_ADDRESSDETAIL}" disabled class="infoDisabled">
								<input type="hidden" name="CUST_ADDRESSEXTRA" value="${accountDTO.CUST_ADDRESSEXTRA}">
							</td>
						</tr>
						<tr class="table-col">
							<td>이용 서비스</td>
							<td class="first-row">
								<label for="type1">
									<input type="radio" name="CUST_TYPE" value="회원" id="type1"> 회원
								</label>
								<label for="type2">
									<input type="radio" name="CUST_TYPE" value="점주" id="type2"> 점주
								</label>
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
</body>
</html>