<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../../static/header.jsp"%>

<title>Insert title here</title>

<style>
	.center-block{
		text-align:center;
	}

</style>

</head>
<body class="jumbotron">
	<%@ include file="../../static/navigator.jsp"%>
	
<div class="row">
	<div class="col-md-4 center-block">
	</div>
	<div class="col-md-4 center-block">
		<span class="text-danger">您可以用本账户的虚拟货币支付或者前往支付宝界面支付0.01元。</span>
		<br ><br >
		<span mid="${totalMoney }" id="mid">${totalMoney }元</span>
		<br ><br ><br><br><br><br><br><br>
		<a href="pay.jsp?uoid=${uoid}&price=0.01&type=1&pay_id=${userSession.userUsername }"><button type="button" class="btn btn-success">前往支付宝支付</button></a>
			<br >
		<span>使用支付宝支付0.01元 </span>
		<br><br><br><br><br><br><br><br><br><br>
		<button type="button" class="btn btn-info" id="paymentBtn">付款</button>
		<span id="helpBlock" class="help-block">剩余余额：(<span id="restMoney">${userSession.userMoney }</span><span class="glyphicon glyphicon-usd"></span>)</span>
	</div>
</div>

<script>
	$("#paymentBtn").on("click", function(){
		var mid = $("#mid").attr("mid");
		var restMoney = $("#restMoney").html().trim();
		if (Number(restMoney) < Number(mid)){
			alert("没有足够的钱支付,请先充值");
			location.href = "home";
			return;
		}
		if (!confirm("是否确认付款")){
			return;
		}
		$.post("money", {mid:mid, type:"1" }, function(){
			$.post("updateOrder", {uoid:"${uoid}", type:"2" }, function(){
				location.href = "userOrder";
			});
		});
	});
</script>
</body>
</html>