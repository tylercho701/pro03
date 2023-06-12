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
<%@ include file="../common.jsp" %>
<title>visitUpdate</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div>
	<h2>VisitUpdate</h2>
	<p>${msg }</p>
	<form action="${path }/InsertVisitPro.do" method="post" enctype="multipart/form-data" onsubmit="onSubmit();">
		<table class="table">
			<tbody>
				<tr>
					<th><label for="name">visit명</label></th>
					<td>
						<input type="text" id="name" name="name" maxlength="195" title="200자 이내로 작성해 주십시오."
						 placeholder="200자 이내로 작성해 주십시오."required="required">
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input type="text" id="address1" name="address1" placeholder="기본주소">
						<input type="text" id="address2" name="address2" placeholder="상세주소">
						<input type="text" id="postcode" name="postcode" placeholder="우편번호">
						<button type="button" onclick="findAddr()" class="btn btn-primary">우편번호 검색</button>
					</td>
				</tr>
				<tr>
					<th><label for="imgMain">첨부 파일</label></th>
					<td>
						<c:if test="${!empty prod.pic1 }">
						<img src="${path }/product/${prod.pic1 }" alt="${prod.p_name }">
						</c:if>
						<p></p>
						<input type="file" name="imgMain" id="imgMain" class="form-control file">
						<c:if test="${!empty prod.pic1 }">
						<input type="hidden" name="og_imgMain" id="og_imgMain" value="${prod.pic1 }">
						</c:if>
					</td>
				</tr>
				<tr>
					<th><label for="imgSub1">첨부 파일</label></th>
					<td>
						<c:if test="${!empty prod.pic2 }">
						<img src="${path }/product/${prod.pic2 }" alt="${prod.p_name }">
						</c:if>
						<p></p>
						<input type="file" name="imgSub1" id="imgSub1" class="form-control file">
						<c:if test="${!empty prod.pic2 }">
						<input type="hidden" name="og_imgSub1" id="og_imgSub1" value="${prod.pic2 }">
						</c:if>
					</td>
				</tr>
				<tr>
					<th><label for="imgSub1">첨부 파일</label></th>
					<td>
						<c:if test="${!empty prod.pic3 }">
						<img src="${path }/product/${prod.pic3 }" alt="${prod.p_name }">
						</c:if>
						<p></p>
						<input type="file" name="imgSub1" id="imgSub1" class="form-control file">
						<c:if test="${!empty prod.pic3 }">
						<input type="hidden" name="og_imgSub1" id="og_imgSub1" value="${prod.pic3 }">
						</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="visit 등록" class="btn btn-primary">
						<a href="javascript:history.go(-1)">뒤로가기</a>				
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<script>
		$(document).ready(function(){
			$(".file").change(function(){
				var tar = $(this).index();
				if($(this).val()!=""){
					$(this).prev("p").html("<strong>이미지 첨부 성공</strong>");
				}
			});
		});
		function findAddr(){
			new daum.Postcode({
				oncomplete: function(data) {
					console.log(data);
					var roadAddr = data.roadAddress;
					var jibunAddr = data.jibunAddress;
					document.getElementById("postcode").value = data.zonecode;
					if(roadAddr !== '') {
						document.getElementById("address1").value = roadAddr;				
					} else if(jibunAddr !== ''){
						document.getElementById("address1").value = jibunAddr;
					}
					document.getElementById("address2").focus();
				}
			}).open();		
		}
	</script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>