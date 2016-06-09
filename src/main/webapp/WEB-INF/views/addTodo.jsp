<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf"%>
<!-- binding form tags -->
	<div class="container">
    <form:form method="post" commandName="todo">
        <form:hidden path="id" />
        <fieldset class="form-group">
            <form:label path="desc">Description</form:label>
            <form:input path="desc" type="text" class="form-control"
                required="required" />
            <form:errors path="desc" cssClass="text-warning" />
        </fieldset>
        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</div>		
<%@ include file="common/footer.jspf" %>
