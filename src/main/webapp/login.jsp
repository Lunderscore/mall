<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="static/header.jsp"%>

<script>
<%
	if (session.getAttribute("user") != null){
%>
		location.href = "index.jsp";
<%
	}
%>
</script>

<title>Insert title here</title>
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
			<form class="form-horizontal">
				<div class="form-group has-error"  id="usernameDiv">
					<div class="col-sm-6">
						<input type="text" class="form-control"	id="username" placeholder="请输入账号">
					</div>
					<div class="col-sm-3">
						<span class="text-danger" id="usernameSpan">123</span>
					</div>
				</div>
				<div class="form-group"  id="password1Div">
					<div class="col-sm-6">
						<input type="password" class="form-control" id="password1" placeholder="请输入密码">
					</div>
					<div class="col-sm-3">
						<span class="id="password1Span" id="password1Span">123</span>
					</div>
				</div>
				<div id="password2Div" class="form-group"></div>
				<div class="form-group">
					<div class="col-sm-6">
						<button type="button" class="btn btn-danger btn-block" id="submitBtn">登录</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<script src="js/login.js"></script>
</body>
</html>