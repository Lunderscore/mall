$(function(){
	$("#addProducteBtn").on("click", function(){
		addProduct();
	});
	
	$(document).on("click", ".uploadImgBtnClass", function(){
		var pid = $(this).attr("pid");
		var type = $(this).attr("tp");
		if (type == 1){
			$("#pictureFrom").attr("action", "mainPicture/"+pid);
		}else if (type == 2){
			$("#pictureFrom").attr("action", "secPicture/"+pid);
		}else if (type == 3){
			$("#pictureFrom").attr("action", "thiPicture/"+pid);
		}
	});
	
	$(document).on("click", ".updateClass", function(){
		var pid = $(this).attr("pid");
		$("#updateFrom").attr("action", "product/"+pid);
	});
	
	$(document).on("click", ".delBtn", function(){
		var pid = $(this).attr("pid");
		
		$.post("delProduct",{_method:"delete", productId:pid}, function(){
			
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
});


function addProduct(){
	var name = $("#addProductName").val();
	var price = $("#addProductPrice").val();
	var stock = $("#addProductStock").val();
	var info = $("#addProductInfo").val();
	$.post("product", {productTitle:name, productPrice:price, productStock:stock, productInfo:info, productDel:"0"}, function(data){
		console.log(data);
	})
}

function picture(){
 	$("#pictureFrom").submit();
}
function updateProduct(){
	$("#updateFrom").submit();
}