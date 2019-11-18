<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->

<link rel="stylesheet" href="/resources/css/main.css">
<script src="/resources/js/use/noticeList.js"></script>
<!-- ##### Catagory ##### -->
<div class="clever-catagory bg-img d-flex align-items-center justify-content-center p-3">
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
	<div class="container-table100">
		<div class="wrap-table100">
			<div class="table">

				<div class="row-t header">
					<div class="cell">번호</div>
					<div class="cell">제목</div>
					<div class="cell">등록일</div>
					<c:if test= "${not empty sessionAdmin }">
						<div class="cell"></div>
					</c:if>
				</div>

				<c:forEach var="list" items="${list.content }">

					<div class="row-t">
						<div class="cell" data-title="번호">
							<span 
							<c:if test= "${not empty sessionAdmin }"> onclick="noticeViewAction(${list.noticeNo })"
								${list.noticeNo }
							</c:if>
							<c:if test= "${empty sessionAdmin }"> onclick="noticeUserViewAction(${list.noticeNo })"</c:if>>
								${list.noticeNo }
							</span>
						</div>
						<div class="cell" data-title="제목"><a href="/notice/view/${list.noticeNo}"><strong>[공지] ${list.subject }</strong></a></div>
						<div class="cell" data-title="등록일"><strong>${list.regDate }</strong></div>
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
							<a href="/notice/new" class="btn clever-btn">공지사항 등록</a>
						</div>
					</div>
					<div class="col-2">
						<div class="load-more">
							<a href="#" class="btn clever-btn">엑셀 다운로드</a>
						</div>
					</div>
				</div>
			</c:if>

			<input type="hidden" id="nowPageNum" name="nowPageNum" value="${nowPageNum }"/>
			<input type="hidden" id="totalPage" name="totalPage" value="${totalPage }"/>

			<div class="pagination">
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
</div>
<!-- ##### Popular Course Area End ##### -->

<!-- ##### Footer Area Start ##### -->
<%@ include file="./footer.jsp"%>
<!-- ##### Footer Area End ##### -->
