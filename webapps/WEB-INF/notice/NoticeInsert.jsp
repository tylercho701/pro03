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
<title>Notification Registration</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<section class="container-fluid">
				<h2 class="title">공지사항 등록</h2>
				<form action="${path }/NoticeInsertPro.do" method="post" enctype="multipart/form-data">
					<table class="table">
						<tbody>
							<tr>
								<th><label for="noticeTitle">제목</label></th>
								<td>
									<input type="hidden" name="writtenBy" id="writtenBy" value="${sid }">
									<input type="text" name="noticeTitle" id="noticeTitle" maxlength="100" required autofocus>
								</td>
							</tr>
							<tr>
								<th><label for="noticeContent">내용</label></th>
								<td>
									<textarea cols="100" rows="10" id="noticeContent" name="noticeContent" required ></textarea>
								</td>
							</tr>
							<tr>
								<th><label for="attachment">첨부파일</label></th>
								<td><input type="file" id="attachment" name="attachment"></td>
							</tr>
							<tr>
								<td colspan="3">
									<input type="submit" class="btn btn-primary" value="글쓰기">
									<a href="${path }/NoticeList.do" class="btn btn-primary">글 목록</a>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</section>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>