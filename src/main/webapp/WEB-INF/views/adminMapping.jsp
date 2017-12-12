<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../../static/header.jsp"%>

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

	.productItem{
		border: 1px 
	}
</style>

<title>Insert title here</title>
</head>
<body class="jumbotron">
	<%@ include file="../../static/navigator.jsp"%>
	
	<div class="row">
		<h2 class="center-block">后台页面-商品管理</h2>
	</div>
	
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<%@include file="../../include/adminTable.jsp"%>
		</div>
	</div>
	
	<%@include file="../../include/adminModal.jsp"%>
	
	<div class="row">
		<div class="col-md-3 col-md-offset-9">
			<%@ include file="../../static/pagination.jsp"%>
		</div>
	</div>
	
	<script type="text/javascript" src="js/admin.js"></script>
</body>
</html>