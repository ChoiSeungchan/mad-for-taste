<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- JQuery -->
<script src="http://code.jquery.com/jquery-1.11.3.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$('#header').css('background','lime');
		$('#main').css('background','pink');
		$('#footer').css('background','orange');
		$('#left').css('background','yellow');
		
		$('#left').height(500);
		
		
		// left div와 main div의 높이를 동기화
		var leftHeight = $('#left').height();
		var mainHeight = $('#main').height();
		if(leftHeight > mainHeight) { $('#main').height(leftHeight); }
		else { $('#left').height(mainHeight); }
		
	});
</script>
<style type="text/css">
body {
	margin-top: 60px;	
}
#right {
	margin-top: 15px;	
}
</style>
</head>
<body>
<div class="container-fluid">
<div id="nav" class="col-md-12">
	<tiles:insertAttribute name="nav"></tiles:insertAttribute>
</div>
<div id="header" class="col-md-12">
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
</div>
<div id="left" class="col-md-2">
	<tiles:insertAttribute name="left"></tiles:insertAttribute>
</div>
<div id="main" class="col-md-8">
	<tiles:insertAttribute name="main"></tiles:insertAttribute>
</div>
<div id="right" class="col-md-2">
	<tiles:insertAttribute name="right"></tiles:insertAttribute>
</div>
<div id="footer" class="col-md-12">
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</div>
</body>
</html>