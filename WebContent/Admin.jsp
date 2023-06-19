<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN LOGIN</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="com.candidate.*" %>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
 <form action="Login" method="post">    
          <label for="accno">ENTER EMAIL : </label>
		<input type="number" id="accno" name="accno"><br><br><br>
		<label for="psd">PASSWORD : </label>
<input type="password" id="psd" name="psd"><br><br><br>
<button>Login</button>

</body>
</html>