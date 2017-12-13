$(function(){
	$("#loginBtn").on("click", function(){
		login();
	});
	$("#registerBtn").on("click", function(){
		register();
	});

	$("#submitBtn").on("click", function(){
		$("#loginForm").submit();
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
	var password2Span = $("<div class='col-sm-3'></div>")
			.append("<span id='password2Span'>123</span>");

	$("#password2Div").append(password2Div).append(password2Span);
	
	$("#loginForm").attr("action", "register");
}

function resetNav() {
	$("#loginBtn").removeClass("active");
	$("#registerBtn").removeClass("active");
	$("#password2Div").empty();
	$("#loginForm").attr("action", "login");
}
