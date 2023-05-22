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
<link rel="stylesheet" href="/source/bulma.css">
<meta charset="UTF-8">
<title>QNA List</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<section class="container-fluid">
				<h2>QNA 목록</h2>
				<table class="table">
					<thead>
						<tr><th>연번</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
					</thead>
					<tbody>
						<c:set var="cnt" value="0" />
						<c:forEach var="qna" items="${qnaList }">
							<tr>
								<c:if test="${qna.qIdGroup==1 }">			<!-- 질문  -->
									<c:set var="cnt" value="${cnt=cnt+1 }" />
									<td>${cnt }</td>
									<td>
										<a href="${path }/QnAQuestionDetail.do?qid=${qna.qId }">${qna.qTitle }</a>
									</td>
								</c:if>
								<c:if test="${qna.qIdGroup==2 }">			<!-- 답변  -->
									<td colspan="2">
										<a href="${path }/QnAAnswerDetail.do?qid=${qna.qId }" >${qna.qTitle }</a>
									</td>
								</c:if>
								<td>${qna.askedBy }</td>
								<td>
									<fmt:parseDate value="${qna.askedAt }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
									<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" />
								</td>
							</tr>
						</c:forEach>
						<c:if test="${empty qnaList }">
						<tr>
							<td colspan="4">질문 및 답변이 존재하지 않습니다.</td>
						</tr>
						</c:if>	
					</tbody>
				</table>
				<c:if test="${!empty sid }">
				<div class="btn-group">
					<a href="${path }/QnaInsertQuestion.do" class="btn btn-primary">질문하기</a>
				</div>
				</c:if>
			</section>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>