package com.candidate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddJob
 */
public class AddJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJob() {
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
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String salary=request.getParameter("salary");
		String quality = "";
		String experience=request.getParameter("experience");
		int jid=0;
		
		boolean o,c,e,a,n;
		Connection con =DBConnection.Connect();
		
		
			try{
			if(request.getParameter("o").equals("Openness"))
			{
				quality+=("Openness,");
			}
			}
			catch(java.lang.NullPointerException ne)
			{
				o=false;
			}
			try{
			if(request.getParameter("c").equals("Conscientiousness"))
			{
				quality+=(" Conscientiousness,");
			}
			}catch(java.lang.NullPointerException ne)
			{
				c=false;
			}
			try{
			if(request.getParameter("e").equals("Extraversion"))
			{
				quality+=("Extraversion,");
			}
			}catch(java.lang.NullPointerException ne)
			{
				e=false;
			}
			try{
			if(request.getParameter("a").equals("Agreeableness"))
			{
				quality+=("Agreeableness,");
			}
			}catch(java.lang.NullPointerException ne)
			{
				a=false;
			}
			try{
			if(request.getParameter("n").equals("Neuroticism"))
			{
				quality+=("Neuroticism,");
			}
			}catch(java.lang.NullPointerException ne)
			{
				n=false;
			}
		
		try {
			PreparedStatement pstmt1=con.prepareStatement("insert into job values(?,?,?,?,?,?,?)");
			pstmt1.setInt(1, jid);
			pstmt1.setString(2, title);
			pstmt1.setString(3, description);
			pstmt1.setString(4, salary);
			pstmt1.setString(6, experience);
			pstmt1.setString(5, quality);
			pstmt1.setInt(7,GetSet.getHid());
			int i=pstmt1.executeUpdate();
			if(i>0)
			{
			
				response.sendRedirect("HrSubMenu.html");
			}
			else
			{
				response.sendRedirect("AddJob.html");
			}
			} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		
		
	}

	
}


