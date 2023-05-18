<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<%@ page import="kr.go.busan.*" %>
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
		<h2 class="title">JSONArray 형태의 ArrayList 객체 출력</h2>
		<hr>
		<div id="msg">
			<ul id="lst">
				
			</ul>
		</div>
		<button type="button" id="reqBtn">데이터 가져오기</button>
		<script>
			$(document).ready(function(){
				$("#reqBtn").click(function(){
					$.ajax({
						url:"${path }/JSONTest3.do",
						type:"post",
						enctype:"UTF-8",
						dataType:"json",
			 			processData:false,
						contentType:false, 
						cache:false,
						success:function(data){
							$("#lst").empty();
							var trans = data;
							console.log(trans.data);
							var tg = "";
							$.each(trans, function(key, value){
								if(key=="data"){
									for(var i=0;i<value.length;i++){
										tg = "";
										console.log(value[i].item1);
										tg = tg + "<div>아이디 : "+value[i].item1+"</div>";
										tg = tg + "<div>포인트 : "+value[i].item2+"</div>";
										tg = tg + "<div>가입일 : "+value[i].item3+"</div>";
										tg = tg + "<hr>"
										$("#lst").append("<li>"+tg+"</li>");
									}
								}
							});
						}
					});
				});
			});
		</script>
	</div>
</body>
</html>