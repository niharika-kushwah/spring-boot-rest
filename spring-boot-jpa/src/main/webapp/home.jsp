<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    enter data here 
	<form action="addEmployee">
	id	<input type="text" name="id"><br><br>
	name	<input type="text" name="name"><br><br>
		<input type="submit"><br><br>
	</form>

     to get employee by id
	<form action="getEmployee"><br>
	enter id	<input type="text" name="id"><br><br>
		<input type="submit"><br><br>
	</form>
	
	to update data 
	<form action="updateEmployee">
	id	<input type="text" name="id"><br><br>
	name	<input type="text" name="name"><br><br>
		<input type="submit"><br><br>
	</form>
	
	to delete by id
	
	<form action="deletebyID">
	id	<input type="text" name="id"><br><br>

		<input type="submit"><br><br>
	</form>
	
	
	
	
</body>
</html>