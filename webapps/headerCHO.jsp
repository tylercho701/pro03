<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path_header" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	
	String sid = "";
	if(session != null) {
		sid = (String) session.getAttribute("sid");
	}
%>
<header class="header is-fluid">
	<div class="notification is-primary">
		<p>header</p>
		<a href="${path_header }/Test.do">link</a>
		<a href="${path_header }/MemberLogin.do">로그인</a>
		<a href="${path_header }/MemberMyPage.do?id="+<%=sid %>>마이페이지</a>
		<a href="${path_header }/MemberUpdate.do?id="+<%=sid %>>회원수정</a>
		<a href="${path_header }/MemberTerms.do">회원가입</a>
	</div>
</header>