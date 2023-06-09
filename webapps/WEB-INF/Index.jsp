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
<%@ include file="../common.jsp" %>
<link rel="stylesheet" href="/source/bulma.css">
<link rel="stylesheet" href="../form_common.css">
<meta charset="UTF-8">
<title>VISIT BUSAN</title>
<style>
.row:after { content:""; display:block; clear:both; }
.row li { float:left; }
.content ul.row { width:960px; margin:10px auto; margin-left:auto; margin-right:auto; }
.tb_review { float:left; width:620px; margin:10px 30px; border: 1px solid #333 ; text-align:center; }
.tb_review > h3 { margin:15px auto; }
.tb_review:last-child { margin:10px auto; }
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../header.jsp" %>
		<div class="content">
			<h2 class="title">VISIT BUSAN</h2>
			<div class="tb_review">
				<h3>Review_Ranking_Top_3</h3>
				<table class="table">
					<thead>
						<tr>
							<th>Rank</th>
							<th>Name</th>
							<th>cnt</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rList" items="${reviewList }" varStatus="status">
							<tr>
								<td>${status.count }</td>
								<td>${rList.reviewedBy }</td>
								<td>${rList.likeCnt }</td>
							</tr>
						</c:forEach>
						<c:if test="${empty reviewList}">
							<tr>
								<td colspan="3">여행 후기 랭크가 준비되지 않았습니다.</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
			<div class="tb_review">
				<h3>Review_Ranking_Top_3</h3>
				<table class="table">
					<thead>
						<tr>
							<th>Rank</th>
							<th>Name</th>
							<th>cnt</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rList" items="${reviewList }" varStatus="status">
							<tr>
								<td>${status.count }</td>
								<td>${rList.reviewedBy }</td>
								<td>${rList.likeCnt }</td>
							</tr>
						</c:forEach>
						<c:if test="${empty reviewList}">
							<tr>
								<td colspan="3">여행 후기 랭크가 준비되지 않았습니다.</td>
							</tr>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
		<div class="divider" style="clear:both; content=""; ">
			<span>
			</span>
		</div>
		<%@ include file="../footer.jsp" %>
	</div>
	<script>
		$(document).ready(function(){
			$.ajax({
				url:"${path }/MenuLoad.do",
				type:"post",
				enctype:"UTF-8",
				processData:false,
				contentType:"application/json",
				cache:false,
				success:function(obj){
					//console.log(obj);
					$(".navbar-dropdown.cate").empty();
					$(".ftcate").empty();
					$.each(obj, function(key, value){
						for (var i=0;i<value.length;i++){
							if(value[i].cateGroup == "여행"){
								$("#cate01").append("<a href='${header_path }/VisitListbyCateCode.do?cateCode="+value[i].cateCode+"' class='navbar-item'>"+value[i].cateName+"</a>");
								$("#cf01").append("<li><a href='${footer_path }/VisitListbyCateCode.do?cateCode="+value[i].cateCode+"'>"+value[i].cateName+"</a></li>");	
							} else if(value[i].cateGroup == "공연"){
								$("#cate02").append("<a href='${header_path }/VisitListbyCateCode.do?cateCode="+value[i].cateCode+"' class='navbar-item'>"+value[i].cateName+"</a>");
								$("#cf02").append("<li><a href='${footer_path }/VisitListbyCateCode.do?cateCode="+value[i].cateCode+"'>"+value[i].cateName+"</a></li>");
							} else if(value[i].cateGroup == "축제"){
								$("#cate03").append("<a href='${header_path }/VisitListbyCateCode.do?cateCode="+value[i].cateCode+"' class='navbar-item'>"+value[i].cateName+"</a>");
								$("#cf03").append("<li><a href='${footer_path }/VisitListbyCateCode.do?cateCode="+value[i].cateCode+"'>"+value[i].cateName+"</a></li>");
							}
						}
					});
				}
			});
		});
	</script>
</body>
</html>