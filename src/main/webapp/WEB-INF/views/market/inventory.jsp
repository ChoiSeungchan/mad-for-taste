<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
$(function() {
	$('#itemUseBtn').click(function(){
		alert($('.itemContainer').attr('id'))
	});
});
</script>
<style type="text/css">
.invenContainer{
	width: 100%;
	padding: 10px;
}
.itemContainer{
	border: 1px solid #FCFCFC;
	padding: 10px;
	margin: 0px auto;
}
.itemImgContainer{
}
.itemImg{
 	width :250px;
	height : 250px;
	object-fit: cover;
}
.itemTitle {
	margin-top: 5px;
	margin-bottom: 5px;
	font-size: 14px;
	font-weight: bold;
}
.itemAmount {
	margin-top: 5px;
	margin-bottom: 5px;
	font-size: 14px;
	color: black;
}
.buttonArea {
	margin-bottom: 10px;
}
</style>
<div class="invenContainer">
	<c:forEach var="inven" items="${inventory}">
	<div class="col-md-3 col-xs-6 itemContainer" id="${inven.itemNo}" align="center">
	<div id="itemImgContainer">
	<img class="img-responsive itemImg" src="${initParam.root}resources/images/market/item/${inven.item.itemImgName}">
	</div>
	<div class="itemTitle">
	${inven.item.itemName }
	</div>
	<div class="itemAmount">${inven.itemAmount}개 보유중</div>
	<div class="buttonArea">
		<button id="itemUseBtn" class="btn btn-default">사용하기</button>
	</div>
	</div>
	</c:forEach>
</div>
