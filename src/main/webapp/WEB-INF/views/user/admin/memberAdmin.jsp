<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="page" value="${container.page}" />

<script type="text/javascript">
$(function(){
})
</script>
<div class="col-md-12">
<div align="center">
	<hr>
		<h3>회원관리</h3>
	<hr>
</div>
<form >
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
		<tr id="memberTr">
			<td><input type="checkbox" value="${member.id}" name="checkedMember"></td>
			<td>${member.id}</td>
			<td><input type="password" name="password" value="${member.password}"></td>
			<td><input type="text" name="name" value="${member.name}"></td>
			<td>${member.gender}</td>
			<td>${member.birth}</td>
			<td><input type="text" name="tel" value="${member.tel}"></td>
			<td>${member.levelInfo.level}</td>
			<td><input type="text" name="exp" value="${member.exp}"></td>
			<td><input type="text" name="point" value="${member.point}"></td>
			<td></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</form>
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