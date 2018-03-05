<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="/component/header"/>
    <%--<c:if test="${empty adminSession}">--%>
    <%--<c:redirect url="../adminLogin.jsp"></c:redirect>--%>
    <%--</c:if>--%>
    <style>
        .pimg {
            width: 100px;
            height: 100px;
        }
        .center-block {
            text-align: center;
        }
        #productHead {
            background-color: #F0FFF0;
        }

        .productInfo {
            border: 1px solid red;
        }

        .productInfoHead {
            background-color: #EEE8AA;
        }

        .productItem {
            border: 1px
        }
    </style>
    <title>管理员后台</title>
</head>
<body>
<div class="jumbotron">
<div class="row">
    <h3 class="center-block">当前登入管理员：${adminSession.userUsername }&nbsp;&nbsp;&nbsp;<a href="adminLogOut">
        <button type="button" class="btn btn-warning">注销</button>
    </a></h3>
</div>
<div class="row">
    <h2 class="center-block">后台页面-商品管理</h2>
</div>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <div class="input-group input-group-lg">
            <input type="text" id="searchInput" class="form-control" placeholder="输入商品名"
                   aria-describedby="sizing-addon1">
            <span class="input-group-btn">
		        <button class="btn btn-default" id="searchBtn">查询</button>
		      </span>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-10 col-md-offset-1">
        <%@include file="include/table.jsp" %>
    </div>
</div>
<%@include file="include/modal.jsp" %>
<jsp:include page="/component/pagination"/>
<script type="text/javascript" src="../js/admin.js"></script>
<script type="text/javascript">
    $(".productItem").on("mouseover", function () {
        $(this).css("background-color", "#fcc5fb");
    });
    $(".row.productItem").on("mouseout", function () {
        $(this).css("background-color", "");
    });
</script>
</div>
</body>
</html>