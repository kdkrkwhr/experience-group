/**
 * NOTICE LIST
 */

function noticeAdminViewAction(idx) {
	location.href = "/notice/admin/view/" + idx;
}

function noticeViewAction(idx) {
	location.href = "/notice/view/" + idx;
}

function noticeDeleteAction(idx) {
	var delCon = confirm("해당 게시글을 지우시겠습니까?");

	if (delCon) {
		$.ajax({
	        method: "DELETE",
	        url: pageUrl + "notice/api/delete/" + idx,
	        success: function() {
	        	alert('게시글이 지워졌습니다.');
	        	location.reload();
	        }
	    });
	}
}

function excelDownload() {
	var nowPage = $('#nowPage').val();
	var excelDownloadCon = confirm("다운로드 받으시겠습니까?");

	if (excelDownloadCon) {
		$.ajax({
			method : "GET",
			url : pageUrl + "notice/api/excel?sort=noticeNo,desc&size=5&page=" + nowPage,
			success : function() {
				console.log("EXCEL_DOWNLOAD");
			}
		});
	}
}