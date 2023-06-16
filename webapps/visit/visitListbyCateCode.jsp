<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*, java.text.*, java.net.InetAddress" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../common.jsp" />
<link rel="stylesheet" href="${path }/source/bulma.css">
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
.subtitle { text-align: center; }
.row:after { content:""; display:block; clear:both; }
.row li { float:left; }
.content ul.row { width:960px; margin:10px auto; margin-left:auto; margin-right:auto; }

.section {
	position: relative;
}
.section barImg {
	width: 100%;
	vertical-align: middle;
}
</style>
</head>
<body>
	<div class="container">
		<%@ include file="../header.jsp" %>
		<section class="section">
		  <h1 class="title" style="padding: 5px 10px; ntext-align: center; position: absolute; top: 50%; left: 50%; transform: translate( -50%, -50% ); color:#fff;">${cate.cateName }</h1>
		  <img src="${path }/visit/img/bar.jpg" alt="bg" class="barImg">
		</section>
		<div class="content">
			<ul class="row">
			<c:forEach var="visit" items="${visitList }" >
				<li class="column is-3">
					<div class="card">
					  <div class="card-image">
					    <figure class="image is-16by9">
					      <a href="${path }/VisitDetail.do?visitId=${visit.visitId }&sid=${sid }">
					      	<img src="${path }/visit/${visit.visitImgMain }" alt="Placeholder image">
					      </a>
					    </figure>
					  </div> 			
				      <div class="card-content">
				        <div class="content" style="text-align:center;">
					      <a href="${path }/VisitDetail.do?visitId=${visit.visitId }&sid=${sid }">${visit.visitTitle }</a>
				          <br><span>좋아요&nbsp;${visit.likeCnt }</span>
				        </div>
				      </div>
				    </div>
				</li>
			</c:forEach>
			</ul>
			<c:if test="${empty visitList }">
				<section class="section">
		  			<h2 class="subtitle">현재 해당하는 여행상품이 존재하지 않습니다.</h2>
				</section>
			</c:if>
		</div>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>