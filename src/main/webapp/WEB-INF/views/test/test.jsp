<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="http://openapi.map.naver.com/openapi/naverMap.naver?ver=2.0&key=5bc54909bf6294c7538ba9828efdb279"></script>
<script type="text/javascript">
$(function(){
	
	var key = 'e124bb7fb19604d25ec62feb7c7ff1f1';
	var query = '성남시 분당구 서현동 피자헛';
	$.ajax({
		type:"post",
		url:'${initParam.root}naverGeoCording.json?key='+key+'&query='+query.trim(),
		dataType:"json",
		success:function(data){		
			var tastePlace = data[0];
		}
	});

    
})
</script>

<div id="map" style="width:700px; height:450px; display:inline; float:left; position: relative;" ></div>
