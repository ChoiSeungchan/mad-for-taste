<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
	$(function() {
		$('#registerBtn').click(function(){
			var userCategory = $(':input[name=userCategory]:checked').val();
			if(userCategory=='member') {
				location.href='memberRegisterForm';
			} else if(userCategory=='owner') {
				location.href='ownerRegisterForm';
			}
		});
	})
</script>
<ul class="list-group">
	<li class="list-group-item">
		<form id="loginForm" role="form">
			<div class="form-group">
				<label class="control-label">ID</label> <input class="form-control"
					placeholder="Enter ID" type="text">
			</div>
			<div class="form-group">
				<label class="control-label">Password</label> <input
					class="form-control" placeholder="Password" type="password">
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
				<button type="submit" class="btn btn-primary">로그인</button>
				<button type="button" id="registerBtn" class="btn btn-info">회원가입</button>
			</div>
		</form>
	</li>
</ul>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">실시간 검색어</h3>
	</div>
	<div class="panel-body">
		<ul class="list-group">
			<li class="list-group-item">Cras justo odio</li>
			<li class="list-group-item">Dapibus ac facilisis in</li>
			<li class="list-group-item">Morbi leo risus</li>
			<li class="list-group-item">Porta ac consectetur ac</li>
			<li class="list-group-item">Vestibulum at eros</li>
		</ul>
	</div>
</div>