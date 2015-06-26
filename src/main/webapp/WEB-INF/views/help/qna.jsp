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
			location.href = "qnaInsertView"
		})
		$("#t1 tbody tr").click(function() {
			var articleNo =$(this).children("td:eq(0)").text();
			location.href="qnaShowContentView?no="+articleNo;
			
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
		<h3>Q&A</h3>
		<br> 질문&답변 공간 입니다. 
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
			<c:forEach var="qna" items="${qnaBoardList}">
				<tr>
					<td id="articleNo" align="left">${qna.articleNo}</td>
					<td><span class="col-md-3"> ${qna.writer} </span></td>
					<td>${qna.title}</td>
					<span class="col-md-5" style="text-align: right">
						<td><div class="glyphicon glyphicon-eye-open"></div>
							${qna.viewCount} &nbsp&nbsp&nbsp&nbsp</td>
						<td><div class="glyphicon glyphicon-time"></div>
							${qna.regDate }
					<td>
					</span>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	
		<div id="insert">
			<button type="button" class="btn btn-primary btn-block">Qna
				register</button>
		</div>
	
	<div style="margin-bottom: 30px" align="center">
		<ul class="pagination">
			<li> <a href="qnalist?pageNo=${qnaPageInfo.currentPage-1}">Prev</a></li>
	<c:forEach var="p" begin="${qnaPageInfo.beginPage}" end="${qnaPageInfo.endPage}">
      <c:choose>
      	<c:when test="${qnaPageInfo.pageCount==0}">
      	  <li class="active">
	      	<a href="#">1</a>
	      </li>
      	</c:when>
      	<c:when test="${qnaPageInfo.currentPage==p}">
	      <li class="active">
	        <a href="qnalist?pageNo=${p}">${p}</a>
	      </li>
      	</c:when>
      	<c:otherwise>
	      <li>
	        <a href="qnalist?pageNo=${p}">${p}</a>
	      </li>
      	</c:otherwise>
      </c:choose>
      </c:forEach>
			<li><a href="qnalist?pageNo=${qnaPageInfo.currentPage+1}">Next</a></li>
		</ul>
	</div>
</div>