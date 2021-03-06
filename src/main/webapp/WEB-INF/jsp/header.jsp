<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Title -->
<title>체험단 신청</title>
<!-- Favicon -->
<!-- Stylesheet -->
<link rel="stylesheet" href="/resources/style.css">
<!-- jQuery-2.2.4 js -->
<script src="/resources/js/jquery/jquery-2.2.4.min.js"></script>
<!-- Popper js -->
<script src="/resources/js/bootstrap/popper.min.js"></script>
<!-- Bootstrap js -->
<script src="/resources/js/bootstrap/bootstrap.min.js"></script>
<!-- SUMMER NOTE -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/lang/summernote-ko-KR.js"></script>
<!-- Common JS -->
<script src="/resources/js/use/common.js"></script>
</head>
<body>
	<header class="header-area">

		<!-- Navbar Area -->
		<div class="clever-main-menu">
			<div class="classy-nav-container breakpoint-off">
				<!-- Menu -->
				<nav class="classy-navbar justify-content-between" id="cleverNav">
					<!-- Logo -->
					<a class="nav-brand" href="/"><img
						src="/resources/img/core-img/logo.png"></a>

					<!-- Navbar Toggler -->
					<div class="classy-navbar-toggler">
						<span class="navbarToggler"><span></span><span></span><span></span></span>
					</div>

					<!-- Menu -->
					<div class="classy-menu">

						<!-- Close Button -->
						<div class="classycloseIcon">
							<div class="cross-wrap">
								<span class="top"></span><span class="bottom"></span>
							</div>
						</div>

						<!-- Nav Start -->
						<div class="classynav">
							<ul>
								<li><a href="/servlet/experience/board">체험단 신청하기</a></li>
								<li><a href="/servlet/notice/list?sort=noticeNo,desc&size=5">공지사항</a></li>
							</ul>
						</div>
					</div>
					<!-- Nav End -->
				</nav>
			</div>
		</div>
	</header>
