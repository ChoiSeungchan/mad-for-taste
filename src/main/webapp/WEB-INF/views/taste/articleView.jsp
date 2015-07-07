<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=true"></script>
<!-- GoogoleMap Asynchronously Loading the API ********************************************* -->
<script type="text/javascript">
    function initialize() {
     
        var mapOptions = {
                            zoom: 17, // 지도를 띄웠을 때의 줌 크기
                            mapTypeId: google.maps.MapTypeId.ROADMAP
                        };
         
         
        var map = new google.maps.Map(document.getElementById("map-canvas"), // div의 id과 값이 같아야 함. "map-canvas"
                                    mapOptions);
       
        // Geocoding *****************************************************
        var address = '${article.restaurant.city} ${article.restaurant.sigungu} ${article.restaurant.eupmyeondong} ${article.restaurant.resName}'; // DB에서 주소 가져와서 검색하거나 왼쪽과 같이 주소를 바로 코딩.
        var marker = null;
        var geocoder = new google.maps.Geocoder();
        geocoder.geocode( { 'address': address}, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                map.setCenter(results[0].geometry.location);
                marker = new google.maps.Marker({
                                map: map,
                                title: '${article.restaurant.city} ${article.restaurant.sigungu} ${article.restaurant.eupmyeondong} ${article.restaurant.resName}', // 마커에 마우스 포인트를 갖다댔을 때 뜨는 타이틀
                                position: results[0].geometry.location
                            });
 
                var content = "${article.restaurant.city} ${article.restaurant.sigungu} ${article.restaurant.eupmyeondong} ${article.restaurant.resName}"; // 말풍선 안에 들어갈 내용
             
                // 마커를 클릭했을 때의 이벤트. 말풍선 뿅~
                var infowindow = new google.maps.InfoWindow({ content: content});
                infowindow.open(map,marker);
                //google.maps.event.addListener(marker, "click", function() {infowindow.open(map,marker);});
            } else {
                alert("Geocode was not successful for the following reason: " + status);
            }
        });
        // Geocoding // *****************************************************
         
    }
    google.maps.event.addDomListener(window, 'load', initialize);
</script>

<script type="text/javascript">
$(function(){
		var rating=0;
		if(${article.restaurant.good!=0})
			rating=${article.restaurant.good/(article.restaurant.good+article.restaurant.bad)}*100; 
		//jstl로 분기처리를 하지않고 자바단에서 변수를 분기처리해서 적용(조금더 간결한 로직)
		if(rating==0){
			if(${article.restaurant.bad>0}){
				$("#grade1").css("width","100%");
				$("#grade1").html("최악의 가게 입니다 (좋아요  <span class='glyphicon glyphicon-thumbs-up'></span>&nbsp;&nbsp;"+${article.restaurant.good}+"  /  싫어요 <span class='glyphicon glyphicon-thumbs-down'></span>&nbsp;&nbsp;"+${article.restaurant.bad}+")");
			}
			if(${article.restaurant.bad==0})
				$('[data-toggle="tooltip"]').hide();
		}
		else if(rating==100){
			$("#grade3").css("width","100%");
			$("#grade3").html("이 가게는 최고의 맛집이네요! (좋아요  <span class='glyphicon glyphicon-thumbs-up'></span>&nbsp;&nbsp;"+${article.restaurant.good}+"  /  싫어요 <span class='glyphicon glyphicon-thumbs-down'></span>&nbsp;&nbsp;"+${article.restaurant.bad}+")");
		}
		else{
			if(rating<40){
				alert(rating);
				$("#grade2").css("width",(100-rating)+"%");
				$("#grade2").html("가게 평이 매우 안좋네요 (싫어요 <span class='glyphicon glyphicon-thumbs-down'></span>&nbsp;&nbsp;"+${article.restaurant.bad}+")");
				$("#grade3").css("width",rating+"%");
				if(rating>=15)
					$("#grade3").html("좋아요  <span class='glyphicon glyphicon-thumbs-up'></span>&nbsp;&nbsp;"+${article.restaurant.good});
			}
			if(rating>60){
				$("#grade2").css("width",(100-rating)+"%");
				if(rating<85)
					$("#grade2").html("싫어요 <span class='glyphicon glyphicon-thumbs-down'></span>&nbsp;&nbsp;"+${article.restaurant.bad});
				$("#grade3").css("width",rating+"%");
				$("#grade3").html(" 가게 평이 매우 좋네요 (좋아요  <span class='glyphicon glyphicon-thumbs-up'></span>&nbsp;&nbsp;"+${article.restaurant.good}+")");
			}
			if(rating>=40&&rating<=60){
				$("#grade2").css("width",(100-rating)+"%");
				$("#grade2").html("싫어요 <span class='glyphicon glyphicon-thumbs-down'></span>&nbsp;&nbsp;"+${article.restaurant.bad});
				$("#grade3").css("width",rating+"%");
				$("#grade3").html("좋아요  <span class='glyphicon glyphicon-thumbs-up'></span>&nbsp;&nbsp;"+${article.restaurant.good});
			}
		}
	    
		$('[data-toggle="tooltip"]').tooltip();
		
	    function reLogin() {
			$.ajax({
				type:"post",
				url:"${initParam.root}maintainAuthSession",
				dataType:"json",
				success:function(data){		
					alert(data);
				}
			});
		}
		reLogin();
		
		$("#good").click(function(){
			$.getJSON("${initParam.root}article/upGood?id=${sessionScope.member.id}&articleNo=${article.articleNo}&resNo=${article.restaurant.resNo}",function(data){
				if (data=="fail") { 
					alert('이미 투표 하셨습니다!');
				} else if (data=="notLogon") {
					alert('로그인 후에 투표 가능합니다!');
				} else {
					alert('좋아요/싫어요 투표 결과 : 경험치를 ' + data[1] + ' 획득하였습니다.');
					reLogin();
					location.href = location.href;
				}
			})
		})
		
		$("#bad").click(function(){
			$.getJSON("${initParam.root}article/upBad?id=${sessionScope.member.id}&articleNo=${article.articleNo}&resNo=${article.restaurant.resNo}",function(data){
				if (data=="fail") { 
					alert('이미 투표 하셨습니다!');
				} else if (data=="notLogon") {
					alert('로그인 후에 투표 가능합니다!');
				} else {
					alert('좋아요/싫어요 투표 결과 : 경험치를 ' + data[1] + ' 획득하였습니다.');
					reLogin();
					location.href = location.href;
				}
			})
		})
		
		
		$('img').attr('class','img-responsive');	
		
		$('#updateArticleFormBtn').click(function(){
			location.href='${initParam.root}updateArticleForm/'+${article.articleNo};
		})
		
		$('#deleteArticleFormBtn').click(function(){
			var flag = confirm('정말 삭제하시겠습니까?');
			if(flag) location.href='${initParam.root}deleteArticle/'+${article.articleNo};
		})
	
		$('#replyForm').submit(function(){
			if($(':input[name=contents]').val()=='') {
				alert('댓글을 입력하세요!');
				return false;
			}
		})
		
		$('#listBtn').click(function(){
			location.href=${initParam.root};
		})
		
		$('#deleteTasteBoardReplyForm').submit(function(){
			return confirm('정말 삭제하시겠습니까?');
		})
	})
	
