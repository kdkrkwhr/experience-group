/**
 * EXP REGISTER
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

	$('#btnRegister').click(function() {
		$.ajax({
			method : "POST",
			url : pageUrl + "/servlet/experience/api/register",
			data : JSON.stringify({
				subject : $('#subject').val(),
				type : $('#type').val(),
				appliCnt : 0,
				recrutCnt : $('#recrutCnt').val(),
				prdName : $('#prdName').val(),
				content : $('#content').val()
			}),
			contentType : "application/json; charset=utf-8",
			success : function() {
				alert("글이 등록 되었습니다.");
				location.href = "/";
			}
		});
	});
});

// 추후 적용
function valid() {
	if ($("#subject").val().length > 30) {
		alert("제목 길이는 30자 이하로 작성해주세요.");
		$("#subject").focus();
		return false;
	}
	return true;
}
