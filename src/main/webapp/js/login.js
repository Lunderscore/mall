$(function(){
	$("#loginBtn").on("click", function(){
		login();
	});
	$("#registerBtn").on("click", function(){
		register();
	});
	$("#submitBtn").on("click", function(){
		var username = $("#username").val().trim();
		var password1 = $("#password1").val().trim();
		if ($("#loginForm").attr("action") == "login" && checkLogin()){
			$.post("loglogin", {userUsername:username, userPassword:password1 }, function(data){
				if (data.code == 0){
					location.href = "index.jsp";
				}else{
					alert(data.content.msg);
				}
			});
		}else if(checkRegister()){
			$.get("users/"+username, function(data){
				if (data.code == 1){
					alert("存在相同用户名，请换其他用户名！");
				}else{
					$.post("regregister", {userUsername:username, userPassword:password1 }, function(data){
						location.href = "index.jsp";
					});
				}
			});
		}
	});
});

function login() {
	resetNav();
	$("#loginBtn").addClass("active");
	$("#loginForm").attr("action", "login");
}

function register() {
	resetNav();
	$("#registerBtn").addClass("active");
	var password2Div = $($("<div class='col-sm-6'></div>")
			.append("<input type='password' class='form-control' id='password2' placeholder='确认密码'>"))
	$("#password2Div").append(password2Div);
	$("#loginForm").attr("action", "register");
	$("#flag").attr("flag", "1");
}

function resetNav(){
	$("#loginBtn").removeClass("active");
	$("#registerBtn").removeClass("active");
	$("#password2Div").empty();
	$("#loginForm").attr("action", "login");
}

function checkLogin(){
	var username = $("#username").val().trim();
	var password1 = $("#password1").val().trim();
	if (username == "" || password1 == ""){
		alert("用户名和密码不能为空");
		return false;
	}
	return true;
}

function checkRegister(){
	var username = $("#username").val().trim();
	var password1 = $("#password1").val().trim();
	var password2 = $("#password2").val().trim();
	if ( /^[a-zA-Z][a-zA-Z0-9_]{4,15}$/.test(username) == false){
		alert("账号格式：字母开头，允许5-16字节，允许字母数字下划线");
		return;
	}else if (/^[a-zA-Z]\w{5,17}$/.test(password1) == false){
		alert("密码格式：字母开头，长度在6~18之间，只能包含字母、数字和下划线")
		return;
	}
	if (password1 != password2){
		alert("两次密码不一样");
		return false;
	}
	return checkLogin();
}
