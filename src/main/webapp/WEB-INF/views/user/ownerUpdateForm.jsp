<%@page import="org.kosta.madfortaste.user.domain.Owner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="update_access" method="post" enctype="multipart/form-data">
<div class="col-md-4 col-md-offset-4">
  <div class="form-group">
    <label for="id">아이디</label>
    <input type="text" class="form-control"  name="ownerId"  placeholder="아이디를 입력하세요" readonly="readonly" value="${owner.ownerId }"/>
  </div>
  <div class="form-group">
    <label for="password">현재 비밀번호</label>
    <input type="password" class="form-control"  placeholder="비밀번호를 입력하세요" />
  </div>
  <div class="form-group">
    <label for="password">새로운 비밀번호</label>
    <input type="password" class="form-control"  name="password"  placeholder="비밀번호를 입력하세요" />
  </div>
  <div class="form-group">
    <label for="password">비밀번호 확인</label>
    <input type="password" class="form-control" placeholder="비밀번호를 입력하세요" />
  </div>
  <div class="form-group">
    <label for="name">이름</label>
    <input type="text" class="form-control" placeholder="이름을 입력하세요" name=name value="${owner.name }"/>
  </div>
  <div class="form-group">
    <label for="tel">전화번호</label>
    <input type="text" class="form-control" placeholder="전화번호를 입력하세요" name=tel value="${owner.tel }"/>
  </div>
  <div class="form-group">
  <label for="email">EMAIL</label>
    <input type="text" class="form-control" placeholder="이메일을 입력하세요" name=email value="${owner.email}"/>
  </div>
  <div class="form-group">
    <label for="email"><font color="lime">[현재 등록된 프로필 파일명]</font></label>
    <input type="text" class="form-control" name=profileImg readonly="readonly" value="${owner.profileImg }" />
  </div>
  <div class="form-group">
    <input type="file" class="form-control" name=imgFile />
  </div>
  <input type="submit" class="btn btn-default" value="정보수정">
</div>
</form>