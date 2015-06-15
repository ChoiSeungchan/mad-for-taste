<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script>
	//<![CDATA[
	           $(function(){
	        	   $("#deleteBtn").click(function(){
	        		 	  if(confirm("정말 삭제하시겠습니까?")){
	        		 		  if($("#hidden").val()=="Y"){
	        		 			  alert("계약 중인 가게는 삭제 할수 없습니다");
	        		 			  return;
	        		 		  }
	        				  location.href="${initParam.root}deleteTastyPlace?id="+$("#brNo").val();        			  
	        		 	  }
	        		   });
        		   $("#collection").hide();
	        	   $("#select").change(function(){
	        		   if($(this).val()=="")
	        			   $("#collection").hide();
	        		 	$.ajax({
	        		 		type:"post",
	        		 		url:"brNoselectByIdAjax?brNo="+$("#select option:selected").val(),
	        		 		dataType:"json",
	        		 		success:function(data){
	        		 			$("#hidden").val(data.contractFlag);
	        		 			$("#collection").show();
	        		 			var str="계약되지 않음";
	        		 			$("#brNo").val(data.brNo);
	        		 			$("#tastyName").val(data.businessName);
	        		 			$("#tastyAddr").val(data.address);
	        		 			$("#tastyTel").val(data.tastyTel);
	        		 			if(data.contractFlag=="Y")
	        		 				str="현재 계약 중";
	        		 			$("#flag").val(str);
	        		 		}
	        		 	});
	        	   });
	           });
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
<div class="col-md-4 col-md-offset-4" id="collection">
   <div class="form-group">
    <label for="brNo">사업자 등록번호</label>
    <input type="text" class="form-control" readonly="readonly" id="brNo"/>
   </div>
    <div class="form-group">
    <label for="tastyName">상호명(가게명)</label>
    <input type="text" class="form-control" readonly="readonly" id="tastyName"/>
   </div>
   <div class="form-group">
    <label for="tastyAddr">가게 주소</label>
    <input type="text" class="form-control" readonly="readonly" id="tastyAddr"/>
   </div>
    <div class="form-group">
    <label for="tastyTel">가게 전화번호</label>
    <input type="text" class="form-control" readonly="readonly" id="tastyTel"/>
   </div>
   <div class="form-group">
    <label for="flag">광고 계약 여부</label>
    <input type="text" class="form-control" readonly="readonly" id="flag"/>
   </div>
   	  <input type="hidden" id="hidden">
      <input type="button" class="btn btn-danger" value="삭제" id="deleteBtn">
</div>