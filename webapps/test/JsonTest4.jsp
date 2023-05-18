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
		<input  class="input is-normal" type="text" id="item1" name="item1">
			<ul id="lst">
				
			</ul>
		</div>
		<button class="button" type="button" id="reqBtn">데이터 가져오기</button>
		<script>
			$(document).ready(function(){
				$("#reqBtn").click(function(){
					if($("#item1").val()==""){
						alert("검색할 아이디를 입력하세요.");
						$("#item1").focus();
						return;
					}
					var params = { item1:$("#item1").val() };
					$.ajax({
						url:"${path }/JSONTest2.do",
						type:"post",
						dateType:"json",
						data:params,
						success:function(obj){
							/* console.log(result.result); */
							var js = obj;
							if(js.name != "undefined"){
								$("#lst").append("<li>아이디 : "+js.name+"</li>");
								$("#lst").append("<li>포인트 : "+js.point+"</li>");
								$("#lst").append("<li>가입일 : "+js.resdate+"</li>");
							} else {
								$("#lst").append("<li> 올바른 아이디를 입력하세요.</li>");
							}
						}
					});
				});
			});
		</script>
	</div>
</body>
</html>