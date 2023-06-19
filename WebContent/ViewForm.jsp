<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESULT</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="com.candidate.*" %>
	<br><br><br><br><br><br><br>
	<head>
		<title>RESULT</title>
	</head>
	<style>
	table,th,td{
	 border:1px solid white;
	 border-collapse:collapse;
	 text-align:center;
	}  
body{
background-position:center;
            background-image: url('2053097.png');  
             background-size: 100%;
        } 
	</style>
	<center>
		<h1 style="background-color: black;color: white;">JOB DETAILS</h1><br><br>
		<%	boolean O=false,C=false,E=false,A=false,N=false;
                                            	int jid=GetSet.getJid();
                                            	System.out.println(jid);
                                            	Connection con = DBConnection.Connect();
                                            	PreparedStatement psmt = con.prepareStatement("select * from job where jid=?");
                                            	psmt.setInt(1,jid);
                                            	ResultSet rs = psmt.executeQuery();
                                            	rs.next();
                                            	if(rs.getString(5).contains("Openness")){
                                            		O=true;
                                            	}
                                            	if(rs.getString(5).contains("Conscientiousness")){
                                            		C=true;
                                            	}
                                            	if(rs.getString(5).contains("Extraversion")){
                                            		E=true;
                                            	}
                                            	if(rs.getString(5).contains("Agreeableness")){
                                            		A=true;
                                            	}
                                            	if(rs.getString(5).contains("Neuroticism")){
                                            		N=true;
                                            	}
                                            	String query = "select * from marks where jid="+jid;
                                            	if(O){
                                            		query+=" and o>=8";
                                            	}
                                            	if(C){
                                            		query+=" and c>=8";
                                            	}
                                            	if(E){
                                            		query+=" and e>=8";
                                            	}
                                            	if(A){
                                            		query+=" and a>=8";
                                            	}
                                            	if(N){
                                            		query+=" and n>=8";
                                            				
                                            	}
                                            	
                                            	PreparedStatement psmt2 = con.prepareStatement(query);
                                            	ResultSet rs2 = psmt2.executeQuery();
                                            	PreparedStatement p3 = con.prepareStatement("select * from register where id=?");
                                                	
                                                %>
                                                    <table class="table table-hover" style="width:75%;background-color: black;color: white;">
                                                        <thead>
                                                            <tr>
                                                                <th>ID</th>
                                                                <th>CANDIDATE NAME</th>
                                                                <th>O-MARKS</th>
                                                                <th>C-MARKS</th>
                                                                <th>E-MARKS</th>
                                                                <th>A-MARKS</th>
                                                                <th>N-MARKS</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                        <%while(rs2.next())
                                                    	{ %>
                                                            <tr>
                                                               
                                                                <td><%=rs2.getInt(2)%></td>
                                                                <% p3.setInt(1,rs2.getInt(2));
                                                                	ResultSet rs3=p3.executeQuery();
                                                                	rs3.next();
                                                                %>
                                                                <td><%=rs3.getString(2) %></td>
                                                                <td><%=rs2.getInt(3) %></td>
                                                                <td><%=rs2.getInt(4) %></td>
                                                                <td><%=rs2.getInt(5) %></td>
                                                                <td><%=rs2.getInt(6) %></td>
                                                                <td><%=rs2.getInt(7) %></td>
                                                            </tr>
                                                             <%} %>
                                                        </tbody>
                                                    </table>
                                                    <br><br><br>
                                                    <button style="height:25px;font-size:10pt;width:170px;"><a href=HrSubMenu.html>BACK TO SUBMENU</a></button>
		<br><br><br>
		</center>
</body>
</html>