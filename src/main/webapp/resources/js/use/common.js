/**
 * COMMON
 */

var pageUrl = window.location.hostname;
pageUrl = "http://" + pageUrl + ":8889/";

$().ready(function() {
	$('#loginBtn').click(function() {
		$.ajax({
			method: "POST",
			url: pageUrl + "admin/login",
			data : JSON.stringify({
				adminEmail : $('#adminEmail').val(),
				adminPassword : $('#adminPassword').val()
			}),
			contentType : "application/json; charset=utf-8",
			success: function(data) {
				if (data) {
					alert("로그인 되셨습니다.");
				} else if(!data) {
					alert("암호를 확인해주세요.");
				}
				location.reload();
			}
		});
	})
	$('#logOut').click(function() {
		$.ajax({
			method: "POST",
			url: pageUrl + "admin/logout",
			success: function() {
				alert("로그아웃 되셨습니다.");
				location.reload();
			}
		});
		
	})
})