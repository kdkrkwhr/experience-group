/**
 * EXP MEMBER LIST
 */

function excelDownload() {
	var excelDownloadCon = confirm("다운로드 받으시겠습니까?");

	if (excelDownloadCon) {
		$.ajax({
			method : "GET",
			url : pageUrl + "/servlet/member/api/excel",
			success : function() {
				console.log("EXCEL_DOWNLOAD");
			}
		});
	}
}