<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->
<link rel="stylesheet" href="/resources/css/main.css">
<script>
	var insert = function() {
		alert("insert 버튼 클릭");
	}
</script>
<!-- ##### Catagory ##### -->

<!-- ##### Popular Course Area Start ##### -->

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
							<h4>${cat } / ${exp.prdName }</h4>
							<div class="row">
								<div class="col-12 col-lg-12">
									<div class="form-group">
										<strong>블로그 주소</strong> <input type="text" class="form-control"
											name="blogAddress" id="blogAddress" placeholder="블로그 주소" />
									</div>
								</div>
								<div class="col-12 col-lg-12">
									<div class="form-group">
										<strong>이메일<strong> <input type="text" class="form-control"
											name="email" id="email" placeholder="이메일" />
									</div>
								</div>
								<div class="col-12 col-lg-12">
									<div class="form-group">
										<strong>이름</strong> <input type="text" class="form-control"
											name="name" id="name" placeholder="제 목" />
									</div>
								</div>
								<div class="col-12 col-lg-12">
									<div class="form-group">
										<strong>휴대폰 번호</strong> <input type="text" class="form-control"
											name="phone" id="phone" placeholder="휴대폰 번호" />
									</div>
								</div>
								<div class="col-12 col-lg-12">
									<div class="form-group">
										<strong>주소</strong> <input type="text" class="form-control"
											name="address" id="address" placeholder="주소" />
									</div>
								</div>
								<div class="col-12 col-lg-12">
									<div class="form-group">
										<strong>상품명</strong> <input type="text" class="form-control"
											name="prdName" id="prdName" placeholder="상품명" value="${exp.prdName }" readonly="readonly"/>
									</div>
								</div>
								<div class="col-12 col-lg-12">
									<div class="form-group">
										<strong>메모</strong> <input type="text" class="form-control"
											name="memo" id="memo" placeholder="메모" />
									</div>
								</div>
								<div class="col-12" style="padding-top: 10px;"
									style="background: rgba(0,123,255,.25);">
										<input type="button" class="btn w-100" id="registerBtn" name="registerBtn" value="신청하기">
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
