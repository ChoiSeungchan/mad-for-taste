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
							<div class="progress">
								<div
									class="progress-bar progress-bar-striped"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100"
									style="width: ${member.levelInfo.expPercentage}%">
									${member.levelInfo.currentLevelExp}/${member.levelInfo.nextLevelExp}
									(${member.levelInfo.expPercentage}%)
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td><b>Lv.${member.levelInfo.level}</b> ${member.name}(${member.id})님 로그인중</td>
					</tr>
					<tr>
						<td>포인트 : ${member.point}P</td>
					</tr>
					</tbody>
				</table>
				<input type="button" id="logoutBtn" class="btn btn-primary" value="로그아웃">
			</c:when>
			<c:when test="${sessionScope.owner!=null}">
				점주회원 : ${owner.name}(${owner.ownerId})님 접속중
				<input type="button" id="logoutBtn" class="btn btn-primary" value="로그아웃">
			</c:when>
			<c:otherwise>
				<form action="login" id="loginForm" role="form">
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