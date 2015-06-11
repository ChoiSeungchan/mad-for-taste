<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<li class="active">
				<a href="#">Link</a>
			</li>
			<li>
				<a href="#">Link</a>
			</li>
			<li class="dropdown">
				 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
				<ul class="dropdown-menu">
					<li>
						<a href="#">Action</a>
					</li>
					<li>
						<a href="#">Another action</a>
					</li>
					<li>
						<a href="#">Something else here</a>
					</li>
					<li class="divider">
					</li>
					<li>
						<a href="#">Separated link</a>
					</li>
					<li class="divider">
					</li>
					<li>
						<a href="#">One more separated link</a>
					</li>
				</ul>
			</li>
		</ul>
		<form class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" class="form-control" />
			</div> <button type="submit" class="btn btn-default">Submit</button>
		</form>
		<!-- Small modal -->
		<div class="modal fade loginModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content"><br>
				<form role="form">
				<div class="modal-header">
					<h4>로그인</h4>
				</div>
				<div class="modal-body">
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
								<label class="radio-inline"> <input type="radio"
									name="optionsRadios" id="optionsRadios1" value="option1"
									checked="checked">일반 회원
								</label> <label class="radio-inline"> <input type="radio"
									name="optionsRadios" id="optionsRadios2" value="option2">업주
									회원
								</label>
							</div>
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
			<li>
				<a href="#" data-toggle="modal" data-target=".loginModal">로그인</a>
			</li>
			<li class="dropdown">
				 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
				<ul class="dropdown-menu">
					<li>
						<a href="#">Action</a>
					</li>
					<li>
						<a href="#">Another action</a>
					</li>
					<li>
						<a href="#">Something else here</a>
					</li>
					<li class="divider">
					</li>
					<li>
						<a href="#">Separated link</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</nav>