<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*, java.text.*, java.net.InetAddress" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="${page }/common.jsp" />
<link rel="stylesheet" href="../../form_common.css">
<link rel="stylesheet" href="/source/bulma.css">
<title>여행일자 수정</title>
</head>
<body>
	<div class="container">
		<jsp:include page="${page }/header.jsp" />
		<div class="content">
			<h2 class="title">여행일자 수정</h2>
			<form action="${path }/RegiUpdatePro.do" method="post">
				<table class="table" style="width: 90%">
					<tbody>
						<tr>
							<th>visitTitle</th>
							<td>
								${visit.visitTitle }
								<input type="hidden" id="regId" name="regId" value="${regId }">
								<input type="hidden" id="sid" name="sid" value="${sid }">
							</td>
						<tr>
							<th>tourDate</th>
							<td><input type="date" id="tourDate" name="tourDate"></td>
						</tr>
					</tbody>
				</table>
				<div>
					<input type="submit" value="여행일자 수정하기" class="button is-info">
					<a href="javascript:history.go(-1)" class="button is-danger">뒤로가기</a>
				</div>
			</form>
		</div>
		<jsp:include page="${page }/footer.jsp" />
	</div>
		<script>
			$(document).ready(function(){
				var date = new Date();
				var year = date.getFullYear();
				var month = ('0' + (date.getMonth() + 1)).slice(-2);
				var day = ('0' + date.getDate()).slice(-2);
				var today = year + '-' + month  + '-' + day;
				$("#tourDate").attr('min', today);
			});
		</script>
</body>
</html>