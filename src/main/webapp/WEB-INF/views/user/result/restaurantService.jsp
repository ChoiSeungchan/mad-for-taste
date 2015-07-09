<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<Style type="text/css">
	.bold{
		font-size: 16px;
		font-weight: 600;
	}
	.boldlessGood{
		color: blue;
	}
	.boldlessBad{
		color: red;
	}
	.boldless{
		font-size: 13px;
		font-weight: 900;
	}
	.myAddressNearByRestaurant{
		text-align: center;
	}
	#restaurantContainer{
		text-align: center;
	}
</Style>
<script type="text/javascript">
//<![CDATA[
           var restaurantValues="";
           var restaurantPaging="<ul class='pagination'>";
           var flag="";
           var thisResNo;
           var page=new Object();
           $(function(){
        	$(".loading").hide();
        	   $("#moreRestaurantBoard").hide();
				$(".resultService").click(function(){
					$("#moreRestaurantBoard").hide();
					if(flag!=$(this).children("#resNo").val()){
						flag=$(this).children("#resNo").val();
						thisResNo=$(this).children("#resNo").val();
						$.getJSON("${initParam.root}restaurantSeeEverything?resNo="+$(this).children("#resNo").val(),function(data){						
							page=data.resultPage;
							restaurantValues="";		
							restaurantPaging="<ul class='pagination'>";
							$.each(data.list,function(index,val){
								restaurantValues+="<div class='alert alert-success'><span class=bold>게시글 번호: </span>"+val.articleNo+
								"&nbsp;&nbsp&nbsp;<span class=bold>작성자: </span>"+val.writer+"&nbsp;&nbsp;&nbsp;<span class=bold>제목: </span>"+val.title+"</div>";													
							})
							//	restaurantPaging+="</ul>";
								$("#resultService").html(restaurantValues);
								if(data.list.length>0&&page.pageCount>page.endPage)
									$("#moreRestaurantBoard").show();
						})
					}
				})
				$("#moreRestaurantBoard").click(function(){
					$(".loading").show();
					$("#moreRestaurantBoard").hide();
					setTimeout(function(){
						$(".loading").hide();
						$.getJSON("${initParam.root}restaurantSeeEverything?resNo="+thisResNo+"&currPage="+(page.currentPage+1),function(data){
							page=data.resultPage;
							$.each(data.list,function(index,val){
								restaurantValues+="<div class='alert alert-success'><span class=bold>게시글 번호: </span>"+val.articleNo+
								"&nbsp;&nbsp&nbsp;<span class=bold>작성자: </span>"+val.writer+"&nbsp;&nbsp;&nbsp;<span class=bold>제목: </span>"+val.title+"</div>";													
							})
							restaurantPaging+="</ul>";
							$("#resultService").html(restaurantValues);
							if(data.list.length>0&&page.pageCount>page.endPage)
								$("#moreRestaurantBoard").show();
						})
					}, 1000)
				})
           })
          //]]>
</script>
<div class="col-md-10 col-md-offset-1" id=restaurantContainer>
<div class="btn-group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
    Number to show us <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu">
      <li><a href="${initparam.root }memberAddressNearByRestaurantService?currPage=${page.getCurrentPage()}&pageSize=3">3</a></li>
      <li><a href="${initparam.root }memberAddressNearByRestaurantService?currPage=${page.getCurrentPage()}&pageSize=5">5</a></li>
      <li><a href="${initparam.root }memberAddressNearByRestaurantService?currPage=${page.getCurrentPage()}&pageSize=7">7</a></li>
    </ul>
  </div>
  <br><br>
 <c:forEach items="${restaurantList }" var="list"> 	
 	<div class="alert alert-danger">
 		<div class="resultService">
 			<input type="hidden" value="${list.resNo }" id="resNo">
 			<span class="bold">가게명: </span>${list.resName }&nbsp;&nbsp;
 			<span class="bold">주소: </span>${list.city } ${list.sigungu } ${list.eupmyeondong }&nbsp;&nbsp;
 			<span class="boldlessGood">좋아요 </span><span class='glyphicon glyphicon-thumbs-up'></span> ${list.good } / 
 			<span class="boldlessBad">싫어요 </span><span class='glyphicon glyphicon-thumbs-down'></span> ${list.bad }
 		</div>
 	</div>
 </c:forEach>
	<div style="margin-bottom: 30px" >
		<ul class="pagination">
			<li><a href="${initparam.root }memberAddressNearByRestaurantService?currPage=${page.beginPage-1}&pageSize=${page.getPageSize()}">Prev</a></li>
			<c:forEach begin="${page.beginPage }" end="${page.endPage }" varStatus="pageNo">
				<c:choose>
					<c:when test="${page.getCurrentPage()==pageNo.index }">
						<li class="active"><a href="#">${pageNo.index }</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${initparam.root }memberAddressNearByRestaurantService?currPage=${pageNo.index }&pageSize=${page.getPageSize()}">${pageNo.index }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<li><a href="${initparam.root }memberAddressNearByRestaurantService?currPage=${page.endPage+1}&pageSize=${page.getPageSize()}">Next</a></li>
		</ul>
	</div>
	<div id="resultService">
	</div>
	<button id="moreRestaurantBoard" class="btn btn-default btn-lg btn-block">더 보기</button>
 	<div class="col-md-12 loading" align="center">
		<img height="150px" width="auto" src="${initParam.root}resources/images/common/loding.gif">
	</div>
 </div>
