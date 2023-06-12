<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="footer_path" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<footer class="footer" id="ft1">
	<div class="container is-fullhd">
		<div class="content has-text-centered">
			<p class="title is-4">VISIT BUSAN SOCIAL MEDIA</p>
			<a href="https://youtube.com/BTOrganization">
				<img src="${footer_path }/img/index/sns5.png" alt="youtube">
			</a>&nbsp;&nbsp;
			<a href="https://www.facebook.com/visitbusan.kr">
				<img src="${footer_path }/img/index/sns2.png" alt="facebook">
			</a>&nbsp;&nbsp;
			<a href="https://www.instagram.com/visitbusan.kr">
				<img src="${footer_path }/img/index/sns3.png" alt="instagram">
			</a>&nbsp;&nbsp;
			<a href="https://blog.naver.com/busanto1115">
				<img src="${footer_path }/img/index/sns5.png" alt="naverBlog">
			</a>&nbsp;&nbsp;
		</div>
		<div class="tile is-ancestor">
			<div id="ftBox" class="tile is-parent">
				<article id="ftBox1" class="tile is-child box">
					<h3 class="title is-4">여행</h3>
					<ul id="cf01" class="ftcate">
					
					</ul>
				</article>
			</div>
			<div id="ftBox" class="tile is-parent">
				<article id="ftBox1" class="tile is-child box">
					<h3 class="title is-4">공연</h3>
					<ul id="cf02" class="ftcate">
					
					</ul>
				</article>
			</div>
			<div id="ftBox" class="tile is-parent">
				<article id="ftBox1" class="tile is-child box">
					<h3 class="title is-4">축제</h3>
					<ul id="cf03" class="ftcate">
					
					</ul>
				</article>
			</div>
			<div id="ftBox" class="tile is-parent">
				<article id="ftBox1" class="tile is-child box">
					<h3 class="title is-4">유용한정보</h3>
					<ul>
						<li><a href="">공지사항</a></li>
          				<li><a href="">랭킹</a></li>
          				<li><a href="">QnA</a></li>
					</ul>
				</article>
			</div>
		</div>
	</div>
</footer>
<footer class="footer" id="ft2">
	<div class="container is-fullhd">
		<div class="tile is-ancestor">
			<div class="tile is-parent">
				<article id="ftBox1" class="tile is-child box">
					<p class="title is-4">제공</p>
					<figure class="image is-128x128">
						<img src="${footer_path }/img/index/footer1.png" alt="footer1" id="ft2img1">
					</figure>
					<a href="https://www.busan.go.kr/vprivacy1">개인정보보호방침</a>&nbsp;
					<a href="https://www.busan.go.kr/cright">저작권보호정책</a>&nbsp;
					<a href="https://www.busan.go.kr/terms">약관</a>&nbsp;<br>
					<a href="https://www.busan.go.kr/minwon/mdidsms">행정서비스현황</a>&nbsp;
					<a href="https://www.busan.go.kr/viewdn">뷰어다운로드</a>&nbsp;
					<div class="content">
						<p>Copyright Busan Metropolitan City. All rights reserved.</p>
					</div>
				</article>
			</div>
			<div class="tile is-parent">
				<article id="ftBox2" class="tile is-child box">
					<p class="title is-4">관광 문의</p>
					<figure class="image is-128x128">
						<img src="${footer_path }/img/index/footer2.png" alt="footer2" id="ft2img2">
					</figure>
					<figure class="image is-128x128">
						<img src="${footer_path }/img/index/footer2.5.png" alt="footer3" id="ft2img3">
					</figure>
				</article>
			</div>
			<div class="tile is-parent">
				<article id="ftBox2" class="tile is-child box">
					<p class="title is-4">민원대표전화</p>
					<figure class="image is-128x128">
						<img src="${footer_path }/img/index/footer3.png" alt="footer4" id="ft2img4">
					</figure>
					<div class="content">
						<p>평일 08:30 - 18:30</p>
						<p>※야간/공휴일 등 근무시간외는 당직실로 전환.</p>
					</div>
				</article>
			</div>
		</div>
	</div>
</footer>