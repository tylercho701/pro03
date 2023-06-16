<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Review Update</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<h2 class="title">리뷰 수정</h2>
			<form action="${path }/ReivewUpdatePro.do" method="post" enctype="multipart/form-data">
				<table class="table">
					<tbody>
						<tr>
							<th><label for="reviewTitle">제목</label></th>
							<td>
								<input type="hidden" name="reviewedBy" id="reviewedBy" value="${review.reviewedBy }">
								<input type="hidden" name="reviewId" id="reviewId" value="${review.reviewId }">
								<input type="text" name="noticeTitle" id="noticeTitle" maxlength="100" value="${review.reviewTitle }" required autofocus>
							</td>
						</tr>
						<tr>
							<th><label for="reviewContent">내용</label></th>
							<td>
								<textarea cols="100" rows="10" id="noticeContent" name="noticeContent" required >${review.reviewContent }</textarea>
							</td>
						</tr>
						<tr>
							<th><label for="img">첨부파일</label></th>			<!-- 이미지는 게시 형식이고, 교체 가능 여부를 구현해야 함 -->
							<td>
								<span>
									<c:set var="lh" value="${fn:length(review.img) }" />
									<c:set var="download" value="${fn:substring(review.img,5,lh) }" />
									${download }
								</span><br>
								<input type="radio" name="fileSel" id="fileSel1" onclick="fileCall()" checked>교체 안함<br> 
								<input type="radio" name="fileSel" id="fileSel2" onclick="fileCall()" >교체<br>
								<input type="file" name="img" id="img" class="">
								<input type="hidden" name="file1" id="file2" value="${download }">
								<script>
									function fileCall(){
										var fileSel1 = document.getElementById("fileSel1");
										var fileSel2 = document.getElementById("fileSel2");
										var file1 = document.getElementById("file1");
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
								<a href="${path }/ReviewList.do" class="button is-info">글 목록</a>
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