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
<link rel="stylesheet" href="/source/bulma.css">
<meta charset="UTF-8">
<title>Index</title>
<style>
.row:after { content:""; display:block; clear:both; }
.row li { float:left; }
.content ul.row { width:960px; margin:10px auto; margin-left:auto; margin-right:auto; }
</style>
</head>
<body>
<%@ include file="../header.jsp" %>
	<div class="container">
		<div class="content">
			<h2 class="title">메인페이지</h2>
			<ul class="row">
			<c:forEach var="noti" items="${notiList }">
				<li class="column is-3">
					 <div>${noti.noticeId }</div>
					 <div>${noti.noticeTitle }</div>
					 <div>${noti.noticeContent }</div>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
<%@ include file="../footer.jsp" %>
</body>
</html>