</script>
<style type="text/css">
#replyList {
	margin-top:20px;
	margin-bottom:80px;
	background-color: #F2F0F0;
	border: 1px solid #DFD9DA;
}

#viewWraper {
	margin: 0 0 7px 0;
 	padding: 25px 12px 22px;
}

#viewWraper .header{
	font-size: 14px;
	font-weight: bold;
	color: #4c4b4b;
	margin: 0 0 15px 0;
}

#viewWraper .header small{
  font-size: 11px;
  font-weight: normal;
  color: #928383;
  padding: 0 0 0 10px;
}

#viewWraper .contents{
  line-height: 18px;
  color: #847473;
  word-break: break-all;
  word-wrap: break-word;
}

pre{
	background-color: #F2F0F0;
	border: 0px;
}

#map-canvas {
	width: 100%; 
	height: 300px;
	margin-top: 30px;
}
</style>
</head>
<body>
	<div class="col-md-10 col-md-offset-1">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>
						#${article.articleNo}. ${article.title} </small>
					</h1>
				</div>
			</div>
		</div>
		<table width="100%">
			<tr>
				<td width="50px">
					<img style="width: 40px; height: 40px" src="${initParam.root}resources/images/user/member/${article.member.profileImg}">
				</td>
				<td width="30px">
					<img  src="${initParam.root}resources/images/user/member/level/${article.member.levelInfo.level}.gif">
				</td>
				<td>
					<b>${article.member.name} (${article.member.id})</b> 님이 ${article.calDate}에 작성한 글입니다.
				</td>
				<td>
				<c:if test="${article.member.id==sessionScope.member.id}">
					<button id="updateArticleFormBtn" class="btn btn-success btn-sm">글 수정하기</button>&nbsp&nbsp
					<button id="deleteArticleFormBtn" class="btn btn-danger btn-sm">글 삭제하기</button>
				</c:if>
				</td>
				<td align="right">
					<span class="glyphicon glyphicon glyphicon-comment" style="color:#045FB4"></span> ${article.reply} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-eye-open"></span> ${article.hits} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-thumbs-up" style="color:#045FB4"></span> ${article.good} &nbsp&nbsp&nbsp&nbsp
					<span class="glyphicon glyphicon-thumbs-down" style="color:#D9230F"></span> ${article.bad} &nbsp&nbsp&nbsp&nbsp
				</td>
			</tr>
		</table>
		<hr>
		<div class="row">
			<div class="col-md-12">
				<p>
					${article.contents}
				</p>
				<div id="map-canvas"></div>
				<c:if test="${article.restaurant.good==0&&article.restaurant.bad==0 }">
				<div align="center" style="margin: 20px; font-size: 16px; font-weight: bold;">
					${article.restaurant.resName }에 대한 평가가 아직 없습니다. 좋아요/싫어요 투표해주세요!
				</div>
				</c:if>
				<div class="progress" data-toggle="tooltip" title="현재 맛집에 대한 평가 (평가는 좋아요-싫어요 로 평가됩니다)">
				  <div class="progress-bar progress-bar-warring" role="progressbar" style=width:0%  id="grade1">
				  </div>
				  <div class="progress-bar progress-bar-info" role="progressbar" style="width:0%" id="grade3">
				  </div>
				  <div class="progress-bar progress-bar-danger" role="progressbar" style="width:0%" id="grade2">
				  </div>
				</div>
			</div>
		</div>
		<div class="col-md-12" align="center">
			<table>
				<tr>
					<td>
						<button id="good" class="btn btn-lg btn-info ">
							${article.good}
							<span class="glyphicon glyphicon-thumbs-up"></span> 좋아요!
						</button>&nbsp&nbsp
					</td>
					<td>
						<button id="bad" class="btn btn-lg btn-primary">
							${article.bad}
							<span class="glyphicon glyphicon-thumbs-down"></span> 싫어요!
						</button>
					</td>
				</tr>
			</table>
		</div>
		<div class="col-md-12" align="right">
			<button id="listBtn" class="btn btn-default">목록 보기</button>
		</div>
		<!-- 댓글 기능 -->
		<div id="replyList" class="col-md-12">
			<div id="viewWraper">
				<c:choose>
					<c:when test="${member!=null}">
						<form id="replyForm" action="${initParam.root}registerTasteBoardReply" method="post" >
							<input type="hidden" name="articleNo" value="${article.articleNo}">
							<input type="hidden" name="writer" value="${sessionScope.member.id}">
							<textarea name="contents" class="form-control" rows="3"></textarea>
						<br>
						<div style="padding-left: 35%; padding-right: 35%" align="center">
							<button type="submit" class="btn btn-default btn-block">댓글 달기</button>
						</div>
						</form>
					</c:when>
					<c:otherwise>
						<table align="center">
							<tr>
								<td>
									<b>로그인 후에 댓글을 달아보세요!</b>
								</td>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
				<c:forEach var="reply" items="${replies}">
				<hr>
				<dl>
					<dd class="header">
						<table>
							<tr>
								<td>
									<img style="height: 30px;width: 30px; float: left;" src="${initParam.root}resources/images/user/member/${reply.member.profileImg}">
								</td>
								<td style="padding-left: 10px">
									<img style="float: left;" src="${initParam.root}resources/images/user/member/level/${reply.member.levelInfo.level}.gif">
								</td>
								<td style="padding-left: 5px">
									${reply.member.name} (${reply.member.id})<small>${reply.calDate}</small>
								</td>
								<c:if test="${reply.member.id==sessionScope.member.id}">
								<td style="padding-left: 10px">
									<button type="button"  class="btn btn-xs" class="updateReplyBtn" data-toggle="modal" data-target="#myModal">수정</button>
								</td>
								<td style="padding-left: 5px">
									<form id="deleteTasteBoardReplyForm" action="${initParam.root}deleteTasteBoardReply" method="post">
										<input type="hidden" name="replyNo" value="${reply.replyNo}">
										<input type="hidden" name="articleNo" value="${reply.articleNo}">
										<button type="submit" class="btn btn-xs">삭제</button>
									</form>
								</td>
								<!-- Modal -->
								<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								  <div class="modal-dialog">
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								        <h4 class="modal-title" id="myModalLabel">댓글 수정하기</h4>
								      </div>
								      <div class="modal-body">
									    <form id="updateTasteBoardReplyForm" action="${initParam.root}updateTasteBoardReply" method="post" >
											<input type="hidden" name="replyNo" value="${reply.replyNo}">
											<input type="hidden" name="articleNo" value="${reply.articleNo}">
											<input type="hidden" name="writer" value="${reply.member.id}">
											<textarea name="contents" class="form-control" rows="10">${reply.contents}</textarea>
											<br>
											<div align="right">
												<button type="submit" class="btn btn-success">댓글 수정</button>
												<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
											</div>
										</form>
								      </div>
								    </div>
								  </div>
								</div>
								</c:if>
							</tr>
						</table>
					</dd>
					<dd class="contents">
						<pre>${reply.contents}</pre>
					</dd>
				</dl>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
