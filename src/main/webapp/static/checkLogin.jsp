<script>
<%
	if (session.getAttribute("user") == null){
%>
		alert("你还没有登录, 请登录！");
		location.href = "login.jsp";
<%
	}
%>
</script>