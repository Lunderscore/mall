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
			<button type="button" class="btn btn-primary" onclick="location.reload()">商品详情</button>
		</div>
		<div class="col-md-1">
			<button type="button" class="btn btn-default" id="getComments">买家评价</button>
		</div>
	</div>

	<div class="row" id="productComments">
		<div class="col-md-10 col-md-offset-1">
			<p class="longWOrd" id="prodictInfo"></p>
		</div>
	</div>

<script src="js/itemDetail.js">
</script>
</body>
</html>