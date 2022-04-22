<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String CUST_ID = null;
	if(session.getAttribute("CUST_ID") != null){
		CUST_ID = (String) session.getAttribute("CUST_ID");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 확인</title>
</head>
<body>

</body>
</html>