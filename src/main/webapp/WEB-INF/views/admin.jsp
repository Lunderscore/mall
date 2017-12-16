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
<!-- navigator ========================-->
<div class="row">
	<div class="col-md-12">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="../index"> <img alt="Brand"
						src="https://static.hdslb.com/images/favicon.ico">
					</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="../index">首页</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="../login.jsp">登录</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</div>
<!-- navigator ========================-->
	
	<div class="row">
		<h2 class="center-block">后台页面-商品管理</h2>
	</div>
	
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="input-group input-group-lg">
			  <input type="text" id="searchInput" class="form-control" placeholder="输入商品名" aria-describedby="sizing-addon1">
			  <span class="input-group-btn">
		        <button class="btn btn-default" id="searchBtn">查询</button>
		      </span>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<%@include file="../../include/adminTable.jsp"%>
		</div>
	</div>
	
	<%@include file="../../include/adminModal.jsp"%>
	
	<div class="row">
		<div class="col-md-6 col-md-offset-8">
			<%@ include file="../../static/pagination.jsp"%>
		</div>
	</div>
	
	<script type="text/javascript" src="../js/admin.js"></script>
</body>
</html>