<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	$(function(){
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
	</div>
	<div class="tasteBoard" style="margin-top: 30px">
	<c:forEach var="article" items="${tasteBoard}">
		 <blockquote id="tasteBoardBQ">
			<div class="row" style="height: 50px; font-size: 16px">
				<span class="col-md-1">
					#${article.articleNo}<br>
					<b>${article.location}</b>
				</span>
				<span class="col-md-3">
					<img style="width:50px;height: 50px" src="${initParam.root}resources/images/user/member/default.jpg">
					${article.writer}
				</span>
				<span class="col-md-3" style="padding-top:12px">
					${article.title}
				</span>
				<span class="col-md-5" style="padding-top:12px; text-align: right">
					<span class="glyphicon glyphicon-thumbs-up"></span> ${article.good} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-thumbs-down"></span> ${article.bad} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-eye-open"></span> ${article.hits} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-time"></span> ${article.regDate }
				</span>
			</div>
         </blockquote>
	</c:forEach>
	</div>
			<%-- <td>#${article.articleNo}</td>
			<td>${article.location}</td>
			<td>${article.title }</td>
			<td>${article.writer }</td>
			<td>${article.good}</td>
			<td>${article.bad}</td>
			<td>${article.hits}</td>
			<td>${article.regDate}</td> --%>
</div>

