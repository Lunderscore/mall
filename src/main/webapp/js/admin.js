$(function(){
	$("#addProducteBtn").on("click", function(){
		addProduct();
	});
	
	$(document).on("click", ".uploadImgBtnClass", function(){
		var pid = $(this).attr("pid");
		$("[name=pid]").attr("value", pid);
		var type = $(this).attr("tp");
		if (type == 1){
			$("#pictureFrom").attr("action", "mainPicture");
		}else if (type == 2){
			$("#pictureFrom").attr("action", "secPicture");
		}else if (type == 3){
			$("#pictureFrom").attr("action", "thiPicture");
		}
	});
	
	$(document).on("click", ".updateClass", function(){
		var pid = $(this).attr("pid");
		$("#updateFrom").attr("action", "product/"+pid);
		$.get("getProductByIDJSON?pid=" + pid, function(data){
			var d = data.content.product;
			$("#updateProductTitle").val(d.productTitle);
			$("#updateProductPrice").val(d.productPrice);
			$("#updateProductStock").val(d.productStock);
			$("#updateProductInfo").val(d.productInfo);
		});
	});
	
	$(document).on("click", ".ChangeBtn", function(){
		var pid = $(this).attr("pid");
		var status = $(this).attr("status");
		
		$.post("changeProductStatus",{pid: pid, status:status}, function(){
			location.reload();
		});
		
	});
	$(document).on("click", ".updateClass", function(){
		var pid = $(this).attr("pid");
		$("#updateFrom").attr("action", "product/"+pid);
	});
	
	$("#submitImgBtn").on("click", function(){
		picture();
	});
	
	$("#updateProductBtn").on("click", function(){
		updateProduct();
	});
	
	$(document).on("click", "[tp]", function(){
		var pid = $(this).attr("pid");
		var tp = $(this).attr("tp");
		if (tp == 1){
			var imgUri = $(this).attr("mimg");
			$("#alterImg").attr("src", imgUri);
		}else if (tp == 2 || tp == 3){
			$.get("getProductImg?pid=" + pid + "&which=" + tp, function(data){
				$("#alterImg").attr("src", data.content.imgUri);
			});
		}
		
	});
});


function addProduct(){
	var name = $("#addProductName").val();
	var price = $("#addProductPrice").val();
	var stock = $("#addProductStock").val();
	var info = $("#addProductInfo").val();
	$.post("product", {productTitle:name, productPrice:price, productStock:stock, productInfo:info, productDel:"0"}, function(data){
		location.reload();
	})
}

function picture(){
 	$("#pictureFrom").submit();
}
function updateProduct(){
	$("#updateFrom").submit();
}
