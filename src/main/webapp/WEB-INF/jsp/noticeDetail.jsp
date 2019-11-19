<!-- 공지사항 / 상세보기 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->
<link rel="stylesheet" href="/resources/css/main.css">
<!-- ##### Catagory ##### -->
<!-- ##### Popular Course Area Start ##### -->
<section class="register-now section-padding-100-0 d-flex justify-content-between align-items-center"
	style="padding-top: 30px; padding-bottom: 33px; background: #651441;">
	<!-- Register Contact Form -->
	<div class="register-contact-form wow fadeInUp" data-wow-delay="250ms"
		style="visibility: visible; animation-delay: 250ms; animation-name: fadeInUp; min-width: 100%;">
		<div class="register-contact-form mb-0 wow fadeInUp"
			data-wow-delay="250ms"
			style="visibility: visible; animation-delay: 250ms; animation-name: fadeInUp; min-width: 100%;">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="forms">
							<h4>${cat }</h4>
							<div class="row">
								<div class="col-12 col-lg-12">
									<div class="form-group">
										<strong>등록일   ${notice.regDate }</strong>
										<h4><strong>${notice.subject }</strong></h4>
									</div>
								</div>
								<div class="col-12 col-lg-12">
									<hr/>
									<div class="form-group" style="height: 300px">
										${notice.content }
									</div>
									<hr/><br/>
								</div>
<%-- 								<div class="col-12 col-lg-12">
									<div class="form-group">
										<strong>파일 경로 : ${notice.filePath }</strong>
									</div>
								</div> --%>
								<hr/>
								<div class="col-12" style="padding-top: 10px;"
									style="background: rgba(0,123,255,.25);">
										<input type="button" onclick="javascript:location.href = '/notice/list?sort=noticeNo,desc&size=5';" class="btn w-100" id="registerBtn" name="registerBtn" value="목록으로" />
								</div>
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
