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
<title>MyPage</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<section class="container-fluid">
				<h2 class="title">내 정보 보기</h2>
				<table class="table">
					<tbody>
						<tr>
							<th>아이디</th>
							<td>${member.id }</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td>${member.pw }</td>
						</tr>
						<tr>
							<th>회원이름</th>
							<td>${member.name }</td>
						</tr>
						<tr>
							<th>연락처</th>
							<td>${member.tel }</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>${member.email }</td>
						</tr>
						<tr>
							<th>주소</th>
							<td>${member.addr }</td>
						</tr>
						<tr>
							<th>방문 횟수</th>
							<td>${member.logCnt }</td>
						</tr>
						<tr>
							<td colspan="2">
								<a href="${path }/MemberUpdate.do?id=${member.id}" class="btn btn-primary">회원 정보 수정</a>
								<a href="${path }/MemberDelete.do?id=${member.id}" class="btn btn-primary">회원 탈퇴</a>
								<a href="javascript:history.go(-1)" class="btn btn-primary">뒤로</a>						
							</td>
						</tr>
					</tbody>
				</table>
			</section>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>