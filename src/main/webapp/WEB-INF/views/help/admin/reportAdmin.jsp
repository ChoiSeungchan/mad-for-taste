<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
				<button class="btn btn-primary btn-xs">블라인드 처리</button>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</div>