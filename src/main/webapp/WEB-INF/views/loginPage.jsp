<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>맛에 미치다!</title>
<!-- JQuery -->
<script src="http://code.jquery.com/jquery-1.11.3.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="${initParam.root}resources/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="${initParam.root}resources/bootstrap/theme/simplex.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="${initParam.root}resources/bootstrap/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript">
	$(document).ready(function(){
		$('#footer').css('background','orange');
		
		var loginResult = '${loginResult}';
		if(loginResult=='failure') {
			alert('존재하지 않는 아이디 이거나 패스워드를 잘못 입력하셨습니다.');
			$('#loginId').focus();
		}
	});
</script>
<style type="text/css">
body {
	margin-top: 60px;
}
#right {
	margin-top: 15px;	
}
#left {
	margin-top: 15px;
}
.container-fluid {
  width: 1366px;
  max-width: none !important;
}
#main{
	margin-top: 50px;
	margin-bottom: 50px;
}
</style>
</head>
<body>
<div class="container-fluid">
<div id="nav" class="col-xs-12">
	<jsp:include page="templates/nav.jsp"></jsp:include>
</div>
<div id="header" class="col-xs-12">
	<jsp:include page="templates/header.jsp"></jsp:include>
</div>
<div id="main" class="col-xs-8 col-xs-offset-2">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">로그인이 필요한 서비스입니다</h3>
		</div>
		<div class="panel-body">
			<form action="${initParam.root}loginWithPath" method="post" role="form">
				<div class="form-group">
					<label class="control-label">ID</label> <input class="form-control"
						placeholder="Enter ID" type="text" id="loginId" name="id">
				</div>
				<div class="form-group">
					<label class="control-label">Password</label> <input
						class="form-control" placeholder="Password" type="password" id="loginPass" name="password">
				</div>
				<div class="form-group">
					<div class="radio">
						<label class="radio-inline"> 
						<input type="radio"	name="userCategory" id="member" value="member" checked="checked">일반 회원
						</label> 
						<label class="radio-inline"> 
						<input type="radio" name="userCategory" id="owner" value="owner">업주 회원
						</label>
					</div>
					<input type="hidden" name="path" value="${path}">
					<button type="submit" id="rightLoginBtn" class="btn btn-primary">로그인</button>
					<button type="button" id="registerBtn" class="btn btn-info">회원가입</button>
				</div>
			</form>
		</div>
	</div>
</div>
<div id="footer" class="col-xs-12">
	<jsp:include page="templates/footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>




