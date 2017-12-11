$(function(){
	$("#addProducteBtn").on("click", function(){
		addProduct();
	});
});


function addProduct(){
	var name = $("#addProductName").val();
	var price = $("#addProductPrice").val();
	var stock = $("#addProductStock").val();
	var info = $("#addProductInfo").val();
	
	$.post("product", {productTitle:name, productPrice:stock, productStock:stock, productInfo:info}, function(data){
		console.log(data);
	})
}