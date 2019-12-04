$(function(){
    curButtonClass();

    $("#submitComment").on("click", function(){
        addComment();
    });

    $(".showAddress").on("click", function(){
        $.get("getOrderById?uoid=" + $(this).attr("uoid"), function(data){
            var v = data.content.order;
            $("#psersonName").html(v.orderPersonName);
            $("#personphone").html(v.orderPhone);
            $("#psersonAddress").html(v.orderAddress);
            $("#personMsg").html(v.orderMessage);
        });
    });

    $("[tp]").on("click", function(){
        var tp = $(this).attr("tp");
        var uoid = $(this).attr("uoid");
        $("[name=uoid]").val(uoid);
        $("[name=totalMoney]").val($(this).attr("money"));
        switch(Number(tp)){
            case -1:
                if (!confirm("是否删除订单")){
                    return;
                }
                $.post("updateStatus", {uoid:uoid, type:tp}, function(){
                    location.reload();
                });
                break;
            case 0:
                alert("前往付款页面");
                $("#payment").submit();
                break;
            case 1:
                var pid = $(this).attr("pid");
                $.get("products/" + pid, function(data){
                    var product = data.content.product;
                    $("#commentProductImg1").attr("src", product.productImg1);
                    $("#commentProductTitle").html(product.productTitle);
                    $("#submitComment").attr("pid", pid);
                    $("#submitComment").attr("uoid", uoid);
                })
                break;
            case 2:
                if (!confirm("是否删除订单")){
                    return;
                }
                $.get("delOrder", {uoid:uoid}, function(){
                    location.reload();
                });
                break;
            case 3:
                alert("卖家以发货");
                $.post("updateStatus", {uoid:uoid, type:tp}, function(){
                    location.reload();
                });
                break;
            case 4:
                if (!confirm("是否确认确认收货")){
                    return;
                }
                $.post("updateStatus", {uoid:uoid, type:tp}, function(){
                    location.reload();
                });
                break;
        }
    });
});

function curButtonClass(){
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    var type;
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == "type"){
            type = pair[1];
        }
    }
    if(type == undefined){
        $("[href='?type=0']").find("button").addClass("btn-primary");
    }
    $("[href='?type="+type+"']").find("button").addClass("btn-primary");
}

function addComment(){
    var comment = $("#comment").val().trim();
    var pid = $("#submitComment").attr("pid");
    var uoid = $("#submitComment").attr("uoid");
    $.get("addComment?commentContent=" + comment + "&commentPid=" + pid, function(){
        $.post("updateStatus", {uoid:uoid, type:"5"}, function(){
            location.reload();
        });
    });
}