$(function(){
	$("#userImgDiv").find("img").on("mouseover", function(){
		$(this).css("opacity", "0.7");
	});
	
	$("#userImgDiv").find("img").on("mouseout", function(){
		$(this).css("opacity", "1");
	});
	
});