<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Update Demart</h1></center>
<form method="get" action="updateDemart">
   <center>
		Demart Id : 
		<input type="number" name="id" value=${demart.id} readonly/>
		<br/><br/> 
		 Name : 
		<input type="text" name="name" value=${demart.name} /> 
		<br/><br/>
		Product : 
		<input type="text" name="product" value=${demart.product} /> 
		<br/><br/> 
		Price : 
		<input type="number" name="price" value=${demart.price} /> 
		<br/><br/> 
		<input type="submit" value="Update" />
	</center>
</form>
</body>
</html>