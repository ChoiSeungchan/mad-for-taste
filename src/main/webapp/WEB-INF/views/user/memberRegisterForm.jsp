
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="col-md-4 col-md-offset-4">
<form:form action="registerMember" method="post" enctype="multipart/form-data" commandName="member">
  <div class="form-group">
    <label for="id">아이디</label>
    <form:input type="text" class="form-control" path="id" name="id" id="id" placeholder="아이디를 입력하세요"/>
  	<font color="red"><form:errors path="id"/></font>
  </div>
  <div class="form-group">
    <label for="password">비밀번호</label>
    <form:input type="password" class="form-control" path="password" name="password" id="password" placeholder="비밀번호를 입력하세요"/>
  	<font color="red"><form:errors path="password"/></font>
  </div>
  <div class="form-group">
    <label for="name">이름</label>
    <form:input type="text" class="form-control" path="name" name="name" id="name" placeholder="이름을 입력하세요"/>
  	<font color="red"><form:errors path="name"/></font>
  </div>
   <div class="form-group">
    <label for="address">주소</label>
    <form:input type="text" class="form-control" path="address" name="address" id="address" placeholder="주소를 입력하세요"/>
  	<font color="red"><form:errors path="address"/></font>
  </div>
  <div class="form-group">
    <label for="gender">성별</label>
    <form:input type="text" class="form-control" path="gender" name="gender" id="gender" placeholder="성별을 입력하세요"/>
  	<font color="red"><form:errors path="gender"/></font>
  </div>
  <div class="form-group">
    <label for="birth">생년월일</label>
    <form:input type="text" class="form-control" path="birth" name="birth" id="birth" placeholder="생년월일을 입력하세요"/>
  	<font color="red"><form:errors path="birth"/></font>
  </div>
  <div class="form-group">
    <label for="tel">전화번호</label>
    <form:input type="text" class="form-control" path="tel" name="tel" id="tel" placeholder="전화번호를 입력하세요"/>
  	<font color="red"><form:errors path="tel"/></font>
  </div>
  <div class="form-group">
    <label for="imgFile">프로필 사진</label>
    <input type="file" name="imgFile" id="imgFile" accept="image/gif,image/jpeg,image/bmp, image/png">
  </div>
  <button type="submit" class="btn btn-default">회원가입</button>
</form:form>
</div>
</body>
</html>