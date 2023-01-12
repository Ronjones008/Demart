<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
    
    <center><h1>Demart DataTable</h1></center>
		<table border="3" align="center">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Product</th>
				<th>Price</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		<c:forEach var="e" items="${demartlist}">
			<tr>
				<td>${e.id}</td>
				<td>${e.name}</td>
				<td>${e.product}</td>
				<td>${e.price}</td>
				<td>
        			<a href="editDemart?id=${e.id}">Update</a>
        			</td>
        		<td>
        			<a href="deleteDemart?id=${e.id}">Delete</a>
        		</td>
		</c:forEach>
		</table>
		<center>
		        <h3><a href="newDemart">Add Demart</a></h3>
		</center>
    </body>
</html>
