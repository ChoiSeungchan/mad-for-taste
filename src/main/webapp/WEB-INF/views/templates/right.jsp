<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(function() {
		$('#registerBtn').click(function(){
			var userCategory = $(':input[name=userCategory]:checked').val();
			if(userCategory=='member') {
				location.href='memberRegisterForm';
			} else if(userCategory=='owner') {
				location.href='owner_ownerRegisterForm';				
			}
		});
		
		$('#logoutBtn').click(function(){
			location.href='logout';
		});
		
		/*
			경험치 20%, 50%, 90% 분기마다 경험치 바 색깔이 바뀌는 코드
		*/
		var percentage = $('#expPercentage').val();
		if(percentage!='') {
			if (percentage>90) {
				$('#levelInfo').attr('color','red');
				$('#progress').attr('class','progress-bar progress-bar-striped active');
			} else if (percentage>50) {
				$('#levelInfo').attr('color','#886A08');
				$('#progress').attr('class','progress-bar progress-bar-danger progress-bar-striped active');
			} else if (percentage>20) {
				$('#levelInfo').attr('color','#0489B1');
				$('#progress').attr('class','progress-bar progress-bar-info progress-bar-striped active');
			} else {
				$('#levelInfo').attr('color','green');
				$('#progress').attr('class','progress-bar progress-bar-success progress-bar-striped active');
			}
		}
	})
</script>
<ul class="list-group">
	<li class="list-group-item"> <!-- 박스 시작 -->
		<c:choose>
			<c:when test="${sessionScope.member!=null}">
				<table class="table">
					<thead>
						<tr>
							<th>
								회원 정보
							</th>
						</tr>
					</thead>
					<tbody>
					<tr>
						<td>
							<font id="levelInfo" color="#0489B1">
							<b>Lv.${member.levelInfo.level}</b><br>
							${member.levelInfo.currentLevelExp}/${member.levelInfo.nextLevelExp}
							(${member.levelInfo.expPercentage}%)
							</font>
							<div class="progress">
								<div id="progress"
									class="progress-bar progress-bar-info progress-bar-striped active"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100"
									style="width: ${member.levelInfo.expPercentage}%">
								</div>
							</div>
							<h4><b>${member.name}(${member.id})</b></h4>
						</td>
					</tr>
					<tr>
						<td>포인트 : ${member.point}P</td>
					</tr>
					</tbody>
				</table>
				<div align="center">
				<input type="button" id="logoutBtn" class="btn btn-primary btn-xs" value="로그아웃">
				<input type="button" id="updateBtn" class="btn btn-info btn-xs" value="내 정보 수정">
				<input type="button" id="deleteBtn" class="btn btn-warning btn-xs" value="회원 탈퇴">
				</div>
			</c:when>
			<c:when test="${sessionScope.owner!=null}">
				점주회원 : ${owner.name}(${owner.ownerId})님 접속중
				<div align="center">
				<input type="button" id="logoutBtn" class="btn btn-primary btn-xs" value="로그아웃">
				<input type="button" id="updateBtn" class="btn btn-info btn-xs" value="내 정보 수정">
				<input type="button" id="deleteBtn" class="btn btn-warning btn-xs" value="회원 탈퇴">
				</div>
			</c:when>
			<c:otherwise>
				<form action="login" method="post" id="loginForm" role="form">
					<div class="form-group">
						<label class="control-label">ID</label> <input class="form-control"
							placeholder="Enter ID" type="text" name="id">
					</div>
					<div class="form-group">
						<label class="control-label">Password</label> <input
							class="form-control" placeholder="Password" type="password" name="password">
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
			</c:otherwise>
		</c:choose>
		<input type="hidden" id="expPercentage" value="${member.levelInfo.expPercentage}">
	</li> <!-- 박스 끝 -->
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