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
<title>Terms</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
		<section>
			<h2 class="title">약관 동의 페이지</h2>
			<article>
				약관1
			</article>
			<div>
				<input type="checkbox" id="ck_item1" name="ck_item">
				<label for="ck_item1">약관에 동의</label><br><br>
			</div>
			<article class="agree_fr">
				약관 2
			</article>
			<div>
				<input type="checkbox" id="ck_item2" name="ck_item2">
				<label for="ck_item2">개인정보처리방침에 동의</label><br><br>
			</div><hr>
			<div>
				<label for="ck_item3" onclick="protocol()">
					<strong>전체 약관에 동의</strong>
				</label>
			</div>
			<hr>
			<div class="btn-group">
				<button type="button" id="in_btn1" class="btn btn-primary">다음 단계</button>
			</div>
			<script>
				var ck_item1 = document.getElementById("ck_item1");
				var ck_item2 = document.getElementById("ck_item2");
				var in_btn1 = document.getElementById("in_btn1");
				in_btn1.addEventListener("click", function(){
					if(ck_item1.checked && ck_item2.checked){
						location.href = "${path_t }/UserSignUp.do";
					} else {
						alert("약관 및 개인정보처리 방침에 동의하지 않으셨습니다.");
						return;
					}
				});
				function protocol(){
					ck_item1.checked = true;
					ck_item2.checked = true;
				}
			</script>
		</section>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>