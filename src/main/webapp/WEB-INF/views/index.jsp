<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <jsp:include page="/component/header"/>
    <title>主界面</title>
</head>
<body>
<div class="jumbotron">
    <jsp:include page="/component/navigator"/>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="input-group input-group-lg">
                <input type="text" id="searchInput" class="form-control" placeholder="输入商品名"
                       aria-describedby="sizing-addon1">
                <span class="input-group-btn">
		        <button class="btn btn-default" id="searchBtn">Go!</button>
		      </span>
            </div>
        </div>
    </div>
    <c:if test="${not empty pageInfo }">
    <c:forEach items="${pageInfo.list }" var="product" varStatus="i">
        <c:if test="${i.index%5 == 0 }">
            <div class="row col-md-offset-1">
        </c:if>
        <div class="col-md-2">
            <a href="productDetail?pid=${product.id }">
                <div class="thumbnail item">
                        <%--TODO--%>
                        <%--<img src="${product.productImg1 }">--%>
                    <div class="caption">
                        <h5>${product.title }</h5>
                        <h4>价格：${product.price }</h4>
                    </div>
                </div>
            </a>
        </div>
        <c:if test="${i.index%5 == 4 }">
            </div>
        </c:if>
    </c:forEach>
</c:if>
<jsp:include page="/component/pagination"/>
<script src="../../static/js/index.js"></script>
</div>
</body>
</html>