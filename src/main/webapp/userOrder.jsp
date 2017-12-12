<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="static/header.jsp"%>

<%@ include file="static/checkLogin.jsp"%>

<title>Insert title here</title>
<style>
	.pimg{
		width: 100px;
		height: 100px;
	}
	.center-block {
	  text-align:center;
	}
	
	#productHead{
		background-color: #F0FFF0;
	}
	.productInfo{
		border: 1px solid red;
	}
	.productInfoHead{
		background-color: #EEE8AA;
	}
</style>
</head>
<body class="jumbotron">
	<%@ include file="static/navigator.jsp"%>

	<div class="col-md-10 col-md-offset-1">
		<%@include file="include/userOrderTable.jsp"%>
	</div>

	<script src="js/login.js"></script>
</body>
</html>