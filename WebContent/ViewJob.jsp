<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HR DETAILS</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="com.candidate.*" %>

<html>
	<head>
		<title>JOB DETAILS</title>
	</head>
	<style>
	table,th,td{
	 border:1px solid white;
	 border-collapse:collapse;
	 text-align:center;
	}body {
background-position:center;
            background-image: url('2053097.png');  
             background-size: 100%;
        } 
	</style>
	<justify>
	<center>
	<body>
	<br><br><br><br><br><br><br>
		<h1 style="background-color: black;color: white;">JOB DETAILS</h1><br><br>
		<% 
			Connection con=DBConnection.Connect();
			PreparedStatement stmt = con.prepareStatement("select * from job where hid=?");
			stmt.setInt(1, GetSet.getHid());
			ResultSet rs =  stmt.executeQuery();
		%>
		
		<table style="width:75%;background-color: black;color: white;">
		<tr>
		<th>JOB ID</th>
			<th>JOB TITLE</th>
			<th>DESCRIPTION</th>
			<th>SALARY RANGE</th>
			<th>QUALITY</th>
			<th>EXPERIENCE</th>
			<th>DELETE</th>
			
		</tr>
		<% while(rs.next()) { %>
			<tr><center>
				<td><%= rs.getString(1) %></td>
				<td><%= rs.getString(2) %></td>
				<td><%= rs.getString(3) %></td>
				<td><%= rs.getString(4) %></td>
				<td><%= rs.getString(5) %></td>
				<td><%= rs.getString(6) %></td>
				<td><a href="DeleteJob.jsp?job_title=<%= rs.getString(1) %>">DELETE</a>	</td>	
				</center>
			</tr>
			<% } %>
		</table>
		<br><br>
		<button type="submit"  class="btn btn-larger btn-block"/><a href=HrSubMenu.html>
                Back to SubMenu</a>
                </button>
		<br><br><br>
		
</body>
</html>