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
<title>Modification member info</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../header.jsp" %>
		<div class="content">
			<h2 class="title">회원 정보 수정</h2>
			<form name="frm1" id="frm1" action="${path }/UpdateUserPro.do" method="post">
				<table class="table is-striped table is-fullwidth">
					<tbody>
						<tr>
							<th>아이디</th>
							<td>
								<fieldset disabled>
									<div class="field">
									  <div class="control has-icons-left has-icons-right">
									    <input class="input" type="text" name="id" id="id" value="${mem.id }" required>
									  </div>
									</div>
								</fieldset>
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td>
								<div class="field">
								  <div class="control has-icons-left has-icons-right">
								    <input class="input" type="password" name="pw" id="pw" value="${mem.pw }" required>
								  </div>
								  <p class="help" id="msg" style="padding-left:0.5rem">변경할 비밀번호를 입력하세요.</p>
							     </div>
							</td>
						</tr>
						<tr>
							<th>비밀번호 확인</th>
							<td>
								<div class="field">
								  <div class="control has-icons-left has-icons-right">
								    <input class="input" type="password" name="pw2" id="pw2" required>
								    <input type="hidden" name="hiddenpw" id="hiddenpw" value="${mem.pw }" />
								  </div>
								  <p class="help" id="msg" style="padding-left:0.5rem">변경할 비밀번호 다시 한 번 입력하세요.</p>
							     </div>
							</td>
						</tr>
						<tr>
							<th>이름</th>
							<td>
								<div class="field">
								  <div class="control has-icons-left has-icons-right">
								    <input class="input" type="text" name="name" id="name" value="${mem.name }" required>
								  </div>
							     </div>
							</td>
						</tr>
						<tr>
							<th>연락처</th>
							<td>
								<div class="field">
								  <div class="control has-icons-left has-icons-right">
								    <input class="input" type="text" name="tel" id="tel" value="${mem.tel }" required>
								  </div>
							     </div>
							</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>
								<div class="field">
								  <div class="control has-icons-left has-icons-right">
								    <input class="input" type="email" name="email" id="email" value="${mem.email }" required>
								  </div>
							     </div>
							</td>
						</tr>
						<tr>
							<th>주소</th>
							<td>
								<div class="field">
								  <div class="control has-icons-left has-icons-right">
								  	<input class="input" type="text" name="addr" id="addr" value="${mem.addr }">
								    <input class="input" type="text" name="postcode" id="postcode" placeholder="00000" required>
								    <br>
								    <button id="post_btn" onclick="findAddr()" class="button is-normal">우편번호 검색</button>
								  </div>
								   <div class="control has-icons-left has-icons-right">
								    <input class="input" type="text" name="address1" id="address1" placeholder="기본 주소" required>
								  </div>
							     </div>
							     <div class="control has-icons-left has-icons-right">
								    <input class="input" type="text" name="address2" id="address2" placeholder="상세 주소" required>
								    <input type="hidden" name="addr" id="addr" value="${mem.addr }" />
								  </div>
							</td>
	 					</tr>
						<%--
						<tr>
							<th>주소</th>
							<td>
								<span style="display:block;">${member.addr }</span>
								<input type="text" name="postcode" id="postcode" style="width:160px;float:left;margin-right:20px;" placeholder="우편번호" class="form-control">
								<button id="post_btn" onclick="findAddr()" class="btn btn-primary">우편번호 검색</button>
								<input type="text" name="address1" id="address1" placeholder="기본 주소 입력" class="form-control" /><br>
								<input type="text" name="address2" id="address2" placeholder="상세 주소 입력" class="form-control" /><br>
								<input type="hidden" name="addr" id="addr" value="${member.addr }" />
							</td>
						</tr>
						--%>
						<tr>
							<td colspan="2">
								<input type="submit" value="회원정보수정" class="button is-primary"/>
								<a href="${path }/MemberMyPage.do?id=${mem.id }" class="button is-danger">취소</a>
								<a href="${path }/MemberMyPage.do?id=${mem.id }" class="button is-info">마이페이지로 이동</a>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
			<script>
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
		<%@ include file="../../footer.jsp" %>
	</div>
</body>
</html>