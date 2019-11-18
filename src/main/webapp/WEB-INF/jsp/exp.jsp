<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->
<script>
var goMenu = function(idx) {
	location.href = "/experience/board/" + idx;
}

function delMenu(idx){
	var delCon = confirm("해당 게시글을 지우시겠습니까?");

	if (delCon) {
		$.ajax({
	        method: "DELETE",
	        url: pageUrl + "experience/api/delete/" + idx,
	        success: function() {
	        	alert('게시글이 지워졌습니다.');
	        	location.reload();
	        }
	    });
	}
}
</script>
<!-- ##### Catagory ##### -->
<div
	class="clever-catagory bg-img d-flex align-items-center justify-content-center p-3"
	style="background-image: url('/resources/img/bg-img/bg2.jpg');">
</div>

<!-- ##### Popular Course Area Start ##### -->
<section class="popular-courses-area section-padding-100">
	<div class="container">
		<div class="row" style="display:none;">
			<div class="col-1">
				<div class="load-more text-center wow fadeInUp"
					data-wow-delay="50ms">
					<a href="/boardRegister" class="btn clever-btn btn-2">게시물 등록</a>
				</div>
			</div>
		</div>
		<hr/>
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
						<div class="course-content">
							<h4>
								<span style="cursor: pointer;" onclick="javascript:goMenu(${board.experienceNo})" >${board.subject }</span>
							</h4>
							<p style="height: 50px; overflow: auto;">${board.content }</p>
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
							<c:if test="${not empty sessionAdmin }">
								<div class="seat-rating h-100 d-flex align-items-center"
									style="cursor: pointer;">
									<div onclick="delMenu(${board.experienceNo});">
										<span>삭제</span>
									</div>
								</div>
							</c:if>
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