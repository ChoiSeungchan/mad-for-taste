<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script type="text/javascript">
$(function() {
	
	$('.reportTd').click(function(){
		var tr = $(this).parent();
		var row = $(this).parent().get(0);
		var boardNameTD = row.cells[1];
		var articleNoTD = row.cells[2];
		var boardName = $(boardNameTD).html();
		var articleNo = $(articleNoTD).html();
		reportPopup(boardName, articleNo);
	})
	
	$('.blindForm').submit(function() {
		return confirm('정말 삭제 처리 하시겠습니까?');
	})

	function reportPopup(boardName,articleNo) {
		 cw=screen.availWidth;     //화면 넓이
		 ch=screen.availHeight;    //화면 높이

		 sw=1100;    //띄울 창의 넓이
		 sh=800;    //띄울 창의 높이

		 ml=(cw-sw)/2;        //가운데 띄우기위한 창의 x위치
		 mt=(ch-sh)/2;         //가운데 띄우기위한 창의 y위치
		 
		 if(boardName=='TASTEBOARD') {
			url = '${initParam.root}article/'+articleNo;			 
		 } else {
			url = 'market/item/'+itemNo;
		 }
		 
		 test=window.open(url,'tst','width='+sw+',height='+sh+',top='+mt+',left='+ml+',resizable=no,scrollbars=no');
	}
})
</script>
<style type="text/css">
.reportTd {
	color: #02a5de;
	font-weight: bold;
}
</style>
<div align="center">
	<hr>
		<h3>신고 처리</h3>
	<hr>
</div>
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
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="report" items="${reportList}">
		<tr class="reportTr">
			<td>${report.reportNo}</td>
			<td>${report.boardName}</td>
			<td>${report.articleNo}</td>
			<td>${report.accuserId}</td>
			<td>${report.reportReason}</td>
			<td>${report.calDate}</td>
			<td class="reportTd">신고된 게시물 상세보기</td>
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
<div style="margin-bottom: 30px" align="center">
	<ul class="pagination">
      <li>
        <a href="${initParam.root}reportAdmin/${page.beginPage-1}">Prev</a>
      </li>
      <c:if test="${page.currentPageGroup!=1 && page.pageGroupCount!=0}">
      <li>
      	<a href="${initParam.root}reportAdmin/1">1</a>
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
	        <a href="${initParam.root}reportAdmin/${p}">${p}</a>
	      </li>
      	</c:when>
      	<c:otherwise>
	      <li>
	        <a href="${initParam.root}reportAdmin/${p}">${p}</a>
	      </li>
      	</c:otherwise>
      </c:choose>
      </c:forEach>
      <c:if test="${page.currentPageGroup!=page.pageGroupCount}">
      <li>
      	<a href="#">...</a>
      </li>
  	  <li>
      	<a href="${initParam.root}reportAdmin/${page.pageCount}">${page.pageCount}</a>
      </li>
      </c:if>
      <li>
        <a href="${initParam.root}reportAdmin/${page.endPage+1}">Next</a>
      </li>
    </ul>
</div>