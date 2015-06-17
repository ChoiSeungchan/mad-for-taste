<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function(){
		$(".row").click(function(){
			location.href="";
		})
		
		$("blockquote").hover(function(){
			$(this).attr('style','background-color:#4F5151;color:grey');
		}, function (){
			$(this).attr('style','background-color:none');
		})
		
		/* $('#regTasteBoardBtn').hover(function(){
			$(this).attr('class','btn btn-success btn-lg btn-block')
		}, function(){
			$(this).attr('class','btn btn-default btn-lg btn-block')
		}) */
	});
</script>
<div class="col-md-12">
	<%-- <div class="carousel slide" id="carousel-507091">
		<ol class="carousel-indicators">
			<li class="active" data-slide-to="0" data-target="#carousel-507091">
			</li>
			<li data-slide-to="1" data-target="#carousel-507091"></li>
			<li data-slide-to="2" data-target="#carousel-507091"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<a href="testForm"><img alt="" src="${initParam.root}resources/images/test1.jpg" /></a>
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
	</div> --%>
	<div class="noticeBoard" style="margin-top: 10px">
	<%-- <c:choose>
		<c:when test="${member!=null && member.levelInfo.level>=10}">
			<button id="regTasteBoardBtn" class="btn btn-default btn-lg btn-block" style="margin-bottom: 10px">나만의 맛집 소개하기</button>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose> --%>
	<c:forEach var="notice" items="${boardList}">
		 <blockquote>
			<div class="row" style="height: 20px; font-size: 16px">
				<span class="col-md-1">
					No.${notice.articleNo}<br>
				</span>
				<span class="col-md-3">
					<%-- <img style="width:50px;height: 50px" src="${initParam.root}resources/images/user/member/default.jpg"> --%>
					${notice.writer}
				</span>
				<span class="col-md-3">
					${notice.title}
				</span>
				<span class="col-md-5" style="text-align: right">
					<span class="glyphicon glyphicon-eye-open"></span> ${notice.viewCount} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-time"></span> ${notice.regDate }
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
      <li>
        <a href="#">1</a>
      </li>
      <li>
        <a href="#">2</a>
      </li>
      <li>
        <a href="#">3</a>
      </li>
      <li>
        <a href="#">4</a>
      </li>
      <li>
        <a href="#">5</a>
      </li>
      <li>
        <a href="#">Next</a>
      </li>
    </ul>
	</div>
</div>