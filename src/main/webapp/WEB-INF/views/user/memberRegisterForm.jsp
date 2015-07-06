<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	$("#birth").datepicker({
	
		  buttonImageOnly: true, // 버튼에 있는 이미지만 표시한다.
	
		  changeMonth: true, // 월을 바꿀수 있는 셀렉트 박스를 표시한다.
	
		  changeYear: true, // 년을 바꿀 수 있는 셀렉트 박스를 표시한다.
	
		  minDate: '-100y', // 현재날짜로부터 100년이전까지 년을 표시한다.
	
		  nextText: '다음 달', // next 아이콘의 툴팁.
	
		  prevText: '이전 달', // prev 아이콘의 툴팁.
	
		  numberOfMonths: [1,1], // 한번에 얼마나 많은 월을 표시할것인가. [2,3] 일 경우, 2(행) x 3(열) = 6개의 월을 표시한다.
	
		  stepMonths: 1, // next, prev 버튼을 클릭했을때 얼마나 많은 월을 이동하여 표시하는가. 
	
		  yearRange: 'c-50:c+20', // 년도 선택 셀렉트박스를 현재 년도에서 이전, 이후로 얼마의 범위를 표시할것인가.
	
		  showButtonPanel: true, // 캘린더 하단에 버튼 패널을 표시한다. 
	
		  currentText: '오늘 날짜' , // 오늘 날짜로 이동하는 버튼 패널
	
		  closeText: '닫기',  // 닫기 버튼 패널
	
		  dateFormat: "yy-mm-dd", // 텍스트 필드에 입력되는 날짜 형식.
	
		  showAnim: "slide", //애니메이션을 적용한다.
	
		  showMonthAfterYear: true , // 월, 년순의 셀렉트 박스를 년,월 순으로 바꿔준다. 
	
		  dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], // 요일의 한글 형식.
	
		  monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] // 월의 한글 형식.
	
		 });
	
	
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
});
</script>
</head>
<body>
<div class="col-md-4 col-md-offset-4">
<form:form action="registerMember" method="post" id="registerMemberForm" enctype="multipart/form-data" commandName="member">
  <div class="form-group">
    <label for="id">아이디</label>
    <form:input type="text" class="form-control" path="id" name="id" id="id" placeholder="아이디를 입력하세요"/>
  	<font color="red"><form:errors path="id"/></font>
  </div>
  <div class="form-group">
    <label for="password">비밀번호</label>
    <form:input type="password" class="form-control" path="password" name="password" id="password" placeholder="비밀번호를 입력하세요"/>
  	<font color="red"><form:errors path="password"/></font>
  </div>
  <div class="form-group">
    <label for="name">이름</label>
    <form:input type="text" class="form-control" path="name" name="name" id="name" placeholder="이름을 입력하세요"/>
  	<font color="red"><form:errors path="name"/></font>
  </div>
  <label for="name">주소</label>
  <ul class="list-group">
	  <li class="list-group-item">
	<div class="form-group">
		<label class="control-label">시.도</label>
		<form:select path="city" name="city" class="form-control" id="listDo">
		<option selected="selected" value=""></option>
		<c:forEach items="${listDo }" var="list">
			<option value="${list}">${list }</option>
		</c:forEach>
		</form:select>
		<font color="red"><form:errors path="city"/></font>
	</div>
	<div class="form-group">
		<label class="control-label">시.군.구</label>
		<form:select path="sigungu" name="sigungu" class="form-control" id="listSi">
		<option selected="selected" value=""></option>
		</form:select>
		<font color="red"><form:errors path="sigungu"/></font>
	</div>
	<div class="form-group">
		<label class="control-label">읍.면.동</label>
		<form:select path="eupmyeondong" name="eupmyeondong" class="form-control" id="listDong">
		<option selected="selected" value=""></option>
		</form:select>
		<font color="red"><form:errors path="eupmyeondong"/></font>
	</div>
	<div class="form-group">
		<label class="control-label">상세 주소</label>
		<form:input path="address" type="text" class="form-control" id="address" name="address"/>
		<font color="red"><form:errors path="address"/></font>
	</div>
	  </li>
  </ul>
  <label for="gender">성별</label>
  <div class="form-group">
	  <input type="radio" name="gender" id="gender" value="male" checked="checked"/> 남
	  <input type="radio" name="gender" id="gender" value="female"/> 여
  </div>
  <div class="form-group">
    <label for="birth">생년월일</label>
    <form:input type="text" class="form-control" path="birth" name="birth" id="birth" placeholder="생년월일을 입력하세요"/>
  	<font color="red"><form:errors path="birth"/></font>
  </div>
  <div class="form-group">
    <label for="tel">전화번호</label>
    <form:input type="text" class="form-control" path="tel" name="tel" id="tel" placeholder="전화번호를 입력하세요"/>
  	<font color="red"><form:errors path="tel"/></font>
  </div>
  <div class="form-group">
    <label for="imgFile">프로필 사진</label>
    <input type="file" name="imgFile" id="imgFile" accept="image/gif,image/jpeg,image/bmp, image/png">
  </div>
  <button type="submit" class="btn btn-default">회원가입</button>
</form:form>
</div>
</body>
</html>