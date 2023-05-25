<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<link rel="stylesheet" href="/source/bulma.css">
<meta charset="UTF-8">
<title>Notification</title>
<link rel="stylesheet" href="${path }/resource/datatables.min.css">
<script src="${path }/resource/datatables.min.js"></script>
<script>
$(document).ready( function () {
	$('#tb1').DataTable();
});
</script>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<section>
				<h2 class="title">공지사항</h2>
				<table class="table" id="tb1">
					<thead>
						<tr><th>연번</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>
					</thead>
					<tbody>
						<c:forEach var="noti" items="${notiList }" varStatus="status">
						<tr>
							<td>${status.count }</td><!-- ${fn:length(notiList) - status.index } -->
							<td><a href="${path }/NoticeDetail.do?noticeId=${noti.noticeId }">${noti.noticeTitle }</a></td>
							<td>${noti.writtenBy }</td>
							<td>
								<fmt:parseDate var="resdate" value="${noti.writtenAt }" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" /> 
							</td>
							<td>${noti.readCnt }</td>
						</tr>
						</c:forEach>
						<c:if test="${empty notiList }">
							<tr>
								<td colspan="5">공지사항이 존재하지 않습니다.</td>
							</tr>
						</c:if>	
					</tbody>
				</table>
				<c:if test="${sid == 'admin' }">
					<div class="buttons">
						<a href="${path }/NoticeInsert.do" class="button is-default">글 등록</a>
					</div>
				</c:if>
			</section>
		</div>
		<%@ include file="../../footer.jsp" %>
	</div>
</body>
</html>