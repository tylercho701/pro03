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
<title>regList</title>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container is-fullhd">
	<h2 class="title">여행목록</h2>
	<c:if test="${!empty regiVOList }">
	<table class="table">
		<thead>
			<tr>
				<th>연번</th>
				<th>여행상품명</th>
				<th>주소</th>
				<th>여행일자</th>
				<th colspan="3">상태</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${regiVOList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${list.visitTitle }</td>
				<td>${list.visitAddr }</td>
				<td>${list.tourDate }</td>
				<td>${list.rStatus }</td>
				<td>
					<c:if test="${list.rStatus == '여행신청' }">
					<a href="${path }/RegiUpdate.do?regId=${list.regId }&visitId=${list.visitId }" class="button is-info">여행일자 수정하기</a>
					</c:if>
				</td>
				<td>
					<c:if test="${list.rStatus != '여행완료' }">
					<a href="${path }/RegiDeletePro.do?regId=${list.regId }&sid=${sid }" class="button is-danger">여행 취소하기</a>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
	<c:if test="${empty regiVOList }">
	<h3 class="subtitle">여행목록이 존재하지 않습니다.</h3>
	</c:if>
	<div>
	<a href="${path }/" class="button is-info">홈으로</a>
</div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>