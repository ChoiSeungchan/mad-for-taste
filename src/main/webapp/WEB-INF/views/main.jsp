<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	$(function(){
		$('blockquote').hover(function(){
			$(this).attr('style','background-color:#4F5151;color:white');
		}, function (){
			$(this).attr('style','background-color:none');
		})		
		
		$('blockquote').click(function(){
			location.href='${initParam.root}article/'+(this).id;
		})
		
		$('#regArticleBtn').hover(function(){
			$(this).attr('class','btn btn-success btn-lg btn-block')
		}, function(){
			$(this).attr('class','btn btn-default btn-lg btn-block')
		})
		
		$('#regArticleBtn').click(function(){
			location.href='${initParam.root}registerArticleForm';
		})
	});
</script>
<style type="text/css">
.blockquoteContainer {
	height: 50px;
	font-size: 15px;
	margin-top : auto;
	margin-bottom : auto;	
}

.blockquoteContainer span {
	overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

.topRank {
	border-left-color: gold;
	background-color: #FFFDE2;
	
}
</style>
<div class="col-md-12">
	<div class="carousel slide" id="carousel-507091">
		<ol class="carousel-indicators">
			<li class="active" data-slide-to="0" data-target="#carousel-507091">
			</li>
			<li data-slide-to="1" data-target="#carousel-507091"></li>
			<li data-slide-to="2" data-target="#carousel-507091"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<a href="blog_tastyPlaceBlog?id=owner1234"><img alt="" src="${initParam.root}resources/images/test1.jpg" /></a>
				<div class="carousel-caption">
					<h4>First Thumbnail label</h4>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
				</div>
			</div>
			<div class="item">
				<a href="blog_tastyPlaceBlogSecond?id=owner2345"><img alt="" src="${initParam.root}resources/images/test2.jpg" /></a>
				<div class="carousel-caption">
					<h4>Second Thumbnail label</h4>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
				</div>
			</div>
			<div class="item">
					<a href="blog_tastyPlaceBlogThree?id=owner3456"><img alt="" src="${initParam.root}resources/images/test3.jpg" /></a>
				<div class="carousel-caption">
					<h4>Third Thumbnail label</h4>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#carousel-507091"
			data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
		<a class="right carousel-control" href="#carousel-507091"
			data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
	</div>
	<div class="tasteBoard" style="margin-top: 10px">
	
	<c:choose>
		<c:when test="${member!=null && member.levelInfo.level>=1}">
			<button id="regArticleBtn" class="btn btn-primary btn-lg btn-block" style="margin-bottom: 10px">나만의 맛집 소개하기</button>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<!-- Notice -->
	
	
	<!-- Top 3 Rank -->
	<c:forEach  var="top3" varStatus="status" items="${topRankArticle}">
		<blockquote id="${top3.articleNo}" class="topRank">
			<div class="blockquoteContainer">
				<span class="col-md-1">
					<img style="width:50px;height: 50px;" src="${initParam.root}resources/images/taste/${status.count}.png">
				</span>
				<span class="col-md-4">
					<img style="width:50px;height: 50px;" src="${initParam.root}resources/images/user/member/${top3.member.profileImg}">
					<img src="${initParam.root}resources/images/user/member/level/${top3.member.levelInfo.level}.gif">
					${top3.member.name}(${top3.writer})
				</span>
				<span class="col-md-3" style="margin-top : 12px;">
					<b>${top3.title}</b>
				</span>
				<span class="col-md-4" style="margin-top : 12px;">
					<span class="glyphicon glyphicon glyphicon-comment" style="color:#045FB4"></span> ${top3.reply} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-eye-open"></span> ${top3.hits} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-thumbs-up" style="color:#045FB4"></span> ${top3.good} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-thumbs-down" style="color:#D9230F"></span> ${top3.bad} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-time"></span> ${top3.calDate }
				</span>
			</div>
         </blockquote>
	</c:forEach>
	<!-- TasteBoard -->
	<c:choose>
		<c:when test="${page.totalListSize==0}">
			<table class="table">
				<thead>
				<tr>
					<td align="center" style="font-size: 15px"><strong>등록된 게시물이 존재하지 않습니다.</strong></td>
				</tr>
				</thead>
			</table>
		</c:when>
		<c:otherwise>
			<c:forEach var="article" items="${tasteBoard}">
				 <blockquote class="tasteBoard" id="${article.articleNo}">
					<div class="blockquoteContainer">
						<span class="col-md-1">
							#${article.articleNo}<br>
							<b>${article.location}</b>
						</span>
						<span class="col-md-4">
							<img style="width:50px;height: 50px;" src="${initParam.root}resources/images/user/member/${article.member.profileImg}">
							<img src="${initParam.root}resources/images/user/member/level/${article.member.levelInfo.level}.gif">
							${article.member.name}(${article.writer})
						</span>
						<span class="col-md-3" style="margin-top : 12px;">
							<b>${article.title}</b>
						</span>
						<span class="col-md-4" style="margin-top : 12px;">
							<span class="glyphicon glyphicon glyphicon-comment" style="color:#045FB4"></span> ${article.reply} &nbsp&nbsp&nbsp&nbsp
							<span class="glyphicon glyphicon-eye-open"></span> ${article.hits} &nbsp&nbsp&nbsp&nbsp
							<span class="glyphicon glyphicon-thumbs-up" style="color:#045FB4"></span> ${article.good} &nbsp&nbsp&nbsp&nbsp
							<span class="glyphicon glyphicon-thumbs-down" style="color:#D9230F"></span> ${article.bad} &nbsp&nbsp&nbsp&nbsp
							<span class="glyphicon glyphicon-time"></span> ${article.calDate }
						</span>
					</div>
		         </blockquote>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</div>
	<div style="margin-bottom: 30px" align="center">
	<ul class="pagination">
      <li>
        <a href="${initParam.root}getArticles/${page.beginPage-1}">Prev</a>
      </li>
      <c:if test="${page.currentPageGroup!=1 && page.pageGroupCount!=0}">
      <li>
      	<a href="${initParam.root}getArticles/1">1</a>
      </li>
      <li>
      	<a href="#">...</a>
      </li>
      </c:if>
      <c:forEach var="p" begin="${page.beginPage}" end="${page.endPage}">
      <c:choose>
      	<c:when test="${page.pageCount==0}">
      	  <li class="active">
	      	<a href="#">1</a>
	      </li>
      	</c:when>
      	<c:when test="${page.currentPage==p}">
	      <li class="active">
	        <a href="${initParam.root}getArticles/${p}">${p}</a>
	      </li>
      	</c:when>
      	<c:otherwise>
	      <li>
	        <a href="${initParam.root}getArticles/${p}">${p}</a>
	      </li>
      	</c:otherwise>
      </c:choose>
      </c:forEach>
      <c:if test="${page.currentPageGroup!=page.pageGroupCount}">
      <li>
      	<a href="#">...</a>
      </li>
  	  <li>
      	<a href="${initParam.root}getArticles/${page.pageCount}">${page.pageCount}</a>
      </li>
      </c:if>
      <li>
        <a href="${initParam.root}getArticles/${page.endPage+1}">Next</a>
      </li>
    </ul>
	</div>
</div>

