<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
function showKeyCode(event) {
	event = event || window.event;
	var keyID = (event.which) ? event.which : event.keyCode;
	if( ( keyID >=48 && keyID <= 57 ) || ( keyID >=96 && keyID <= 105 ) )
	{
		return;
	}
	else
	{
		return false;
	}
}
</script>
<style type="text/css">
#itemRegContainer {
	margin-top: 50px;
}
</style>
<div id="itemRegContainer" class="col-md-10 col-md-offset-1">
<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">아이템 등록</h3>
	</div>
	<div class="panel-body">
		<form action="" method="post" enctype="multipart/form-data">
			<div class="col-md-12 form-group">
				<label for="itemName">아이템 이름</label>
				<input type="text" class="form-control" name="itemName" id="itemName" placeholder="아이템 이름을 입력하세요"/>
			</div>
			<div class="col-md-4 form-group">
				<label for="itemPrice">아이템 가격</label>
				<input type="number" min="0" max="100" step="5" onkeydown="return showKeyCode(event)" class="form-control" name="itemPrice" id="itemPrice" placeholder="아이템 가격을 입력하세요"/>
			</div>
			<div class="col-md-4 form-group">
				<label for="itemStock">아이템 재고</label>
				<input type="number" min="0" max="100" step="1" onkeydown="return showKeyCode(event)" class="form-control" name="itemStock" id="itemStock" placeholder="아이템 재고를 입력하세요"/>
			</div>
			<div class="col-md-4 form-group">
				<label for="itemEffectValue">최대 보유 가능 수량</label>
				<input type="number" min="0" max="100" step="1" onkeydown="return showKeyCode(event)" class="form-control" name="itemEffectValue" id="itemEffectValue" placeholder="효과 수치를 입력하세요"/>
			</div>
			<div class="col-md-4 form-group">
				<label for="itemEffect">아이템 효과</label>
				<select class="form-control" name="itemEffect" id="itemEffect">
				  <option>1</option>
				  <option>2</option>
				  <option>3</option>
				  <option>4</option>
				  <option>5</option>
				</select>
			</div>
			<div class="col-md-4 form-group">
				<label for="itemEffectValue">효과 수치</label>
				<input type="number" min="0" max="100" step="5" onkeydown="return showKeyCode(event)" class="form-control" name="itemEffectValue" id="itemEffectValue" placeholder="효과 수치를 입력하세요"/>
			</div>
			<div class="col-md-4 form-group">
				<label for="imgFile">아이템 사진</label>
				<input type="file" name="imgFile" id="imgFile" accept="image/gif,image/jpeg,image/bmp, image/png">
			</div>
			<div class="col-md-12 form-group">
				<label for="itemDetail">아이템 상세 설명</label>
				<textarea class="form-control" name="itemDetail" id="itemDetail"></textarea>
			</div>
			<div class="col-md-12">
				<button type="submit" class="btn btn-primary btn-lg btn-block">등록하기</button>
			</div>
		</form>
	</div>
</div>
</div>