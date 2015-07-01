<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script>
$(function(){
	$('.loading').hide();
	
	$.ajax({
		type:"post",
		url:"${initParam.root}itemList.json?page=1",
		dataType:"json",
		success:function(data){	
			var str = '';
			$.each(data, function(index, item){
				str+= '<div class="col-md-3 col-xs-6 itemContainer" id="'+item.itemNo+'" align="center">';
				str+= '<div id="itemImgContainer">';
				str+= '<img class="img-responsive itemImg" src="${initParam.root}resources/images/market/itemSample.jpg">';
				str+= '</div>'
				str+= '<div class="itemTitle">';
				str+= item.itemName;
				str+= '</div>';
				str+= '<div class="itemPrice">'+ item.itemPrice +' Point</div>';
				str+= '</div>';
			});
			$('.marketContainer').html(str);
			
			//테두리 hover
			$('.itemContainer').hover(function(){
				$(this).attr('style','border:1px solid');
			},function(){
				$(this).attr('style','');
			});
			
			$('.itemContainer').click(function(){
				if('${sessionScope.member}'=='') {
					alert('로그인 후에 이용하실 수 있습니다');
					return false;
				}
				itemPopup($(this).attr('id'));
			});
			
		}
	});
	
	var page = 2; // 첫 로딩때 1페이지를 뿌리고 시작했기 때문에, 더보기 눌렀을때 2페이지부터 고고싱
	
	$('#moreItemBtn').click(function(){
		$('.loading').show();
		var marketContainer = $('.marketContainer').html();
		setTimeout(function(){
			$('.loading').hide();
			$.ajax({
				type:"post",
				url:"${initParam.root}itemList.json?page="+page,
				dataType:"json",
				success:function(data){	
					var str = '';
					$.each(data, function(index, item){
						str+= '<div class="col-md-3 col-xs-6 itemContainer" id="'+item.itemNo+'" align="center">';
						str+= '<div id="itemImgContainer">';
						str+= '<img class="img-responsive itemImg" src="${initParam.root}resources/images/market/itemSample.jpg">';
						str+= '</div>'
						str+= '<div class="itemTitle">';
						str+= item.itemName;
						str+= '</div>';
						str+= '<div class="itemPrice">'+ item.itemPrice +' Point</div>';
						str+= '</div>';
					});
					marketContainer += str;
					$('.marketContainer').html(marketContainer);
					
					//테두리 hover
					$('.itemContainer').hover(function(){
						$(this).attr('style','border:1px solid');
					},function(){
						$(this).attr('style','');
					});
					
					$('.itemContainer').click(function(){
						if('${sessionScope.member}'=='') {
							alert('로그인 후에 이용하실 수 있습니다');
							return false;
						}
						itemPopup($(this).attr('id'));
					});
					page++;
				 },
				 error: function (xhr, ajaxOptions, thrownError) {
					 var message = '마지막 페이지 입니다.';
				     $('.buttonArea').html(message);
		         }
			});
		},1000)
	});
	
	function itemPopup(itemNo) {

		 cw=screen.availWidth;     //화면 넓이
		 ch=screen.availHeight;    //화면 높이

		 sw=400;    //띄울 창의 넓이
		 sh=400;    //띄울 창의 높이

		 ml=(cw-sw)/2;        //가운데 띄우기위한 창의 x위치
		 mt=(ch-sh)/2;         //가운데 띄우기위한 창의 y위치
		 
		 url = 'market/item/'+itemNo;
		 
		 test=window.open(url,'tst','width='+sw+',height='+sh+',top='+mt+',left='+ml+',resizable=no,scrollbars=no');
	}
	
	$('#regItemBtn').click(function(){
		location.href='${initParam.root}itemRegisterForm';
	});
	
});
</script>
<style type="text/css">
.marketContainer{
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
.itemPrice {
	margin-top: 5px;
	margin-bottom: 5px;
	font-size: 14px;
	color: black;
}
.buttonArea {
	margin-bottom: 10px;
}
</style>
<div class="marketContainer"></div>
<div class="col-md-12 buttonArea" align="center">
	<br>
	<div class="col-md-12 loading" align="center">
		<img height="150px" width="auto" src="${initParam.root}resources/images/common/loding.gif">
	</div>
	<button id="moreItemBtn" class="btn btn-default btn-lg btn-block">더 보기</button>
</div>
<div class="col-md-12" align="center">
	<c:if test="${sessionScope.member!=null && sessionScope.member.exp>=10000000}">
	<button id="regItemBtn" class="btn btn-primary btn-lg btn-block">아이템 등록하기</button>
	<br>
	</c:if>
</div>
