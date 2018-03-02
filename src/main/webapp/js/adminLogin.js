$(function () {
    $("#mid").blur(function () {
        validataMid();
    });
    $("#password").blur(function () {
        validataPassword();
    });
    $("#subBut").click(function () {
        validataMid();
        validataPassword();
        if (validataMid() && validataPassword()) {
            clickLogin();
        }
    });
    $("#resBut").click(function () {
        reset();
    })

});

function validataMid() {
    return validataEmtyp("mid");
}

function validataPassword() {
    return validataEmtyp("password");
}

function validataEmtyp(eleId) {
    if ($("#" + eleId).val() === "") {
        $("#" + eleId + "Div").attr("class", "form-group has-error");
        $("#" + eleId + "Span").html("<span class='text-danger'>该字段的内容不允许为空！</span>");
        return false;
    } else {
        $("#" + eleId + "Div").attr("class", "form-group has-success");
        $("#" + eleId + "Span").html("<span class='text-success'>该字段的内容输入合法！</span>");
        return true;
    }
}

function clickLogin() {
    $.get("admin/login", {
        username: $("#mid").prop("value"),
        password: $("#password").prop("value")
    }, function (data) {
        if (data.code === 0) {
            alert("登录成功");
            location.href = "admin/products";
        } else if (data.code === 1) {
            alert("登录失败");
            $("#tip").show();
        } else {
        }
    });
}

function reset() {
    $("#mid").val("");
    $("#password").val("");
    $("#midDiv").attr("class", "form-group");
    $("#midSpan").html("");
    $("#passwordDiv").attr("class", "form-group");
    $("#passwordSpan").html("");
}