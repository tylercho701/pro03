<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
   
<!-- 검색 엔진 초기화 -->
<meta name="subject">
<meta name="keywords">
<meta name="description">
<meta name="author">

<!-- Favorite Icon 설정 -->
<link rel="shortcut Icon" href="">

<!-- og설정 -->
<meta name="og:site_name" content="project02_daiso">
<meta name="og:title" content="project02_daiso">
<meta name="og:description" content="project02_daiso">
<meta name="og:url" content="">
<meta name="og:image" content="">

<!-- 기본 폰트 및 초기화 로딩 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<!-- 스타일 초기화 -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.css" rel="stylesheet">

<!-- Jquery CND -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<!-- BULMA -->
<link rel="stylesheet" href="${path }/source/bulma.css">

<!-- Paging -->
<link rel="stylesheet" href="${path }/resource/datatables.min.css">
<script src="${path }/resource/datatables.min.js"></script>
<script>
$(document).ready( function () {
	$('#tb1').DataTable();
});
</script>