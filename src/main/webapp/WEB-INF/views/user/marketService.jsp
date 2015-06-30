<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script>
	//<![CDATA[
	           $(function(){
	        	   var itemViews="<tr>";
	        	   <c:forEach items="${itemList}" var="item" varStatus="cnt">
	        			  itemViews+="<td align=center><img src=${initParam.root }resources/images/items/itemSample.jpg width=250 height=150><br><font size=4><b>${item.itemName}</b></font><br><input type=button value=상세보기 class='btn btn-default' id=${item.itemNo}><br><br><br></td>";
	        	  		  if(${cnt.count==3})
	        	  			  itemViews+="</tr><tr>";
	        	   </c:forEach>	
	        	   itemViews+="</tr>";
	        	   $("#tbody1").html(itemViews);	
	        	   $(function(){
	        		   $("#table1 td").children(":button").click(function(){
	        			   $.getJSON("${initParam.root}findItemByNoAjax?no="+$(this).attr("id"),function(data){
	        					$("#button1").trigger("click");
	        					$(".modal-body").html("쿠폰명: "+data.itemName+"<br>현재수량: "+data.itemStock+"<br>최대 구매 가능 수량: "+data.maxAmountAvailable+"<br>쿠폰가격: "+data.itemPrice+"<br>쿠폰설명: "+data.itemDetail);    	        
	        			  		itemNo=data.itemNo;
	        			   });
	        		   });
	        		   $(function(){
	        			   $("#purchase").click(function(){
		        				  alert(itemNo+"구매완료");
		        			   });
	        		   });	
	        	   });
	        	   $("#nextItem").click(function(){
	        		   alert("오늘은 여기까지");
	        	   });
	           });
	           //]]>
</script>
<table align=center width=100% id="table1">
	<tbody id=tbody1></tbody>
</table>
<br>
<button type="button" class="btn btn-block" style="width:100%" id="nextItem"><font size=5>더보기</font></button>
<input type="hidden"  data-toggle="modal" data-target="#myModal" id="button1" >
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">쿠폰 소개</h4>
      </div>
      <div class="modal-body">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="purchase">Purchase</button>
      </div>
    </div>
  </div>
</div>