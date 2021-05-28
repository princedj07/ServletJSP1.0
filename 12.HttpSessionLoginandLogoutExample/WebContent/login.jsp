<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		UserName: &nbsp;<input type="text" name="name"><br><br> 
		Password: &nbsp;<input type="password" name="password"><br><br> 
		&nbsp;&nbsp;<input type="submit" value="login">
	</form>
</body>
</html>