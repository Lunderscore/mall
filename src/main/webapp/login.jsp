<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="static/header.jsp"%>

<c:if test="${not empty userSession }">
	<c:redirect url="index"></c:redirect>
</c:if>
<title>用户登录</title>
</head>
<body class="jumbotron">
	<%@ include file="static/navigator.jsp"%>

	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<ul class="nav nav-tabs nav-justified">
				<li role="presentation" class="active" id="loginBtn"><a>登录</a></li>
				<li role="presentation" id="registerBtn"><a>注册</a></li>
			</ul>
		</div>
		
		<div class="col-md-8 col-md-offset-4">
			<form class="form-horizontal" id="loginForm" action="login" method="post">
				<div class="form-group"  id="usernameDiv">
					<div class="col-sm-6">
						<input type="text" name="userUsername" class="form-control"	id="username" placeholder="请输入账号">
					</div>
				</div>
				<div class="form-group"  id="password1Div">
					<div class="col-sm-6">
						<input type="password" name="userPassword" class="form-control" id="password1" placeholder="请输入密码">
					</div>
					<div class="col-sm-3">
					</div>
				</div>
				<div id="password2Div" class="form-group"></div>
				<div class="form-group">
					<div class="col-sm-6">
						<button type="button" class="btn btn-danger btn-block" id="submitBtn">确认</button>
					</div>
				</div>
				<span id="flag" falg="0"></span>
			</form>
		</div>
	</div>

	<script src="js/login.js"></script>
</body>
</html>