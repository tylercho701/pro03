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
<title>Insert title here</title>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container is-fullhd">
	<table class="table">
		<thead>
			<tr>
				<th>연번</th>
				<th>registeredBy</th>
				<th>visitTitle</th>
				<th>visitAddr</th>
				<th>regDate</th>
				<th colspan="2">rStatus</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="" items="" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<a href="" class="button is-info">상태 변경</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div>
	<a href="javascript:history.go(-1)" class="button is-danger">뒤로가기</a>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>