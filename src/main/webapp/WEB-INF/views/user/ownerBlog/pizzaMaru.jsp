<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<script>
			//<![CDATA[	
			var str="[참여수:"+${map.TOTALCNT}+"명]   [평점:"+${map.TOTALMARK/map.TOTALCNT}+"점]";
			var i2=0;var i3=0;var i4=0;
			i2=${map.two};i3=${map.three};i4=${map.four};
			var two=i2/3*100;
			var three=i3/3*100;
			var four=i4/3*100;
			$(function(){	   			
			    $('#container').highcharts({
			        chart: {
			            plotBackgroundColor: null,
			            plotBorderWidth: 0,
			            plotShadow: false
			        },
			        title: {
			            text: str,
			            align: 'center',
			            verticalAlign: 'middle',
			            y: 50
			        },
			        tooltip: {
			            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
			        },
			        plotOptions: {
			            pie: {
			                dataLabels: {
			                    enabled: true,
			                    distance: -50,
			                    style: {
			                        fontWeight: 'bold',
			                        color: 'white',
			                        textShadow: '0px 1px 2px black'
			                    }
			                },
			                startAngle: -90,
			                endAngle: 90,
			                center: ['50%', '75%']
			            }
			        },
			        series: [{
			            type: 'pie',
			            name: 'Browser share',
			            innerSize: '50%',
			            data: [
			                ['20대',   two],
			                ['30대',   three],
			                ['40대',   four],
			                {
			                    name: 'Others',
			                    y: 0.0,
			                    dataLabels: {
			                        enabled: false
			                    }
			                }
			            ]
			        }]
			    });//this
				$("#view").html("<img src='${initParam.root }resources/images/user/owner/tasty/mark3.jpg' width='150px'>");
				$("#one").click(function(){
					$("#view").html("<img src='${initParam.root }resources/images/user/owner/tasty/mark.jpg' width='150px'>");
				});
				$("#two").click(function(){
					$("#view").html("<img src='${initParam.root }resources/images/user/owner/tasty/mark2.jpg' width='150px'>");
				});
				$("#three").click(function(){
					$("#view").html("<img src='${initParam.root }resources/images/user/owner/tasty/mark3.jpg' width='150px'>");
				});
				$("#four").click(function(){
					$("#view").html("<img src='${initParam.root }resources/images/user/owner/tasty/mark4.jpg' width='150px'>");
				});
				$("#five").click(function(){
					$("#view").html("<img src='${initParam.root }resources/images/user/owner/tasty/mark5.jpg' width='150px'>");
				});
				var member="${member}";
				$("#markBtn").click(function(){
					if($("input[name=mark]:checked").val()==null){
						alert("평점 선택을 해주세요!");
						return;
					}
					if(member==""){
						alert("일반 사용자로 로그인 하셔야 가능합니다");
						return;
					}
					$.ajax({
						type:"post",
						url:"markAjax?mark="+$("input[name=mark]:checked").val()+"&id=${member.id}&brNo="+$("#hideBrNo").val(),
						dateType:"json",
						success:function(data){
							if(data.fail!=null)
								alert(data.fail);
							else
								alert(data.success);
						}
					}); 
				});
			});
  			 //]]>
			
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
</script>
<div class="alert alert-danger">
	<c:forEach items="${list }" var="list">
	<c:if test="${list.contractFlag=='Y'}">
	<input type="hidden" id="hideBrNo" value="${list.brNo }">
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
<div id="container" style="min-width: 310px; height: 400px; max-width: 900px; margin: 0 auto"></div>
<div id="view"></div>
&nbsp;&nbsp;&nbsp;<input type="radio" name=mark value="1" id="one"> &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name=mark value="2" id="two"> &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name=mark value="3" id="three" checked="checked"> &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name=mark value="4" id="four"> &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name=mark value="5" id="five"><br>
<button type="button" class="btn btn-info btn-xs" id="markBtn">평점등록하기</button>