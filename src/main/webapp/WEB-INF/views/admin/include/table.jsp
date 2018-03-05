<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="center-block">
	<button type="button" class="btn btn-info" data-toggle="modal" data-target="#productFormModal" data-whatever="@mdo" onclick="$('#productForm').attr('onsubmit', 'return productFrom(\'POST\');')">上架产品</button>
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
<c:if test="${not empty pages }">
	<c:forEach items="${pages.list }" var="product">
		<div class="row productItem">
		<div class="col-md-1 center-block">
			${product.id }
			<br>
			<c:if test="${product.status eq 1 }">
				(下架状态)
			</c:if>	
		</div>
		<div class="col-md-2 center-block">
		<%--<c:if test="${not empty product.productImg1 }">--%>
			<%--<img src="../${product }" class="pimg"/>--%>
		<%--</c:if>--%>
		<%--<c:if test="${empty product.productImg1 }">--%>
			<span>需要上传图片1才能在主界面显示商品</span>
		<%--</c:if>--%>
		</div>
		<div class="col-md-2 center-block">${product.title }</div>
		<div class="col-md-1 center-block">${product.price }</div>
		<div class="col-md-1 center-block">${product.stock }</div>
		<div class="col-md-2 center-block">
			<div class="col-md-4 center-block">
				<button type="button" class="btn btn-success uploadImgBtnClass" data-toggle="modal"
				data-target="#productImgModal" pid="${product.id }" tp="1">图片1</button>
			</div>
			<div class="col-md-4 center-block">
				<button type="button" class="btn btn-primary uploadImgBtnClass" data-toggle="modal"
				data-target="#productImgModal" pid="${product.id }" tp="2">图片2</button>
			</div>
			<div class="col-md-4 center-block">
				<button type="button" class="btn btn-primary uploadImgBtnClass" data-toggle="modal"
				data-target="#productImgModal" pid="${product.id }" tp="3">图片3</button>
			</div>
		</div>
		<div class="col-md-2 center-block">
			<button type="button" class="btn btn-warning updateClass" data-toggle="modal"
				data-target="#updateProductModal" pid="${product.id }">详细信息编辑</button>
		</div>
		<div class="col-md-1 center-block">
			<div class="btn-group" role="group" aria-label="...">
			<c:if test="${product.status eq 1 }">
				<button type="button" class="btn btn-default ChangeBtn" pid="${product.id }" status="0">上架产品</button>
			</c:if>
			<c:if test="${product.status eq 0 }">
				<button type="button" class="btn btn-warning ChangeBtn" pid="${product.id }" status="1">下架产品</button>
			</c:if>
			<button type="button" class="btn btn-danger ChangeBtn" pid="${product.id }" status="-1">删除产品</button>
		</div>
		</div>
	</div>
	</c:forEach>
</c:if>



