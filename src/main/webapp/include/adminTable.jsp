<!-- shoppingCar.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
           
<div class="center-block">
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addProductModal" data-whatever="@mdo">上架产品</button>
</div>
 
<div class="row" id="productHead">
	<div class="col-md-1 center-block">商品ID</div>
	<div class="col-md-2 center-block">商品图片</div>
	<div class="col-md-3 center-block">商品名称</div>
	<div class="col-md-1 center-block">价格</div>
	<div class="col-md-1 center-block">库存数量</div>
	<div class="col-md-1 center-block">图片管理</div>
	<div class="col-md-2 center-block">详细信息编辑</div>
	<div class="col-md-1 center-block">下架</div>
</div>

	<!-- 	=============== -->
<c:if test="${not empty products }">
	<c:forEach items="${products }" var="product">
		<div class="row productItem">
		<div class="col-md-1 center-block">${product.productId }</div>
		<div class="col-md-2 center-block">
			<img src="http://how2j.cn/tmall/img/productSingle/676.jpg"
				class="pimg" />
		</div>
		<div class="col-md-3 center-block">${product.productTitle }</div>
		<div class="col-md-1 center-block">${product.productPrice }</div>
		<div class="col-md-1 center-block">${product.productStock }</div>
		<div class="col-md-1 center-block">
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#productImgModal" data-whatever="@mdo">PICTURE</button>
		</div>
		<div class="col-md-2 center-block">
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#alterPassword" data-whatever="@mdo">详细信息编辑</button>
		</div>
		<div class="col-md-1 center-block">
			<button type="button" class="btn btn-danger">下架</button>
		</div>
	</div>
	</c:forEach>
</c:if>



