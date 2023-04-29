<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.techpalle.model.Student" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
</head>
<body>

<h1>Student List:</h1>

<table border="1">

	<thead>
		<tr>
			<th>Sno</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Mobile</th>
			<th>Actions</th>
		</tr>
	</thead>
	
	<tbody>
	<% ArrayList<Student> s = (ArrayList<Student>) request.getAttribute("student"); %>
	<%
		for(Student item : s)
		{
	%>
			<tr>
				<td><c:out value="<%= item.getSno() %>"></c:out></td>
				<td><c:out value="<%= item.getName() %>"></c:out></td>
				<td><c:out value="<%= item.getEmail() %>"></c:out></td>
				<td><c:out value="<%= item.getPassword() %>"></c:out></td>
				<td><c:out value="<%= item.getMobile() %>"></c:out></td>
				<td>
					<a href="edit?id=<c:out value="<%= item.getSno() %>"></c:out>">edit</a>
					<a href="delete?id=<c:out value="<%= item.getSno() %>"></c:out>">delete</a>
				</td>
			</tr>
	<%
		}
	%>	
	</tbody>
			
</table>

	<br/>
	
	<br/>
	
	<form action="student" params="signout">

	<button name="signout">Sign Out</button>
	
	</form>
	
</body>
</html>