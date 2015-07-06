<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	    $("#registerArticleBtn").click(function(){
	    	if($("#listDo").val()==""||$("#listSi").val()==""||$("#listDong").val()==""||$("#restaurant").val().trim().length==0){
	    		alert("등록하실 맛집에 대한 정보를 모두 기입해 주세요");
	    		return;
	    	}
	        //id가 smarteditor인 textarea에 에디터에서 대입
	        editor_object.getById["SE"].exec("UPDATE_CONTENTS_FIELD", []);
	         
	        // 이부분에 에디터 validation 검증
	         
	        //폼 submit
	        $("#articleForm").submit();
	    })
	    
	    $('#articleForm').submit(function(){
	    	var title = $(':input[name=title]').val();
	    	var contents = $(':input[name=contents]').val();
			 if (title.trim()=='') {
				alert('제목을 입력해주세요')
				$(':input[name=title]').focus();
				return false;
			} else if (contents.trim()=='<p>&nbsp;</p>') {
				alert('내용을 입력해주세요')
				$(':input[name=contents]').focus();
				return false;
			}
	    })
	    $("#listDo").change(function(){
    		$("#restaurant").val("");
	    	var listVal="<option value=''></option>";
	    	$("#listDong option").remove();
	    	$.getJSON("listDoClickAjax?doVal="+$(this).val(),function(data){
	    		$.each(data,function(index,val){
	    			listVal+="<option value="+val+">"+val+"</option>";
	    		})
    			$("#listSi").html(listVal);
	    	})
	    })
	    $("#listSi").change(function(){
    		$("#restaurant").val("");
	    		var listVal="<option value=''></option>";
			 	$.ajax({
	    		type : "post",
	    		url : "listSiClickAjax?doVal="+$("#listDo").val()+"&siVal=  "+$(this).val(),
	    		dataType : "json",
	    		success : function(data){
	        		$.each(data,function(index,val){
		    			listVal+="<option value="+val+">"+val+"</option>";
		    		})
	    			$("#listDong").html(listVal);
	    		}
	    	}) 
	    })
	    $("#listDong").change(function(){
    		$("#restaurant").val("");
	    })
	    $("#restaurant").keyup(function(){
	    	if($("#listDo").val()&&$("#listSi").val()&&$("#listDong").val()!=""){
	    		$.getJSON("findRestaurantAjax?doVal="+$("#listDo").val()+"&siVal=  "+$("#listSi").val()+"&dongVal=  "+$("#listDong").val()+"&name="+$(this).val(),function(data){	 
	  				if($("#restaurant").val().trim().length==0){
	    				$("#findRestaurant").html("찾을 이름(상호)").css("color","black");
	    				return;
    				}
	    			if(data=="")
	    				$("#findRestaurant").html("등록하실수 있어요").css("color","lime");
	    			else	
	    				$("#findRestaurant").html("등록 되어 있네요").css("color","red");	    		
	    		})
	    	}
	    })
	})
	
</script>
</head>
<body>
	<div class="container-fluid">
		<form action="${initParam.root}registerArticle" method="post" role="form" id="articleForm">
			<input type="hidden" name="writer" value="${sessionScope.member.id}"> 
			<div class="col-md-3">
				<div class="form-group">
					<label class="control-label">시.도</label>
					<select	name="doVal" class="form-control" id="listDo">
					<option selected="selected" value=""></option>
					<c:forEach items="${listDo }" var="list">
						<option value="${list}">${list }</option>
					</c:forEach>
					</select>
				</div>
			</div>		
			<div class="col-md-3">
			<div class="form-group">
					<label class="control-label">시.군.구</label>
					<select	name="siVal" class="form-control" id="listSi">
					<option selected="selected" value=""></option>
					</select>
				</div>
			</div>
			<div class="col-md-3">
			<div class="form-group">
					<label class="control-label">읍.면.동</label>
					<select	name="dongVal" class="form-control" id="listDong">
					<option selected="selected" value=""></option>
					</select>
				</div>
			</div>
			<div class="col-md-3">
				<label class="control-label"><span id="findRestaurant">찾을 이름(상호)</span></label>
					<input type="text" class="form-control" id="restaurant" name="name">
			</div>
			<div class="form-group">
				<label class="control-label" for="title">맛집 소개글의 제목을 입력해주세요</label>
				<input name="title" value="${article.title}" class="form-control" id="title"	placeholder="제목을 입력하세요" type="text">
			</div>
			<div class="form-group">
				<textarea id="SE" name="contents" style="width:100%; height:412px;" rows="20" cols="30" class="form-control">
				${article.contents}
				</textarea>
			</div>
			<button id="registerArticleBtn" type="button" class="btn btn-default btn-block btn-lg">맛집 소개하기</button>
		</form>
	</div>
</body>
</html>