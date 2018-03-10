$(function() {
    // 获取用户地址
    $.post("getUserAddress", function (data) {
        var address = data.content.address;
        $("#displayName").html(address.addressName);
        $("#displayPhone").html(address.addressPhone);
        $("#displayAddress").html(address.addressContent);
    });

    // 鼠标移动到头像时增加透明度
    $("#userImgDiv").find("img").on("mouseover", function () {
        $(this).css("opacity", "0.7");
    });
    $("#userImgDiv").find("img").on("mouseout", function () {
        $(this).css("opacity", "1");
    });
    $("#passwordIconBtn").on("click", function () {
        var span = $(this).find("span");
        if ($(span).attr("flag") === "0") {
            $(span).removeClass("glyphicon glyphicon-eye-open");
            $(span).addClass("glyphicon glyphicon-eye-close");
            $("#oldPassword").prop("type", "text");
            $(span).attr("flag", "1");
        } else {
            $(span).removeClass("glyphicon glyphicon-eye-close");
            $(span).addClass("glyphicon glyphicon-eye-open");
            $("#oldPassword").prop("type", "password");
            $(span).attr("flag", "0");
        }
    })
});

function alterPassword(){
	var password1 = $("#password1").val().trim();
	var password2 = $("#password2").val().trim();
	if (!/^[a-zA-Z]\w{5,17}$/.test(password1)){
        layer.msg("密码格式：字母开头，长度在6~18之间，只能包含字母、数字和下划线");
		return;
	}
	if(password1 !== password2){
        layer.msg("两次密码输入不一致");
		return;
	}
	$.post("users", {password: password1, _method: "PUT"}, function(data){
		location.reload();
	});
}

function recharge(){
	var money = $("#moneyInput").val();
	if (Number(money) < 0){
        layer.msg("数额不能小于0");
        return;
    }
    $.post("userInfos", {money: money, _method: "PUT"}, function(data){
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
	if (person==="" || phone==="" || address===""){
		alert("必须全部填写");
		return;
	}
	if ( !/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/.test(phone)){
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