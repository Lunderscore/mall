$(function(){
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
});