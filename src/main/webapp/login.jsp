<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="/component/header"/>
    <c:if test="${not empty user }">
        <c:redirect url="index"/>
    </c:if>
    <title>用户登录</title>
</head>
<body>
<div class="jumbotron">
    <jsp:include page="/component/navigator"/>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <ul class="nav nav-tabs nav-justified">
                <li class="active"><a>登录</a></li>
                <li><a href="register.jsp">注册</a></li>
            </ul>
        </div>
        <div class="col-md-8 col-md-offset-4">
            <form class="form-horizontal" method="post" onsubmit="formSubmit(); return false;">
                <div class="form-group">
                    <div class="col-sm-6">
                        <input type="text" required pattern="^[a-zA-Z][a-zA-Z0-9_]{4,15}$"
                               oninvalid="setCustomValidity('账号格式：字母开头，允许5-16字节，允许字母数字下划线')"
                               oninput="setCustomValidity('')"
                               id="username" class="form-control" placeholder="请输入账号">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <input type="password"  required pattern="^[a-zA-Z][a-zA-Z0-9_]{4,15}$"
                               oninvalid="setCustomValidity('密码格式：字母开头，长度在6~18之间，只能包含字母、数字和下划线')"
                               oninput="setCustomValidity('')"
                               id="password" class="form-control" placeholder="请输入密码">
                    </div>
                    <div class="col-sm-3">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-danger btn-block" id="submitBtn">确认</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script>
        function formSubmit() {
            var username = $("#username").val();
            var password = $("#password").val();

            $.post("login", {username: username, password: password}, function (data) {
                // 登录失败提示信息
                if (1 === data.code) {
                    //TODO 使用layui提示
                    alert(data.message);
                    return;
                }
                // 登录成功跳转页面
                location.href = "/";
            });
        }
    </script>
</div>
</body>
</html>