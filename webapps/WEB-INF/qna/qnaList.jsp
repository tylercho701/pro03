<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common.jsp" %>
<link rel="stylesheet" href="../../form_common.css">
<link rel="stylesheet" href="/source/bulma.css">
<link rel="stylesheet" href="/source/bulma-rtl.css">
<meta charset="UTF-8">
<title>QNA List</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<h2 class="title">QNA 목록</h2>
			<table class="table">
				<thead>
					<tr><th>질문번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
				</thead>
				<tbody>
					<c:forEach var="qna" items="${qList }">
						<tr>
							<c:if test="${qna.qType==1 }">			<!-- 질문  -->
								<td>${qna.qIdGroup }</td>
								<td>
									<a href="${path }/QnaDetail.do?qId=${qna.qId }">${qna.qTitle }</a>
								</td>
							</c:if>
							<c:if test="${qna.qType==2 }">			<!-- 답변  -->
								<td><span>&nbsp;</span></td>
								<td style="padding-left:20px; ">
									<a href="${path }/QnaDetail.do?qId=${qna.qId }">ㄴ ${qna.qTitle }</a>
								</td>
							</c:if>
							<td>${qna.askedBy }</td>
							<td>
								<fmt:parseDate value="${qna.askedAt }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" />
							</td>
						</tr>
					</c:forEach>
					<c:if test="${empty qList }">
					<tr>
						<td colspan="4">질문 및 답변이 존재하지 않습니다.</td>
					</tr>
					</c:if>	
				</tbody>
			</table>
			<c:if test="${!empty sid }">
			<div class="buttons">
				<a href="${path }/QnaInsertQuestion.do?askedBy=${sid }" class="button is-primary">질문하기</a>
			</div>
			</c:if>
		</div>
		<%@ include file="../../footer.jsp" %>
	</div>
</body>
</html>