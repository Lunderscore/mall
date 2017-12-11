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
			<p class="longWOrd">aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</p>
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
	var url = location.href;
	var num = url.indexOf("=");
	var pid = url.substr(num+1); 
	alert(pid);
	
	$.get("getProductByIDJSON?pid="+pid, function(data){
		console.log(data);
	});
</script>
</body>
</html>