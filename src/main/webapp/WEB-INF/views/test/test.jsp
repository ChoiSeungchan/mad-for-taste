<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="http://openapi.map.naver.com/openapi/naverMap.naver?ver=2.0&key=5bc54909bf6294c7538ba9828efdb279"></script>
<script type="text/javascript" src="http://openapi.map.naver.com/openapi/naverMap.naver?ver=2.0&key=5bc54909bf6294c7538ba9828efdb279"></script>
<script type="text/javascript">
$(function(){
	
	var key = 'e124bb7fb19604d25ec62feb7c7ff1f1';
	var query = '성남시 분당구 서현동 교촌치킨';
	$.ajax({
		type:"post",
		url:'${initParam.root}naverGeoCording.json?key='+key+'&query='+query.trim(),
		dataType:"json",
		success:function(data){		
		
			var	mapx=data[0].mapx;
			var	mapy=data[0].mapy;
		
			var oPoint = new nhn.api.map.TM128(mapx, mapy);
		    nhn.api.map.setDefaultPoint('LatLng');
		    oMap = new nhn.api.map.Map('testMap' ,{
			           point : oPoint,
			           zoom : 12,
			           enableWheelZoom : true,
			           enableDragPan : true,
			           enableDblClickZoom : false,
			           mapMode : 0,
			           activateTrafficMap : false,
			           activateBicycleMap : false,
			           minMaxLevel : [ 1, 14 ],
			           size : new nhn.api.map.Size(950, 400)
			});
		    
		    var oSize = new nhn.api.map.Size(28, 37);
		    var oOffset = new nhn.api.map.Size(14, 37);
		    var oIcon = new nhn.api.map.Icon('http://static.naver.com/maps2/icons/pin_spot2.png', oSize, oOffset);
		    var oMarker = new nhn.api.map.Marker(oIcon, { title : data[0].title });                        
		    oMarker.setPoint(oPoint);                        
		    oMap.addOverlay(oMarker);  
			
		    var oLabel = new nhn.api.map.MarkerLabel(); // - 마커 라벨 선언.       
		    oMap.addOverlay(oLabel);  
		    oLabel.setVisible(true, oMarker);
		    
		}
	});
	
    
})
</script>
<div id = "testMap" style="border:1px solid #000; width:100%; height:400px; margin:20px;"></div>
