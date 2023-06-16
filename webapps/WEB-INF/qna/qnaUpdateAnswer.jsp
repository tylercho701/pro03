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
<link rel="stylesheet" href="../../form_common.css">
<link rel="stylesheet" href="/source/bulma.css">
<meta charset="UTF-8">
<title>Modification Answer</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<h2>답변 수정</h2>
			<form action="${path }/QnaUpdateAnswerPro.do" method="post">
				<table class="table">
					<tbody>
						<tr>
							<th><label for="qTitle">답변 제목</label></th>
							<td>
								<input type="hidden" name="qId" id="qId" value="${qna.qId }">
								<input type="text" name="qTitle" id="qTitle" value="${qna.qTitle }" maxlength="98" title="100자 내로 작성" placeholder="100자 내로 작성" class="form-control" required autofocus>
							</td>
						</tr>
						<tr>
							<th><label for="content">답변 글 내용</label></th>
							<td>
								<textarea rows="10" cols="100" name="content" id="content" maxlength="990" title="1000자 내로 작성" class="form-control">${qna.qContent }</textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="답변 수정" class="button is-primary">
								<a href="javascript:history.go(-1)" class="button is-info">이전으로</a>				
							</td>
						</tr>
					</tbody>
				</table>
			</form>		
		</div>
		<%@ include file="../../footer.jsp" %>
	</div>
</body>
</html>