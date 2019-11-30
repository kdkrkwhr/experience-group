<!-- 공지사항 / 상세보기 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<%@ page import="com.example.model.Notice" %>
<!-- ##### Header Area End ##### -->
<link rel="stylesheet" href="/resources/css/main.css">
<!-- ##### Catagory ##### -->
<!-- ##### Popular Course Area Start ##### -->
<%
String filePath = ((Notice)request.getAttribute("notice")).getFilePath();

String fileName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length());

String realFilePath = filePath.substring(filePath.lastIndexOf("/uploads"), filePath.length());
%>
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
							<div class="row">
								<%-- <strong>등록일  / ${notice.regDate }</strong> --%>
								<div class="col-12 col-lg-12">
									<div class="form-group">
										<strong>제목</strong>
										<hr/>
										<h5><strong>${notice.subject }</strong></h5><hr/>
									</div>
								</div>
								<div class="col-12 col-lg-12">
									<strong>내용</strong>
									<hr/>
									<div class="form-group" style="height: 300px">
										${notice.content }
									</div>
									<hr/><br/>
								</div>
								<div class="col-12 col-lg-12">
									<div class="form-group">
										<strong>첨부파일 : </strong>
										<a href="<%="/servlet/notice/fileDownload?filePath="+filePath%>"><%=fileName %></a>
									</div>
								</div>
								<hr/>
								<div class="col-12" style="padding-top: 10px;"
									style="background: rgba(0,123,255,.25);">
										<input type="button" onclick="javascript:location.href = '/servlet/notice/list?sort=noticeNo,desc&size=5';" class="btn w-100" id="registerBtn" name="registerBtn" value="목록으로" />
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
