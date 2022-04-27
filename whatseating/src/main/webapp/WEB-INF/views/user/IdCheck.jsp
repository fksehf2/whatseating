<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
function swalSuccess(seq){
	Swal.fire({
		title: '회원님의 아이디는 "${id }"입니다.',
		icon: 'warning',
		confirmButtonColor: '#e3205a',
		confirmButtonText: '확인'
	}).then((result) => {
		if (result.value) {
			location.href="${pageContext.request.contextPath}/user/loginform.do";
	  }
	})
}
</script>
	<script>
		swalSuccess();
	</script>

</body>
</html>