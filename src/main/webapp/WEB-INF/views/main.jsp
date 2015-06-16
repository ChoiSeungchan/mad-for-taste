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
			alert((this).id);
		})
		
		$('#regArticleBtn').hover(function(){
			$(this).attr('class','btn btn-success btn-lg btn-block')
		}, function(){
			$(this).attr('class','btn btn-default btn-lg btn-block')
		})
		
		$('#regArticleBtn').click(function(){
			location.href='registerArticleForm';
		})
	});
</script>
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
				<a href="pizzaMaru?id=kostajjang"><img alt="" src="${initParam.root}resources/images/test1.jpg" /></a>
				<div class="carousel-caption">
					<h4>First Thumbnail label</h4>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
				</div>
			</div>
			<div class="item">
				<img alt="" src="${initParam.root}resources/images/test2.jpg" />
				<div class="carousel-caption">
					<h4>Second Thumbnail label</h4>
					<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam.
						Donec id elit non mi porta gravida at eget metus. Nullam id dolor
						id nibh ultricies vehicula ut id elit.</p>
				</div>
			</div>
			<div class="item">
				<img alt="" src="${initParam.root}resources/images/test3.jpg" />
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
			<button id="regArticleBtn" class="btn btn-default btn-lg btn-block" style="margin-bottom: 10px">나만의 맛집 소개하기</button>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<c:forEach var="article" items="${tasteBoard}">
		 <blockquote id="${article.articleNo}">
			<div class="row" style="height: 50px;font-size: 15px;">
				<span class="col-md-1">
					#${article.articleNo}<br>
					<b>${article.location}</b>
				</span>
				<span class="col-md-3">
					<img style="width:50px;height: 50px" src="${initParam.root}resources/images/user/member/${article.member.profileImg}">
					<img style="width:20px;height: 20px" src="${initParam.root}resources/images/user/member/level/${article.member.levelInfo.level+1}.gif">
					${article.member.name}(${article.writer})
				</span>
				<span class="col-md-4" style="padding-top:12px;overflow:hidden;text-overflow:ellipsis;">
					<b>${article.title}</b>
				</span>
				<span class="col-md-4" style="padding-top:12px; text-align: right">
					<span class="glyphicon glyphicon glyphicon-comment" style="color:#045FB4"></span> ${article.reply} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-eye-open"></span> ${article.hits} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-thumbs-up" style="color:#045FB4"></span> ${article.good} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-thumbs-down" style="color:#D9230F"></span> ${article.bad} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-time"></span> ${article.calDate }
				</span>
			</div>
         </blockquote>
	</c:forEach>
	</div>
	<div style="margin-bottom: 30px" align="center">
	<ul class="pagination">
      <li>
        <a href="#">Prev</a>
      </li>
      <c:if test="${page.currentPageGroup!=1}">
      <li>
      	<a href="#">1</a>
      </li>
      <li>
      	<a href="#">...</a>
      </li>
      </c:if>
      <c:forEach var="p" begin="${page.beginPage}" end="${page.endPage}">
      <li>
        <a href="#">${p}</a>
      </li>
      </c:forEach>
      <c:if test="${page.currentPageGroup!=page.pageGroupCount}">
      <li>
      	<a href="#">...</a>
      </li>
  	  <li>
      	<a href="#">${page.pageCount}</a>
      </li>
      </c:if>
      <li>
        <a href="#">Next</a>
      </li>
    </ul>
	</div>
</div>

