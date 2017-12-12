<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="static/header.jsp"%>
<title>Insert title here</title>

<style>
	.center-block{
		text-align:center;
	}

</style>

</head>
<body class="jumbotron">
	<%@ include file="static/navigator.jsp"%>
	
<div class="row">
	<div class="col-md-4 center-block">
		微信支付个人不能获得接口，需要公司申请。<a href="https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=3_1" target="_blank">详细信息请点击</a>
	</div>
	<div class="col-md-4 center-block">
		<span class="text-danger">此二维码只是一个普通二维码，占位用。</span>
		<br ><br >
		<img src="static/img/HelloWorld.png" />
		<br><br>
		<button type="button" class="btn btn-info" id="paymentBtn">付款</button>
		<span id="helpBlock" class="help-block">剩余余额：(100.00<span class="glyphicon glyphicon-usd"></span>)</span>
	</div>
	<div class="col-md-4 center-block">
		同理支付宝支付个人不能获得接口。<a href="https://docs.open.alipay.com/270#s3" target="_blank">详细信息请点击</a>
	</div>
</div>

<script>
	$("#paymentBtn").on("click", function(){
		location.href = "userOrder.jsp";
	});
</script>
</body>
</html>