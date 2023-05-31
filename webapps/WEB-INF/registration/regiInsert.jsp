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
<title>Insert title here</title>
</head>
<body>
<jsp:include page="${page }/header.jsp" />
<div class="container is-fullhd">
	<h2 class="title">regInsert</h2>
	<form action="${path }/RegiInsertPro.do" method="post">
		<table class="table" style="width: 90%">
			<tbody>
				<tr>
					<th>visitTitle</th>
					<td>
						${visit.visitTitle }
						<input type="hidden" id="registeredBy" name="registeredBy" value="${sid }">
						<input type="hidden" id="pokeId" name="pokeId" value="${pokeId }">
						<input type="hidden" id="visitId" name="visitId" value="${visit.visitId }">
					</td>
				<tr>
					<th>tourDate</th>
					<td><input type="date" id="tourDate" name="tourDate"></td>
				</tr>
			</tbody>
		</table>
		<div>
			<input type="submit" value="visit 신청하기" class="button is-info">
			<a href="javascript:history.go(-1)" class="button is-danger">뒤로가기</a>
		</div>
	</form>
</div>
<jsp:include page="${page }/footer.jsp" />
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