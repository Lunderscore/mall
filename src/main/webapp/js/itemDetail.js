var query = window.location.search.substring(1);
var vars = query.split("&");
var pid;
for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == "pid"){
        	pid = pair[1];
       	}
}
$(function(){
	init();
	
	$("#getComments").on("click", function(){
		$("#productComments").empty();
		$.get("getCommentByPid?pid=" + pid, function(data){
			if (data.code == 0){
				var head = $("<div class='col-md-10 col-md-offset-1'></div>");
				var tableHead = $("<table class='table table-hover'><caption><h2 style='text-align:center;'>购买过该商品的用户评论</h2></caption></table>");
				$("<tr><td>评论内容</td><td>评论日期</td><td>评论用户</td></tr>").appendTo(tableHead);
				var comments = data.content.comments;
				console.log(comments);
				$(comments).each(function(){
					var content = $("<td></td>").append(this.commentContent);
					var time = new Date(this.commentDateTime);
					var year = time.getFullYear();
					var mouth = time.getMonth() + 1;
					var day = time.getDate();
					var time = $("<td></td>").append(year + "-" + mouth + "-" + day);
					var user = $("<td></td>").append(this.user.userUsername);
					$("<tr></tr>").append(content).append(time).append(user).appendTo(tableHead);
				});
				$(head).append(tableHead).appendTo("#productComments");
			}else{
				$("#productComments").html("<h2 style='text-align:center'>该商品暂时没有人评论</h2>");
			}
		});
	});
	
	$("#addToCar").on("click", function(){
		var num = $("#number").val();
		var stock = $("#stock").html();
		if (Number(num) > Number(stock)){
			alert("输入超过库存，加入购物车失败");
			return;
		}else if ( num < 1){
			alert("加入购物车数量至少为1");
			return;
		}
		$.post("order", {pid:pid, num:num}, function(data){
			alert(data.content.msg);
			location.reload();
		});
	});
});

function init(){
	$.get("products/"+pid, function(data){
		var v = data.content.product;
		$("#ProductTitle").html(v.productTitle);
		$("#price").html(v.productPrice);
		$("#stock").html(v.productStock);
		$("#prodictInfo").html(v.productInfo);
		
		if (v.productImg1 != null ){
			$("<li data-target='#carousel-example-generic' data-slide-to='0' class='active'></li>")
				.appendTo("#carouselIndex");
			$("<div class='item active'></div>")
				.append("<img src="+ v.productImg1 +" class='img-responsive' />")
				.appendTo("#carouselImg");
		}
		
		if (v.productImg2 != null ){
			$("<li data-target='#carousel-example-generic' data-slide-to='1'></li>")
				.appendTo("#carouselIndex");
			
			$("<div class='item'></div>")
			.append("<img src="+ v.productImg2 +" class='img-responsive' />")
			.appendTo("#carouselImg");
		}
		
		if (v.productImg3 != null ){
			$("<li data-target='#carousel-example-generic' data-slide-to='2'></li>")
				.appendTo("#carouselIndex");
			
			$("<div class='item'></div>")
			.append("<img src="+ v.productImg3 +" class='img-responsive' />")
			.appendTo("#carouselImg");
		}
	});
}
