$(function(){
	$("#userImgDiv").find("img").on("mouseover", function(){
		$(this).css("opacity", "0.7");
	});
	
	$("#userImgDiv").find("img").on("mouseout", function(){
		$(this).css("opacity", "1");
	});
	
	$("#passwordBtn").on("click", function(){
		alterPassword();
	});
	$("#moneyBtn").on("click", function(){
		alterMoney();
	});
	$("#addressBtn").on("click", function(){
		alterAddress();
	});
	$("#avatarBtn").on("click", function(){
		avatar();
	});
});

function alterPassword(){
	var password1 = $("#password1").val();
	$.post("user", {userPassword: password1, _method:"PUT"}, function(data){
		
	});
}
function alterMoney(){
	var money = $("#money").val();
	alert(money);
	$.post("user", {userMoney: money, _method:"PUT"}, function(data){
	});
}

function alterMoney(){
	var money = $("#money").val();
	alert(money);
	$.post("user", {userMoney: money, _method:"PUT"}, function(data){
	});
}
function alterAddress(){
	var person = $("#person").val();
	var phone = $("#phone").val();
	var address = $("#address").val();
	$.post("userAddress", {addressName: person, addressPhone: phone, addressContent: address,  _method:"PUT"}
		,function(){
		}
	);
}

function avatar(){
	
	$("#avatarForm")[0].submit();
}