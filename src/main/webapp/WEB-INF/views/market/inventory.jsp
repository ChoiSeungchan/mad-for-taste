<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
$(function() {
	$('#itemUseBtn').click(function(){
		alert('${sessionScope.member.name}님이 itemNo : '+$('.itemContainer').attr('id')+' 를 사용하였습니다.');
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
.myInventoryTitle {
	margin-top: 20px;
	margin-bottom: 20px;
	font-size : 20px;
	font-weight: bold;
}
</style>
<div class="myInventoryTitle" align="center">
	<hr>
	${sessionScope.member.name}(${sessionScope.member.id}) 님의 인벤토리
	<hr>
</div>
<div class="invenContainer">
	<c:if test="${container.page.totalListSize==0}">
		<div align="center">
			<font color="red">보유 중인 아이템이 없습니다.</font>
		</div>
	</c:if>
	<c:forEach var="inven" items="${container.list}">
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
