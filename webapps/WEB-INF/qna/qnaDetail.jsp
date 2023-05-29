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
<title>QnA Detail</title>
<style>
</style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container">	
	<div class="content">
		<div class="container-fluid">
			<h2>QNA 상세보기</h2>
			<table class="table">
				<tbody>
					<tr>
						<th>QNA 유형</th>
						<td>
							<c:if test="${qna.qType == 1 }">
								질문(Question)
							</c:if>
							<c:if test="${qna.qType == 2 }">
								답변(Answer)
							</c:if>
							<input type="hidden" name="qid" id="qid" value="${qna.qId }">
						</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${qna.qTitle }</td>
					</tr>
					<tr>
						<th>작성자ID</th>
						<td>
							${qna.askedBy }
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							${qna.qContent }
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<c:if test="${qna.askedBy.equals(sid) }">
								<c:if test="${qna.qType == 1 }">
									<a href="${path }/QnaUpdateQuestion.do?qId=${qna.qId }" class="button is-info">질문 수정</a>
									<a href="${path }/QnaDeleteQuestionPro.do?qId=${qna.qId }" class="button is-danger">질문 삭제</a>
									<a href="${path }/QnaList.do" class="button is-default">QNA 목록</a>
								</c:if>
								<c:if test="${qna.qType == 2 }">
										<a href="${path }/QnaUpdateAnswer.do?qId=${qna.qId }" class="button is-info">답변 수정</a>
										<a href="${path }/QnaDeleteAnswerPro.do?qId=${qna.qId }" class="button is-danger">답변 삭제</a>
										<a href="${path }/QnaList.do" class="button is-default">QNA 목록</a>
								</c:if>	
							</c:if>
							<c:if test="${sid.equals('admin') }">
								<c:if test="${qna.qType == 1 }">
									<a href="${path }/QnaInsertAnswer.do?qId=${qna.qId }" class="button is-info">답변 등록</a>
									<a href="${path }/QnaList.do" class="button is-default">QNA 목록</a>
								</c:if>
							</c:if>		
						</td>
					</tr>
				</tbody>
			</table>
			<c:if test="${qna.qType == 1 }">
				<h3>답글 보기</h3>
				<table class="table">
					<thead>
						<tr><th>연번</th><th>답변 제목</th><th>작성일</th></tr>
					</thead>
					<tbody>
						<c:forEach var="qna" items="${qListA }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td>
								<a href="${path }/QnaDetail.do?qId=${qna.qId }">${qna.qTitle }</a>
							</td>
							<td>
								<fmt:parseDate value="${qna.askedAt }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" />
							</td>
						</tr>
						</c:forEach>
						<c:if test="${empty qListA }">
						<tr>
							<td colspan="4">답변 목록이 존재하지 않습니다.</td>
						</tr>
						</c:if>	
					</tbody>
				</table>
			</c:if>
			<c:if test="${qna.qType == 2 }">
				<h3>질문 보기</h3>
				<table class="table">
					<thead>
						<tr><th>연번</th><th>질문 제목</th><th>작성일</th></tr>
					</thead>
					<tbody>
						<c:forEach var="qna" items="${qListQ }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td>
								<a href="${path }/QnaDetail.do?qId=${qna.qId }">${qna.qTitle }</a>
							</td>
							<td>
								<fmt:parseDate value="${qna.askedAt }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" />
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>