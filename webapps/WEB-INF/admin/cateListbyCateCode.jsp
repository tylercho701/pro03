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
<title>CateListbyCateCode</title>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container is-fullhd">
	<h2 class="title">카테고리 리스트</h2>
	<hr>
	<div class="btn-group">
		<a href="${path1 }/GetCategoryAll.do?" class="btn btn-default">전체</a>
		<a href="${path1 }/GetCategory.do?catecode=01" class="btn btn-default">여행</a>
		<a href="${path1 }/GetCategory.do?catecode=02" class="btn btn-default">공연</a>
		<a href="${path1 }/GetCategory.do?catecode=03" class="btn btn-default">축제</a>
	</div>
	<hr>
	<table class="table">
		<thead>
			<tr><th>연번</th><th>카테고리번호</th><th>카테고리 그룹명</th><th colspan="2">카테고리 이름</th></tr>
		</thead>
		<tbody>
			<c:forEach var="cate" items="${cateList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>
					<a href="${path1 }/GetCategoryDetail.do?cate=${cate.cate }">${cate.cate }</a>
				</td>
				<td>${cate.categroup }</td>
				<td>${cate.catename }</td>
				<td><a href="DeleteCategory.do?catecode=${cate.cate }" class="btn btn-danger">카테고리 삭제</a></td>
			</tr>
			</c:forEach>
			<c:if test="${empty cateList }">
			<tr>
				<td colspan="4">카테고리 목록이 존재하지 않습니다.</td>
			</tr>
			</c:if>	
		</tbody>
	</table>
	<c:if test="${!empty sid }">
	<div class="btn-group">
		<a href="${path1 }/InsertCategory.do" class="button is-info">카테고리 등록</a>
		<a href="javascript:history.go(-1)" class="button is-danger">뒤로가기</a>
	</div>
	</c:if>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>