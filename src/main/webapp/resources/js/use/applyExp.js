/**
 * NOTICE REGISTER
 */

$().ready(function() {

	$('#applyBtn').click(function() {
		$.ajax({
			method : "GET",
			url : pageUrl + "member/api/check/" + $('#experienceNo').val(),
			success : function() {
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
						$.ajax({
							method : "POST",
							url : pageUrl + "member/api/cntupdate/" + $('#experienceNo').val(),
							success : function() {
								alert("신청이 완료 되었습니다.");
								location.href = "/experience/board";
							}
						})
					}
				});
			}
		});
	});
})
