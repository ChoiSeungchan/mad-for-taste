<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script>
	//<![CDATA[
	           $(function(){
	        	  	$(":button").click(function(){
	        	  		location.href="${initParam.root}login?id=${param.id}&password=${param.password}";
	        	  	});
	           });
	           //]]>
</script>
<img  style="margin:0px auto; " class="img-responsive" src="${initParam.root}resources/images/user/owner/result.jpg"><br>
<input type="button" class="btn btn-default" value="Let`s go Home">