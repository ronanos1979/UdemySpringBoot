<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<link href="webjars/bootstrap/5.3.3/css/bootstrap.css" rel="stylesheet">
<link href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.standalone.css" rel="stylesheet">
<title>List Todos Page</title>
</head>
<body>
<div class="container">
	<div>Welcome ${name}</div>
	<hr>
	<h1> Your todos are:</h1>
	<table class="table">
		<thead>
			<tr>
				<!-- <th>Id</th> -->
				<th>Description</th>
				<th>Target Date</th>
				<th>Done</th>
				<th></th>
				<th></th>
			</tr>	
		</thead>
		<tbody>	
			<c:forEach items="${todos}" var="todo">			
				<tr>
					<!--  <td>${todo.id}</td>  -->
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-primary">Update</a></td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
				</tr>		
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Add Todo</a>
	<script src="webjars/bootstrap/5.3.3/js/bootstrap.js"></script>
	<script src="webjars/jquery/3.7.1/jquery.js"></script>
	<script src="webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.js"></script>
</div>
</body>
</html>