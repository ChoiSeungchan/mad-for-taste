<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function(){
		 
		$(".content").click(function(){
			var no = $("#no").text();
			location.href="showContentView?no="+no
		})
		
		$("blockquote").hover(function(){
			$(this).attr('style','background-color:#4F5151;color:grey');
		}, function (){
			$(this).attr('style','background-color:none');
		})
		
		/* $('#regTasteBoardBtn').hover(function(){
			$(this).attr('class','btn btn-success btn-lg btn-block')
		}, function(){
			$(this).attr('class','btn btn-default btn-lg btn-block')
		}) */
	});
</script>
<div class="col-md-12">
	<h2>Notice</h2>
  <p>각종 이벤트 및 사이트 운영에 관한 공지사항내용들입니다. </p>            
  <table class="table table-hover">
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
      <tr class="content">
        <td id="no" align="left">
					${notice.articleNo}
			</td>
        <td><span class="col-md-3">
					${notice.writer}
				</span></td>
        <td>${notice.title}</td>
       <span class="col-md-5" style="text-align: right">
					 <td><div class="glyphicon glyphicon-eye-open"></div> ${notice.viewCount} &nbsp&nbsp&nbsp&nbsp</td>
					<td><div class="glyphicon glyphicon-time"></div> ${notice.regDate }<td>
				</span>
      </tr>
       </c:forEach>
    </tbody>
   
  </table>
	<%-- <div class="noticeBoard" style="margin-top: 10px">
	<c:choose>
		<c:when test="${member!=null && member.levelInfo.level>=10}">
			<button id="regTasteBoardBtn" class="btn btn-default btn-lg btn-block" style="margin-bottom: 10px">나만의 맛집 소개하기</button>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<c:forEach var="notice" items="${boardList}">
		 <blockquote>
			<div class="row" style="height: 20px; font-size: 16px">
				<span class="col-md-1">
					No.${notice.articleNo}<br>
				</span>
				<span class="col-md-3">
					<img style="width:50px;height: 50px" src="${initParam.root}resources/images/user/member/default.jpg">
					${notice.writer}
				</span>
				<span class="col-md-3">
					${notice.title}
				</span>
				<span class="col-md-5" style="text-align: right">
					<span class="glyphicon glyphicon-eye-open"></span> ${notice.viewCount} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-time"></span> ${notice.regDate }
				</span>
			</div>
         </blockquote>
	</c:forEach>
	</div> --%>
	<c:if test="${sessionScope.member.levelInfo.level >= 100}">
	<div><button type="button" class="btn btn-primary btn-block">Button 1</button></div>
	</c:if>
	<div style="margin-bottom: 30px" align="center">
		<ul class="pagination">
      <li>
        <a href="#">Prev</a>
      </li>
      <li>
        <a href="#">1</a>
      </li>
      <li>
        <a href="#">2</a>
      </li>
      <li>
        <a href="#">3</a>
      </li>
      <li>
        <a href="#">4</a>
      </li>
      <li>
        <a href="#">5</a>
      </li>
      <li>
        <a href="#">Next</a>
      </li>
    </ul>
	</div>
</div>