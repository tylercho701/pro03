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
</style>
</head>
<body>
<%@ include file="../header.jsp" %>
	<div class="container">
		<div class="content">
			<h2 class="title">메인페이지</h2>
			<table class="table">
			<tbody>
				<c:forEach var="noti" items="${notiList }">
						<tr>
							<td>${noti.noticeId }</td>
							<td><a href="${path }/NoticeDetail.do?noticeId=${noti.noticeId }">${noti.noticeTitle }</a></td>
							<td>${noti.writtenBy }</td>
							<td>
								<fmt:parseDate var="resdate" value="${noti.writtenAt }" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" /> 
							</td>
							<td>${noti.readCnt }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
<%@ include file="../footer.jsp" %>
</body>
</html>