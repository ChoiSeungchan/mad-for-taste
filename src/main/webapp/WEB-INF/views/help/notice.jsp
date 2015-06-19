<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#insert").click(function() {
			location.href = "insertView"
		})
		$("#t1 tbody tr").click(function() {
			var articleNo =$(this).children("td:eq(0)").text();
			location.href="showContentView?no="+articleNo;
			
		});

		$("blockquote").hover(function() {
			$(this).attr('style', 'background-color:#4F5151;color:grey');
		}, function() {
			$(this).attr('style', 'background-color:none');
		})

	});
</script>
<div class="col-md-12">
	<caption>
		<h3>Notice</h3>
		<br> 공지사항에 대한 의문사항은 댓글로 문의 바랍니다.
		<hr>
		<br>
	</caption>
	<table class="table table-hover" id="t1">
		<thead>
			<tr>
				<th><span class="label label-default">No.</span></th>
				<th><span class="label label-primary">Writer</span></th>
				<th><span class="label label-success">Title</span></th>
				<th><span class="label label-info">ViewCount</span></th>
				<th><span class="label label-warning">Date</span></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="notice" items="${boardList}">
				<tr>
					<td id="articleNo" align="left">${notice.articleNo}</td>
					<td><span class="col-md-3"> ${notice.writer} </span></td>
					<td>${notice.title}</td>
					<span class="col-md-5" style="text-align: right">
						<td><div class="glyphicon glyphicon-eye-open"></div>
							${notice.viewCount} &nbsp&nbsp&nbsp&nbsp</td>
						<td><div class="glyphicon glyphicon-time"></div>
							${notice.regDate }
					<td>
					</span>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:if test="${sessionScope.member.levelInfo.level >= 100}">
		<div id="insert">
			<button type="button" class="btn btn-primary btn-block">Notice
				register</button>
		</div>
	</c:if>
	<div style="margin-bottom: 30px" align="center">
		<ul class="pagination">
			<li><a href="#">Prev</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">Next</a></li>
		</ul>
	</div>
</div>