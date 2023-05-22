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
<title>JoinMemberPage</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../../hd.jsp" %>
		<div class="content">
			<section>
				<h2 class="title">회원가입페이지</h2>
				<form name="frm1" id="frm1" action="${path }/UserJoinPro.do" method="post" onsubmit="return joinCheck(this)">
					<table class="table">
						<tbody>
							<tr>
								<th>아이디</th>
								<td>
									<div class="form-row">
										<input type="text" name="id" id="id" placeholder="아이디를 입력핫요." autofocus required />
										<input type="button" class="btn btn-primary" value="아이디 중복 확인" onclick="idCheck()">
										<input type="hidden" name="idck" id="idck" value="no">
									</div>
									<div>
										<c:if test="${empty qid }">
										<p id="msg" style="padding-left:0.5rem">아이디 중복 체크를 하지 않았습니다.</p>
										</c:if>
										<c:if test="${not empty qid }">
										<p id="msg" style="padding-left:0.5rem">아이디 중복 체크가 완료되었습니다.</p>
										</c:if>
									</div>
								</td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td>
									<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요." required />
								</td>
							</tr>
							<tr>
								<th>비밀번호 확인</th>
								<td><input type="password" name="pw2" id="pw2" placeholder="비밀번호 다시 한 번 입력하세요." required /></td>
							</tr>
							<tr>
								<th>이름</th>
								<td><input type="text" name="name" id="name" placeholder="이름을 입력하세요." required /></td>
							</tr>
							<tr>
								<th>연락처</th>
								<td>
									<input type="tel" name="tel" id="tel" placeholder="연락처를 입력하세요." required>
									<p>공란없이 11자리를 입력하세요.</p>
								</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td><input type="email" name="email" id="email" placeholder="이메일 주소를 입력하세요" required></td>
							</tr>
							<tr>
								<th>주소</th>
								<td>
									<input type="text" name="postcode" id="postcode" style="width:160px;float:left;margin-right:20px;" placeholder="우편번호" >
									<button id="post_btn" onclick="findAddr()" class="btn btn-primary">우편번호 검색</button>
									<input type="text" name="address1" id="address1" placeholder="기본 주소" required /><br>
									<input type="text" name="address2" id="address2" placeholder="상세 주소를 입력하세요." required /><br>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="회원가입" class="btn btn-primary"/>
									<input type="reset" value="취소" class="btn btn-cancel"/>
									
								</td>
							</tr>
						</tbody>
					</table>
				</form>
				<script>
					function idCheck(){
						if($("#id").val()==""){
							alert("아이디를 입력하시기 바랍니다.");
							$("#id").focus();
							return;
						}
						var params = { id:$("#id").val() }
						$.ajax({
							url:"${path_sgnup }/IdCheck.do",
							type:"post",
							dataType:"json",
							data:params,
							success:function(result){
								//console.log(result);
								var idChk = result.result;
								if(idChk==false){
									$("#idck").val("no");
									$("#msg").html("<strong>사용할 수 없는 아이디 입니다.</strong>")
								} else if(idChk==true){
									$("#idck").val("yes");
									$("#id").attr("readonly","true");
									$("#msg").html("<strong>사용 가능한 아이디 입니다.</strong>");
									$("#pw").focus();
								} else {
									$("#msg").html("<strong>아이디가 확인되지 않았습니다. 다시 시도 바랍니다.</strong>")
								}
							}
						});
					}
					function joinCheck(f){
						if(f.pw.value!=f.pw2.value){
							alert("비밀번호와 비밀번호 확인이 서로 다릅니다.");
							f.pw.focus();
							return false;
						}
						if(f.idck.value!="yes"){
							alert("아이디 중복 체크를 하지 않으셨습니다.");
							return false;
						}
					}
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
			</section>
		</div>
		<%@ include file="../../ft.jsp" %>
	</div>
</body>
</html>