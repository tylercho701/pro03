<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="header_path" value="${pageContext.request.contextPath }" />
<%@ include file="../common.jsp" %>
<%
	String sid="";
	if(session.getAttribute("sid")!=null){
		sid = (String) session.getAttribute("sid");
	}
 %>

<header id="hd" class="container">
<nav class="navbar" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item" href="${header_path }">
      <img src="https://bulma.io/images/bulma-logo.png" width="112" height="28">
    </a>

    <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
    </a>
  </div>

  <div id="navbarBasicExample" class="navbar-menu">
    <div class="navbar-start">
      <div class="navbar-item has-dropdown is-hoverable">
        <a class="navbar-link">
		  여행
        </a>
        
		<div class="navbar-dropdown">
          <a href="" class="navbar-item">
			테마여행
          </a>
          <a href="" class="navbar-item">
			미식여행
          </a>
        </div>
      </div>
      
      <div class="navbar-item has-dropdown is-hoverable">
        <a class="navbar-link">
		  공연
        </a>
        
		<div class="navbar-dropdown">
          <a href="" class="navbar-item">
			야구
          </a>
          <a href="" class="navbar-item">
			국제영화제
          </a>
        </div>
      </div>
      
      <div class="navbar-item has-dropdown is-hoverable">
        <a class="navbar-link">
		  축제
        </a>
        
		<div class="navbar-dropdown">
          <a href="" class="navbar-item">
			봄
          </a>
          <a href="" class="navbar-item">
			여름
          </a>
          <a href="" class="navbar-item">
			가을
          </a>
          <a href="" class="navbar-item">
			겨울
          </a>
        </div>
      </div>

      <div class="navbar-item has-dropdown is-hoverable">
        <a class="navbar-link">
		  유용한정보
        </a>

        <div class="navbar-dropdown">
          <a href="${header_path }/NoticeList.do" class="navbar-item">
			공지사항
          </a>
          <a href="" class="navbar-item">
			랭킹
          </a>
          <a href="" class="navbar-item">
            QnA
          </a>
        </div>
      </div>
    </div>

    <div class="navbar-end">
      <div class="navbar-item">
        <c:if test="${empty sid }">
	      <div class="buttons">
	        <a href="${header_path }/MemberTerms.do" class="button is-primary">
	          <strong>회원가입</strong>
	        </a>
	        <a href="${header_path }/MemberLogin.do" class="button is-light">
			  로그인
	        </a>
          </div>
        </c:if>
        
	    <c:if test="${!empty sid && !sid.equals('admin')}">
		    <div class="navbar-item has-dropdown is-hoverable">
		      <a class="navbar-link" href="${header_path }/MemberMyPage.do?id=<%=sid %>">
			        마이페이지
		      </a>
		        
			  <div class="navbar-dropdown">
		        <a href="" class="navbar-item">
				    찜목록보기
		        </a>
		        <a href="" class="navbar-item">
				    여행목록
		        </a>
		        <a href="" class="navbar-item">
				    내 질문 보기
		        </a>
		      </div>
		    </div>
		    
			<div class="buttons">
			  <a href="${header_path }/MemberLogout.do" class="button is-light">
				로그아웃
		      </a>
			</div>
	    </c:if>
	    
	    <c:if test="${!empty sid && sid.equals('admin')}">
		    <div class="navbar-item has-dropdown is-hoverable">
		      <a class="navbar-link">
			        관리자페이지
		      </a>
		        
			  <div class="navbar-dropdown">
		        <a href="${header_path }/MemberList.do" class="navbar-item">
				    멤버관리
		        </a>
		        <a href="${header_path }/NoticeList.do" class="navbar-item">
				  notice관리
		        </a>
		        <a href="" class="navbar-item">
				  review관리
		        </a>
		        <a href="" class="navbar-item">
				  QnA관리
		        </a>
		        <a href="" class="navbar-item">
				  visit관리
		        </a>
		        <a href="" class="navbar-item">
				  regi관리
		        </a>
		      </div>
		    </div>
		    
			<div class="buttons">
			  <a href="${header_path }/MemberLogout.do" class="button is-light">
				로그아웃
		      </a>
			</div>
	    </c:if>
      </div>
    </div>
  </div>
</nav>
</header>