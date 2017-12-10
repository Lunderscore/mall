<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="static/header.jsp"%>
<style>
	a:hover{
		text-decoration: none;
	}
</style>
<title>Insert title here</title>
</head>
<body class="jumbotron">
	<%@ include file="static/navigator.jsp"%>
	
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="input-group input-group-lg">
			  <input type="text" class="form-control" placeholder="输入商品名" aria-describedby="sizing-addon1">
			  <span class="input-group-btn">
		        <button class="btn btn-default" type="button">Go!</button>
		      </span>
			</div>
		</div>
	</div>
	
	
	<div class="row col-md-offset-1">
	
		<div class="col-md-2">
			<a href="itemDetail.jsp">
				<div class="thumbnail item">
					<img src="http://tmall.how2j.cn/productSingle_middle/676.jpg">
					<div class="caption">
						<p>商品介绍</p>
						<h3>9.9包邮</h3>
					</div>
				</div>
			</a>
		</div>
		
	</div>

	<div class="row">
		<div class="col-md-3 col-md-offset-9">
			<%@ include file="static/pagination.jsp"%>
		</div>
	</div>
	<script src="js/index.js"></script>
</body>
</html>