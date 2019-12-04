$(function(){
    init();

    $("#searchBtn").on("click", function(){
        location.href = "?keyword=" + $("#searchInput").val().trim();
    });

    $("#addProducteBtn").on("click", function(){
        addProduct();
    });

    $(document).on("click", ".uploadImgBtnClass", function(){
        var pid = $(this).attr("pid");
        var type = $(this).attr("tp");
        if (type == 1){
            $("#pictureFrom").attr("action", "products/" + pid + "/" + "1");
        }else if (type == 2){
            $("#pictureFrom").attr("action", "products/" + pid + "/" + "2");
        }else if (type == 3){
            $("#pictureFrom").attr("action", "products/" + pid + "/" + "3");
        }
    });

    $(document).on("click", ".updateClass", function(){
        var pid = $(this).attr("pid");
        $("#updateFrom").attr("action", "products/"+pid);
        $.get("products/"+pid, function(data){
            var d = data.content.product;
            $("#updateProductTitle").val(d.productTitle);
            $("#updateProductPrice").val(d.productPrice);
            $("#updateProductStock").val(d.productStock);
            $("#updateProductInfo").val(d.productInfo);
        });
    });

//	下架或删除产品
    $(document).on("click", ".ChangeBtn", function(){
        var pid = $(this).attr("pid");
        var status = $(this).attr("status");

        if (status == -1 && !confirm("是否删除？")){
            return ;
        }
        $.post("products/"+pid,{productStatus: status}, function(){
            location.reload();
        });

    });
    $(document).on("click", ".updateClass", function(){
        var pid = $(this).attr("pid");
        $("#updateFrom").attr("action", "products/"+pid);
    });

//	提交图片
    $("#submitImgBtn").on("click", function(){
        picture();
    });

    $("#updateProductBtn").on("click", function(){
        updateProduct();
    });

//	更新照片前获取照片
    $(document).on("click", "[tp]", function(){
        var pid = $(this).attr("pid");
        var tp = $(this).attr("tp");
        $.get("products/"+pid, function(data){
            console.log(data);
            if (tp == 1){
                $("#alterImg").attr("src", "../"+data.content.product.productImg1);
            }else if (tp == 2){
                $("#alterImg").attr("src", "../"+data.content.product.productImg2);
            }else if (tp == 3){
                $("#alterImg").attr("src", "../"+data.content.product.productImg3);
            }
        });
    });
});

//添加商品
function addProduct(){
    if ($("#addProductName").val().trim() == ""
        || $("#addProductPrice").val().trim() == ""
        || $("#addProductStock").val().trim() == ""
        || $("#addProductInfo").val().trim() == ""){
        alert("必须全部填写");
        return;
    }
    $("#addProductForm").submit();
}

//上传图片
function picture(){
    $("#pictureFrom").submit();
}
//更新产品
function updateProduct(){
    if ($("#updateProductTitle").val().trim() == ""
        || $("#updateProductPrice").val().trim() == ""
        || $("#updateProductStock").val().trim() == ""
        || $("#updateProductInfo").val().trim() == ""){
        alert("必须全部填写");
        return;
    }
    $("#updateFrom").submit();
}

function init(){
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == "keyword"){
            var keyword = pair[1];
            $("#searchInput").val(decodeURI(keyword));
        }
    }
}