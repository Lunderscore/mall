$(function () {
    let query = window.location.search;
    let keyword = query.match(/(?<=keyword=).*/);
    $("#searchInput").val(decodeURI(keyword));

    $(".item").on("mouseover", function () {
        $(this).css("border", "1px solid red");
        $(this).find("img").css("opacity", "0.7");

    });
    $(".item").on("mouseout", function () {
        $(this).css("border", "");
        $(this).find("img").css("opacity", "1");
    });
    $(".item").on("click", function () {
    });
    $("#searchBtn").on("click", function () {
        location.href = "?keyword=" + $("#searchInput").val().trim();
    });
});