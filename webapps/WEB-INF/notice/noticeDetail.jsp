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
<title>Nofitication Detail</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<section class="container-fluid">
				<h2 class="title">공지사항 상세</h2>
				<table class="table">
					<tbody>
						<tr>
							<th>글번호</th>
							<td>${noti.noticeId }</td>
						</tr>
						<tr>
							<th>제목</th>
							<td>${noti.noticeTitle }</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>${noti.noticeContent }</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>${noti.writtenBy }</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td>
								<fmt:parseDate var="resdate" value="${noti.writtenAt }" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" /> 
							</td>
						</tr>
						<c:if test="${!empty noti.attachment }">
							<th>첨부파일</th>		<!-- 첨부파일의 경로 협의 후 진행 필요 -->
							<td>
								<c:set var="lh" value="${fn:length(noti.attachment) }" />
								<c:set var="download" value="${fn:substring(noti.attachment,5,lh) }" />
								<a href="${path }/${filepath1 }/${file1 }" download>${download }</a>
							</td>
						</c:if>
						<tr>
							<th>조회수</th>
							<td>${noti.readCnt }</td>
						</tr>
					</tbody>
				</table>
				<div class="btn btn-group">
					<a href="${path }/NoticeList.do" class="btn btn-primary">공지사항 목록으로</a>
					<c:if test="${sid.equals('admin' }">
						<a href="${path }/NoticeInsert.do" class="btn btn-primary">새 공지사항 등록</a>
						<a href="${path }/NoticeUpdate.do?noticeId=${noti.noticeId }" class="btn btn-primary">글 변경</a>
						<a href="${path }/NoticeDelete.do?noticeId=${noti.noticeId }" class="btn btn-primary">글 삭제</a>
					</c:if>
				</div>
			</section>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>