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
<title>Modification Question</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<section class="container-fluid">
				<h2>질문 글 수정</h2>
				<form action="${path }/QnaUpdateQuestionPro.do" method="post" enctype="multipart/form-data">
					<table class="table">
						<tbody>
							<tr>
								<th><label for="qTitle">질문 제목</label></th>
								<td>
									<input type="hidden" name="writtenBy" id="writtenBy" value="${sid }">
									<input type="hidden" name="qid" id="qid" value="${qna.qid }">
									<input type="text" name="title" id="title" value="${qn.qTitle }" maxlength="98" title="100자 내로 작성" placeholder="100자 내로 작성" class="form-control" required autofocus>
								</td>
							</tr>
							<tr>
								<th><label for="content">질문 내용</label></th>
								<td>
									<textarea rows="10" cols="100" name="content" id="content" maxlength="990" title="1000자 내로 작성" class="form-control">${qn.qContent }</textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="질문 수정" class="btn btn-primary">
									<a href="${path }/QnaList.do" class="btn btn-primary">QNA 목록</a>				
								</td>
							</tr>
						</tbody>
					</table>
				</form>
				<hr>
				<h3>답글 보기</h3>
				<table class="table">
					<thead>
						<tr><th>연번</th><th>답변 제목</th><th>작성자</th><th>작성일</th></tr>
					</thead>
					<tbody>
						<c:forEach var="qna" items="${qnaList }">
						<tr>
							<td>${qna.qId }</td>
							<td>
								<a href="${path }/QnAAnswerDetail.do?qid=${qna.qId }">${qna.qTitle }</a>
							</td>
							<td>${qna.askedBy }</td>
							<td>
								<fmt:parseDate value="${qna.askedAt }" var="resdate" pattern="yyyy-MM-dd HH:mm:ss" />
								<fmt:formatDate value="${resdate }" pattern="yyyy년 MM월 dd일" />
							</td>
						</tr>
						</c:forEach>
						<c:if test="${empty qnaList }">
						<tr>
							<td colspan="4">답변 목록이 존재하지 않습니다.</td>
						</tr>
						</c:if>	
					</tbody>
				</table>
			</section>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>