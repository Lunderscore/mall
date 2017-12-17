<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../../static/header.jsp"%>

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

<title>个人中心</title>
</head>
<body class="jumbotron">
	<%@ include file="../../static/navigator.jsp"%>
    
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
        	<div id="userImgDiv">
        	<a href="#"  data-toggle="modal" data-target="#avatarModal">
        		<c:if test="${empty userSession.userAvatar }">
	        		<img id="uImg" src="static/img/defaultAvatar.jpg" />
        		</c:if>
        		<c:if test="${not empty userSession.userAvatar }">
	        		<img id="uImg" src="${userSession.userAvatar }" />
        		</c:if>
        		</a>
        	</div>
        	
        	<br>
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">账号：</label>
                    <div class="col-sm-10 input-group">
                        <input class="form-control" type="text" placeholder="${userSession.userUsername }" readonly>
                        <span class="input-group-btn">
                            <a tabindex="0" class="btn btn-default popBtn" role="button" data-toggle="popover" data-trigger="focus" title="提示" data-content="账号创建后不可修改">??</a>
                        </span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
                    <div class="col-sm-10 input-group">
                        <input class="form-control" id="passwordinfo" type="password" value="${userSession.userPassword }" readonly>
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-default"  id="passwordIconBtn"><span flag="0" class="glyphicon glyphicon-eye-open"></span></button>
                            <button type="button" class="btn btn-default"  data-toggle="modal" data-target="#alterPassword" ><span class="glyphicon glyphicon-pencil"></span></button>
                        </span>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">剩余余额：</label>
                    <div class="col-sm-3">
                      <p class="form-control-static">${userSession.userMoney}</p>
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
			  	<td id="displayName"></td>
			  </tr>
			  <tr class="warning">
			  	<td>手机号码：</td>
			  	<td id="displayPhone"></td>
			  </tr>
			  <tr class="info">
			  	<td>收货地址：</td>
			  	<td id="displayAddress"></td>
			  </tr>
			</table>
        </div>
    </div>
	<div class="row center-block">
		<button type="button" class="btn btn-danger"  data-toggle="modal" data-target="#addressModal" id="addressHomeBtn">修改默认收货地址</button>
	</div>

	<%@ include file="../../include/homeModal.jsp"%>

    <script>
        $(function(){
            $('.popBtn').popover();
        });
    </script>
    
   	<script src="js/home.js"></script>
</body>
</html>