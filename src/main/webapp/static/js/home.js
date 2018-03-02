$(function(){
	$.post("getUserAddress",function(data){
		var address = data.content.address;
		$("#displayName").html(address.addressName);
		$("#displayPhone").html(address.addressPhone);
		$("#displayAddress").html(address.addressContent);
	});
	
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
	$("#addressHomeBtn").on("click", function(){
		getAddress();
	});
	$("#passwordIconBtn").on("click", function(){
		var span = $(this).find("span");
		if ($(span).attr("flag") == 0){
			$(span).removeClass("glyphicon glyphicon-eye-open");
			$(span).addClass("glyphicon glyphicon-eye-close");
			$("#passwordinfo").attr("type", "text");
			$(span).attr("flag", "1");
		}else{
			$(span).removeClass("glyphicon glyphicon-eye-close");
			$(span).addClass("glyphicon glyphicon-eye-open");
			$("#passwordinfo").attr("type", "password");
			$(span).attr("flag", "0");
		}
	})
});

function alterPassword(){
	var password1 = $("#password1").val().trim();
	var password2 = $("#password2").val().trim();
	if (/^[a-zA-Z]\w{5,17}$/.test(password1) == false){
		alert("密码格式：字母开头，长度在6~18之间，只能包含字母、数字和下划线")
		return;
	}
	if (password1 == "" ||  password2 == ""){
		alert("不能输入为空");
		return;
	}else if(password1 != password2){
		alert("两次密码输入不一致");
		return;
	}
	$.post("user", {userPassword: password1}, function(data){
		location.reload();
	});
}

function alterMoney(){
	var money = $("#money").val();
	if (money < 0){
		alert("数额不能小于0");
		return;
	}
	$.post("money", {mid: money}, function(data){
		location.reload();
	});
}

function getAddress(){
	$.post("getUserAddress",function(data){
		var address = data.content.address;
		$("#person").val(address.addressName);
		$("#phone").val(address.addressPhone);
		$("#address").val(address.addressContent);
	});
}
function alterAddress(){
	var person = $("#person").val().trim();
	var phone = $("#phone").val().trim();
	var address = $("#address").val().trim();
	if (person=="" || phone=="" || address==""){
		alert("必须全部填写");
		return;
	}
	if ( /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/.test(phone) == false){
		alert("请输入正确的手机号码");
		return;
	}
	$.post("userAddress", {addressName: person, addressPhone: phone
		, addressContent: address}, function(){
			location.reload();
		}
	);
}
function avatar(){
	$("#avatarForm")[0].submit();
}