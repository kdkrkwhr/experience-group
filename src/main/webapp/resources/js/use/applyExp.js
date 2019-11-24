/**
 * NOTICE REGISTER
 */

$().ready(function() {

	$('#applyBtn').click(function() {
		$.ajax({
			method : "POST",
			url : pageUrl + "member/api/register",
			data : JSON.stringify({
				blogAddress : $('#blogAddress').val(),
				experienceNo : $('#experienceNo').val(),
				email : $('#email').val(),
				name : $('#name').val(),
				phone : $('#phone').val(),
				address : $('#address').val(),
				prdName : $('#prdName').val(),
				memo : $('#memo').val(),
			}),
			contentType : "application/json; charset=utf-8",
			success : function() {
				alert("신청이 완료 되었습니다.");
				location.href = "/notice/list?sort=noticeNo,desc&size=5";
			}
		});
	});

	$('#updateBtn').click(function() {
		var noticeNo = $('#noticeNo').val();
		$.ajax({
			method : "PUT",
			url : pageUrl + "notice/api/update/" + noticeNo,
			data : JSON.stringify({
				subject : $('#subject').val(),
				content : $('#content').val(),
				filePath : ""
			}),
			contentType : "application/json; charset=utf-8",
			success : function() {
				alert("공지사항이 수정 되었습니다.");
				location.href = "/notice/list?sort=noticeNo,desc&size=5";
			}
		});
	})
})
