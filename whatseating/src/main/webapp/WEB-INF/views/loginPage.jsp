<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지 창</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/commonsFunction.js"></script>
</head>
<body>
<input type="text" name="CUST_ID" id="id">
<input type="text" name="CUST_PW" id="pw">
<button type="button" id="logBtn">로그인</button>
</body>
</html>