<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
	<div class="btn-toolbar" role="toolbar" aria-label="...">
		<div class="col-md-2">
			<a href="?type=0"><button type="button" class="btn btn-block">所有订单</button></a>
		</div>
		<div class="col-md-2">
			<a href="?type=1"><button type="button" class="btn btn-block">待付款</button></a>
		</div>
		<div class="col-md-2">
			<a href="?type=2"><button type="button" class="btn btn-block">待发货</button></a>
		</div>
		<div class="col-md-2">
			<a href="?type=3"><button type="button" class="btn btn-block">待收货</button></a>
		</div>
		<div class="col-md-2">
			<a href="?type=4"><button type="button" class="btn btn-block">待评价</button></a>
		</div>
	</div>
</div>
<br>
<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="input-group input-group-lg">
		  <input type="text" id="searchInput" class="form-control" placeholder="输入商品名" aria-describedby="sizing-addon1">
		  <span class="input-group-btn">
	        <button class="btn btn-default" id="searchBtn">Go!</button>
	      </span>
		</div>
	</div>
</div>
<br>	
<div class="row" id="productHead">
	<div class="col-md-12">
		<div class="col-md-6 center-block">商品</div>
		<div class="col-md-1 center-block">单价</div>
		<div class="col-md-1 center-block">数量</div>
		<div class="col-md-2 center-block">实付款</div>
		<div class="col-md-2 center-block">操作</div>
	</div>
</div>

<c:if test="${not empty pages }">
<c:forEach items="${pages.list }" var="item">
	<div class="row productInfo">
		<div class="col-md-12 productInfoHead">
			<div class="col-md-6">
				<div class="col-md-5">
					<b><fmt:formatDate type="both" value="${item.orderDateTime }" /></b>
				</div>
				<div class="col-md-4">
					<span>订单号: ${item.orderId } </span>
				</div>
				<div class="col-md-3">
					<span>&nbsp;&nbsp;&nbsp;&nbsp;收货人信息</span>
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
				<div class="col-md-3">
					<img src="${item.product.productImg1 }"	class="pimg" />
				</div>
				<div class="col-md-6">
					<span>商品名称：${item.product.productTitle }</span>
				</div>
				<div class="col-md-3">
					<button uoid=" ${item.orderId }" type="button" class="btn btn-default showAddress" data-toggle="modal" data-target="#addressModal">收货人信息</button>
				</div>
			</div>
			<div class="col-md-1 center-block">${item.product.productPrice }</div>
			<div class="col-md-1 center-block">${item.orderNumber }</div>
			<div class="col-md-2 center-block" id="mone">${item.product.productPrice * item.orderNumber }</div>
			<div class="col-md-2 center-block">
			
			<c:if test="${item.orderStatus eq 1 }">
				<button type="button" class="btn btn-danger btn-xs" tp="2" uoid="${item.orderId }" money="${item.product.productPrice * item.orderNumber }">
					<span class="orderListItemDelete glyphicon glyphicon-trash"></span>
					取消订单
				</button>
			</c:if>
			<c:if test="${item.orderStatus ne 1 }">
				<button type="button" class="btn btn-danger btn-xs" tp="-1" uoid="${item.orderId }" money="${item.product.productPrice * item.orderNumber }">
					<span class="orderListItemDelete glyphicon glyphicon-trash"></span>
					删除订单
				</button>
			</c:if>
				<br ><br >
				<c:if test="${item.orderStatus eq 1 }">
					<button type="button" class="btn btn-warning btn-xs" tp="0" uoid="${item.orderId }" money="${item.product.productPrice * item.orderNumber }">
						<span class="orderListItemDelete glyphicon glyphicon-shopping-cart"></span>
							去付款&nbsp;&nbsp;&nbsp;
					</button>
				</c:if>
				<c:if test="${item.orderStatus eq 2 }">
					<button type="button" class="btn btn-info btn-xs" tp="3" uoid="${item.orderId }" money="${item.product.productPrice * item.orderNumber }">
					<span class="orderListItemDelete glyphicon glyphicon-send"></span>
							提醒发货
					</button>
				</c:if>
				<c:if test="${item.orderStatus eq 3 }">
					<button type="button" class="btn btn-success btn-xs"  tp="4" uoid="${item.orderId }" money="${item.product.productPrice * item.orderNumber }">
					<span class="orderListItemDelete glyphicon glyphicon-check"></span>
							确认收货
					</button>
				</c:if>
				<c:if test="${item.orderStatus eq 4 }">
					<button type="button" class="btn btn-default btn-xs" tp="1" uoid="${item.orderId }" money="${item.product.productPrice * item.orderNumber }" data-toggle="modal" data-target="#commentModal" pid="${item.product.productId }">
					<span class="orderListItemDelete glyphicon glyphicon-pencil"></span>
							去评价&nbsp;&nbsp;&nbsp;
					</button>
				</c:if>
				<c:if test="${item.orderStatus eq 5 }">
							交易完成 
				</c:if>
			</div>
		</div>
	</div>
	<form action="payment" id="payment" method="post">
		<input type="hidden" name="uoid">
		<input type="hidden" name="totalMoney">
	</form>
	<br>
</c:forEach>
</c:if>