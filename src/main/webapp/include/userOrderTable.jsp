<!-- shoppingCar.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
		
	<div class="btn-toolbar" role="toolbar" aria-label="...">
		<div class="col-md-2">
			<button type="button" class="btn btn-primary btn-block">所有订单</button>
		</div>
		<div class="col-md-2">
			<button type="button" class="btn btn-block">待付款</button>
		</div>
		<div class="col-md-2">
			<button type="button" class="btn btn-block">待发货</button>
		</div>
		<div class="col-md-2">
			<button type="button" class="btn btn-block">待收货</button>
		</div>
		<div class="col-md-2">
			<button type="button" class="btn btn-block">待评价</button>
		</div>
	</div>
</div>

<hr>

<div class="row" id="productHead">
	<div class="col-md-12">
		<div class="col-md-6 center-block">商品</div>
		<div class="col-md-1 center-block">单价</div>
		<div class="col-md-1 center-block">数量</div>
		<div class="col-md-2 center-block">实付款</div>
		<div class="col-md-2 center-block">操作</div>
	</div>
</div>



<c:if test="${not empty userOrder }">
<c:forEach items="${userOrder }" var="item">
	<div class="row productInfo">
		<div class="col-md-12 productInfoHead">
			<div class="col-md-6">
				<div class="col-md-7">
					<b>${item.orderDateTime }</b>
				</div>
				<div class="col-md-5">
					<span>订单号: ${item.orderId } </span>
				</div>
			</div>
			<div class="col-md-1 center-block"></div>
			<div class="col-md-1 center-block"></div>
			<div class="col-md-2 center-block"></div>
			<div class="col-md-2 center-block">
			</div>
		</div>
		<div class="col-md-12">
			<div class="col-md-6">
				<div class="col-md-4">
					<img src="${item.product.productImg }"
						class="pimg" />
				</div>
				<div class="col-md-8">${item.product.productTitle }</div>
			</div>
			<div class="col-md-1 center-block">${item.product.productPrice }</div>
			<div class="col-md-1 center-block">${item.orderNumber }</div>
			<div class="col-md-2 center-block">${item.product.productPrice * item.orderNumber }</div>
			<div class="col-md-2 center-block">
				<button type="button" class="btn btn-danger btn-xs">
					<span class="orderListItemDelete glyphicon glyphicon-trash"></span>
						删除订单
				</button>
			</div>
		</div>
	</div>
	<br>
</c:forEach>
</c:if>