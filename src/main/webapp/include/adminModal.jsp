	<div class="modal fade" id="productImgModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改图片</h4>
				</div>
				<div class="modal-body">
					<form id="pictureFrom" class="form-horizontal" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<img class="pimg" id="alterImg"/>
							<div class="col-sm-9">
								<input type="file" class="form-control" name="image">
							</div>
						</div>
						<input type="hidden" name="_method" value="put">
					</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="submitImgBtn">保存</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- =================== -->
	<div class="modal fade" id="updateProductModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">详细信息编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="updateFrom" method="post">
					<div class="form-group">
						<label for="updateProductTitle" class="col-sm-3 control-label">商品名称：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input id="updateProductTitle" name="productTitle" class="form-control" type="text"	placeholder="请输入商品名称">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label for="updateProductPrice" class="col-sm-3 control-label">价格：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input type="number" id="updateProductPrice" name="productPrice" class="form-control" type="text"	placeholder="请输入价格">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label for="updateProductStock" class="col-sm-3 control-label">库存数量：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input type="number" id="updateProductStock" name="productStock" class="form-control" type="text"	placeholder="请输入库存数量">
										</button>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
						<label for="updateProductInfo" class="col-sm-3 control-label">产品介绍：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<textarea id="updateProductInfo" name="productInfo" class="form-control" type="text" placeholder="请输入产品介绍" rows="3"></textarea>
								</div>
							</div>
						</div>
						<input name="_method" value="put" type="hidden"/>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="updateProductBtn">保存</button>
				</div>
			</div>
		</div>
	</div>

<!-- ============================= -->


	<div class="modal fade" id="addProductModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">上架产品</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="products" method="post" id="addProductForm">
					<div class="form-group">
						<label for="addProductName" class="col-sm-3 control-label">商品名称：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input id="addProductName" name="productTitle" class="form-control" type="text"	placeholder="请输入商品名称">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label for="addProductPrice" class="col-sm-3 control-label">价格：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input id="addProductPrice" name="productPrice" class="form-control" type="number"	placeholder="请输入价格">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label for="addProductStock" class="col-sm-3 control-label">库存数量：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input id="addProductStock" name="productStock" class="form-control" type="number"	placeholder="请输入库存数量">
								</div>
							</div>
						</div>
						
						<div class="form-group">
						<label for="addProductInfo" class="col-sm-3 control-label">产品介绍：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<textarea id="addProductInfo" name="productInfo" placeholder="请输入产品介绍" class="form-control" rows="3"></textarea>
								</div>
							</div>
						</div>
						<input name="productStatus" value="0" type="hidden">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="addProducteBtn">保存</button>
				</div>
			</div>
		</div>
	</div>


