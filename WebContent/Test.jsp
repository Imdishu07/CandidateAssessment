<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TEST</title>
</head>
<body>
  <style>
body{
background-position:center;
            background-image: url('2053097.png');  
             background-size: 100%;
        } 
</style>

<%@ page import="java.sql.*" %>
<%@ page import="com.candidate.*" %>
<% 
Connection con=DBConnection.Connect();
Statement stmt ;
stmt = con.createStatement();
ResultSet rs=stmt.executeQuery("SELECT * FROM test");

%>

<center>
<form action="AddMarks" method="post">
<br>
<h1 style="background-color: black;color: white;">OCEAN PERSONALITY TEST</h1><br>
<br>
<table style="width:75%;background-color: black;color: white;">
  <tr>
    <th>Sr. No.</th>
    <th>Questions</th>
    <th>         </th>
    <th>         </th>
    <th>Choose Any One Option</th>
    <th>         </th>
    <th>         </th>
    
  </tr>
  <tr>
  <td></td>
   <td ></td>
   <td></td>
   <td></td>
   <td></td>
   <td></td>
  </tr>
  <%int count=1; %>
  <% while(rs.next()) { %>
  <tr>
    <td><%= rs.getLong(1) %></td>
    <td><%= rs.getString(2) %></td>
    <th><input type="radio" value="sa" name="q<%=Integer.toString(count)%>" > strongly agree </th>
    <th><input type="radio" value="a" name="q<%=Integer.toString(count)%>" > agree </th>
    <th><input type="radio" value="n" name="q<%=Integer.toString(count)%>" > neutral </th>
    <th><input type="radio" value="d" name="q<%=Integer.toString(count)%>" > disagree </th>
    <th><input type="radio" value="sd" name="q<%=Integer.toString(count)%>" >strongly disagree</th>
    <%count++; %>
  </tr>
 <% } %>
 
</table>

<button style="height:25px;font-size:13pt;width:140px;">Submit</button>


</form>


</center>
</body>
</html>