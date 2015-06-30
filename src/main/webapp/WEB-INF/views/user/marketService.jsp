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
	        					$("#myModal").modal('show');
	        			   });
	        		   });
	        	   });
	           });
	           //]]>
</script>
<table align=center width=100% border="1" id="table1">
	<tbody id=tbody1></tbody>
</table>