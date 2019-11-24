<!-- 공지사항  목록 페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->

<link rel="stylesheet" href="/resources/css/main.css">
<script src="/resources/js/use/noticeList.js"></script>
<!-- ##### Catagory ##### -->
<div class="clever-catagory bg-img d-flex align-items-center justify-content-center p-3" tyle="background-image: url('/resources/img/bg-img/bg2.jpg');">
	<div class="container">
		<div class="col-12">
			<h3>공지사항</h3>
		</div>
		<div class="col-12">
			<h6>체험단 신청하기 전에 공지사항을 확인해주세요.</h6>
		</div>
	</div>
</div>

<!-- ##### Popular Course Area Start ##### -->
<div class="limiter">
	<div class="container-table100" style="margin-top: 45px">
		<div class="wrap-table100" style="height: 470px; overflow-y: auto">
			<div class="table">
				<div class="row-t header">
					<div class="cell">번호</div>
					<div class="cell">제목</div>
					<div class="cell">등록일</div>
					<c:if test= "${not empty sessionAdmin }">
						<div class="cell"></div>
					</c:if>
				</div>
				<c:if test="${fn:length(list.content) == 0}">
					<div class="col-12" style=" text-align: center;">
						<span style="color: #869ada;">등록된 게시물이 없습니다.</span>
					</div>
				</c:if>
				<c:forEach var="list" items="${list.content }">
					<div class="row-t">
						<div class="cell" data-title="번호"<c:if test= "${not empty sessionAdmin }"> onclick="noticeAdminViewAction(${list.noticeNo })"</c:if>
								<c:if test= "${empty sessionAdmin }"> onclick="noticeViewAction(${list.noticeNo })"</c:if>>
							<span><strong>${list.noticeNo }</strong></span>
						</div>
						<div class="cell" data-title="제목"<c:if test= "${not empty sessionAdmin }"> onclick="noticeAdminViewAction(${list.noticeNo })"</c:if>
								<c:if test= "${empty sessionAdmin }"> onclick="noticeViewAction(${list.noticeNo })"</c:if>><strong>[공지] ${list.subject }</strong></div>
						<div class="cell" data-title="등록일"<c:if test= "${not empty sessionAdmin }"> onclick="noticeAdminViewAction(${list.noticeNo })"</c:if>
								<c:if test= "${empty sessionAdmin }"> onclick="noticeViewAction(${list.noticeNo })"</c:if>><strong>${list.regDate }</strong></div>
						<c:if test= "${not empty sessionAdmin }">
							<div class="cell" data-title=""><span onclick = "noticeDeleteAction(${list.noticeNo })"><strong>삭제</strong></span></div>
						</c:if>
					</div>
				</c:forEach>
			</div>
			<hr/>
			<c:if test= "${not empty sessionAdmin }">
				<div class="row">
					<div class="col-2">
						<div class="load-more">
							<a href="/servlet/notice/new" class="btn clever-btn">공지사항 등록</a>
						</div>
					</div>
					<div class="col-2">
						<div class="load-more">
							<span class="btn clever-btn" onclick = "excelDownload()">엑셀 다운로드</span>
						</div>
					</div>
				</div>
				<hr/>
			</c:if>

		</div>
		<input type="hidden" id="nowPage" name="nowPage" value="${nowPageNum }"/>
		<input type="hidden" id="totalPage" name="totalPage" value="${totalPage }"/>
		<div class="pagination" style="margin-top: 10px;">
			<a href="?sort=noticeNo,desc&size=5" class="page-btn">&laquo;</a>
			<c:if test="${totalPage > nowPageNum }">
				<c:if test="${nowPageNum ne 0 }">
					<a href="?sort=noticeNo,desc&size=5&page=${nowPageNum-1 }" class="page-btn">${nowPageNum }</a>
				</c:if>
				<a href="?sort=noticeNo,desc&size=5&page=${nowPageNum }" class="page-btn">${nowPageNum+1 }</a>
				<c:if test="${totalPage-1 ne nowPageNum }">
					<a href="?sort=noticeNo,desc&size=5&page=${nowPageNum+1 }" class="page-btn">${nowPageNum+2 }</a>
				</c:if>
			</c:if>
			<a href="?sort=noticeNo,desc&size=5&page=${totalPage-1 }" class="page-btn">&raquo;</a>
		</div>
	</div>
</div>
<!-- ##### Popular Course Area End ##### -->

<!-- ##### Footer Area Start ##### -->
<%@ include file="./footer.jsp"%>
<!-- ##### Footer Area End ##### -->
