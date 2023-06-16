<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<title>Notice Update</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<section class="container-fluid">
				<h2 class="title">공지사항 수정</h2>
				<form action="${path }/NoticeUpdatePro.do" method="post" enctype="multipart/form-data">
					<table class="table">
						<tbody>
							<tr>
								<th><label for="title">제목</label></th>
								<td>
									<input type="hidden" name="writtenBy" id="writtenBy" value="${sid }">
									<input type="hidden" name="noticeId" id="noticeId" value="${notice.noticeId }">
									<input type="text" name="noticeTitle" id="noticeTitle" maxlength="100" value="${notice.noticeTitle }" required autofocus>
								</td>
							</tr>
							<tr>
								<th><label for="noticeContent">내용</label></th>
								<td>
									<textarea cols="100" rows="10" id="noticeContent" name="noticeContent" required >${notice.noticeContent }</textarea>
								</td>
							</tr>
							<tr>
								<th><label for="attachment">첨부파일</label></th>
								<td>
									<span>
										<c:set var="lh" value="${fn:length(notice.attachment) }" />
										<c:set var="download" value="${fn:substring(notice.attachment,11,lh) }" />
										${download }
									</span><br>
									<input type="radio" name="fileSel" id="fileSel1" onclick="fileCall()" checked>교체 안함<br> 
									<input type="radio" name="fileSel" id="fileSel2" onclick="fileCall()" >교체<br>
									<input type="file" name="attachment" id="attachment" class="button is-default">
									<input type="hidden" name="file2" id="file2" value="${download }">
									<script>
										function fileCall(){
											var fileSel1 = document.getElementById("fileSel1");
											var fileSel2 = document.getElementById("fileSel2");
											var file1 = document.getElementById("attachment");
											var file2 = document.getElementById("file2");
											if(fileSel1.checked){
												file1.style.display = "none";
												file1.setAttribute("disabled");
												file2.removeAttribute("disabled");
											} else {
												file1.style.display = "block";
												file1.removeAttribute("disabled");
												file2.setAttribute("disabled");
											}
										}
									</script>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="글 수정" class="button is-primary">
									<a href="${path }/NoticeList.do" class="button is-info">글 목록</a>
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