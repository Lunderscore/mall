<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="static/header.jsp"%>

<style>
	#userImgDiv{
		text-align:center;
	}
	#uImg{
		width: 150px;
		height: 150px;
	}
	.center-block{
		text-align: center;
	}
</style>

<title>Insert title here</title>
</head>
<body class="jumbotron">
${user }
<img src="D:\myWorkSpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\mall\data\img\userAvatar\2.jpg">
	<%@ include file="static/navigator.jsp"%>
    
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
        	<div id="userImgDiv">
        	<a href="#"  data-toggle="modal" data-target="#avatarModal">
        		<img id="uImg" src="static/img/defaultAvatar.jpg" />
        		</a>
        	</div>
        	
        	<br>
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">账号：</label>
                    <div class="col-sm-10 input-group">
                        <input class="form-control" type="text" placeholder="Readonly input here…" readonly>
                        <span class="input-group-btn">
                            <a tabindex="0" class="btn btn-default popBtn" role="button" data-toggle="popover" data-trigger="focus" title="提示" data-content="账号创建后不可修改">??</a>
                        </span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
                    <div class="col-sm-10 input-group">
                        <input class="form-control" type="text" placeholder="Readonly input here…" readonly>
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-eye-open"></span></button>
                            <button type="button" class="btn btn-default"  data-toggle="modal" data-target="#alterPassword" ><span class="glyphicon glyphicon-pencil"></span></button>
                        </span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">剩余余额：</label>
                    <div class="col-sm-3">
                      <p class="form-control-static">0.00</p>
                    </div>
                    <div class="col-sm-5">
                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#moneyModal"><span class="glyphicon glyphicon-usd"></span>充值</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    
    <div class="row center-block">
		<h4 class="text-primary">默认收货地址</h4>
	</div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
        	<table class="table table-striped">
			  <tr class="success">
			  	<td>收货人：</td>
			  	<td>老王</td>
			  </tr>
			  <tr class="warning">
			  	<td>手机号码：</td>
			  	<td>131415161775</td>
			  </tr>
			  <tr class="info">
			  	<td>收货地址：</td>
			  	<td>老王的说法的合同预计一天</td>
			  </tr>
			</table>
        </div>
    </div>
	<div class="row center-block">
		<button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#addressModal">修改默认收货地址</button>
	</div>

	<%@ include file="include/homeModal.jsp"%>

    <script>
        $(function(){
            $('.popBtn').popover();
        });
    </script>
    
   	<script src="js/home.js"></script>
</body>
</html>