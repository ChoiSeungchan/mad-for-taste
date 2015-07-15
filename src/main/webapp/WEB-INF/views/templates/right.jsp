<%@page import="org.kosta.madfortaste.user.domain.Owner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
var htmlVal="";
	$(function() {
		$.ajax({
			type: "post",
			url: "${initParam.root}restaurantRankAjax",
			dateType: "json",
			success: function(data){
				htmlVal="";
				$.each(data,function(index,val){
					if(index<5)
						htmlVal+="<tr><td>"+val.rank+"위&nbsp&nbsp"+val.name+"</td></tr>";
				})
				$("#bestRestaurantTable").html(htmlVal);
			}
		})
		setInterval(function() {
				$.ajax({
					type: "post",
					url: "${initParam.root}restaurantRankAjax",
					dateType: "json",
					success: function(data){
						htmlVal="";
						$.each(data,function(index,val){
							if(index<5)
								htmlVal+="<tr><td>"+val.rank+"위&nbsp&nbsp"+val.name+"</td></tr>";
						})
						$("#bestRestaurantTable").html(htmlVal);
					}
				})
			}, 3000); 
		$("#writerSearch").click(function(){
			if($("#searchVal").val().trim().length<=1){
				alert("검색어를 2자이상 입력해 주세요");
				$("#searchVal").val("");
				$("#searchVal").focus();
				return;
			}
			location.href="${initParam.root}searchGetArticles?searchVal="+$("#searchVal").val()+"&event="+$(this).val();
		})
		
		$('#mainSearchForm').submit(function(){
			if($("#searchVal").val().trim().length<=1){
				alert("검색어를 2자이상 입력해 주세요");
				$("#searchVal").val("");
				$("#searchVal").focus();
				return false;
			}
			location.href="${initParam.root}searchGetArticles?searchVal="+$("#searchVal").val()+"&event="+$(this).val();
			return false;
		});
		
		$('#rightLoginForm').submit(function() {
			var id = $('#rightId').val();
			var password = $('#rightPass').val();
			if(id=='') {
				alert('아이디를 입력하세요');
				return false;
			} else if (password=='') {
				alert('비밀번호를 입력하세요');
				return false;
			} 
			$.ajax({
				type:"post",
				url:"${initParam.root}loginAjax?"+$('#rightLoginForm').serialize(),
				dataType:"json",
				success:function(data){		
					if(data=='success') location.reload(true);
					else if (data=='failure') {
						alert('없는 아이디이거나 비밀번호를 잘못 입력하셨습니다.');
					} else if (data=='empty') {
						alert('아이디 또는 비밀번호를 바르게 입력해주세요.')
					}
				}
			});
			return false;
		})
		
		$('#logoutBtn').click(function(){
			$.ajax({
				type:"post",
				url:"${initParam.root}logoutAjax",
				dataType:"json",
				success:function(data){	
				}
			});
				location.reload(true);
		});
		
		$('#memberAdminBtn').click(function(){
			location.href='${initParam.root}memberAdmin/1';
		});
		
		$('#reportAdminBtn').click(function(){
			location.href='${initParam.root}reportAdmin/1';
		});
		
		$('#registerBtn').click(function(){
			var userCategory = $(':input[name=userCategory]:checked').val();
			if(userCategory=='member') {
				location.href='${initParam.root}memberRegisterForm';
			} else if(userCategory=='owner') {
				location.href='${initParam.root}owner_ownerRegisterForm';				
			}
		});
		
		$('#dailyCheckBtn').click(function(){
			$.ajax({
				type:"post",
				url:"${initParam.root}dailyCheck",
				dataType:"json",
				success:function(data){	
					if(data.result=='failure') {
						alert('오늘은 이미 출석체크를 하셨습니다. 12시에 초기화됩니다.');
					} else {
						alert(data.exp+" 경험치와 "+data.point+" 포인트를 획득하였습니다.");
					}
					
					$.ajax({
						type:"post",
						url:"${initParam.root}maintainAuthSession",
						dataType:"json",
						success:function(data){		
							alert(data);
						}
					});
					
					location.href=location.href;
				}
			});
		})
		
		$('#inventoryBtn').click(function(){
			location.href='${initParam.root}myInventory';
		});
		
		
		$('#memberUpdateBtn').click(function(){
			location.href='${initParam.root}memberUpdateForm';
		});
		$("#ownerUpdateBtn").click(function(){
			location.href="${initParam.root}owner_ownerUpdateForm";
		});
		$("#registerTpBtn").click(function(){
			location.href="${initParam.root}owner_tastyRegisterForm";
		});
		$("#deleteTpBtn").click(function(){
			location.href="${initParam.root}ownerDeleteForm";
		});
		$("#updateTpBtn").click(function(){
			location.href="${initParam.root}tastyUpdateForm?id=${owner.ownerId}";
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
		
		
		/*
			회원 랭킹 가져오는 ajax function
		*/
		$.ajax({
			type:"post",
			url:"${initParam.root}memberRank.json",
			dataType:"json",
			success:function(data){	
				var tempStr = '';
				$.each(data, function(index, member) {
					tempStr+='<tr>';
					tempStr+='<td>'+(index+1)+'</td>';
					tempStr+='<td><img src=${initParam.root}resources/images/user/member/level/'+member.levelInfo.level+'.gif></td>';
					tempStr+='<td><b>'+member.id+'</b></td>';
					tempStr+='<td>'+member.exp+'</td>';
					tempStr+='</tr>';
				})
				$('#memberRankTableBody').html(tempStr);
			}
		});
	})
</script>
<style type="text/css">
#searchVal{
	margin-top: 10px;
	margin-bottom: 10px;
	width: 100%;
	height: 40px;
	font-size: 17px;
	border: 3px solid #d9230f;
}

.rightTable {
	width: 270px;
	height: auto;
}

.rightTable td{
	padding-bottom: 10px;
}

#bestRestaurantTable {
	font-size:14px;
	text-align: center;
}


