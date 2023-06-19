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
 * Servlet implementation class AddMarks
 */
public class AddMarks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMarks() {
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
		int o=0,c=0,e=0,a=0,n=0;
		Connection con=DBConnection.Connect();
		PreparedStatement psmt,qr;
		try {
			
			qr=con.prepareStatement("select * from test");
			ResultSet qn=qr.executeQuery();
			
			psmt = con.prepareStatement("select * from test where qid=?");
			while(qn.next()){
				psmt.setInt(1, qn.getInt(1));
				ResultSet rs=psmt.executeQuery();
				rs.next();	
				String result=null;
				if(request.getParameter("q"+qn.getInt(1)).equals("sa")){
					result=rs.getString(3);
				}
				else if(request.getParameter("q"+qn.getInt(1)).equals("a")){
					result=rs.getString(4);
				}
				else if(request.getParameter("q"+qn.getInt(1)).equals("n")){
					result=rs.getString(5);
				}
				else if(request.getParameter("q"+qn.getInt(1)).equals("d")){
					result=rs.getString(6);
				}
				else if(request.getParameter("q"+qn.getInt(1)).equals("sd")){
					result=rs.getString(7);
				}
				
				switch(result.charAt(0)){
				case 'o' : o+=Character.getNumericValue(result.charAt(1));
							break;
				case 'c' : c+=Character.getNumericValue(result.charAt(1));
							break;
				case 'e' : e+=Character.getNumericValue(result.charAt(1));
							break;
				case 'a' : a+=Character.getNumericValue(result.charAt(1));
							break;
				case 'n' : n+=Character.getNumericValue(result.charAt(1));
							break;
				}
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PreparedStatement psmt2;
		try {
			psmt2 = con.prepareStatement("insert into marks values(?,?,?,?,?,?,?)");
			psmt2.setInt(1, GetSet.getJid());
			psmt2.setInt(2,GetSet.getId());
			psmt2.setInt(3, o);
			psmt2.setInt(4, c);
			psmt2.setInt(5, e);
			psmt2.setInt(6, a);
			psmt2.setInt(7, n);
			
			if(psmt2.executeUpdate()==1){
				response.sendRedirect("NewFile.html");
			}
			
		} catch (SQLException e1) {
			
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
	}

}
