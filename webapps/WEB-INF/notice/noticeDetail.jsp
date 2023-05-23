<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Notification Detail</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<section class="container-fluid">
				<h2 class="title">공지사항 상세</h2>
				<table class="table">
					<tbody>
						<tr>
							<th>글번호</th>
							<td>${notice.noticeId }</td>
						</tr>
						<tr>
							<th>제목</th>
							<td>${notice.noticeTitle }</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>${notice.noticeContent }</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${notice.writtenBy }</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td>
								<fmt:parseDate var="resdate" value="${notice.writtenAt }" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" /> 
							</td>
						</tr>
						<c:if test="${!empty notice.attachment }">
							<th>첨부파일</th>		<!-- 첨부파일의 경로 협의 후 진행 필요 -->
							<td>
								<c:set var="lh" value="${fn:length(notice.attachment) }" />
								<c:set var="download" value="${fn:substring(notice.attachment,5,lh) }" />
								<a href="${path }/${attachmentPath1 }/${attachment1 }" download>${download }</a>
							</td>
						</c:if>
						<tr>
							<th>조회수</th>
							<td>${notice.readCnt }</td>
						</tr>
					</tbody>
				</table>
				<div class="btn btn-group">
					<a href="${path }/NoticeList.do" class="button is-default">공지사항 목록으로</a>
					<c:if test="${sid.equals('admin') }">
						<a href="${path }/NoticeInsert.do" class="button is-primary">새 공지사항 등록</a>
						<a href="${path }/NoticeUpdate.do?noticeId=${notice.noticeId }" class="button is-info">글 변경</a>
						<a href="${path }/NoticeDelete.do?noticeId=${notice.noticeId }" class="button is-danger">글 삭제</a>
					</c:if>
				</div>
			</section>
		</div>
		<%@ include file="../../footer.jsp" %>
	</div>
</body>
</html>