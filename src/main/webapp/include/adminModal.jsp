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
<!-- 				<span id="helpBlock" class="help-block">显示的图片是原图片，上传更新后图片将更新。<span class="redWord">开发者设置只支持三张图片,并且第一张为主要图片</span></span> -->
					<form id="pictureFrom" class="form-horizontal" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<img class="pimg" src="http://how2j.cn/tmall/img/productSingle_middle/676.jpg"/>
							<div class="col-sm-9">
								<input type="file" class="form-control" name="image">  
							</div>
						</div>
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
						<label for="productTitle" class="col-sm-3 control-label">商品名称：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input id="productTitle" name="productTitle" class="form-control" type="text"	placeholder="Readonly input here…">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label for="productPrice" class="col-sm-3 control-label">价格：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input type="number" id="productPrice" name="productPrice" class="form-control" type="text"	placeholder="Readonly input here…">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label for="productStock" class="col-sm-3 control-label">库存数量：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input type="number" id="productStock" name="productStock" class="form-control" type="text"	placeholder="Readonly input here…">
										</button>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
						<label for="productInfo" class="col-sm-3 control-label">产品介绍：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<textarea id="productInfo" name="productInfo" class="form-control" type="text"	placeholder="Readonly input here…" rows="3"></textarea>
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
					<form class="form-horizontal">
					<div class="form-group">
						<label for="addProductName" class="col-sm-3 control-label">商品名称：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input id="addProductName" name="productTitle" class="form-control" type="text"	placeholder="Readonly input here…">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label for="addProductPrice" class="col-sm-3 control-label">价格：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input id="addProductPrice" name="productPrice" class="form-control" type="number"	placeholder="Readonly input here…">
								</div>
							</div>
						</div>
						<div class="form-group">
						<label for="addProductStock" class="col-sm-3 control-label">库存数量：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input id="addProductStock" name="productStock" class="form-control" type="number"	placeholder="Readonly input here…">
										</button>
									</span>
								</div>
							</div>
						</div>
						
						<div class="form-group">
						<label for="addProductInfo" class="col-sm-3 control-label">产品介绍：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<textarea id="addProductInfo" name="productInfo" class="form-control" type="text" rows="3"></textarea>
								</div>
							</div>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="addProducteBtn">保存</button>
				</div>
			</div>
		</div>
	</div>


