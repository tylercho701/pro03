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
<title>MemberList</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<section>
				<h2 class="title">회원 현황</h2>
				<table class="table">
					<thead>
						<tr><th>회원아이디</th><th>비밀번호(앞세자리이후*)</th><th>이름</th><th>연락처</th><th>Email</th><th>주소</th><th>로그인회수</th></tr>
					</thead>
					<tbody>
						<c:forEach var="mem" items="${memList }">
						<tr>
							<td>${mem.id }</td>
							<td>${mem.pw }</td>
							<td><a href="${path }/MemberDetail.do?id=${mem.id }">${mem.name }</a></td>
							<td>${mem.tel }</td>
							<td>${mem.email }</td>
							<td>${mem.addr }</td>
							<td>${mem.logCnt }</td>
						</tr>
						</c:forEach>
						<c:if test="${empty memList }">
							<tr>
								<td colspan="5">가입한 회원이 없습니다.</td>
							</tr>
						</c:if>	
					</tbody>
				</table>
				<c:if test="${sid == 'admin' }">
				<div class="btn btn-group">
					<a href="${path }/MemberInsert.do" class="button is-default">직권 회원 등록</a>
				</div>
				</c:if>
			</section>
		</div>
		<%@ include file="../../footer.jsp" %>
	</div>
</body>
</html>