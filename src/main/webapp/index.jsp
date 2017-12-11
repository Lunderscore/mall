<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	
<c:if test="${not empty products }">
	<c:forEach items="${products }" var="product" varStatus="i">
		<c:if test="${i.index%5 == 0 }">
			<div class="row col-md-offset-1">
		</c:if>
		<div class="col-md-2">
			<a href="itemDetail.jsp?pid=${product.productId }">
				<div class="thumbnail item">
					<img src="${product.productImg }">
					<div class="caption">
						<p>${product.productTitle }</p>
						<h3>${product.productPrice }+${i.index }</h3>
					</div>
				</div>
			</a>
		</div>
		<c:if test="${i.index%5 == 4 }">
			</div>
		</c:if>
	</c:forEach>
	</div>
</c:if>
	
	<div class="row">
		<div class="col-md-3 col-md-offset-9">
			<%@ include file="static/pagination.jsp"%>
		</div>
	</div>
	<script src="js/index.js"></script>
</body>
</html>