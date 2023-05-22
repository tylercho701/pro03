<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common.jsp" %>
<meta charset="UTF-8">
<title>Index</title>
<style>
</style>
</head>
<body>

	<div class="container">
		<%@ include file="../hd.jsp" %>
		<div class="content">
			<h2 class="title">메인페이지</h2>
		</div>
		<%@ include file="../ft.jsp" %>
	</div>

</body>
</html>