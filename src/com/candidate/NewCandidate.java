package com.candidate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewCandidate
 */
public class NewCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int id = 0;
		String name=request.getParameter("name");
		String experience=request.getParameter("experience");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String gender= request.getParameter("gender");
		String dob= request.getParameter("dob");
		String email=request.getParameter("email");
		
		String city=request.getParameter("city");
		String jname= request.getParameter("jname");
		
		
		Connection con=DBConnection.Connect();
		try {
			PreparedStatement stmt=con.prepareStatement("insert into register values(?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1,id);
			stmt.setString(2,name);
			stmt.setString(3, email);
			stmt.setLong(4, mobile);
			stmt.setString(5, city);
			stmt.setString(6, dob);
			stmt.setString(7, gender);
			stmt.setString(8, jname);
			stmt.setString(9, experience);
			
			
			int i=stmt.executeUpdate();
			if(i>0){
				PreparedStatement pstmt1= con.prepareStatement("select id from register where Email=? and mob=?");
				pstmt1.setString(1, email);
				pstmt1.setLong(2, mobile);
				ResultSet rs=pstmt1.executeQuery();
				if(rs.next())
				{
					id=rs.getInt(1);
					GetSet.setId(id);
		
				}
				response.sendRedirect("Test.jsp");
			}else{
				response.sendRedirect("NewCandidate.jsp");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
