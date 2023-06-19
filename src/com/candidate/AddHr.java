package com.candidate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.candidate.DBConnection;

/**
 * Servlet implementation class AddHr
 */
public class AddHr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHr() {
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
		int hid = 0;
		String name=request.getParameter("name");
		 
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String designation=request.getParameter("designation");
		
		Connection con=DBConnection.Connect();
		try {
			PreparedStatement stmt=con.prepareStatement("insert into hr values(?,?,?,?,?,?)");
			stmt.setInt(1,hid);
			stmt.setString(2,name);
			stmt.setString(3, email);
			stmt.setLong(4, mobile);
			stmt.setString(5, designation);
			stmt.setString(6, password);
			int i=stmt.executeUpdate();
			if(i>0){
				GetSet.setHid(hid);
				response.sendRedirect("RegSuccess.html");
			}else{
				response.sendRedirect("AddHr.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


