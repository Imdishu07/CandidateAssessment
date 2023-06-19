<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CANDIDATE REGISTER</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="com.candidate.*" %>
<% int jid=Integer.parseInt(request.getParameter("jid"));
GetSet.setJid(jid);
%>
<style>
body{
background-position:center;
            background-image: url('2053097.png');  
             background-size: 100%;
        } label{
      	display:inline-block;
      	width:140px;
      	text-align:right;
      }
</style>
<center>
<h1 style="background-color: black;color: white;">CANDIDATE REGISTRATION</h1><br>
<h3> 
<form action="NewCandidate" method="post">

<div>
<br>
<label for="name">NAME : </label>
  <input type="text" id="name" name="name" required><br>
<br>  
<label for="email">EMAIL : </label>
  <input type="text" id="email" name="email" required><br>
<br>  
<label for="mobile">MOBILE NO. : </label>
  <input type="number" id="mobile" name="mobile" required><br>
 <br> 
<label for="city">CITY : </label>
  <input type="text" id="city" name="city" required><br>
 <br> 
<label for="dob">DATE OF BIRTH : </label>
  <input type="date" id="dob" name="dob" required><br>
 <br> 
<label for="gender">GENDER :</label>
  <select name="gender" id="gender" required>
  <option value="gender">SELECT GENDER</option>
    <option value="male" >MALE</option>
    <option value="female">FEMALE</option>
    <option value="other">OTHER</option>
</select>
 <br><br>
<label for="experience">EXPERIENCE : </label>
  <input type="text" id="experience" name="experience" required><br><br><br> 

<label>   SELECT JOB:  </label>    
<% 
 Connection con=DBConnection.Connect();
Statement stmt ;
stmt = con.createStatement();
ResultSet rs=stmt.executeQuery("SELECT * FROM job");

%>
  
  <% while(rs.next()) { %>
<input type="radio" value="<%= rs.getString(2) %>" name="jname" > <%= rs.getString(2) %> 

 <% } %>   
  
 </div>
 <br>
  <button style="height:25px;font-size:13pt;width:140px;position:absolute;top:560px;left:730px;">GO TO TEST</button>
</center>

</body>
</html>