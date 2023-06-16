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
<%@ include file="../../common.jsp" %>
<link rel="stylesheet" href="../../form_common.css">
<link rel="stylesheet" href="${path }/source/bulma.css">
<title>여행상태변경</title>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<h2 class="title">여행 상태 변경</h2>
			<form action="${path }/UpdateRstatus.do" method="post">
				<table class="table">
					<tbody>
						<tr>
							<th>regId</th>
							<td>
								<span>${list.regId }</span>
								<input type="hidden" id="regId" name="regId" value="${list.regId }">
							</td>
						</tr>
						<tr>
							<th>visitTitle</th>
							<td>
								${list.visitTitle }
							</td>
						<tr>
							<th>visitAddr</th>
							<td>${list.visitAddr }</td>
						</tr>
						<tr>
							<th>tourDate</th>
							<td><input type="date" id="tourDate" name="tourDate"></td>
						</tr>
						<tr>
							<th><label for="rStatus">여행상태</label></th>
							<td>
								<span>${list.rStatus }</span>
								<select id="rStatus" name="rStatus" required>
									<option value="여행 신청">여행 신청</option>
									<option value="여행 승인">여행 승인</option>
									<option value="여행 완료">여행 완료</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
			<div>
				<input type="submit" value="rStatus 처리 변경" class="button is-info">
				<a href="javascript:history.go(-1)" class="button is-danger">뒤로가기</a>
			</div>
		</div>
		<%@ include file="../../footer.jsp" %>
	</div>
</body>
</html>