<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*, java.text.*, java.net.InetAddress" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../../common.jsp" />
<title>visitListbyCateCode</title>
<style>
a:link {
  color : black;
}
a:visited {
  color : black;
}
a:hover {
  color : black;
}
a:active {
  color : black;
}
.title { text-align: center; }
.subtitle { text-align: center; }
.row:after { content:""; display:block; clear:both; }
.row li { float:left; }
.content ul.row { width:960px; margin:10px auto; margin-left:auto; margin-right:auto; }
</style>
</head>
<body>
<jsp:include page="../../header.jsp" />
<div class="container is-fullhd">
	<h2 class="title">visit 관리</h2>
	<table class="table">
		<thead>
			<tr>
				<th>연번</th>
				<th>visitId</th>
				<th>cateCode</th>
				<th>cateName</th>
				<th>visitTitle</th>
				<th>likeCnt</th>
				<th>pokeCnt</th>
				<th colspan="2">관리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${visitVOList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${list.visitId }</td>
				<td>${list.cateCode }</td>
				<td>${list.cateName }</td>
				<td>${list.visitTitle }</td>
				<td>${list.likeCnt }</td>
				<td>${list.pokeCnt }</td>
				<td><a href="${path }/" class="button is-info">수정</a></td>
				<td><a href="${path }/VisitDeletePro.do?visitId=${list.visitId }" class="button is-danger">삭제</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="6">
					<a href="${path }/VisitInsert.do" class="button is-info">추가</a>
					<a href="javascript:history.go(-1)" class="button is-danger">뒤로가기</a>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<jsp:include page="../../footer.jsp" />
<script>
</script>
</body>
</html>