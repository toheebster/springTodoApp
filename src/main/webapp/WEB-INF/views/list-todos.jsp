<%@ include file="common/header.jspf" %>
<body>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<div>Hi, ${name}</div> <br> 
		<table class="table table-striped">
			<caption>Your todos are</caption>
			<thead>
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th>User</th>
					<th>Status</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.desc}</td>
						<td>${todo.user}</td>
						<td>${todo.done}</td>
						<td><a href="/update-todo?id=${todo.id}" class="btn btn-primary">Edit</a></td>
						<td><a href="/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
					</tr>
					</c:forEach>
			</tbody>
		</table>
		<div class="btn btn-success">
			<a style="color:white" class="button" href="/add-todo">Add a todo</a>
		</div>
		
	</div>
<%@ include file="common/footer.jspf" %>