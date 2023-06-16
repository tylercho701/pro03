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
<title>로그인 하기</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<h2 class="title">로그인</h2>
			<form action="${path }/MemberLoginPro.do" method="post" class="box">
				<table class="table is-striped">
					<tbody>
						<tr>
							<th>
								<div class="field">
									<label class="label" for="id">아이디</label>
								</div>
							</th>
							<td>
								<div class="control">
									<input class="input" type="text" name="id" id="id" placeholder="아이디를 입력하세요." required autofocus>
								</div>
							</td>
						</tr>
						<tr>
						<tr>
							<th>
								<div class="field">
									<label class="label" for="pw">비밀번호</label>
								</div>
							</th>
							<td>
								<div class="control">
									<input class="input" type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요." required>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="로그인" class="button is-succes">
								<input type="reset" value="취소" class="button is-danger" >
								<a href="${path }/MemberTerms.do" class="button is-info">회원가입</a>				
							</td>
						</tr>
					</tbody>
				</table>
			</form>		
		</div>
		<%@ include file="../../footer.jsp" %>
	</div>
</body>
</html>