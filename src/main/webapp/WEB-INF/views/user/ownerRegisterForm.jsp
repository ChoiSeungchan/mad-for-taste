
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script type="text/javascript">
//<![CDATA[
	$(function(){
		$("#ownerId").keyup(function(){
				$.getJSON("idCheckAjax?id="+$("#ownerId").val(),function(data){
					if(data=="사용불가"){
						$("#id").html(data);
						idCheckFlag=true;
					}
					else{
						$("#id").html("");
						idCheckFlag=false;
					}
			}); 
		});
	});
	function duplicationCheck(){
		if(idCheckFlag)
			return false;
	}
	//]]>
</script>
</head>
<body>

<!-- 아이디/비밀번호/이름/이메일/전화번호/사업자등록번호/상호명/맛집주소/맛집전화번호 -->

 <div class="col-md-4 col-md-offset-4">
<form:form action="register_access" commandName="ownerForm" enctype="multipart/form-data" onsubmit="return duplicationCheck()">
	<div class="form-group"> 
	 <label for="ownerId">아이디</label>
    <form:input id="ownerId" path="ownerId" placeholder="아이디를 입력하세요" class="form-control"/>
    <font color="red"><form:errors path="ownerId"></form:errors><div id="id"></div></font>
 </div>
  	<div class="form-group"> 
    <label for="password">패스워드</label>
    <form:password class="form-control" id="password" path="password" placeholder="비밀번호를 입력하세요 "/>
    <font color="red"><form:errors path="password"></form:errors></font>
    </div>
    <div class="form-group"> 
    <label for="name">이름</label>
    <form:input class="form-control" id="name" path="name" placeholder="이름을 입력하세요 "/>
    <font color="red"><form:errors path="name"></form:errors></font>
    </div>
    <div class="form-group"> 
    <label for="tel">전화번호</label>
    <form:input class="form-control" id="tel" path="tel" placeholder="전화번호를 입력하세요 "/>
    <font color="red"><form:errors path="tel"></form:errors></font>
    </div>
    <div class="form-group"> 
    <label for="email">이메일</label>
    <form:input class="form-control" id="email" path="email" placeholder="이메일을 입력하세요 "/>
    <font color="red"><form:errors path="email"></form:errors></font>
    </div>
     <div class="form-group"> 
    <label for="email">프로필 사진</label>
	<input type="file" name=imgFile value="프로필사진" accept="image/gif,image/jpeg,image/bmp, image/png">
    </div>  
    <div class="form-group"> 
    <label for="brNo">사업자 등록 번호</label>
    <form:input class="form-control" id="brNo" path="brNo" placeholder="사업자 등록번호를 입력하세요"/>
    <font color="red"><form:errors path="brNo"></form:errors></font>
    </div> 
    <div class="form-group"> 
    <label for="businessName">가게 이름</label>
    <form:input class="form-control" id="businessName" path="businessName" placeholder="가게 이름을 입력하세요"/>
    <font color="red"><form:errors path="businessName"></form:errors></font>
    </div> 
    <div class="form-group"> 
    <label for="address">가게 주소</label>
    <form:input class="form-control" id="address" path="address" placeholder="가게 주소를 입력하세요"/>
    <font color="red"><form:errors path="address"></form:errors></font>
    </div> 
    <div class="form-group"> 
    <label for="tastyTel">가게 전화번호</label>
    <form:input class="form-control" id="tastyTel" path="tastyTel" placeholder="가게 전화번호를 입력하세요"/>
    <font color="red"><form:errors path="tastyTel"></form:errors></font>
    </div> 
  <input type="submit" class="btn btn-default" value="회원가입">
</form:form>
	<input type="button" id="b1" value="테스트">
</div> 
</body>
</html>
