
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
<form:form action="registerMember" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="id">아이디</label>
    <input type="text" class="form-control" name="id" id="id" placeholder="아이디를 입력하세요">
  </div>
  <div class="form-group">
    <label for="password">비밀번호</label>
    <input type=text class="form-control" name="password" id="password" placeholder="비밀번호를 입력하세요">
  </div>
  <div class="form-group">
    <label for="name">이름</label>
    <input type="text" class="form-control" name="name" id="name" placeholder="이름을 입력하세요">
  </div>
  <div class="form-group">
    <label for="address">주소</label>
    <input type="text" class="form-control" name="address" id="address" placeholder="주소를 입력하세요">
  </div>
  <div class="form-group">
    <label for="gender">성별</label>
    <input type="text" class="form-control" name="gender" id="gender" placeholder="성별을 입력하세요">
  </div>
  <div class="form-group">
    <label for="birth">생년월일</label>
    <input type="text" class="form-control" name="birth" id="birth" placeholder="생년월일을 입력하세요">
  </div>
  <div class="form-group">
    <label for="tel">전화번호</label>
    <input type="text" class="form-control" name="tel" id="tel" placeholder="전화번호를 입력하세요">
  </div>
  <div class="form-group">
    <label for="imgFile">프로필 사진</label>
    <input type="file" name="imgFile" id="imgFile">
  </div>
  <button type="submit" class="btn btn-default">회원가입</button>
</form:form>
</div>
</body>
</html>