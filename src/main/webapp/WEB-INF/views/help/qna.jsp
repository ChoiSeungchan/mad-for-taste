<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<!-- <script type="text/javascript">
   function qnalist(pageNo) {
      var selectComp = $("searchSelect").Element.value();
      alert(selectComp);
      location.href = "qnalist?pageNo="
            + pageNo + "&searchSelect=" + selectComp;
   }
</script> -->
<script>
	$(function() {
		$("#insert").click(function() {
			location.href = "insertQnaView"
		});
		
		$("#qnaSearchBtn").click(function(){
			var inputText=$("#input").text();
			alert(inputText);
			
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
					
					<td class="titleView">
					<c:if test="${qna.relevel!=0}">
					<c:forEach begin="1" end="${qna.relevel}" step="1">&nbsp;&nbsp;</c:forEach>				
					<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>${qna.title }
					</c:if>
					${qna.title }
				</td>	
					
					<span class="col-md-5" style="text-align: right">
						<td><div class="glyphicon glyphicon-eye-open"></div>
							${qna.viewCount} &nbsp&nbsp&nbsp&nbsp</td>
						<td><div class="glyphicon glyphicon-time"></div>
							${qna.regDate }
					</td>
					</span>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	 
		<div id="insert">
		 <c:if test="${sessionScope.member!=null||sessionScope.owner!=null }">
			<button type="button" class="btn btn-primary btn-block">Qna
				register</button>
					</c:if>
		</div>
	
	<form id="searchForm" action="qnalist">
	<div style="margin-bottom: 30px" align="center">
		<ul class="pagination">
			<li> <a href="qnalist?pageNo=${qnaPageInfo.currentPage-1}&searchSelect=${param.searchSelect}&input=${param.input}">Prev</a></li>
	<c:forEach var="p" begin="${qnaPageInfo.beginPage}" end="${qnaPageInfo.endPage}">
      <c:choose>
      	<c:when test="${qnaPageInfo.pageCount==0}">
      	  <li class="active">
	      	<a href="#">1</a>
	      </li>
      	</c:when>
      	<c:when test="${qnaPageInfo.currentPage==p}">
	      <li class="active">
	        <a href="qnalist?pageNo=${p}&searchSelect=${param.searchSelect}&input=${param.input}">${p}</a>
	      </li>
      	</c:when>
      	<c:otherwise>
	      <li>
	        <a href="qnalist?pageNo=${p}&searchSelect=${param.searchSelect}&input=${param.input}">${p}</a>
	      </li>
      	</c:otherwise>
      </c:choose>
      </c:forEach>
			<li><a href="qnalist?pageNo=${qnaPageInfo.currentPage+1}&searchSelect=${param.searchSelect}&input=${param.input}">Next</a></li>
		</ul>
		
	<!-- Search -->
	<div class="col-md-offset-0">
	<!-- SelectBoax -->
      <div class="col-md-2 text-right">
         <div class="btn-group btn-group-sm">
            <select class="selectpicker" name="searchSelect" id="searchSelect">
               <option value="">검색조건</option>
               <option value="0">사용자</option>
               <option value="1">제목+내용</option>
            </select>
         </div>
      </div>
      
      <!-- Text and Button Area -->
      <div class="col-md-10 text-left">
         <div class="form-group">
            <div class="input-group">
               <input type="text" class="form-control" placeholder="검색어입력"
                  name="input" id="input"> <span class="input-group-btn">
                  <input type="submit" id="qnaSearchBtn" class="btn btn-primary" value="검색">
               </span>
            </div>
         </div>
      </div>
      </div>

	</div>
	</form>
</div>