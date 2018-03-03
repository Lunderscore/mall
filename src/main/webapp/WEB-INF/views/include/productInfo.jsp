<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<form class="form-horizontal" id="itemDetailForm" action="order">
    <div class="form-group">
        <label class="col-sm-2 control-label">商品名：</label>
        <div class="col-sm-10">
            <p type="email" class="form-control-static">
                <span>${product.title}</span>
            </p>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">价格：</label>
        <div class="col-sm-10">
            <p type="email" class="form-control-static">
                <span>${product.price}</span> <span class="glyphicon glyphicon-usd"></span>
            </p>
        </div>
    </div>
    <div class="form-group">
        <label for="number" class="col-sm-2 control-label">数量：</label>
        <div class="col-sm-3">
            <input type="number" class="form-control" id="number">
            <span id="helpBlock" class="help-block">(还剩: ${product.stock}件)</span>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="button" class="btn btn-warning" id="addToCar">加入购物车</button>
        </div>
    </div>
</form>