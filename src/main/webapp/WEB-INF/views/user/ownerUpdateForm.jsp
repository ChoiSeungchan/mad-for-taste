<%@page import="org.kosta.madfortaste.user.domain.Owner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script>
	//<![CDATA[
	           var RegexEmail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i; 
	           var curPass = "${owner.password}";
	           $(function(){
	        	     	
	           });
	           function checkForm(){
	        		if ( !RegexEmail.test($.trim($("#email").val())) )
	        		{
	        			$("#divEmail").html("이메일 형식에 맞게 입력해 주세요");
	        			return false;
	        		}  
/* 	        		if ($("#ownerId").val().trim().length<6||$("#ownerId").val().trim().length>16)
	        		{
	        			alert("아이디 오류");
	        			$("#divId").html("아이디는 6자 이상 16자 이하만 가능합니다");
	        			return false;
	        		}	 */
	        		if ($("#ownerPass").val().trim().length<6||$("#ownerPass").val().trim().length>16)
	        		{
	         			$("#divPass").html("비밀번호는 6자 이상 16자 이하만 가능합니다");
	        			return false;
	        		}	
	        	    if(curPass!=$("#curPass").val()){
	        	    	$("#divCurPass").html("이전 비밀번호가 맞지 않으므로 수정 할수 없습니다");
	        	    	return false;
	        	    }
	        	    if($("#curPass").val()!=$("#okPass").val()){
	        	    	$("#divOkPass").html("입력한 비밀번호가 서로 맞지 않습니다 다시 확인후 입력해 주세요");
	        	    	return false;
	        	    }
	           }
	           //]]>
</script>
<form action="update_access" method="post" enctype="multipart/form-data" onsubmit="return checkForm()">
<div class="col-md-4 col-md-offset-4">
  <div class="form-group">
    <label for="id">아이디</label>
    <input type="text" class="form-control"  name="ownerId"  placeholder="아이디를 입력하세요" readonly="readonly" value="${owner.ownerId }" id="ownerId"/>
    <font color="red"><div id="divId"></div></font>
  </div>
  <div class="form-group">
    <label for="password">현재 비밀번호</label>
    <input type="password" class="form-control"  placeholder="비밀번호를 입력하세요"  id="curPass"/>
    <font color="red"><div id="divCurPass"></div></font>
  </div>
  <div class="form-group">
    <label for="password">새로운 비밀번호</label>
    <input type="password" class="form-control"  name="password"  placeholder="비밀번호를 입력하세요" id="ownerPass" />
    <font color="red"><div id="divPass"></div></font>
  </div>
  <div class="form-group">
    <label for="password">비밀번호 확인</label>
    <input type="password" class="form-control" placeholder="비밀번호를 입력하세요"  id="okPass"/>
    <font color="red"><div id="divOkPass"></div></font>
  </div>
  <div class="form-group">
    <label for="name">이름</label>
    <input type="text" class="form-control" placeholder="이름을 입력하세요" name=name value="${owner.name }"/>
  </div>
  <div class="form-group">
    <label for="tel">전화번호</label>
    <input type="text" class="form-control" placeholder="전화번호를 입력하세요" name=tel value="${owner.tel }"/>
  </div>
  <div class="form-group">
  <label for="email">EMAIL</label>
    <input type="text" class="form-control" placeholder="이메일을 입력하세요" name=email value="${owner.email}" id="email"/>
     <font color="red"><div id="divEmail"></div></font>
  </div>
  <div class="form-group">
    <input type="file" class="form-control" name=imgFile />
  </div>
  <input type="submit" class="btn btn-default" value="정보수정">
</div>
</form>