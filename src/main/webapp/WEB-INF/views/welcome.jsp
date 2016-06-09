<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf"%>
	<div> 
		<h1>Welcome ${name}</h1><br>
		<i> Now you can <a href="/list-todos?name=${name}">manage your Todos</a>.</i>
	</div>
	
<%@ include file="common/footer.jspf" %>
