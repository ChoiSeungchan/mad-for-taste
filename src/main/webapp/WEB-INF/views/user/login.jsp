<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	var loginResult = '${param.loginResult}';
	if(loginResult=='failure') {
		alert('로그인 실패');
	}
</script>
<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">로그인이 필요한 서비스입니다</h3>
	</div>
	<div class="panel-body">
		<form action="${initParam.root}loginWithPath" method="post" role="form">
			<div class="form-group">
				<label class="control-label">ID</label> <input class="form-control"
					placeholder="Enter ID" type="text" id="rightId" name="id">
			</div>
			<div class="form-group">
				<label class="control-label">Password</label> <input
					class="form-control" placeholder="Password" type="password" id="rightPass" name="password">
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
${path}