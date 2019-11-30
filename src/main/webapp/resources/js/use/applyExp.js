/**
 * EXP REGISTER
 */

$().ready(function() {

	var recrutCnt = $('#recrutCnt').val();
	var appliCnt = $('#appliCnt').val();
	var resultCnt = recrutCnt - appliCnt;

	if (resultCnt <= 0) {
		alert("신청인원이 마감 되었습니다.");
		location.href = '/';
	}

	$('#applyBtn').click(function() {

		$.ajax({
			method : "GET",
			url : pageUrl + "/servlet/member/api/check/" + $('#experienceNo').val(),
			success : function(flag) {
				if (flag) {
				
					$.ajax({
						method : "POST",
						url : pageUrl + "/servlet/member/api/register",
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
								url : pageUrl + "/servlet/member/api/cntupdate/" + $('#experienceNo').val(),
								success : function() {
									alert("신청이 완료 되었습니다.");
									location.href = "/servlet/experience/board";
								}
							})
						}
					});
				} else if(!flag) {
					alert("신청인원이 마감 되었습니다.");
					location.href = '/';
				}
			}
		});
	});
})
