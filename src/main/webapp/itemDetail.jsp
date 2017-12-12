<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="static/header.jsp"%>
<title>Insert title here</title>

<style>
	.pimg{
		width: 300px;
		height: 300px;
	}
	.carousel-control.left, .carousel-control.right{
		background-image: none;
	}
	.longWOrd{
		word-break:break-all; 
	}
	.comment{
		width: 60%;
	}
	.commentTime{
		width: 30%;
	}
	#prodictInfo{
		border: 2px solid #CDB38B;
	}
</style>

</head>
<body class="jumbotron">
	<%@ include file="static/navigator.jsp"%>
	
	<div class="row col-md-offset-2">
		<div class="col-md-4">
			<%@ include file="include/carousel.jsp"%>
		</div>
	
		<div class="col-md-6">
			<%@include file="include/itemDetailContent.jsp" %>
		</div>
	</div>
	
	<hr>

	<div class="row">
		<div class="col-md-1  col-md-offset-5">
			<button type="button" class="btn btn-primary">商品详情</button>
		</div>
		<div class="col-md-1">
			<button type="button" class="btn btn-default">买家评价</button>
		</div>
	</div>

	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<p class="longWOrd" id="prodictInfo"></p>
		</div>
		
		<div class="col-md-10 col-md-offset-1">
			<table class="table table-hover">
			  	<tr>
					<td class="comment">1123</td>
					<td class="commentTime">123</td>
					<td>123</td>			  	
			  	</tr>
			</table>
		</div>
	</div>

<script>
var query = window.location.search.substring(1);
var vars = query.split("&");
var pid;
for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == "pid"){
        	pid = pair[1];
       	}
}
$(function(){
	$.get("getProductByIDJSON?pid="+pid, function(data){
		console.log(data);
		$("#ProductTitle").html(data.content.product.productTitle);
		$("#price").html(data.content.product.productPrice);
		$("#stock").html(data.content.product.productStock);
		$("#prodictInfo").html(data.content.product.productInfo);
		
		if (data.content.product.productImg != null ){
			$("<li data-target='#carousel-example-generic' data-slide-to='0' class='active'></li>")
				.appendTo("#carouselIndex");
			$("<div class='item active'></div>")
				.append("<img src="+ data.content.product.productImg +" class='img-responsive' />")
				.appendTo("#carouselImg");
		}
		
		if (data.content.secPic != null ){
			$("<li data-target='#carousel-example-generic' data-slide-to='1'></li>")
				.appendTo("#carouselIndex");
			
			$("<div class='item'></div>")
			.append("<img src="+ data.content.secPic +" class='img-responsive' />")
			.appendTo("#carouselImg");
		}
		
		if (data.content.thiPic != null ){
			$("<li data-target='#carousel-example-generic' data-slide-to='2'></li>")
				.appendTo("#carouselIndex");
			
			$("<div class='item'></div>")
			.append("<img src="+ data.content.thiPic +" class='img-responsive' />")
			.appendTo("#carouselImg");
		}
	});
})
	
	
	$("#addToCar").on("click", function(){
		var num = $("#number").val();
		$.post("order", {pid:pid, num:num}, function(){
			location.href = "shoppingCar.jsp";
		});
	});
	
		
</script>
</body>
</html>