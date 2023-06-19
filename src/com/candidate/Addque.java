package com.candidate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addque
 */
@WebServlet("/Addque")
public class Addque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addque() {
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
		int qid=0;
			String que = request.getParameter("que");
        String sd = request.getParameter("sd");
        String d = request.getParameter("d");
        String n = request.getParameter("n");
        String a = request.getParameter("a");
        String sa = request.getParameter("sa");
        
        Connection con = DBConnection.Connect();
        PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("insert into test values(?,?,?,?,?,?,?)");
			 	pstmt.setInt(1, qid);
		        pstmt.setString(2, que);
		        pstmt.setString(3, sa);
		        pstmt.setString(4, a);
		        pstmt.setString(5, n);
		        pstmt.setString(6, d);
		        pstmt.setString(7, sd);
		        int i = pstmt.executeUpdate();
		        if(i>0)
		        {
		        	response.sendRedirect("HrSubMenu.html");
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
      
	}

}