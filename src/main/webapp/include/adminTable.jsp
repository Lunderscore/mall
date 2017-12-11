<!-- shoppingCar.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
           
<div class="center-block">
	<button type="button" class="btn btn-info" data-toggle="modal" data-target="#addProductModal" data-whatever="@mdo">上架产品</button>
</div>
 
<div class="row" id="productHead">
	<div class="col-md-1 center-block">商品ID</div>
	<div class="col-md-2 center-block">商品图片</div>
	<div class="col-md-2 center-block">商品名称</div>
	<div class="col-md-1 center-block">价格</div>
	<div class="col-md-1 center-block">库存数量</div>
	<div class="col-md-2 center-block">图片管理</div>
	<div class="col-md-2 center-block">详细信息编辑</div>
	<div class="col-md-1 center-block">下架</div>
</div>

	<!-- 	=============== -->
<c:if test="${not empty products }">
	<c:forEach items="${products }" var="product">
		<div class="row productItem">
		<div class="col-md-1 center-block">${product.productId }</div>
		<div class="col-md-2 center-block">
		<c:if test="${not empty product.productImg }">
			<img src="${product.productImg }" class="pimg" />
		</c:if>
		</div>
		<div class="col-md-2 center-block">${product.productTitle }</div>
		<div class="col-md-1 center-block">${product.productPrice }</div>
		<div class="col-md-1 center-block">${product.productStock }</div>
		<div class="col-md-2 center-block">
			<div class="col-md-4 center-block">
				<button type="button" class="btn btn-success uploadImgBtnClass" data-toggle="modal"
				data-target="#productImgModal" pid="${product.productId }" tp="1">图片1</button>
			</div>
			<div class="col-md-4 center-block">
				<button type="button" class="btn btn-primary uploadImgBtnClass" data-toggle="modal"
				data-target="#productImgModal" pid="${product.productId }" tp="2">图片2</button>
			</div>
			<div class="col-md-4 center-block">
				<button type="button" class="btn btn-primary uploadImgBtnClass" data-toggle="modal"
				data-target="#productImgModal" pid="${product.productId }" tp="3">图片3</button>
			</div>
		</div>
		<div class="col-md-2 center-block">
			<button type="button" class="btn btn-warning updateClass" data-toggle="modal"
				data-target="#updateProductModal" pid="${product.productId }">详细信息编辑</button>
		</div>
		<div class="col-md-1 center-block">
			<button type="button" class="btn btn-danger delBtn" pid="${product.productId }">下架</button>
		</div>
	</div>
	</c:forEach>
</c:if>



