<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script>
	//<![CDATA[
	           $(function(){
	        	   $("#updateView").hide();
	        	   $("#select").change(function(){
	        		   if($(this).val()==""){
	        			   $("#updateView").hide();
	        			   return;
	        		   }
	        		   $("#updateView").show();
	        		   $.getJSON("brNoselectByIdAjax?brNo="+$(this).val(),function(data){
	        			   $("#brNo").val(data.brNo);
	        			   $("#businessName").val(data.businessName);
	        			   $("#tastyAddr").val(data.address);
	        			   $("#tastyTel").val(data.tastyTel);
	        		   });
	        	   });
	        	   $("#businessName").blur(function(){
	   	       			if($("#businessName").val().trim().length!=0){
		    				$("#divName").html("");
		    			}
	        	   });
	        	   $("#tastyAddr").blur(function(){
	   	       			if($("#tastyAddr").val().trim().length!=0){
		    				$("#divAddr").html("");
		    			}
	        	   });
	        	   $("#tastyTel").blur(function(){
	   	       			if($("#tastyTel").val().trim().length!=0){
		    				$("#divTel").html("");
		    			}
	        	   });
	           });
	      function checkForm(){
	    	  	$("#divName").html("");
	    	  	$("#divAddr").html("");
	    	  	$("#divTel").html("");
	    	  	
   	       		if($("#businessName").val().trim().length==0){
	    			$("#divName").html("가게 이름을 입력해 주세요");
	    			return false;
	    		}
	     		if($("#tastyAddr").val().trim().length==0){
	    			$("#divAddr").html("가게 주소를 입력해 주세요");
	    			return false;
	    		}
	    		if($("#tastyTel").val().trim().length==0){
	    			$("#divTel").html("가게 전화번호를 입력해 주세요");
	    			return false;
	    		}
	    		if(isNaN($("#tastyTel").val())){
	    			$("#divTel").html("전화번호는 숫자만 가능합니다");
	    			return false;
	    		}
	    		if(flag)
	    			return false;
	      }
	           //]]>
</script>
<div class="col-md-4 col-md-offset-4">
  <div class="form-group">
    <label for="brNo"><font color="lime">등록된 가게 정보: </font> </label>
	<select id="select">
		<option value="">-------</option>
		<c:forEach items="${list }" var="list">
			<option value="${list.brNo }">${list.businessName }</option>
		</c:forEach>
	</select>
   </div>
</div>
<form action="updateTastyPlace" method="post" onsubmit="return checkForm()">
<div class="col-md-4 col-md-offset-4" id="updateView">
  <div class="form-group">
    <label for="brNo">사업자 등록번호</label>
    <input type="text" class="form-control"  name="brNo" id="brNo" readonly="readonly"/>
   </div>
   <div class="form-group">
    <label for="businessName">상호명(가게 이름)</label>
    <input type="text" class="form-control"  name="businessName"  placeholder="상호를 입력하세요"  id="businessName"/>
    <font color="red"><div id="divName"></div></font>
   </div>
   <div class="form-group">
    <label for="tastyAddr">가게 주소</label>
    <input type="text" class="form-control"  name="address"  placeholder="주소를 입력하세요"  id="tastyAddr"/>
    <font color="red"><div id="divAddr"></div></font>
   </div>
   <div class="form-group">
    <label for="tastyTel">가게 전화번호</label>
    <input type="text" class="form-control"  name="tastyTel"  placeholder="전화번호를 입력하세요"  id="tastyTel"/>
    <font color="red"><div id="divTel"></div></font>
   </div>
   <input type="submit" class="btn btn-warning" value="가게 정보 수정">
   <input type="hidden" name=ownerId value="${owner.ownerId }">
</div>
</form>