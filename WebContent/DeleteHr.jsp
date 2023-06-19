<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="com.candidate.*" %>

<% 
			Connection con=DBConnection.Connect();
			String email=request.getParameter("email");
			PreparedStatement stmt = con.prepareStatement("delete from hr where email=?");
			stmt.setString(1,email);
			int i =  stmt.executeUpdate();
			if(i>0){
				response.sendRedirect("ViewHr.jsp");
			}
		%>
</body>
</html>