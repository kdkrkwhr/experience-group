<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->

<script src="/resources/js/use/boardList.js"></script>
<!-- ##### Catagory ##### -->
<div class="clever-catagory bg-img d-flex align-items-center justify-content-center p-3">
	<div class="container">
		<div class="col-12">
			<h3>이용방법 안내</h3>
		</div>
		<div class="col-12">
			<h6>체험단 신청하기 버튼을 통해 쉽고 빠르게 접수해보세요.</h6>
		</div>	
		<div class="col-2">
			<div class="load-more text-center wow fadeInUp"
				data-wow-delay="50ms">
				<a href="/experience/board" class="btn clever-btn btn-2">신청하러 가기</a>
			</div>
		</div>
	</div>
</div>

<!-- ##### Popular Course Area Start ##### -->
<section class="popular-courses-area section-padding-100">
	<div class="container">
		<div class="row">
			<div class="col-12" style=" text-align: center;">
				<span style="color: #869ada;">등록된 게시물이 없습니다.</span>
			</div>
			
			<!-- Single Popular Course -->
			<div class="col-12 col-md-6 col-lg-12">
				<div class="single-popular-course mb-100 wow fadeInUp"
					data-wow-delay="100ms">
					<!-- Course Content -->
					<div class="course-content">
						<h4>
							<span style="cursor: pointer;">제목</span>
						</h4>
						<div class="meta d-flex align-items-center">
							<a href="#">유형</a> <span>
						</div>
						<p style="height: 50px; overflow: auto;">내용</p>
					</div>
					<!-- Seat Rating Fee -->
					<div class="seat-rating-fee d-flex justify-content-between">
						<div class="seat-rating h-100 d-flex align-items-center">
							<div class="seat">
								<i class="fa fa-user" aria-hidden="true"></i>받은목록 / 총모집인원
							</div>
							<div class="rating">
								<i class="fa fa-star" aria-hidden="true"></i>작성일
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- ##### Popular Course Area End ##### -->

<!-- ##### Footer Area Start ##### -->
<%@ include file="./footer.jsp"%>
<!-- ##### Footer Area End ##### -->