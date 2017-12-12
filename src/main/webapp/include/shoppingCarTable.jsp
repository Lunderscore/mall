<!-- shoppingCar.jsp -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-bordered">
	<thead>
		<tr>
			<th style="width:20%">
				<input type="checkbox">
			</th>
			<th>商品名</th>
			<th>单价</th>
			<th>数量</th>
			<th>金额</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${not empty shoppingCar }">
			<c:forEach items="${shoppingCar }" var="item">
				<tr>
					<td>
						<input type="checkbox">
						<img src="${item.product.productImg }" class="pimg" />
					</td>
				<th>${item.product.productTitle }</th>
				<th>${item.product.productPrice }</th>
				<th>${item.orderNumber }</th>
				<th>${item.product.productPrice * item.orderNumber }</th>
				<th><button type="button" class="btn btn-danger" uoid="${item.orderId }">删除</button></th>
			</tr>
			</c:forEach>
		</c:if>
		
<!-- 		============== -->
	</tbody>
</table>