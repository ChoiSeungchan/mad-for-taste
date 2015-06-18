<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$('img').attr('class','img-responsive');	
		
		$('#updateArticleFormBtn').click(function(){
			location.href='${initParam.root}updateArticleForm/'+${article.articleNo};
		})
		
		$('#deleteArticleFormBtn').click(function(){
			var flag = confirm('정말 삭제하시겠습니까?');
			if(flag) location.href='${initParam.root}deleteArticle/'+${article.articleNo};
		})
	})
	
</script>
</head>
<body>
	<div class="col-md-10 col-md-offset-1">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>
						#${article.articleNo}. ${article.title} <small><${article.location}></small>
					</h1>
				</div>
			</div>
		</div>
		<table width="100%">
			<tr>
				<td>
					<img style="width: 40px; height: 40px" src="${initParam.root}resources/images/user/member/${article.member.profileImg}">
				</td>
				<td>
					<img  src="${initParam.root}resources/images/user/member/level/${article.member.levelInfo.level}.gif">
				</td>
				<td>
					<b>${article.member.name}(${article.member.id})</b> 님이 ${article.calDate}에 작성한 글입니다.
				</td>
				<td>
				<c:if test="${article.member.id==sessionScope.member.id}">
					<button id="updateArticleFormBtn" class="btn btn-success btn-sm">글 수정하기</button>&nbsp&nbsp
					<button id="deleteArticleFormBtn" class="btn btn-danger btn-sm">글 삭제하기</button>
				</c:if>
				</td>
				<td align="right">
					<span class="glyphicon glyphicon glyphicon-comment" style="color:#045FB4"></span> ${article.reply} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-eye-open"></span> ${article.hits} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-thumbs-up" style="color:#045FB4"></span> ${article.good} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-thumbs-down" style="color:#D9230F"></span> ${article.bad} &nbsp&nbsp&nbsp&nbsp
				</td>
			</tr>
		</table>
		<hr>
		<div class="row">
			<div class="col-md-12">
				<p>
					${article.contents}
				</p>
			</div>
		</div>
		<div class="col-md-12" align="center">
			<button class="btn btn-lg btn-info ">
				${article.good}
				<span class="glyphicon glyphicon-thumbs-up"></span> 좋아요!
			</button>&nbsp&nbsp
			<button class="btn btn-lg btn-primary">
				${article.bad}
				<span class="glyphicon glyphicon-thumbs-down"></span> 싫어요!
			</button>
		</div>
		<div class="col-md-12" align="right">
			<button class="btn btn-default">목록 보기</button>
		</div>
	</div>
</body>
</html>