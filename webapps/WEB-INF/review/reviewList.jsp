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
<%@ include file="../../common.jsp" %>
<link rel="stylesheet" href="/source/bulma.css">
<meta charset="UTF-8">
<title>Review List</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<section>
				<h2 class="title">리뷰 목록</h2>
				<table class="table">
					<thead>
						<tr><th>리뷰번로</th><th>리뷰제목</th><th>작성자아이디</th><th>작성일</th><th>평점</th></tr>
					</thead>
					<tbody>
						<c:forEach var="rev" items="${reviewList }">
						<tr>
							<td>${rev.reviewId }</td>
							<td><a href="${path }/ReviewDetail.do?reviewId=${rev.reviewId }">${rev.reviewTitle }</a></td>
							<td>${rev.reviewedBy }</td>
							<td>
								<fmt:parseDate var="resdate" value="${rev.reviewedAt }" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" /> 
							</td>
							<td>${rev.point }</td>
						</tr>
						</c:forEach>
						<c:if test="${empty reviewList }">
							<tr>
								<td colspan="5">공지사항이 존재하지 않습니다.</td>
							</tr>
						</c:if>	
					</tbody>
				</table>
				<div class="btn btn-group">			<!-- 리뷰 목록은 어떻게 구현할지 디테일한 의논 후 결정 필요 -->
					<a href="${path }/ReviewInsert.do" class="btn btn-primary">글 등록</a>
				</div>
			</section>
		</div>
		<%@ include file="../../footer.jsp" %>
	</div>
</body>
</html>