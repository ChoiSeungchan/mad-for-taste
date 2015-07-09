<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="page" value="${container.page}" />

<script type="text/javascript">
$(function(){
	$('#memberDeleteBtn').click(function(){
		var flag = confirm('정말 삭제하시겠습니까?');
		if(flag==true) {
			var checkedMember = $(':input[name=checkedMember]:checked');
			var memberArray = '';
			$(checkedMember).each(function(){
				memberArray += $(this).val()+'/';
			})
			$.ajax({
		   		type : "post",
		   		url : "${initParam.root}memberAdmin/deleteMember.ajax?memberArray="+memberArray,
		   		dataType : "json",
		   		success : function(data){
		       		location.href=location.href;
		   		}
		   	})
		}
	});
	
	$('.memberAdminForm').submit(function() {
		var flag = confirm('정말 수정하시겠습니까?');
		if(flag==true) {
			$.ajax({
		   		type : "post",
		   		url : "${initParam.root}memberAdmin/updateMember.ajax?"+$(this).serialize(),
		   		dataType : "json",
		   		success : function(data){
		   			if(data.result=="success") {
		   				alert('수정이 완료되었습니다.');
		   			} else {
		   				alert(data.result);
		   			}
		       		location.href=location.href;
		   		}
		   	})
		}
		return false;
	});
});
</script>
<div class="col-md-12">
<div align="center">
	<hr>
		<h3>회원 관리</h3>
	<hr>
</div>
<table class="table">
	<thead>
		<tr>
			<th>#</th>
			<th>ID</th>
			<th>PW</th>
			<th>이름</th>
			<th>gender</th>
			<th>birth</th>
			<th>tel</th>
			<th>level</th>
			<th>exp</th>
			<th>point</th>
			<th>update</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="member" items="${container.list}">
		<form action="" method="post" id="${member.id}" class="memberAdminForm">
		<tr id="${member.id}">
			<td><input type="checkbox" value="${member.id}" name="checkedMember"></td>
			<td>${member.id}</td>
			<td><input type="password" style="width: 100%" name="password" value="${member.password}"></td>
			<td><input type="text" style="width: 100%" name="name" value="${member.name}"></td>
			<td>${member.gender}</td>
			<td>${member.birth}</td>
			<td><input type="text" style="width: 100%" name="tel" value="${member.tel}"></td>
			<td>${member.levelInfo.level}</td>
			<td><input type="text" style="width: 100%" name="exp" value="${member.exp}"></td>
			<td><input type="text" style="width: 100%" name="point" value="${member.point}"></td>
			<td>
				<input type="hidden" name="id" value="${member.id}">
				<input type="hidden" name="city" value="${member.city}">
				<input type="hidden" name="sigungu" value="${member.sigungu}">
				<input type="hidden" name="eupmyeondong" value="${member.eupmyeondong}">
				<input type="hidden" name="address" value="${member.address}">
				<input type="hidden" name="gender" value="${member.gender}">
				<input type="hidden" name="birth" value="${member.birth}">
				<button type="submit" id="memberAdminBtn" class="btn btn-default btn-xs">수정</button>
			</td>
		</tr>
		</form>
	</c:forEach>
	</tbody>
</table>
<div>
	<button id="memberDeleteBtn" class="btn btn-primary">회원 삭제</button>
</div>
<div style="margin-bottom: 30px" align="center">
	<ul class="pagination">
      <li>
        <a href="${initParam.root}memberAdmin/${page.beginPage-1}">Prev</a>
      </li>
      <c:if test="${page.currentPageGroup!=1 && page.pageGroupCount!=0}">
      <li>
      	<a href="${initParam.root}memberAdmin/1">1</a>
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
	        <a href="${initParam.root}memberAdmin/${p}">${p}</a>
	      </li>
      	</c:when>
      	<c:otherwise>
	      <li>
	        <a href="${initParam.root}memberAdmin/${p}">${p}</a>
	      </li>
      	</c:otherwise>
      </c:choose>
      </c:forEach>
      <c:if test="${page.currentPageGroup!=page.pageGroupCount}">
      <li>
      	<a href="#">...</a>
      </li>
  	  <li>
      	<a href="${initParam.root}memberAdmin/${page.pageCount}">${page.pageCount}</a>
      </li>
      </c:if>
      <li>
        <a href="${initParam.root}memberAdmin/${page.endPage+1}">Next</a>
      </li>
    </ul>
	</div>
</div>