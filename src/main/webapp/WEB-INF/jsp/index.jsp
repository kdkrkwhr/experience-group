<!-- 체험신청 목록 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->
<script>
var goMenu = function(idx) {
	location.href = "/servlet/experience/board/" + idx;
}

function expMember(idx) {
	location.href = "/servlet/member/applylist/" + idx;
}

function delMenu(idx){
	var delCon = confirm("해당 게시글을 지우시겠습니까?");

	if (delCon) {
		$.ajax({
	        method: "DELETE",
	        url: pageUrl + "/servlet/experience/api/delete/" + idx,
	        success: function() {
	        	alert('게시글이 지워졌습니다.');
	        	location.reload();
	        }
	    });
	}
}
</script>
<link rel="stylesheet" href="/resources/css/main.css">
<!-- ##### Catagory ##### -->
<div class="clever-catagory bg-img d-flex align-items-center justify-content-center p-3" style="background-image: url('/resources/img/bg-img/bg2.jpg');">
	<div class="container">
		<div class="col-12">
			<h3>체험단 신청하기</h3>
		</div>
		<div class="col-12">
			<h6>체험단 신청 목록입니다.</h6>
		</div>	
	</div>
</div>
<!-- ##### Popular Course Area Start ##### -->
<section class="popular-courses-area section-padding-100">
	<div class="container">
		<div class="row" style="display:none;">
			<div class="col-1">
				<div class="load-more text-center wow fadeInUp"
					data-wow-delay="50ms">
					<a href="/servlet/boardRegister" class="btn clever-btn btn-2">게시물 등록</a>
				</div>
			</div>
		</div>
		<c:if test= "${not empty sessionAdmin }">
			<div class="row">
				<div class="col-2">
					<div class="load-more">
						<a href="/servlet/experience/new" class="btn clever-btn">게시글 등록</a>
					</div>
				</div>
			</div>
			<hr/>
		</c:if>
		<div class="row">
			<c:if test="${fn:length(expList) == 0}">
			<div class="col-12" style=" text-align: center;">
				<span style="color: #869ada;"><!-- 등록된 게시물이 없습니다. --></span>
			</div>
			</c:if>
			<c:forEach var="board" items="${expList }">
				<!-- Single Popular Course -->
				<div class="col-12 col-md-6 col-lg-12" style="height: 250px;">
					<div class="single-popular-course mb-100 wow fadeInUp"
						data-wow-delay="100ms">
						<!-- Course Content -->
						<div class="course-content" style="height: 120px; overflow: auto;">
							<h4>
								<span style="cursor: pointer;" >${board.subject }</span>
							</h4>
							<p>${board.content }</p>
						</div>
						<!-- Seat Rating Fee -->
						<div class="seat-rating-fee d-flex justify-content-between">
							<div class="seat-rating h-100 d-flex align-items-center">
								<div class="seat">
									<i class="fa fa-user" aria-hidden="true"></i> ${board.appliCnt } /
									${board.recrutCnt }
								</div>
								<div class="rating">
									<i class="fa fa-star" aria-hidden="true"></i> ${board.regDate }
								</div>
							</div>
							<div class="seat-rating h-100 d-flex align-items-center"
								style="cursor: pointer;">
								<c:if test="${board.recrutCnt - board.appliCnt > 0}">
									<div onclick="javascript:goMenu(${board.experienceNo})" style="padding-right: 25px;">
										<span>체험단 신청하기</span>
									</div>
								</c:if>
								<c:if test="${not empty sessionAdmin }">
									<div onclick="expMember(${board.experienceNo});">
										<span>신청자 명단</span>
									</div>
									<div onclick="delMenu(${board.experienceNo});">
										<span>삭제</span>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
</section>
<!-- ##### Popular Course Area End ##### -->

<!-- ##### Footer Area Start ##### -->
<%@ include file="./footer.jsp"%>
<!-- ##### Footer Area End ##### -->