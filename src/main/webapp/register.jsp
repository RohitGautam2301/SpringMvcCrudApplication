<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.techpalle.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h1>Welcome to Registration</h1>
	<% Student stud = (Student)request.getAttribute("student"); %>
	<%if(stud != null) {%>
	<form action="editStudent" method="post">
	
	Name: <input type="text" value=<%=stud.getName() %> name="tbName" />
	<br/><br/>
	Email: <input type="email" value=<%=stud.getEmail() %> name="tbEmail" />
	<br/><br/>
	Password: <input type="password" value=<%=stud.getPassword() %> name="tbPass" />
	<br/><br/>
	Mobile: <input type="tel" value=<%=stud.getMobile() %> name="tbMobile" />
	<br/><br/>
	<input type="submit" value="save" />
	<%} %>
	<% if (stud == null) { %>
	<form action="insert" method="post">
	
	Name: <input type="text" name="tbName" />
	<br/><br/>
	Email: <input type="email" name="tbEmail" />
	<br/><br/>
	Password: <input type="password" name="tbPass" />
	<br/><br/>
	Mobile: <input type="tel" name="tbMobile" />
	<br/><br/>
	<input type="submit" value="Save" />
	<%} %>
	</form>
	<br/>
	
	<form action="student" params="signout">

	<button name="signout">Sign Out</button>
	
	</form>

</body>
</html>