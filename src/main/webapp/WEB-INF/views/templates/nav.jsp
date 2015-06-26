<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
				class="icon-bar"></span><span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/madfortaste">맛에 미치다!</a>
	</div>

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<!-- <li class="active">
				<a href="#">Link</a>
			</li>
			<li>
				<a href="#">Link</a>
			</li> -->
		</ul>
		<!-- <form class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" class="form-control" />
			</div> <button type="submit" class="btn btn-default">Submit</button>
		</form> -->
		<!-- Small modal -->
		<div class="modal fade loginModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content"><br>
				<form id="loginForm" action="login" method="post" role="form">
				<div class="modal-header">
					<h4>로그인</h4>
				</div>
				<div class="modal-body">
						<div class="form-group">
							<label class="control-label">ID</label> <input class="form-control"
								placeholder="Enter ID" type="text" id="id" name="id">
						</div>
						<div class="form-group">
							<label class="control-label">Password</label> <input
								class="form-control" placeholder="Password" type="password" id="password" name="password">
						</div>
				</div>
				<div class="modal-footer">
						<button type="submit" class="btn btn-default">로그인</button>
				</div>	
				</form>
		    </div>
		  </div>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${member==null && owner==null}">
					<li>
						<a href="#" data-toggle="modal" data-target=".loginModal">로그인</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="logout">로그아웃</a>
					</li>
				</c:otherwise>
			</c:choose>
			<li class="dropdown">
				 <a href="#" class="dropdown-toggle" data-toggle="dropdown">고객센터<strong class="caret"></strong></a>
				<ul class="dropdown-menu">
					<li>
						<a href="${initParam.root }noticelist">공지사항</a>
					</li>
					<li>
						<a href="${initParam.root }qnalist">질문과 답변</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</nav>