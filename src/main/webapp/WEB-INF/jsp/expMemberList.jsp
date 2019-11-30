<!-- 체험단 신청자 목록 페이지  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ##### Header Area Start ##### -->
<%@ include file="./header.jsp"%>
<!-- ##### Header Area End ##### -->
<link rel="stylesheet" href="/resources/css/main.css">
<script src="/resources/js/use/expMemberList.js"></script>
<style>
table.customTable {
	width: 100%;
	background-color: #FFFFFF;
	border-collapse: collapse;
	border-width: 2px;
	border-color: #651441;
	border-style: solid;
	color: #000000;
}

table.customTable td, table.customTable th {
	border-width: 2px;
	border-color: #651441;
	border-style: solid;
	padding: 5px;
}

table.customTable thead {
	color: white;
	background-color: #651441;
}
</style>
<c:if test="${empty sessionAdmin }">
<script>
alert("로그인 후 게시글 작성이 가능합니다.");
location.href = '/';
</script>
</c:if>
<!-- ##### Catagory ##### -->
<div
	class="clever-catagory bg-img d-flex align-items-center justify-content-center p-3"
	style="background-image: url('/resources/img/bg-img/bg2.jpg');">
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
<div class="limiter">
	<div class="container-table100" style="margin-top: 45px">
		<div class="wrap-table100">
			<table class="customTable">
				<thead>
					<tr>
						<th>이름</th>
						<th>이메일</th>
						<th>연락처</th>
						<th>블로그 주소</th>
						<th>주소</th>
						<th>상품명</th>
						<th>메모</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${fn:length(memberList) == 0}">
						<div class="col-12" style="text-align: center;">
							<span style="color: #869ada;">신청한 회원이 없습니다.</span>
						</div>
					</c:if>
					<c:forEach var="list" items="${memberList }">
						<tr>
							<td><strong>${list.name }</strong></td>
							<td><strong>${list.email }</strong></td>
							<td><strong>${list.phone }</strong></td>
							<td><strong>${list.blogAddress }</strong></td>
							<td><strong>${list.address }</strong></td>
							<td><strong>${list.prdName }</strong></td>
							<td><strong>${list.memo }</strong></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr />
			<div class="row">
				<div class="col-2">
					<div class="load-more">
						<span class="btn clever-btn" onclick="excelDownload()">엑셀
							다운로드</span>
					</div>
				</div>
			</div>
			<hr />
		</div>
	</div>
</div>
<!-- ##### Popular Course Area End ##### -->



<!-- ##### Footer Area Start ##### -->
<%@ include file="./footer.jsp"%>
<!-- ##### Footer Area End ##### -->
