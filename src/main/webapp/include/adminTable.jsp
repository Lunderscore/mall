<!-- shoppingCar.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${product.productImg1 }
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
	<div class="col-md-1 center-block">操作</div>
</div>

	<!-- 	=============== -->
<c:if test="${not empty pages }">
	<c:forEach items="${pages.list }" var="product">
		<div class="row productItem">
		<div class="col-md-1 center-block">
			${product.productId }
			<br>
			<c:if test="${product.productStatus eq 1 }">
				(下架状态)
			</c:if>	
		</div>
		<div class="col-md-2 center-block">
		<c:if test="${not empty product.productImg1 }">
			<img src="../${product.productImg1 }" class="pimg"/>
		</c:if>
		<c:if test="${empty product.productImg1 }">
			<span>需要上传图片1才能在主界面显示商品</span>
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
			<div class="btn-group" role="group" aria-label="...">
			<c:if test="${product.productStatus eq 1 }">
				<button type="button" class="btn btn-default ChangeBtn" pid="${product.productId }" status="0">上架产品</button>
			</c:if>
			<c:if test="${product.productStatus eq 0 }">
				<button type="button" class="btn btn-warning ChangeBtn" pid="${product.productId }" status="1">下架产品</button>
			</c:if>
			<button type="button" class="btn btn-danger ChangeBtn" pid="${product.productId }" status="-1">删除产品</button>
		</div>
		</div>
	</div>
	</c:forEach>
</c:if>



