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
	    $("#updateArticleBtn").click(function(){
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
		<form action="${initParam.root}updateArticle" method="post" role="form" id="articleForm">
			<input type="hidden" name="articleNo" value="${article.articleNo}"> 
			<input type="hidden" name="writer" value="${sessionScope.member.id}"> 
			<input type="hidden" name="resNo" value="${article.restaurant.resNo}"> 
			<div class="restaurantAddr" style="font-size: 18px; color:red;margin-top: 10px; margin-bottom: 10px">
				글을 등록할 때 소개한 맛집은 수정하실 수 없습니다 : <font style="color: #777777; font-weight: bold;" >${article.restaurant.city} ${article.restaurant.sigungu} ${article.restaurant.eupmyeondong} ${article.restaurant.resName}</font>
			</div>
			<div class="form-group">
				<label class="control-label" for="title">맛집 소개글의 제목을 입력해주세요</label>
				<input name="title" value="${article.title}" class="form-control" id="title"	placeholder="제목을 입력하세요" type="text">
			</div>
			<div class="form-group">
				<textarea id="SE" name="contents" style="width:100%; height:412px;" rows="20" cols="30" class="form-control">${article.contents}</textarea>
			</div>
			<button id="updateArticleBtn" type="button" class="btn btn-default btn-block btn-lg">수정하기</button>
		</form>
	</div>
</body>
</html>