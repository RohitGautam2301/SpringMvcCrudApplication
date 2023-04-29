<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
</head>
<body>
	<h1>Welcome Admin</h1>
	<form action="admin" method="post">
		Admin Username:<input type="text" name="tbAdminUsername">
		<br/><br/>
		Admin Password:<input type="password" name="tbAdminPassword">
		<br/><br/>
		<input type="submit" value="Sign In">
	</form>
</body>
</html>