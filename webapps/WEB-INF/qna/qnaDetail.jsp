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
						<th>내용</th>
						<td>
							${qna.qContent }
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="답변 수정" class="button is-info">
							<a href="${path }/QnAList.do" class="button is-default">글 목록</a>				
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>