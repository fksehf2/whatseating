<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div class="box">
		<ul class="category">
		<c:forEach items="${cateList}" var="str">
				<li>
					<div>
						<div class="code">${str.CA_CODE}</div>
						<div class="img_box">
						   <img src="${pageContext.request.contextPath}\${data.imagePath}" alt="이미지"/>
						</div>
					</div>
					<div class="name">${str.CA_NAME}</div>
					<div id="listDiv"></div>
				</li>
		</c:forEach>
		</ul>
	</div>
