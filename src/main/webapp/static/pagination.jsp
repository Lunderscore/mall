<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav aria-label="...">

	<ul class="pagination pagination-lg">
	<c:if test="${not empty pages }">
		<li><a href="?pn=${pages.prePage }" aria-label="Previous"><span
				aria-hidden="true">&laquo;</span></a></li>
			<c:forEach items="${pages.navigatepageNums }" var="i">
			<c:if test="${pages.pageNum eq i }">
				<li class="active"><a href="?pn=${i }">${i }<span class="sr-only">(current)</span></a></li>
			</c:if>
			<c:if test="${pages.pageNum ne i }">
				<li><a href="?pn=${i }">${i } <span class="sr-only">(current)</span></a></li>
			</c:if>
			</c:forEach>
			
			<c:if test="${pages.hasNextPage }">
				<li>
			      <a href="?pn=${pages.nextPage }" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
		    	</li>
			</c:if>
			<c:if test="${pages.hasNextPage eq false}">
				<li>
			      <a href="?pn=${pages.pageNum }" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
		    	</li>
			</c:if>
   	</c:if>
	</ul>
</nav>
<script>
	var query = window.location.search.substring(1);
	var newQuery = "";
	if (query != ""){
		var vars = query.split("&");
		for (var i=0;i<vars.length;i++) {
		    var pair = vars[i].split("=");
		    if(pair[0] != "pn"){
		    	newQuery = "&" + pair[0] + "=" + pair[1];
		   	}
		}
	}
   	$(".pagination").find("a").each(function(){
   		$(this).attr("href", $(this).attr("href") + newQuery);
   	});
</script> 