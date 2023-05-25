<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Review Detail</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<section class="container-fluid">
				<h2 class="title">리뷰 상세</h2>
				<table class="table">
					<tbody>
						<tr>
							<th>리뷰번호</th>
							<td>
								${review.reviewId }
								<input type="hidden" value="${review.reviewId }" id="reviewId" name="reviewId">	
							</td>
						</tr>
						<tr>
							<th>작성자 ID</th>
							<td>${review.reviewedBy }</td>
						</tr>
						<tr>
							<th>점수</th>
							<td>${review.point }</td>
						</tr>
						<tr>
							<th>작성일</th>
							<td>
								<fmt:parseDate value="${review.reviewedAt }" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate value="${regdate }" pattern="yyyy년 MM월 dd일" />
							</td>
						</tr>
						<tr>
							<th>리뷰 제목</th>
							<td>${review.reviewTitle }</td>
						</tr>
						<tr>
							<th>리뷰 내용</th>
							<td>${review.reviewContent }</td>
						</tr>
						<tr>
							<td colspan="2">
								<c:if test="${review.reviewedBy == sid }">
									<a href="${path }/ReviewUpdate.do?rnum=${review.reviewId}" class="button is-primary">구매 후기 수정</a>
									<a href="${path }/ReviewDelete.do?rnum=${review.reviewId}" class="button is-danger">구매 후기 삭제</a>
								</c:if>
								<c:if test="${sid == 'admin' }">
									<a href="${path }/ReviewDelete.do?rnum=${review.reviewId}" class="button is-danger">구매 후기 삭제</a>
								</c:if>
								<a href="javascript:history.go(-1)" class="button is-warning">뒤로가기</a>
							</td>
						</tr>
						<tr>
							<td colspan="2">
							첨부 이미지
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<figure class="image is-4by3">
									<img src="${review.img }">
								</figure>
							</td>
						</tr>
					</tbody>
				</table>
			</section>
		</div>
		<%@ include file="../../footer.jsp" %>
	</div>
</body>
</html>