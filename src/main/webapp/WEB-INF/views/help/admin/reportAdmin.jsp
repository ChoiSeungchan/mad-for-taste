<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script type="text/javascript">
$(function() {
	$('.blindForm').submit(function() {
		return confirm('정말 삭제 처리 하시겠습니까?');
	})
})
</script>
<div class="col-md-12">
<table class="table table-hover">
	<thead>
		<tr>
			<th>#</th>
			<th>게시판 구분</th>
			<th>게시물 번호</th>
			<th>신고자 아이디</th>
			<th>신고 사유</th>
			<th>신고 일시</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="report" items="${reportList}">
		<tr>
			<td>${report.reportNo}</td>
			<td>${report.boardName}</td>
			<td>${report.articleNo}</td>
			<td>${report.accuserId}</td>
			<td>${report.reportReason}</td>
			<td>${report.calDate}</td>
			<td>
				<form action="${initParam.root}reportAdmin/blindArticle" method="post" class="blindForm">
					<input type="hidden" name="boardName" value="${report.boardName}">
					<input type="hidden" name="articleNo" value="${report.articleNo}">
					<button type="submit" id="blindBtn" class="btn btn-primary btn-xs">삭제 처리</button>
				</form>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</div>