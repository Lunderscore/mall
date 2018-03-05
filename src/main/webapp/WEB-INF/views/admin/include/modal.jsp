<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal fade" tabindex="-1" role="dialog" id="productFormModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form class="form-horizontal" method="post" id="productForm">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">上架产品</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="title" class="col-sm-3 control-label">商品名称：</label>
                        <div class="col-sm-9">
                            <div class="col-sm-10 input-group">
                                <input id="title" name="title" class="form-control" type="text"
                                       placeholder="请输入商品名称" pattern=".*\S+" required
                                       oninvalid="setCustomValidity('不能能输入为空');" oninput="setCustomValidity('')">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="price" class="col-sm-3 control-label">价格：</label>
                        <div class="col-sm-9">
                            <div class="col-sm-10 input-group">
                                <input id="price" name="productPrice" class="form-control" type="number"
                                       placeholder="请输入价格" pattern=".*\S+" required
                                       oninvalid="setCustomValidity('不能能输入为空');" oninput="setCustomValidity('')">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stock" class="col-sm-3 control-label">库存数量：</label>
                        <div class="col-sm-9">
                            <div class="col-sm-10 input-group">
                                <input id="stock" name="stock" class="form-control" type="number"
                                       placeholder="请输入库存数量" pattern=".*\S+" required
                                       oninvalid="setCustomValidity('不能能输入为空');" oninput="setCustomValidity('')">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="info" class="col-sm-3 control-label">产品介绍：</label>
                        <div class="col-sm-9">
                            <div class="col-sm-10 input-group">
                                <textarea id="info" name="info" placeholder="请输入产品介绍"
                                          class="form-control" rows="3" required
                                          oninvalid="setCustomValidity('不能能输入为空');"
                                          oninput="setCustomValidity('')"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">保存</button>
                </div>
                <input type="hidden" id="productId">
            </form>
        </div>
    </div>
</div>
<%--======================================================--%>
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
                    <button type="button" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    // 提交商品信息时
    function productFrom(method) {
        // textarea 没有pattern属性 所以要自己验证
        let info = $("#info").val();
        if (info.trim() === "") {
            layer.msg("产品介绍不能为空");
            return false;
        }
        let title = $("#title").val().trim();
        let price = $("#price").val().trim();
        let stock = $("#stock").val().trim();
        let uri = "products";
        let operation = "添加";
        // 如果是更新操作
        if ("PUT" === method) {
            uri = uri + "/" + $("#productId").val();
            operation = "更新";
        }
        $.post(uri, {title: title, price: price, stock: stock, info: info, _method: method}, function (data) {
            if (0 === data.code) {
                layer.msg(operation + "商品成功");
                location.reload();
            } else {
                layer.msg(operation + "商品失败: " + data.message);
            }
        });
        return false;
    }
</script>