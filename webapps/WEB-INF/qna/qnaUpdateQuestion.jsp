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
<meta charset="UTF-8">
<title>Modification Question</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>	
		<div class="content">
			<div class="container-fluid">
				<h2>질문 글 수정</h2>
				<form action="${path }/QnaUpdateQuestionPro.do" method="post">
					<table class="table">
						<tbody>
							<tr>
								<th><label for="qTitle">질문 제목</label></th>
								<td>
									<input type="hidden" name="qId" id="qId" value="${qna.qId }">
									<input type="text" name="qTitle" id="qTitle" value="${qna.qTitle }" maxlength="98" required>
								</td>
							</tr>
							<tr>
								<th><label for="qContent">질문 내용</label></th>
								<td>
									<textarea rows="10" cols="100" name="qContent" id="qContent" maxlength="990">${qna.qContent }</textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="질문 수정" class="button is-primary">
									<a href="javascript:history.go(-1)" class="button is-info">이전으로</a>				
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
		<%@ include file="../../footer.jsp" %>
	</div>
</body>
</html>