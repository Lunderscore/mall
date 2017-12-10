<!-- MODAL.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="headerInclude.jsp"%>
<title>Insert title here</title>
<body class="jumbotron">


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

						<div class="form-group">
							<label for="addEmailInput" class="col-sm-3 control-label">买家留言：</label>
							<div class="col-sm-9">
								<textarea rows="3" class="form-control">
                    </textarea>
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


	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#address" data-whatever="@mdo">Open modal for @mdo</button>
</body>
</html>