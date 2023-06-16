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
<link rel="stylesheet" href="../../form_common.css">
<link rel="stylesheet" href="/source/bulma.css">
<meta charset="UTF-8">
<title>MemberDetail</title>
<style>

</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<h2 class="title" style="padding-top:30px" >회원 정보 상세 보기</h2>
			<table class="table is-striped table is-fullwidth">
				<tbody>
					<tr>
						<th>아이디</th>
						<td>${mem.id }</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td>${mem.pw }</td>
					</tr>
					<tr>
						<th>회원이름</th>
						<td>${mem.name }</td>
					</tr>
					<tr>
						<th>연락처</th>
						<td>${mem.tel }</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${mem.email }</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${mem.addr }</td>
					</tr>
					<tr>
						<th>방문 횟수</th>
						<td>${mem.logCnt }</td>
					</tr>
					<tr>
						<td colspan="2">
						<div class="buttons">
							<a href="${path }/MemberUpdate.do?id=${mem.id}" class="button is-primary">회원 정보 수정</a>
							<a href="${path }/MemberDeletePro.do?id=${mem.id}" class="button is-danger">회원 탈퇴</a>
							<a href="javascript:history.go(-1)" class="button is-warning">뒤로</a>
						</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<%@ include file="../../footer.jsp" %>
	</div>
</body>
</html>