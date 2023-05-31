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
<title>cateDetail</title>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="content">
<h2 class="title">카테고리 상세</h2>
	<table class="table">
		<tbody>
			<tr>
				<th>카테고리 번호</th>
				<td>
					${cat.catecode }
				</td>
			</tr>
			<tr>
				<th>카테고리 그룹명</th>
				<td>
					${cat.categroup }
				</td>
			</tr>
			<tr>
				<th>카테고리 명</th>
				<td>
					${cat.catename }
				</td>
			</tr>
		</tbody>
	</table>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>