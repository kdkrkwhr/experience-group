/**
 * NOTICE REGISTER
 */

$().ready(function() {
	$('#content').summernote({
		height : 300,
		lang : 'ko-KR',
		minHeight : null, // set minimum height of editor
		maxHeight : null, // set maximum height of editor
		focus : true,
		popover : { //팝오버 설정
			image : [], //이미지 삭제
			link : [], //링크 삭제
			air : []
		}
	});

	$('.note-icon-trash').trigger('click');

	$('.note-insert').remove();
	$('.note-view').remove();

	$('.upload_text').val('Upload File ...');
	$('.input_file').change(function(){
		var i = $(this).val();
		$('.upload_text').val(i);
	});

	$('#registerBtn').click(function() {
		if (valid()) {
			$.ajax({
				method : "POST",
				url : pageUrl + "notice/api/register",
				data : JSON.stringify({
					subject : $('#subject').val(),
					content : $('#content').val(),
					filePath : ""
				}),
				contentType : "application/json; charset=utf-8",
				success : function() {
					alert("공지사항이 등록 되었습니다.");
					location.href = "/notice/list?sort=noticeNo,desc&size=5";
				}
			});
		}
	});

	$('#updateBtn').click(function() {
		if (valid()) {
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
		}
	});
});

function valid() {
	if ($("#subject").val().length() > 30) {
		return false;
	}
	return true;
}
