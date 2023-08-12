<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<meta charset="ISO-8859-1">
<title>KFC Online</title>
</head>
<body>
 
	<div class="container">		
		<h2>Let's Add New!</h2>
		<br/>	
		<p style="color:red;">${message}</p>		
		<br/>
		<form action="employee?type=add" method="post">
			<label for="productName">employee:</label>
			<input class="form-control" type="text" name="employee_id" id="employee_id"/>
			<br/>
			 
			 
			<button class="btn btn-info">Add New</button>
		</form>
	</div>
</body>
</html>