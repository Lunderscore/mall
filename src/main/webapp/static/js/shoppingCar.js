$(document).on("click", "[uoid]", function(){
	if (!confirm("是否删除")){
		return;
	}
	var uoid = $(this).attr("uoid");
	$.get("delOrder", {uoid:uoid}, function(){
		location.href = "shoppingCar";
	});
});

$("#confirmItem").on("click", function(){
	$.post("getUserAddress",function(data){
		var address = data.content.address;
		$("#orderPersonName").val(address.addressName);
		$("#orderPhone").val(address.addressPhone);
		$("#orderAddress").val(address.addressContent);
	});
});

	$("#submitShoppingCar").on("click", function(){
		calcu();
		var name = $("#orderPersonName").val().trim();
		var phone = $("#orderPhone").val().trim();
		var address = $("#orderAddress").val().trim();
		var msg = $("#orderMessage").val().trim();
		if (name=="" || phone=="" || address=="" || msg==""){
			alert("必须全部填写");
			return;
		}
		if ( /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/.test(phone) == false){
			alert("请输入正确的手机号码");
			return;
		}
		if (!confirm("是否确认订单")){
			return;
		}
		$("#shoppingCarForm").submit();
	});
	
	$("#delBatchBtn").on("click", function(){
		if (!confirm("是否选择删除")){
			return;
		}
		calcu();
		var uoid = $("#hideTotalhideUoid").val();
		$.get("delOrderBatch", {uoid:uoid}, function(){
			location.href = "shoppingCar";
		});
	});
	
// 	复选框操作
	function calcu(){
		var totalMoney = 0;
		var uoid = "";
		$.each($(".checkItem:checked"), function(){
			totalMoney += Number($(this).attr("value"));
			uoid += $(this).attr("uoidCheckbox") + "-";
		});
		uoid = uoid.substring(0, uoid.length-1);
		$("#hideTotalMoney").val(totalMoney);
		$("#hideTotalhideUoid").val(uoid);
	}
	
	$("#checkAll").on("click", function(){
		if ($(this).prop("checked")){
			$(".checkItem").prop("checked", true);
		}else{
			$(".checkItem").prop("checked", false);
		}
		if ($(".checkItem:checked").length == 0){
			$("#confirmItem").attr("disabled", "disabled");
			$("#delBatchBtn").attr("disabled", "disabled");
		}else{
			$("#confirmItem").removeAttr("disabled");
			$("#delBatchBtn").removeAttr("disabled");
		}
	});
	
	$(document).on("click", ".checkItem", function(){
		if ($(".checkItem:checked").length == $(".checkItem").length){
			$("#checkAll").prop("checked", true);
		}else{
			$("#checkAll").prop("checked", false);
		}
		if ($(".checkItem:checked").length == 0){
			$("#confirmItem").attr("disabled", "disabled");
			$("#delBatchBtn").attr("disabled", "disabled");
		}else{
			$("#confirmItem").removeAttr("disabled");
			$("#delBatchBtn").removeAttr("disabled");
		}
	});