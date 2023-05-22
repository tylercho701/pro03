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
<title>로그인 하기</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<div class="container-fluid">
				<h2 class="title">로그인</h2>
				<p>${msg }</p>
				<form action="${path }/MemberLoginPro.do" method="post">
					<table class="table">
						<tbody>
							<tr>
								<th><label for="id">아이디</label></th>
								<td>
									<input type="text" name="id" id="id" maxlength="15" placeholder="아이디를 입력하세요." required autofocus>
								</td>
							</tr>
							<tr>
								<th><label for="pw">비밀번호</label></th>
								<td>
									<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요." required>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="로그인" class="btn btn-primary">
									<input type="reset" value="취소" class="btn btn-primary" >
									<a href="${path }/MemberTerms.do" class="btn btn-primary">회원가입</a>				
								</td>
							</tr>
						</tbody>
					</table>
				</form>		
			</div>
		</div>
	</div>
</body>
</html>