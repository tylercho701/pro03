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
<title>Insert Question</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<section class="container-fluid">
				<h2>질문 작성</h2>
				<form action="${path }/QnaInsertQuestionPro.do" method="post">
					<table class="table">
						<tbody>
							<tr>
								<th><label for="qTitle">질문 제목</label></th>
								<td>
									<input type="hidden" name="askedBy" id="askedBy" value="${askedBy }">
									<input type="text" name="qTitle" id="qTitle" maxlength="100" required autofocus>
								</td>
							</tr>
							<tr>
								<th><label for="qContent">질문 내용</label></th>
								<td>
									<textarea rows="10" cols="100" name="qContent" id="qContent" maxlength="990" title="1000자 내로 작성" ></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="글쓰기" class="button is-primary">
									<a href="${path }/QnaList.do" class="button is-info">QNA 목록</a>				
								</td>
							</tr>
						</tbody>
					</table>
				</form>		
			</section>
		</div>
		<%@ include file="../../footer.jsp" %>
	</div>
</body>
</html>