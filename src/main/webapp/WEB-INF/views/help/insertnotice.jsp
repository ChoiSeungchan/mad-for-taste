<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body>
<form action="insert" method="post" id="insert"  >
 <table class="inputForm" >
    <caption>글쓰기</caption>
    <tbody>
	 <tr>
		<td>제목</td>
		<td><input type="text" name="title" id="title"></td>
	 </tr>
	 <tr>
		<td></td>
		<td><input type="text" name="writer" id="writer"></td>
	 </tr>
	 <tr>
		<td>패스워드</td>
		<td><input type="password" name="password" id="password"></td>
	 </tr>
	 <tr>
		<td colspan=2><textarea cols="32" rows="10" name="content" id="content"></textarea></td>
	 </tr>
	 <tr>
	 	<td  colspan=2 >
	 		<img id="writeImg" src="img/write_btn.jpg"  />	 		
	 	</td>
	 </tr>
	 </tbody>
 </table> 
 </form>
</body>
</html>