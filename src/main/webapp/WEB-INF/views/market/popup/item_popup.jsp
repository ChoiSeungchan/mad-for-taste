<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript">
$(function() {
	$('#totalPrice').text('${item.itemPrice}' + ' Point');
    var spinner = $( "#spinner" ).spinner({ min: 1, max: '${item.itemStock}'});
    spinner.spinner( "value", 1 );
    $('.ui-spinner-button').click(function() {
     var totalPirce = $(':input[name=itemAmount]').val() * '${item.itemPrice}';
     $('#totalPrice').text(totalPirce + ' Point');
    })
    
    $('#buyItemForm').submit(function() {
    	return confirm($('#totalPrice').text()+'가 차감됩니다. 진행하시겠습니까?');
    })
});
</script>
<style type="text/css">
#container {
	width: 384px;
	height: 384px;
}
#imgArea {
	width: 100%;
	height: 250px;
}
#formArea {
	margin-top : 10px;
	width: 100%;
	height: 84px;
}
.itemImg {
	border : 1px solid;
	width : 250px;
	height: 250px;
	object-fit: cover;
}
.itemTitle {
	margin-top: 5px;
	margin-bottom: 5px;
	font-size: 14px;
	font-weight: bold;
}
.itemDetail {
	margin-top: 5px;
	margin-bottom: 5px;
	font-size: 14px;
}
#spinner {
	width: 30px;
}
#totalPrice {
	margin : 5px;
	font-size: 15px;
	color: red;
}
</style>
<div id="container" align="center">
<div id="imgArea">
	<img class="img-responsive itemImg" src="${initParam.root}resources/images/market/itemSample.jpg">
</div>
<div class="itemTitle">${item.itemName}</div>
<div class="itemDetail">${item.itemDetail}</div>
<div id="formArea">
<form action="${initParam.root}buyItem" id="buyItemForm" method="post">
	<input type="hidden" name="id" value="${sessionScope.member.id}">
	<input type="hidden" name="itemNo" value="${item.itemNo}">
	<label for="spinner">수량:</label>
	<input type="text" id="spinner" name="itemAmount"> (재고:${item.itemStock}개)
	<div id="totalPrice"></div>
	<button type="submit" class="btn btn-default btn-xs">구매하기</button>
	<button type="button" onclick="javascript:window.close()" class="btn btn-default btn-xs">닫기</button>
</form>
</div>
</div>