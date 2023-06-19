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
 * Servlet implementation class HLogin
 */
public class HLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HLogin() {
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
		Connection con=DBConnection.Connect();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		int hid=0;
		PreparedStatement stmt;
		try {
			stmt=con.prepareStatement("select * from hr where email=? and password=?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs= stmt.executeQuery();
			if(rs.next()){
				hid=rs.getInt(1);
				GetSet.setHid(hid);
				response.sendRedirect("HrSubMenu.html");
			}else{
				System.out.println("fail");
				
				response.sendRedirect("HLogin.html");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


