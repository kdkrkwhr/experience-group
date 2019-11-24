<!-- (관리자) 공지사항 / 등록 및 수정 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->
<link rel="stylesheet" href="/resources/css/main.css">
<script src="/resources/js/use/noticeRegister.js"></script>
<!-- ##### Catagory ##### -->
<!-- ##### Popular Course Area Start ##### -->
<form name="form" id="form" method="post" enctype="multipart/form-data" action="/servlet/notice/api/register">
<section
	class="register-now section-padding-100-0 d-flex justify-content-between align-items-center"
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
								
								<input type="hidden" id="noticeNo" name="noticeNo" value="${notice.noticeNo }"/>
								<div class="col-12 col-lg-12">
									<div class="form-group">
										<strong>제목</strong> <input type="text" class="form-control"
											name="subject" id="subject" placeholder="제 목"
											value="${notice.subject }">
									</div>
								</div>
								<div class="col-12 col-lg-12">
									<textarea name="content" id="content" class="form-control">${notice.content }</textarea>
								</div>
								<div class="col-12 col-lg-12" style="padding: 20px;">
									<!--input box-->
									<input type="text" class="upload_text" name="upload_text" readonly="readonly">
									<!--button-->
									<div class="upload-btn_wrap">
									  <button type="button" title="파일찾기">
									   <span>파일찾기</span>  
									  </button>
									  <input type="file" class="input_file" name="input_file" title="파일찾기">
									</div>
								</div>
								
								<div class="col-12" style="padding-top: 10px;"
									style="background: rgba(0,123,255,.25);">
										<input type="button" class="btn w-100" id="${btnId }" name="${btnId }" value="${btnCat }">
								</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
</form>
<!-- ##### Popular Course Area End ##### -->

<!-- ##### Footer Area Start ##### -->
<%@ include file="./footer.jsp"%>
<!-- ##### Footer Area End ##### -->
