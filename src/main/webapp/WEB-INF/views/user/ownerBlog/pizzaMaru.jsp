<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script>
			function changeImg(obj, img) {
   			 obj.src = img;
			}
			var imgObj = new Image();
			function showImgWin(imgName) {
 			 imgObj.src = imgName;
			  setTimeout("createImgWin(imgObj)", 100);
			}
			function createImgWin(imgObj) {
			  if (! imgObj.complete) {
			    setTimeout("createImgWin(imgObj)", 100);
			    return;
			  }
			  imgwin = window.open("", "imageWin","width=" + imgObj.width + ",height=" + imgObj.height);
			  imgwin.document.write("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>");
			  imgwin.document.write("<html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8'>"); // euc-kr? utf-8?
			  imgwin.document.write("<title>큰이미지</title>");  // 새창 페이지 제목
			  imgwin.document.write("</head><body style='margin:0px;padding:0px'>");
			  imgwin.document.write("<a href='#' onclick='javascript:window.close()'><img src='" + imgObj.src + "' onclick='self.close();' alt='이미지를 클릭하시면 창이 닫힙니다.'></a>\n");
			  imgwin.document.write("</body><html>");
			  imgwin.document.title = imgObj.src;
			}
	//<![CDATA[
				$(function(){

				});
	           //]]>
</script>
<div class="alert alert-danger">
	<c:forEach items="${list }" var="list">
	<c:if test="${list.contractFlag=='Y'}">
  	<strong><font size="5">${list.businessName }</font></strong><br><br>
    <b>주소: </b>${list.address }<br>
    <b>대표전화: </b>${list.tastyTel }<br>
   	<b>영업시간: </b>10:00 ~ 22:00
    </c:if>
    </c:forEach>
</div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:showImgWin('${initParam.root }resources/images/user/owner/tasty/shop.png')"id="shop"><img src="${initParam.root }resources/images/user/owner/tasty/shop.png" class="img-thumbnail" alt="Cinque Terre" width="254px" height="156px"></a>&nbsp;&nbsp;&nbsp;
<a href="javascript:showImgWin('${initParam.root }resources/images/user/owner/tasty/shop2.png')"id="shop"><img src="${initParam.root }resources/images/user/owner/tasty/shop2.png" class="img-thumbnail" alt="Cinque Terre" width="274px" height="156px"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="javascript:showImgWin('${initParam.root }resources/images/user/owner/tasty/shop3.png')"id="shop"><img src="${initParam.root }resources/images/user/owner/tasty/shop3.png" class="img-thumbnail" alt="Cinque Terre" width="254px" height="156px"></a>
<br><br>
<div class="alert alert-info">
  <strong><font size="3">Best Menu </font></strong> &nbsp; 해당 이미지를 클릭하시면 좀더 정확한 이미지를 보실 수 있습니다.
</div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:showImgWin('${initParam.root }resources/images/user/owner/tasty/menu.png')"id="shop"><img src="${initParam.root }resources/images/user/owner/tasty/menu.png" class="img-rounded" alt="Cinque Terre" width="254px" height="206px" onmouseover="changeImg(this,'${initParam.root }resources/images/user/owner/tasty/dMenu.png')" onmouseout="changeImg(this,'${initParam.root }resources/images/user/owner/tasty/menu.png')"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:showImgWin('${initParam.root }resources/images/user/owner/tasty/menu2.png')"id="shop"><img src="${initParam.root }resources/images/user/owner/tasty/menu2.png" class="img-rounded" alt="Cinque Terre" width="254px" height="206px" onmouseover="changeImg(this,'${initParam.root }resources/images/user/owner/tasty/dMenu2.png')" onmouseout="changeImg(this,'${initParam.root }resources/images/user/owner/tasty/menu2.png')"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:showImgWin('${initParam.root }resources/images/user/owner/tasty/menu3.png')"id="shop"><img src="${initParam.root }resources/images/user/owner/tasty/menu3.png" class="img-rounded" alt="Cinque Terre" width="254px" height="206px" onmouseover="changeImg(this,'${initParam.root }resources/images/user/owner/tasty/dMenu3.png')" onmouseout="changeImg(this,'${initParam.root }resources/images/user/owner/tasty/menu3.png')"></a>
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:showImgWin('${initParam.root }resources/images/user/owner/tasty/menu4.png')"id="shop"><img src="${initParam.root }resources/images/user/owner/tasty/menu4.png" class="img-rounded" alt="Cinque Terre" width="254px" height="206px" onmouseover="changeImg(this,'${initParam.root }resources/images/user/owner/tasty/dMenu4.png')" onmouseout="changeImg(this,'${initParam.root }resources/images/user/owner/tasty/menu4.png')"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:showImgWin('${initParam.root }resources/images/user/owner/tasty/menu5.png')"id="shop"><img src="${initParam.root }resources/images/user/owner/tasty/menu5.png" class="img-rounded" alt="Cinque Terre" width="254px" height="206px" onmouseover="changeImg(this,'${initParam.root }resources/images/user/owner/tasty/dMenu5.png')" onmouseout="changeImg(this,'${initParam.root }resources/images/user/owner/tasty/menu5.png')"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:showImgWin('${initParam.root }resources/images/user/owner/tasty/menu6.png')"id="shop"><img src="${initParam.root }resources/images/user/owner/tasty/menu6.png" class="img-rounded" alt="Cinque Terre" width="254px" height="206px" onmouseover="changeImg(this,'${initParam.root }resources/images/user/owner/tasty/dMenu6.png')" onmouseout="changeImg(this,'${initParam.root }resources/images/user/owner/tasty/menu6.png')"></a>
<br><br>
<div class="alert alert-success">
  <strong><font size="3">덧글 공유하기</font></strong>&nbsp; 업주 사장님과 사용자 여러분들의 각자의 의견을 공유하는 공간입니다.
</div>