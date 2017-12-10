$(function(){
	$("#submitBtn").attr("subType", "0");
	
	$("#loginBtn").on("click", function(){
		login();
	});
	$("#registerBtn").on("click", function(){
		register();
	});
	$("#submitBtn").on("click", function(){
		submit();
	});
	
	
});


function login() {
	resetNav();
	$("#loginBtn").addClass("active");
	$("#submitBtn").attr("subType", "0");
}

function register() {
	resetNav();
	$("#registerBtn").addClass("active");
	var password2Div = $($("<div class='col-sm-6'></div>")
			.append("<input type='password' class='form-control' id='password2' placeholder='确认密码'>"))
	var password2Span = $("<div class='col-sm-3'></div>")
			.append("<span id='password2Span'>123</span>");

	$("#password2Div").append(password2Div).append(password2Span);
	
	$("#submitBtn").attr("subType", "1");
}

function resetNav() {
	$("#loginBtn").removeClass("active");
	$("#registerBtn").removeClass("active");
	$("#password2Div").empty();
	$("#submitBtn").attr("subType", "0");
}

function submit(){
	var type = $("#submitBtn").attr("subType");
	var username = $("#username").val();
	var password1 = $("#password1").val();
	var password2 = $("#password2").val();

	if (type == 0){
		$.get("user?userUsername="+username+"&userPassword="+password1, function(data){
			console.log(data);
			if (data.code == 0){
				alert("登录成功");
			}else{
				alert("登录失败");
			}
		});
	}else if(type == 1){
		$.post("user", {userUsername: username, userPassword: password1}, function(data){
			console.log(data);
			if (data.code == 0) {
				alert("注册成功");
			}else{
				alert("注册失败");
			}
		});
	}
}
