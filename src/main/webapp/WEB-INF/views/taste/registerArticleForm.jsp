<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${initParam.root}resources/smarteditor/js/HuskyEZCreator.js"
	charset="utf-8"></script>
<script type="text/javascript">
	/* $(function() {
		var oEditors = [];
		nhn.husky.EZCreator
				.createInIFrame({
					oAppRef : oEditors,
					elPlaceHolder : "SE",
					//SmartEditor2Skin.html 파일이 존재하는 경로
					sSkinURI : "${initParam.root}resources/smarteditor/SmartEditor2Skin.html",
					htParams : {
						// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseToolbar : true,
						// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
						bUseVerticalResizer : true,
						// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
						bUseModeChanger : true,
						fOnBeforeUnload : function() {

						}
					},
					fOnAppLoad : function() {
						//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
						oEditors.getById["SE"].exec("PASTE_HTML",
								[ "기존 DB에 저장된 내용을 에디터에 적용할 문구" ]);
					},
					fCreator : "createSEditor2"
				});
		
		$('#registerArticleBtn').click(function(){
			oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);
			$('#articleForm').submit();
		})
	}); */
	
	
	$(function(){
	    //전역변수선언
	    var editor_object = [];
	     
	    nhn.husky.EZCreator.createInIFrame({
	        oAppRef: editor_object,
	        elPlaceHolder: "SE",
	        sSkinURI: "${initParam.root}resources/smarteditor/SmartEditor2Skin.html", 
	        htParams : {
	            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
	            bUseToolbar : true,             
	            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
	            bUseVerticalResizer : true,     
	            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
	            bUseModeChanger : true, 
	        }
	    });
	     
	    //전송버튼 클릭이벤트
	    $("#registerArticleBtn").click(function(){
	        //id가 smarteditor인 textarea에 에디터에서 대입
	        editor_object.getById["SE"].exec("UPDATE_CONTENTS_FIELD", []);
	         
	        // 이부분에 에디터 validation 검증
	         
	        //폼 submit
	        $("#articleForm").submit();
	    })
	})
	
</script>
</head>
<body>
	<div class="container-fluid">
		<form action="registerArticle" method="post" role="form" id="articleForm">
			<div class="form-group">
				<label class="control-label">어느 지역의 맛집인가요?</label>
				<select	name="location" class="form-control">
				<option>서울</option>
				<option>경기</option>
				<option>대전</option>
				<option>대구</option>
				<option>부산</option>
				<option>광주</option>
				<option>제주</option>
				</select>
			</div>
			<div class="form-group">
				<label class="control-label" for="title">맛집 소개글의 제목을 입력해주세요</label>
				<input name="title" class="form-control" id="title"	placeholder="제목을 입력하세요" type="text">
			</div>
			<div class="form-group">
				<textarea id="SE" name="contents" style="width:100%; height:412px;" rows="20" cols="30" class="form-control"></textarea>
			</div>
			<button id="registerArticleBtn" type="button" class="btn btn-default btn-block btn-lg">맛집 소개하기</button>
		</form>
	</div>
</body>
</html>