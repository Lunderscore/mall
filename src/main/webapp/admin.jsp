<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="static/js/jquery-3.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<c:if test="${not empty adminSession}" >
	<c:redirect url="admin/products" />
</c:if>
<meta name="viewporrt" content="width=device-width, inital-scale=1">
<title>管理员登录</title>
</head>
<body>
<div class="container">
	<form id="loginForm" class="form-horizontal">
		<fieldset>
			<legend><label><span class="glyphocon glyphocpm-user"></span>管理员后台用户登录</label></legend>
			<div class="form-group" id="midDiv">
				<label class="col-md-3 contro-label" for="mid">管理员用户名：admin</label> 
				<div class="col-md-5">
					<input type="text" class="form-control" id="mid" placeholder="输入登录名">
				</div>
				<div class="col-md-4" id="midSpan"></div>
			</div>
			<div class="form-group" id="passwordDiv">
				<label class="col-md-3 contro-label" for="password">管理员密码：admin</label>
				<div class="col-md-5">
					<input type="password" class="form-control" id="password"  placeholder="输入密码">
				</div>
				<div class="col-md-4" id="passwordSpan"></div>
			</div>

		</fieldset>
	</form>
	<div class="form-group" id="butDiv">
		<div class="con-md-5 col-md-offset-4">
			<button type="submit" id="subBut" class="btn btn-xs btn-primary" >登录</button>
			<button type="reset" id="resBut" class="btn btn-xs btn-warning">重置</button>
		</div>
	</div>
	<br />
	<p class="alert alert-danger" id="tip">账号或密码错误</p>
	<script>
		$("#tip").hide();
	</script>
</div>
 <script src="js/adminLogin.js"></script>
</body>
</html>