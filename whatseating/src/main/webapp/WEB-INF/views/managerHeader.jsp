<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <title>header</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
</head>
<body>
    <header>
        <div class="header-top">
            <span class="header-title">점주 관리자 페이지</span>
        </div>
        <div class="top-navi">
            <ul>
                <li><a href="#"><c:out value="${CUST_ID}" /></a></li>
                <li><a href="#" id="logoutBox">로그아웃</a></li>
                <li><a href="#">결제내역</a></li>
            </ul>
        </div>
    </header>
</body>
</html>