</style>
<ul class="list-group">
	<li class="list-group-item"> <!-- 박스 시작 -->
		<c:choose>
			<c:when test="${sessionScope.member!=null && sessionScope.member.exp>=10000000}">
				<table class="table">
					<thead>
						<tr>
							<th>
								관리자 권한 획득
							</th>
						</tr>
					</thead>
					<tbody>
					<tr>
						<td>
							<font id="levelInfo" color="#0489B1">
							<b>Lv.${sessionScope.member.levelInfo.level}</b><br>
							${sessionScope.member.exp}/${sessionScope.member.levelInfo.nextLevelExp}
							(${sessionScope.member.levelInfo.expPercentage}%)
							</font>
							<div class="progress">
								<div id="progress"
									class="progress-bar progress-bar-info progress-bar-striped active"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100"
									style="width: ${sessionScope.member.levelInfo.expPercentage}%">
								</div>
							</div>
							<center><h4><b>${sessionScope.member.name}(${sessionScope.member.id})</b></h4></center>
						</td>
					</tr>
					<tr>
						<td align="center">
							<img class="img-responsive" src="${initParam.root}${sessionScope.member.profileImg}" style="width: 180px; height: 180px">
						</td>
					</tr>
					<tr>
						<td>포인트 : ${sessionScope.member.point}P</td>
					</tr>
					</tbody>
				</table>
				<div style="width: 100%; padding: 5px" align="center">
					<input type="button" id="logoutBtn" class="btn btn-primary btn-block" value="로그아웃">
					<input type="button" id="memberAdminBtn" class="btn btn-info btn-block" value="회원 관리">
					<input type="button" id="reportAdminBtn" class="btn btn-danger btn-block" value="신고 처리">
				</div>
			</c:when>
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
							<b>Lv.${sessionScope.member.levelInfo.level}</b><br>
							${sessionScope.member.exp}/${sessionScope.member.levelInfo.nextLevelExp}
							(${sessionScope.member.levelInfo.expPercentage}%)
							</font>
							<div class="progress">
								<div id="progress"
									class="progress-bar progress-bar-info progress-bar-striped active"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100"
									style="width: ${sessionScope.member.levelInfo.expPercentage}%">
								</div>
							</div>
							<center><h4><b>${sessionScope.member.name}(${sessionScope.member.id})</b></h4></center>
						</td>
					</tr>
					<tr>
						<td align="center">
							<img class="img-responsive" src="${initParam.root}${sessionScope.member.profileImg}" style="width: 180px; height: 180px">
						</td>
					</tr>
					<tr>
						<td>포인트 : ${sessionScope.member.point}P</td>
					</tr>
					</tbody>
				</table>
				<div style="width: 100%; padding: 5px" align="center">
					<input type="button" id="logoutBtn" class="btn btn-primary btn-xs btn-block" value="로그아웃">
					<input type="button" id="memberUpdateBtn" class="btn btn-info btn-xs btn-block" value="내 정보 수정">
					<input type="button" id="deleteBtn" class="btn btn-warning btn-xs btn-block" value="회원 탈퇴">
				</div>
				<div style="width: 100%; padding: 5px">
					<button id="inventoryBtn" class="btn btn-success btn-block">
						<span style="padding-right: 10px" class="glyphicon glyphicon-th" aria-hidden="true"></span>내 인벤토리
					</button>
					<button id="dailyCheckBtn" class="btn btn-default btn-block">
						<span style="padding-right: 10px" class="glyphicon glyphicon-ok" aria-hidden="true"></span>출석체크<br>(1~100EXP,Point 랜덤획득)
					</button>
				</div>
			</c:when>
			<c:when test="${sessionScope.owner!=null}">
				<table class="table">
					<thead>
						<tr>
							<th>
								<center>${sessionScope.owner.name}(${sessionScope.owner.ownerId})</center>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td align="center">			
								<img src="${owner.profileImg}" style="width: 180px; height: 180px">
							</td>
						</tr>
						<tr>
							<td>
								<div align="center">
								<input type="button" id="logoutBtn" class="btn btn-primary btn-xs" value="로그아웃">
								<input type="button" id="ownerUpdateBtn" class="btn btn-info btn-xs" value="내 정보 수정">
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div align="center">
								<input type="button" id="registerTpBtn" class="btn btn-default btn-xs" value="맛집 등록">
								<input type="button" id="updateTpBtn" class="btn btn-default btn-xs" value="맛집 수정">
								<input type="button" id="deleteTpBtn" class="btn btn-default btn-xs" value="맛집 삭제">
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<form action="${initParam.root}login" method="post" id="rightLoginForm" role="form">
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
						<button type="submit" id="rightLoginBtn" class="btn btn-primary">로그인</button>
						<button type="button" id="registerBtn" class="btn btn-info">회원가입</button>
					</div>
				</form>
			</c:otherwise>
		</c:choose>
		<input type="hidden" id="expPercentage" value="${sessionScope.member.levelInfo.expPercentage}">
	</li> <!-- 박스 끝 -->
</ul>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">검색</h3>
	</div>
	<div class="panel-body">
		<div class="btn-group-horizontal">
		  <form id="mainSearchForm">
		  <input type="text" id="searchVal">
		  <button type="submit" class="btn btn-primary" id="titleSearch" value="title" style="width: 49%">제목으로 검색</button>
		  <button type="button" class="btn btn-primary" id="writerSearch" value="writer" style="width: 49%">작성자로 검색</button>
		  </form>
		</div>
	</div>
</div>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">실시간 인기검색 맛집</h3>
	</div>
	<div class="panel-body"><br>
		<table class="rightTable" id="bestRestaurantTable">
		</table>		
	</div>
</div>

<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">회원 랭킹</h3>
	</div>
	<div class="panel-body"><br>
		<table id="memberRankTable" class="rightTable">
			<tbody id="memberRankTableBody"> 
			</tbody>
		</table>
	</div>
</div>

