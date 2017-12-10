	<div class="modal fade" id="avatarModal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改头像</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="addEmpNameIuput" class="col-sm-3 control-label">选择图片：</label>
							<div class="col-sm-9">
								<input type="file" class="form-control" name="img">  
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="addEmpSaveBtn">保存</button>
				</div>
			</div>
		</div>
	</div>

<!-- =================== -->
	<div class="modal fade" id="alterPassword" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改密码</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="addEmpNameIuput" class="col-sm-3 control-label">密码：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input class="form-control" type="text"
										placeholder="Readonly input here…"> <span
										class="input-group-btn">
	
										<button type="button" class="btn btn-default">
											<span class="glyphicon glyphicon-eye-open"></span>
										</button>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
						<label for="addEmpNameIuput" class="col-sm-3 control-label">确认密码：</label>
						<div class="col-sm-9">
							<div class="col-sm-10 input-group">
								<input class="form-control" type="text"
									placeholder="Readonly input here…"> <span
									class="input-group-btn">

									<button type="button" class="btn btn-default">
										<span class="glyphicon glyphicon-eye-open"></span>
									</button>
								</span>
							</div>
						</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="addEmpSaveBtn">保存</button>
				</div>
			</div>
		</div>
	</div>

<!-- ============================= -->


	<div class="modal fade" id="money" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">充值</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
					<div class="form-group">
						<label for="addEmpNameIuput" class="col-sm-3 control-label">充值：</label>
							<div class="col-sm-9">
								<div class="col-sm-10 input-group">
									<input class="form-control" type="number"	placeholder="Readonly input here…"> <span
										class="input-group-btn">
									</span>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="addEmpSaveBtn">保存</button>
				</div>
			</div>
		</div>
	</div>
<!-- ======================== -->

<div class="modal fade" id="address" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">收货地址</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="addEmpNameIuput" class="col-sm-3 control-label">收货人：</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="addEmpNameIuput"
									placeholder="张三" name="empName"> <span id="helpBlock"
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="addEmailInput" class="col-sm-3 control-label">联系电话：</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="addEmailInput"
									placeholder="1696229469@qq.com" name="email"> <span
									id="helpBlock" class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label for="addEmailInput" class="col-sm-3 control-label">收货地址：</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="addEmailInput"
									placeholder="1696229469@qq.com" name="email"> <span
									id="helpBlock" class="help-block"></span>
							</div>
						</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="addEmpSaveBtn">保存</button>
				</div>
			</div>
		</div>
	</div>
