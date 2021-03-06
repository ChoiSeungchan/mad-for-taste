<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
 $(document).ready(function(){
	 $("#list").click(function(){
		 location.href="noticelist";
	 });
	 
	 
	 $("#updateView").click(function(){
		 location.href="updateView?articleNo=${content.articleNo}&title=${content.title}&"+
				 "regDate=${content.regDate}&content=${content.content}";
				 /* "&content=${content.content}"; */
				 });
	 
	 
 });
</script>
<div class="table-responsive">
	<table class="table borderless">
		<caption>
			<h3>Notice</h3>
		</caption>
		<th>
			<div class="col-md-1"align="left">${content.articleNo }</div>
			<div class="col-md-5" align="left">${content.title }&nbsp|&nbsp ${content.writer }</div>
			<div class="col-md-6" align="right">${content.regDate }</div>
		</th>
		<tbody>
			<tr>
				<td>
					<div class="col-md-12">${content.content }</div>
				</td>
			</tr>
		</tbody>
	</table>
	
	 <span class="col-md-12" style="text-align: right">
	<div class="btn-group">
		<c:if test="${sessionScope.member.levelInfo.level >= 100}">
		<button id="updateView" type="button" class="btn btn-primary">수정</button>
		<button id="delete" type="button" class="btn btn-primary">삭제</button>
		</c:if>
		<button id="list" type="button" class="btn btn-primary">목록</button>
	</div>
	</span>
</div>
