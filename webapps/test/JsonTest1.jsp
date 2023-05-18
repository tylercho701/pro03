<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

<!-- BULMA CDN -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css"> -->
<link rel="stylesheet" href="${path }/source/bulma.css">

<!-- 스타일 초기화 -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css" rel="stylesheet">

<!-- Jquery CND -->
<script src="https://code.jquery.com/jquery-latest.js"></script>

<style>
</style>
</head>
<body>
	<div class="container">
		<div id="msg">
			<ul id="lst">
				
			</ul>
		</div>
	</div>
	<button type="button" id="reqBtn">데이터 가져오기</button>
	<script>
		$(document).ready(function(){
			var obj = {id:"kkt", point:99, resdate:"2023-02-27"};
			$("#lst").append("<li>아이디 : "+obj.id+"</li>");
			$("#lst").append("<li>포인트 : "+obj.point+"</li>");
			$("#lst").append("<li>가입일 : "+obj.resdate+"</li>");
		});
	</script>
	<script>
		$(document).ready(function(){
			$("#reqBtn").click(function(){
				$.ajax({
					url:"${path }/JSONTest1.do",
					type:"post",
					dateType:"json",
					success:function(result){
						//console.log(result.result);
						$("#lst").append("<li>메세지 : "+result.result+"</li>");
					}
				})
			})
		})
	</script>
</body>
</html>