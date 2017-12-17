$(function(){
	var query = window.location.search.substring(1);
	var vars = query.split("&");
	for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == "keyword"){
        	var keyword = pair[1];
        	$("#searchInput").val(decodeURI(keyword));
       	}
	}
	
	$(".item").on("mouseover", function(){
		$(this).css("border", "1px solid red");
		$(this).find("img").css("opacity", "0.7");

	});
	
	$(".item").on("mouseout", function(){
		$(this).css("border", "");
		$(this).find("img").css("opacity", "1");
	});
	
	$(".item").on("click", function(){
	});
	
	$("#searchBtn").on("click", function(){
		location.href = "?keyword=" + $("#searchInput").val().trim();
	});
	
});