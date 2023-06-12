<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*, java.text.*, java.net.InetAddress" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common.jsp" />
<title>detail</title>
<style>
#container { text-align: center;}
</style>
</head>
<body>
<jsp:include page="../header.jsp" />
<div class="container is-fullhd">
	<!--  -->
	<section class="section" style="text-align:center;">
	  <h1 class="title" style="margin-bottom: 40px; ">${visit.visitTitle }</h1>
	  <img src="${path }/visit/${visit.visitImgMain }" alt="main">
	</section>
<!-- 	
	<section class="section is-medium" style="text-align:center;">
	  
	</section> -->
	
	<div>
		<button type="button" id="like" class="button" onClick="" value="">좋아요(${visit.likeCnt })</button>
		<button type="button" id="poke" class="button is-info" onClick="pokeCtrl()" value=""></button>
	</div>
	
	<!--  -->
	<div class="tabs is-centered">
	  <ul>
	    <li id="detail" class="is-active"><a onClick="switchDetail()">상세정보</a></li>
	    <li id="map"><a onClick="switchMap()">지도</a></li>
	    <li id="review"><a onClick="switchReview()">리뷰</a></li>
	  </ul>
	</div>
	<div id="container">
		<!-- 상세 -->
		<div id="detail-content">
			<c:if test="${!empty visit.visitImgSub1 }">
				<img src="${path }/visit/${visit.visitImgSub1 }" alt="sub1">
			</c:if>
			<br>
			<c:if test="${!empty visit.visitText }">
				<span>${visit.visitText }</span>
			</c:if>
		</div>
		<!-- 지도 -->
		<div id="map-content" class="is-hidden">
			<iframe src="${visit.visitMapLink }" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
		</div>
		
		<!-- 리뷰 -->
		<div id="review-content" class="is-hidden">
		
		</div>
	</div>
</div>
<jsp:include page="../footer.jsp" />
<script>
	function switchDetail(){
		preSwitch();
		$("#detail").addClass("is-active");
		$("#detail-content").removeClass("is-hidden");
	}
	function switchMap(){
	    preSwitch();
	    $("#map").addClass("is-active");
	    $("#map-content").removeClass("is-hidden");
	}
	function switchReview(){
	    preSwitch();
	    $("#review").addClass("is-active");
	    $("#review-content").removeClass("is-hidden");
	}
	function preSwitch() {
	    $("li").each(function() {
	        $(this).removeClass("is-active");
	    });
	    $("#detail-content").addClass("is-hidden");
	    $("#map-content").addClass("is-hidden");
	    $("#review-content").addClass("is-hidden");
	}
	$(document).ready(function(){
		if('${sid }' == null){
			$("#poke").html('찜하기');
		} else {
			var params = { pokedBy: "<c:out value='${sid }' />", visitId: "<c:out value='${visit.visitId }' />"}
			//console.log(params.pokedBy);
			$.ajax({
				url:"${path }/PokeCheck.do",
				type:"post",
				dataType:"json",
				data:params,
				success:function(result){
					console.log(result);
					if(result.res == '0'){
						$("#poke").val('no');
						$("#poke").html('찜하기');
					} else {
						$("#poke").val('yes');
						$("#poke").html('찜하기 취소');
					}
				}
			});
		}
	});
	
	function pokeCtrl(){
	 	if("${sid }" == ""){
			alert("로그인 후 사용하실 수 있는 기능입니다.");
		} else if($("#poke").val() == "no"){
			var params = {pokedBy: "<c:out value='${sid }' />", visitId: "<c:out value='${visit.visitId }' />"}
			$.ajax({
				url:"${path }/PokeInsertPro.do",
				type:"post",
				dataType:"json",
				data:params,
				success:function(result){
					//console.log(result);
					if(result.res == "1"){
						$("#poke").val('yes');
						$("#poke").html('찜하기 취소');
					}
				}
			});
		} else if($("#poke").val() == "yes"){
			var params = {pokedBy: "<c:out value='${sid }' />", visitId: "<c:out value='${visit.visitId }' />"}
			$.ajax({
				url:"${path }/PokeDeletePro.do",
				type:"post",
				dataType:"json",
				data:params,
				success:function(result){
					console.log(result);
					if(result.res == "1"){
						$("#poke").val('no');
						$("#poke").html('찜하기');
					}
				}
			});
		}
	}
</script>
</body>
</html>